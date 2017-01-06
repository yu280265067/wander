package com.ycx.controller;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.ycx.configuration.SystemConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ycx.dao.UserserviceImp;
import com.ycx.model.User;
//使用servlet原生api的两种方法
//方法一：如下 ，通过value可以指定放入session的对象，types可以指定放入session的类型
//方法二：在形参直接引入HttpSession
//@SessionAttributes(value="",types=User.class)
@RequestMapping("")
@Controller
public class ApiController {
	
	private static final Logger     logger = LoggerFactory.getLogger(ApiController.class);
	
//	@Autowired
//	HttpServletRequest request;
	
	@Resource
	private UserserviceImp userService;

	@RequestMapping("")
	public String index(){
		System.out.println("index...");
		System.out.println("test===="+SystemConfig.getProperty("test"));

		return "datatablesview/index";
	}
	@RequestMapping("/mybatis")
	public String mybatis(){
	//	System.out.println(userService.getuserById("1"));
		return "datatablesview/index";
	}
	
	@ModelAttribute("")
	public void getUser(Map<String,Object> map){
		User user=new User(1,"meixi","1111","ycx@163.com",new Date(1992, 10, 17));
		map.put("user", user);
	}
	
	@RequestMapping("/datatablesview")
	public String datatablesview(User user,HttpSession session){
		System.out.println("datatablesview/index");
  		return "datatablesview/index";
	}
	//@Valid User user,BindingResult result 这两个参数一定要挨着。真操蛋
	@RequestMapping("/testmodelAtt")
	public String testmodelAtt(@Valid User user,BindingResult result,HttpSession session){
		System.out.println("testmodelAtt");
		if(result.getErrorCount()>0){
			for(FieldError error:result.getFieldErrors()){
				System.out.println(error.getField()+"=="+error.getDefaultMessage());
			}
		}
		System.out.println(user.toString());
	//	session.setAttribute("user", user);
  		return "datatablesview/index";
	}
	//@pathvariable 是spring3.0新增的功能 配合ant风格的mapping占位符使用，是spring向resultful方向发展的一个具有里程碑意义的功能
	@RequestMapping("/testResultful/{name}")
	public String testResultful(@PathVariable("name") String name,HttpSession session){
		System.out.println(name);
	//	session.setAttribute("user", user);
  		return "success";
	}
	// 项目中试用方式
	/* //  @ResponseBody
    @RequestMapping("uploadOld")
    public List filesUpload(@RequestParam("file") MultipartFile[] files) {
        //判断file数组不能为空并且长度大于0
        if (files != null && files.length > 0) {
            //循环获取file数组中得文件
            for (int i = 0; i < files.length; i++) {
                MultipartFile file = files[i];
                //保存文件
                saveFile(file);
            }
        }
        String filePath = request.getSession().getServletContext().getRealPath("/") ;
        File uploadDest = new File(filePath);
        List list = new ArrayList();
        String[] fileNames = uploadDest.list();
        System.out.println(filePath);
        for (int i = 0; i < fileNames.length; i++) {
            //打印出文件名
            System.out.println(fileNames[i]);
            // logger.info(fileNames[i]);
            list.add(fileNames[i]);
        }
        // 重定向
        return list;
    }
    public void saveFile(MultipartFile file) {
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                // 文件保存路径
                String filePath = request.getSession().getServletContext().getRealPath("/")
                        + file.getOriginalFilename();
                // 转存文件
                file.transferTo(new File(filePath));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    *
    *
    */
	
	@RequestMapping("/download")
	public ResponseEntity<byte[]> download(HttpSession session) throws IOException{
		byte[] body = null;
		ServletContext context = session.getServletContext();
		InputStream in = context.getResourceAsStream("/files/crackwifi.txt");
		body=new byte[in.available()];
		in.read(body);//  从输入流中读取一定数量的字节，并将其存储在缓冲区数组 b 中。
		//以整数形式返回实际读取的字节数。在输入数据可用、检测到文件末尾或者抛出异常前，此方法一直阻塞。
		HttpHeaders head = new HttpHeaders();
		//不加head则浏览器不会下载，而是会把文件内容打印在页面
		head.add("Content-Disposition", "attachment;filename=crackwifi.txt");
		ResponseEntity<byte[]> res = new ResponseEntity<byte[]>(body,head,HttpStatus.OK); 
		return res;
	}
	@RequestMapping("/select2pre")
	public String select2pre(HttpSession session){
		logger.info("select2pre");
		return "select/index";
	}
	@RequestMapping("/uploadpre")
	public String uploadPre(HttpSession session){
		logger.info("uploadpre");
		return "shangchaun";
	}
	
	/*@RequestMapping("/upload")
	public String fileUpload(@RequestParam("file") MultipartFile file) {  
        // 判断文件是否为空  
        if (!file.isEmpty()) {
            try {  
                // 文件保存路径  
                String filePath = request.getSession().getServletContext().getRealPath("/")  
                        + file.getOriginalFilename();  
                // 转存文件  
                file.transferTo(new File(filePath));  
            } catch (Exception e) {
                e.printStackTrace();  
            }
        }  
        // 重定向  
        return "redirect:/list.html";  
    }  
	@RequestMapping("list")  
    public ModelAndView list() {  
        String filePath = request.getSession().getServletContext().getRealPath("/") ;  
        ModelAndView mav = new ModelAndView("list");  
        File uploadDest = new File(filePath);  
        String[] fileNames = uploadDest.list();  
        for (int i = 0; i < fileNames.length; i++) {  
            //打印出文件名  
            System.out.println(fileNames[i]);  
        }  
        return mav;  
    }  */
	
	@ResponseBody
	@RequestMapping("/select2")
	public Map<String,Object> select2(HttpSession session){
		System.out.println("...select...");
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0;i<10;i++){
			list.add(i+"");
		}
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("name", list);
		return map;
	}

}
