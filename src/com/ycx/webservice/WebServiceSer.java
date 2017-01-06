package com.ycx.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface WebServiceSer {
	@WebMethod
	public String Hello(String name);
}
