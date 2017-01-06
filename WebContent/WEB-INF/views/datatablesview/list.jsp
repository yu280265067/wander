<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctxStatic" value="${pageContext.request.contextPath}/static"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <link href="http://cdn.datatables.net/1.10.5/css/jquery.dataTables.css" rel="stylesheet" /> -->
<link href="${pageContext.request.contextPath}/static/css/jquery.dataTables.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/static/css/jquery.dataTables.min.css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"> 
$(document).ready(function() {
$('#example11').dataTable({
	 "bFilter": false,//去掉搜索框
     //"bAutoWidth": true, //自适应宽度
     "sPaginationType" : "full_numbers",
     "bDestroy" : true,
     "bProcessing" : true,
     "bServerSide" : true,
     
	"sAjaxDataProp" : "aData",//是服务器分页的标志，必须有
  "sAjaxSource" : "${pageContext.request.contextPath}/datatable/datainfo",//通过ajax实现分页的url路径。
   "aoColumns" : [ {
      "mDataProp" : "id",
  }, {
      "mDataProp" : "name",
  }, {
      "mDataProp" : "telephone",
  }, {
      "mDataProp" : "email",
  },  ], 
  // 如果不知是简单的数据显示，需要复杂的要求时，通过以下方法来实现动态js插入。 
  //不知道有没有更好的方法。
 /*  "aoColumnDefs":[{"aTargets":[1],"mRender":function(){
      return "<a href=#>1441</a>"}
     }], */
  "bAutoWidth": true, //自适应宽度
  "sPaginationType" : "full_numbers",
  "oLanguage" : {
      "sProcessing" : "正在加载中......",
      "sLengthMenu" : "每页显示 _MENU_ 条记录",
      "sZeroRecords" : "正在加载中......",
      "sEmptyTable" : "表中无数据存在！",
      "sInfo" : "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
      "sInfoEmpty" : "显示0到0条记录",
      "sInfoFiltered" : "数据表中共为 _MAX_ 条记录",
      "sSearch" : "搜索",
      "oPaginate" : {
          "sFirst" : "首页",
          "sPrevious" : "上一页",
          "sNext" : "下一页",
          "sLast" : "末页"
      }
  }
});
});
</script> 
</head>
<body>
<div>
		<table id="example11" class="display dataTable">
			<thead>
				<th>姓名</th>
				<th>位置</th>
				<th>年龄</th>
				<th>薪水</th>
			</thead>
			<tbody>
				 <c:forEach items="${aData}" var="user">
					<tr>
						<td>${user.name}</td>
						<td>${user.name}</td>
						<td>${user.telephone}</td>
						<td>${user.email}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>  
 
</body>
</html>