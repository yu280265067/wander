package com.ycx.webservice;

import java.util.List;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sun.org.apache.xml.internal.utils.DOMHelper;

public class CheckUserInterceptorCli extends AbstractPhaseInterceptor<SoapMessage>{

	public CheckUserInterceptorCli(String phase) {
		super(Phase.PRE_INVOKE);
		System.out.println("---CheckUserInterceptor Client---");
	}
	
	public CheckUserInterceptorCli() {
		super(Phase.PRE_INVOKE);
		System.out.println("---CheckUserInterceptor Client---");
	}

	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		// TODO Auto-generated method stub
		List<Header> header = message.getHeaders();
		Document document = DOMHelper.createDocument();
		Element rootEle  = document.createElement("ycx");
		Element nameEle  = document.createElement("name");
		nameEle.setAttribute("user", "ycx");
		Element passEle  = document.createElement("password");
		passEle.setNodeValue("123");
		header.add(new Header(new QName("ycx"), rootEle));
	}


}
