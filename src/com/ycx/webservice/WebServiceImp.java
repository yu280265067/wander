package com.ycx.webservice;

import javax.jws.WebService;

@WebService
public class WebServiceImp implements WebServiceSer {
	public String Hello(String name) {
		System.out.println("Hello World  "+ name);
		return "Hello World  "+ name ;
	}

}
