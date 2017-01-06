package com.ycx.annotation;

import java.lang.reflect.Method;

/**
 * 表达式解析
 * Created by yangwenqi on 16/6/2.
 */
public interface ElParser<T> {

    /**
     * 解析方法中注解里的EL表达式值
     * @param expression
     * @param params
     * @param method
     * @return
     */
    T parse(String expression, Object[] params, Method method);

}
