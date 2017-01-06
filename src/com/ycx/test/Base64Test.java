package com.ycx.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64Test {
    static String strImg ="";

		public static void main(String[] args)  
	    {  
			//System.out.println(("asd.sdsd").substring(("asd.dsdsd").indexOf(".")+1));
	 	        GenerateImage(strImg);  
	    }  
		public static String readbase64()  
	    {//将图片文件转化为字节数组字符串，并对其进行Base64编码处理  
	        String imgFile = "/Users/yuchengxiang/Desktop/202base64.txt";//待处理的图片  
	        InputStream in = null;  
	        byte[] data = null;  
	        //读取图片字节数组  
	        try   
	        {  
	            in = new FileInputStream(imgFile);          
	            data = new byte[in.available()];  
	            in.read(data);
	            in.close();  
	        }   
	        catch (IOException e)   
	        {  
	            e.printStackTrace();  
	        }  
	      System.out.println(data);
	        return data.toString();//返回Base64编码过的字节数组字符串  
	    }  
	    public static String GetImageStr()  
	    {//将图片文件转化为字节数组字符串，并对其进行Base64编码处理  
	        String imgFile = "/Users/yuchengxiang/Desktop/201.jpg";//待处理的图片  
	        InputStream in = null;  
	        byte[] data = null;  
	        //读取图片字节数组  
	        try   
	        {  
	            in = new FileInputStream(imgFile);          
	            data = new byte[in.available()];  
	            in.read(data);  
	            in.close();  
	        }   
	        catch (IOException e)   
	        {  
	            e.printStackTrace();  
	        }  
	        //对字节数组Base64编码  
	        BASE64Encoder encoder = new BASE64Encoder();  
	        String result = encoder.encode(data); 
	        
	        String imgFilePath = "/Users/yuchengxiang/Desktop/202base64.txt";//新生成的图片  
            try {
				OutputStream out = new FileOutputStream(imgFilePath);      
				out.write(result.getBytes());  
				out.flush();  
				out.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	        return result;//返回Base64编码过的字节数组字符串  
	    }  
	    public static boolean GenerateImage(String imgStr)  
	    {//对字节数组字符串进行Base64解码并生成图片  
	        if (imgStr == null) //图像数据为空  
	            return false;  
	        BASE64Decoder decoder = new BASE64Decoder();  
	        System.out.println(imgStr);
	        if(imgStr.indexOf(",")!=-1){
	        	imgStr = imgStr.substring(imgStr.indexOf(",")+1);
	        }
	        try   
	        {  
	            //Base64解码  
	            byte[] b = decoder.decodeBuffer(imgStr);  
	            for(int i=0;i<b.length;++i)  
	            {  
	                if(b[i]<0)  
	                {//调整异常数据  
	                    b[i]+=256;  
	                }  
	            }  
	            //生成jpeg图片  
	            String imgFilePath = "/Users/yuchengxiang/Desktop/202base64.jpg";//新生成的图片  
	            OutputStream out = new FileOutputStream(imgFilePath);      
	            out.write(b);  
	            out.flush();  
	            out.close();  
	            return true;  
	        }   
	        catch (Exception e)   
	        {  
	            return false;  
	        }  
	    }  
	}
