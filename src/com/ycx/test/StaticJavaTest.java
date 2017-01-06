package com.ycx.test;

import java.util.concurrent.ConcurrentLinkedQueue;

import com.ycx.proxy.Main;

public class StaticJavaTest {
	public static void main(String[] args) {
		ConcurrentLinkedQueue<String> qu  = new ConcurrentLinkedQueue<>();
		qu.offer("ss");
	}
}
