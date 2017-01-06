package com.ycx.proxy_cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

 /*	cglib是一个提供动态代理的开源框架。
 *  cglib与jdk提供的动态代理不同。jdk的动态代理只能代理实现了接口的类，而没有实现接口的类则不能代理。而cglib可以代理
 * 	没有实现接口的类，这点上cglib比jdk的动态代理要好一些。spring框架如果不特别声明使用cglib的话，默认时使用jdk的动态代理。
 *
 * 
 * 
 */
public class BookFacadeCglib implements MethodInterceptor{
	private Object target;  
	  
    /** 
     * 创建代理对象 
     *  
     * @param target 
     * @return 
     */  
	/*	从代码中可以看出，cglib为被代理对象声称子类，在子类中回调父类中的被代理方法来实现动态代理的。
	 * 	其实也是需要有父子类关系的存在才可以代理，只不过这种关系cglib帮我们构建出来，不需要我们必须按照这种框框来编程。
	 * 
	*/
    public Object getInstance(Object target) {
        this.target = target;  
        Enhancer enhancer = new Enhancer();  
        enhancer.setSuperclass(this.target.getClass());  
        // 回调方法  
        enhancer.setCallback(this);  
        // 创建代理对象  
        return enhancer.create();  
    }  
  
    // 回调方法  
    public Object intercept(Object obj, Method method, Object[] args,  
            MethodProxy proxy) throws Throwable {  
        System.out.println("事物开始");  
        proxy.invokeSuper(obj, args);  
        System.out.println("事物结束");  
        return null;  
  
  
    }


}
