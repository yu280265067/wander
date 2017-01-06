package com.ycx.webservice;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.phase.Phase;

public class LoggingInterceptor extends LoggingInInterceptor{

	public LoggingInterceptor(String phase) {
		super(Phase.PRE_PROTOCOL);
		System.out.println("---LoggingInterceptor---");
	}
	
	public LoggingInterceptor() {
		super(Phase.PRE_PROTOCOL);
		System.out.println("---LoggingInterceptor---");
	}

}
