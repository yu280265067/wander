package com.ycx.webservice;

import javax.xml.namespace.QName;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Element;

public class CheckUserInterceptor extends AbstractPhaseInterceptor<SoapMessage>{

	public CheckUserInterceptor(String phase) {
		super(Phase.PRE_PROTOCOL);
		System.out.println("---CheckUserInterceptor---");
	}
	
	public CheckUserInterceptor() {
		super(Phase.PRE_PROTOCOL);
		System.out.println("---CheckUserInterceptor---");
	}

	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		// TODO Auto-generated method stub
		Header header = message.getHeader(new QName("ycx"));
		if(header!=null){
			Element element  = (Element)header.getObject();
			System.out.println(element.getElementsByTagName("name"));
			String name  = element.getElementsByTagName("name").item(0).getNodeName();
			String password  = element.getElementsByTagName("password").item(0).getNodeValue();
			if("ycx".equals(name)&&"123".equals(password)){
				System.out.println("通过");
				return ;
			}
			System.out.println("用户名或密码错误");
			throw new Fault(new RuntimeException("请输入一个正确的用户名密码"));
		}
		
		
	}


}
