package com.ycx.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class IOServer {
	public static void main(String[] args) {
	       ServerSocket serverSocket = null;
	       InputStream in = null;
	       try
	       {
	           serverSocket = new ServerSocket(8080);
	           int recvMsgSize = 0;
	           byte[] recvBuf = new byte[1024];
	           while(true){
	        	   System.out.println("be");
	               Socket clntSocket = serverSocket.accept();
	               System.out.println("af");
	               SocketAddress clientAddress = clntSocket.getRemoteSocketAddress();
	               System.out.println("Handling client at "+clientAddress);
	               in = clntSocket.getInputStream();
//	               阻塞测试，io的read方法是阻塞的，如果没有数据的话，in.read方法会一直阻塞
//	               nio的测试 见 NIOClient.java 与NIOServer.java文件，是read方法是不阻塞的
	               in.read(recvBuf);
	               System.out.println(" thread continue ");
	               while((recvMsgSize=in.read(recvBuf))!=-1){
	                   byte[] temp = new byte[recvMsgSize];
	                   System.arraycopy(recvBuf, 0, temp, 0, recvMsgSize);
	                   System.out.println(new String(temp));
	               }
	           }
	       }
	       catch (IOException e)
	       {
	           e.printStackTrace();
	       }
	       finally{
	           try{
	               if(serverSocket!=null){
	                   serverSocket.close();
	               }
	               if(in!=null){
	                   in.close();
	               }
	           }catch(IOException e){
	               e.printStackTrace();
	           }
	       }
	   }
}
