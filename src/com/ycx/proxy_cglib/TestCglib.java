package com.ycx.proxy_cglib;


// cglib依赖asm包，而asm与cglib包的版本之间兼容性很差，必须用cglib2.2 版本和最新的asm包才行。
public class TestCglib {
	 public static void main(String[] args) {  
	        BookFacadeCglib cglib=new BookFacadeCglib();  
	        BookFacadeImpl1 bookCglib=(BookFacadeImpl1)cglib.getInstance(new BookFacadeImpl1());  
	        bookCglib.addBook();  
	    }  
}
