<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/static/css/jquery.dataTables.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/static/css/jquery.dataTables.min.css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.dataTables.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <script type="text/javascript">
         $(document).ready(function () {
        	 var data = '<ns2:Hello xmlns:ns2="http://webservice.ycx.com/"><arg0>sdasdas</arg0></ns2:Hello>' ; 
        	var data2 = '<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"><soap:Body><ns2:Hello xmlns:ns2="http://webservice.ycx.com/"><arg0> messi </arg0></ns2:Hello></soap:Body></soap:Envelope>';
           var data3='<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"><soap:Body><ns2:Hello xmlns:ns2="http://webservice.ycx.com/"><arg0>sdasdas</arg0></ns2:Hello></soap:Body></soap:Envelope>';
        	$("#Button1").click(function () {
                 try {
                     $.ajax({
                         type: "GET",  //访问WebService使用post方式请求
                         contentType: "application/json; charset=utf-8",
                         url:"http://localhost:8989/ws/hello?callback=?" ,
                        // url: "http://localhost:8080/spring3Maven/cxf/helloTest", //调用WebService的地址和方法名称组合
                         data: data3,
                         dataType: "xml",
                         jsonp: 'callback',
                         success: function (msg) {
                        	 var $result = $(msg);
                        	 var value = $result.find("return").text();
                            // $("#result").html(result);
                             alert(value);
                         },
                         error:function(error){
                        	 alert("error ==  "+error);
                         }
                     })
                 }
                 catch (ex) {
                     alert(ex);
                 }
             })
         })
       
    </script>


</head>
<body>
<br/><br/>
success
request==  ${requestScope.user}
<br/>
session=  ${sessionScope.user}
<button id="Button1" >webservice请求</button>
</body>
</html>