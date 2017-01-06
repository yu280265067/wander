package com.ycx.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value= "/select")
@Controller
public class SelectController {
	@ResponseBody
	@RequestMapping("/outline")
	public Map<String,Object> select2(HttpServletRequest request,HttpSession session,HttpServletResponse response){
		String term=request.getParameter("term")!=null?request.getParameter("term"):null;
		System.out.println(request.getParameter("term"));
		System.out.println(request.getParameter("q"));
		HashMap<String,Object> map = new HashMap<String,Object>();
		ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
		ArrayList<HashMap<String,String>> result = new ArrayList<HashMap<String,String>>();
		for(int i=0;i<10;i++){
			HashMap<String,String> tempmap = new HashMap<String, String>();
			tempmap.put("text", "上单#"+i*2);
			tempmap.put("id", i*2+"");
			list.add(tempmap);
		}
		for(int i=0;i<10;i++){
			HashMap<String,String> tempmap = new HashMap<String, String>();
			tempmap.put("text", "中单#"+i+"id");
			tempmap.put("id", i+"id");
			list.add(tempmap);
		}
		if(term!=null){
		for(HashMap<String,String> x:list){
			if(term!=null&&x.get("text").startsWith(term)){
				result.add(x);
			}
		}
		}
		else{
			result.addAll(list);
		}
		System.out.println("outlineSearch");
		map.put("rows", result);
		Cookie cookie = new Cookie("name", "messi");
		//cookie.setMaxAge(3600);
		response.addCookie(cookie);
		return map;
	}
	@RequestMapping("/select2submit")
	public void select2submit(HttpServletRequest request,HttpSession session){
//		Cookie[] cookies = request.getCookies();//这样便可以获取一个cookie数组
//		for(Cookie cookie : cookies){
//		   System.out.println(cookie.getName());// get the cookie name
//		     // get the cookie value
//		    System.out.println(cookie.getValue());
//		}
		String[] outline = request.getParameterValues("outline");
		for(int i=0;i<outline.length;i++){
			System.out.println("select2submit==="+outline[i]);
		}
		System.out.println("sessionid=="+session.getId());
		String term = request.getParameter("outline");
		System.out.println("term==="+term);
		
}
}
