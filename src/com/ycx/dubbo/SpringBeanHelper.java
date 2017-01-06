package com.ycx.dubbo;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

public class SpringBeanHelper {
	private static  ApplicationContext context;

	/**
	 * 手工获取bean
	 */
	public static Object getBean(String beanId) {
		return context.getBean(beanId);
	}


	public static void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		context = ctx;
	}
}
