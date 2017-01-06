<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
<body>
hello world
${requestScope.user}
<form:form  path="testmodelAtt" method="post"  >
<input type="text" name="id" value="1"/>
<input type="text" name="name" value="meixi2"/>
<input type="text" name="email" value="ycx@163.com"/>
<input type="text" name="birth" value="1992-10-17"/>
<br/>
<input type="submit" value="提交">
</form:form>
表单标签
<form:form action="${pageContext.request.contextPath }/testmodelAtt" method="POST" 
		modelAttribute="user">
<input type="text" name="id" value="1"/>
<input type="text" name="name" value="meixi2"/>
<input type="text" name="email" value="ycx@163.com"/>
<!--只有用form标签才能是校验的输出是中文的，普通的input输出的error是英文的，需要i18n处理
	properties+application.xml 配置
  -->
<input type="text" name="birth" value="1992-10-17"/> 
<%-- <form:input path="birth" />  --%>
<form:errors path="birth"></form:errors>
<br/>
<input type="submit" value="提交">
</form:form>
下载
<a href="download">download</a>
</body>
</html>