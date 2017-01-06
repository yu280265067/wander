package com.ycx.test;

public enum EnmuTest {
	 	pay("pay","支付中"),
	    paid("paid","支付结束");//可能成功或失败
	    private final String code;
	    private final String message;

	    EnmuTest(String code, String message) {
	        this.code = code;
	        this.message = message;
	    }
	    public static void main(String[] args) {
	    	EnmuTest enu = null ;
			System.out.println(enu.name());
		}
}
class Test {
	public static void main(String[] args) {
		EnmuTest enu = EnmuTest.pay ;
	
		System.out.println(enu.name());
	}
}
