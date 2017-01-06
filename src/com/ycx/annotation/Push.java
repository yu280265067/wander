package com.ycx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Push {
    /**
     * Spring EL表达式
     * @return
     */
    String value();
    /**
     * 值类型
     * @return
     */
    ValueType valueType();
    /**
     * 推送类型
     * @return
     */
    PushType pushType();

    /**
     * 执行的是添加还是更新
     * @return
     */
    Action action() default Action.NONE;
}
