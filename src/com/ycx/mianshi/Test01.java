package com.ycx.mianshi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Test01 {
	//fibonacci数列问题
	public static void fibonacci(int num){
		int s[] = new int[num];
		s[0] = 0;
		s[1]=1;
		System.out.println(s[0]);
		for(int i=2;s[i-1]<=num;i++){
				s[i] = s[i-1]+s[i-2];
				System.out.println(s[i-1]);
			}
	} 
	//求按照字母的出现次数进行排序
	//map排序 java中使用collections的sort静态方法对map进行排序
	public static Map<String,String> sortMap(String str){
		char a[] = new char[str.length()];
		HashMap<String,String> result = new HashMap<String, String>();
		for(int i=0;i<str.length();i++){
			a[i] = str.charAt(i);
		}
		for(int j = 0; j<str.length();j++){
			if(result.containsKey(String.valueOf(a[j]))){
				continue;
			}
			int num=1;
			for(int k = j+1; k<str.length();k++){
				if(a[k]==a[j]){
					num++;
				}
			}
			result.put(String.valueOf(a[j]), String.valueOf(num));
		}
		
		List<Entry<String,String>> list =
				    new ArrayList<Entry<String,String>>(result.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
			public int compare(Map.Entry<String, String> o1,
			 Map.Entry<String, String> o2) {
				return (Integer.valueOf(o2.getValue()) - Integer.valueOf(o1.getValue()));
			    }
			});
		  for (Map.Entry<String, String> entry : list) {
			  System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
		  }
		return result;
	}
	//冒泡排序
	public static int[] sortFromLargest(int a[]){
		int temp;
		for(int i=0;i<a.length;i++){  
		       for(int j=i+1;j<a.length;j++){  
		       if(a[i]<a[j]){  
		           temp=a[i];  
		           a[i]=a[j];  
		           a[j]=temp;  
		       }  
		       }
		}
		return a;
	}
	//全排列 要求："3"不能在第三位，"3"与"5"不能相连
    private static int NUM = 6;  // 全排列数组长度
    private static void permutation(List<Integer> datas, List<Integer> target) {  
    	
        if (target.size() == NUM) {  
        	StringBuffer bf = new StringBuffer() ;
            for (Integer obj : target)  {
            	bf.append(obj);
            }
            if(bf.charAt(2)!='3'){
            	int i=bf.indexOf("3");
            	int j= bf.indexOf("5");
            	if(i-j!=1&&j-i!=1){
            System.out.println(bf);
            	}
            }
            return;  
        }  
        for (int i = 0; i < datas.size(); i++) {  
            List newDatas = new ArrayList(datas);  
            List newTarget = new ArrayList(target);  
            newTarget.add(newDatas.get(i));  
            newDatas.remove(i);  
            permutation(newDatas, newTarget);  
        }  
    }  
    
	public static void main(String[] args) {
		int []a = {1,13,3,21,8,5};
		fibonacci(100);
		sortFromLargest(a);
		for(int x:a){
			System.out.println(x);
		}
		Integer[] datas = new Integer[] { 1,2,3,5,8,13 };  
        permutation(Arrays.asList(datas), new ArrayList()); 
		String data="aavzcadfdsfsdhshgWasdfasdf";
		sortMap(data);
	}
}
