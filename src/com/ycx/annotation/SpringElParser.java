package com.ycx.annotation;

import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yangwenqi on 16/6/2.
 */
@Service
public class SpringElParser implements ElParser<String> {

    private final Lock globalLock = new ReentrantLock();

    private final ConcurrentMap<Method,Lock> methodLocks = new ConcurrentHashMap<Method, Lock>();

    /**缓存方法的参数名*/
    private final ConcurrentMap<Method, String[]> methodNameCache = new ConcurrentHashMap<Method, String[]>();

    @Override
    public String parse(String expression, Object[] params, Method method) {
        StandardEvaluationContext context = new StandardEvaluationContext();
        String[] paramNames = parseMethodParamNames(method);
        int length = paramNames.length;
        for (int i = 0; i < length; i++) {
            context.setVariable(paramNames[i], params[i]);
        }
        ExpressionParser parser = new SpelExpressionParser();
        return parser.parseExpression(expression).getValue(context, String.class);
    }

    /**
     * 解析方法参数名并以数组的形式返回
     * @param method
     * @return
     */
    protected String[] parseMethodParamNames(Method method) {
        String[] paramNames = methodNameCache.get(method);
        if (paramNames == null) {
            Lock lock = methodLocks.get(method);
            if (lock == null) {
                globalLock.lock();
                try {
                    if ((lock = methodLocks.get(method)) == null) {
                        lock = new ReentrantLock();
                        methodLocks.put(method, lock);
                    }
                } finally {
                    globalLock.unlock();
                }
            }
            lock.lock();
            try {
                paramNames = methodNameCache.get(method);
                if (paramNames == null) {
                    paramNames = new LocalVariableTableParameterNameDiscoverer().getParameterNames(method);
                    if (paramNames != null) {
                        methodNameCache.put(method, paramNames);
                    } else {
                        methodNameCache.put(method, new String[]{});
                    }
                }
            } finally {
                lock.unlock();
            }
        }
        return paramNames;
    }
}
