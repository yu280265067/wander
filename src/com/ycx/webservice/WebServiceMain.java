package com.ycx.webservice;

import java.util.List;

import javax.xml.ws.Endpoint;

import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.jaxws22.EndpointImpl;
import org.apache.cxf.message.Message;


public class WebServiceMain {
	public static void main(String[] args) {
		Endpoint endpoint = Endpoint.publish("http://localhost:8989/ws/hello", new WebServiceImp());
		EndpointImpl endpointImpl = (EndpointImpl)endpoint;
		List<Interceptor<? extends Message>> interceptorsIn = endpointImpl.getInInterceptors();
		interceptorsIn.add(new LoggingInInterceptor());
		
		List<Interceptor<? extends Message>> interceptorsOut = endpointImpl.getOutInterceptors();
		interceptorsOut.add(new LoggingInInterceptor());
		
		System.out.println("webservice 发布成功");
	}
}
