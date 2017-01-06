package com.ycx.aop;

import com.ycx.annotation.Action;
import com.ycx.annotation.ElParser;
import com.ycx.annotation.Push;
import com.ycx.annotation.ValueType;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.annotation.Resource;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by yuchengxiang on 16/12/9.
 */
@Aspect
@Component
@Order(value = Ordered.HIGHEST_PRECEDENCE)public class PushAdvice {
    /**EL表达式解析器*/
    @Resource(name="springElParser")
    private ElParser<String> springElParser;

    @Pointcut("@annotation(com.ycx.annotation.Push)") public void point() {
    }


//    @AfterReturning(value="execution(public String com.ycx.aop.PushServiceImpl.*(..))",
//            returning="result")
   @Around("point()")
    //@Around(value="execution(public String com.ycx.aop.PushServiceImpl.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("advice start");
        Object result = pjp.proceed();
        Object target = pjp.getTarget();
        long begin = System.currentTimeMillis();
        try {
            Signature signature = pjp.getSignature();
            if (signature instanceof MethodSignature) {
                MethodSignature methodSignature = (MethodSignature) signature;
                Method method = ReflectionUtils.findMethod(target.getClass(), methodSignature.getName(), methodSignature.getParameterTypes());
                //获取方法上的注解
                Annotation annotation = method.getAnnotation(Push.class);
                if (annotation != null) {
                    Push pushInfo = (Push) annotation;
                    System.out.println(pushInfo.toString());
                    //获取处理器
//                    PushProcessor<PushInfo> pushInfoPushProcessor = pushProcessorMap.get(pushInfo.pushType());
//                    if (pushInfoPushProcessor == null) {
//                        LOG.warn(String.format("pushType:%s未找到其对应的推送处理器.", pushInfo.pushType()));
//                    } else {
                    //解析注解上的EL表达式的值
                    ValueType valueType = pushInfo.valueType();
                    System.out.println("valueType=="+valueType);
                    System.out.println("value=="+pushInfo.value());
                    //BankAccount[] bankaccount = (BankAccount[]) pjp.getArgs();
                    ExpressionParser parser = new SpelExpressionParser();
                    //String nn = parser.parseExpression(pushInfo.value()).getValue().toString();
                    //System.out.println("pjp.args=="+nn);
                    System.out.println("action=="+pushInfo.action());
                    String member = springElParser.parse(pushInfo.value(), pjp.getArgs(), method);
                    Action action = pushInfo.action();
                    System.out.println("member=="+member);
                    // pushInfoPushProcessor.process(new PushInfo(member, valueType, action));
                    //   }
                }
            } else {
                System.out.println("该注解只能用于方法,signature:" + signature);
            }
        } catch (Exception e) {
            System.out.println("推送消息异常" + e);
        }
        System.out.println("将认证,卖家信息推送到MQ用时 :" + (System.currentTimeMillis() - begin));
        return result;
    }
//    public void setSpringElParser(ElParser<String> springElParser) {
//        this.springElParser = springElParser;
//    }
}
