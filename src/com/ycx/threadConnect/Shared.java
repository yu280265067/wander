package com.ycx.threadConnect;

public class Shared {
	private int contents;
	 private boolean available=false;
	 
	 public synchronized int get(){
	  while(available==false){
	   try{
	    wait();
	   }catch(InterruptedException e){}
	  }
	  available=false;
	  notifyAll();
	  return contents;
	 }
	 
	 public synchronized void put(int value){
	  while(available==true){
	   try{
	    wait();
	   }catch(InterruptedException e){}
	  }
	  available=true;
	  notifyAll();
	  contents=value;
	 }
}
