package com.ycx.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.ycx.dao.DatatableDao;
import com.ycx.model.User;

@RequestMapping(value= "/datatable")
@Controller
public class DatatableController {
	@Autowired
	private DatatableDao datadao;
	@RequestMapping("list/{pagenum}")
	public String list(@PathVariable("pagenum") int pagenum,Model model){
		if(pagenum==1){
			System.out.println(DatatableDao.userList.get(1).toString());
			model.addAttribute("userdata",DatatableDao.userList);
		}
		else if(pagenum==2){
			System.out.println(DatatableDao.userList.get(2).toString());
			model.addAttribute("userdata",DatatableDao.userList);
		}
		else if(pagenum==3){
			System.out.println(DatatableDao.userList.get(3).toString());
			model.addAttribute("userdata",DatatableDao.userList);
		}
		System.out.println("list");
		model.addAttribute("aData",DatatableDao.userList);
		return "datatablesview/list";
	}
	//json：理论上返回一个list<User>对象容其实可以自动转换成json对象的，但是datatables不成功，应该是
	//datables对返回的json有规范，对象名aData等，所以只能返回map对象，通过配置文件的解析配置返回
	// 后来知道原来applicationcontext.xml 里的配置完全可以不要...
	@ResponseBody
	@RequestMapping("datainfo")
	public Object datainfo(HttpServletRequest request,Model model,HttpServletResponse response) throws IOException{
		JSONObject jsonobj =new JSONObject();
		System.out.println("sEcho=="+request.getParameter("sEcho"));
		System.out.println("iDisplayStart=="+request.getParameter("iDisplayStart"));
		System.out.println("iDisplayLength=="+request.getParameter("iDisplayLength"));
		System.out.println("returnMessage=="+request.getParameter("returnMessage"));
		System.out.println("sSearch=="+request.getParameter("sSearch"));
		System.out.println("aoColumns=="+request.getParameter("aoColumns"));
		System.out.println("iDisplayStart=="+request.getParameter("iDisplayStart"));
		System.out.println("iDisplayLength=="+request.getParameter("iDisplayLength"));
		jsonobj.put("aData", DatatableDao.userList);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("sEcho", request.getParameter("sEcho"));
		map.put("iTotalRecords", 30);
		map.put("iTotalDisplayRecords", 30);
		map.put("aData", DatatableDao.userList);
		model.addAttribute("aData",DatatableDao.userList);
		System.out.println(jsonobj.toJSONString());
		return map;
		//return DatatableDao.userCollection;
	}
}
