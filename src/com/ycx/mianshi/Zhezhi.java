package com.ycx.mianshi;
import java.util.*;

public class Zhezhi {
	public static void main2(String[] args) {
		String [] s=foldPaper(4);
		for(String x:s){
			System.out.println(x);
		}
	}

	public static void main(String[] args) {
		String ss = new String();
		ss.toString();
	}
	 public static String[] foldPaper(int n) {
	        // write code here
	        ArrayList<String> list = new ArrayList<String>();
	        printProcess(list,1,n,true);
	        String [] s= new String[list.size()];
	        for(int i=0;i<list.size();i++){
	            s[i]=list.get(i);
	        }
	        return s;
	    }
	    public static void printProcess(ArrayList<String> list,int i,int N,boolean down){
	        if(i>N){
	            return;
	        }
	        printProcess(list,i+1,N,true);
	       // list.add(down?"down":"up");
	    	printProcess(list,i+1,N,false);
	    
	    }
}
