package com.ycx.webservice;

import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.phase.Phase;

public class LoggingInterceptorCli extends LoggingOutInterceptor{

	public LoggingInterceptorCli(String phase) {
		System.out.println("---LoggingOutInterceptor---");
	}
	
	public LoggingInterceptorCli() {
		System.out.println("---LoggingOutInterceptor---");
	}

}
