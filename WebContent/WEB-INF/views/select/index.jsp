<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/static/css/select2.min.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/select2.min.js"></script>

<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(function(){
		$("#select2").select2();
	$("#select001").select2({
	        placeholder: "请选择",
	        language: "zh-CN",
	         ajax: {
	            	url: "${pageContext.request.contextPath}/select/outline.do",
	                dataType: 'json',
	                data     : function (params) {  // 请求参数（GET）
	                    params.rows = params.term;
	                    return {
	                    	q:params.term,
	                    	hi:'20'
	                    };
	                },
	                   processResults: function (data, params) {  
	                    params.page = params.page || 1;  
	                    return {  
	                     results: data.rows,  
	                     pagination: {  
	                      more: (params.page * 10) < data.total_count  
	                     }  
	                    };  
	                   },   
	                   cache: true  
	                  },
	                  escapeMarkup: function (markup) { return markup; }, // let our custom formatter work  
	                  templateResult: formatRepoProvince, // omitted for brevity, see the source of this page  
	                  templateSelection: formatReposelect // omitted for brevity, see the source of this page  
	        });  
			var $eventSelect = $("#select001");
			$eventSelect.on("select2:select", function (e) { 
				//alert(e.params.data.id);
		    	//alert(e.params.data.text);
				//log("select2:select", e);
				});
			
			  function formatReposelect(repo) {
				  if (repo.loading) return repo.text;  
	                 var res = repo.text.split("#");
	                 var markup = "<div>"+res[0]+"&nbsp;"+res[1]+"</div>";  
	                 return markup;  
	                } 
			  function formatRepoProvince(repo) {
				  	
	                 if (repo.loading) return repo.text;  
	                 var res = repo.text.split("#");
	                 var markup = "<div>"+res[0]+"&nbsp;"+res[1]+"</div>";  
	                 return markup;  
	                } 
			
			//$('#select').val([1,2,3,4]).change();
	                });   
	function addSelect(){
		var opt1 = "<option value='556' name='asd1' id='idid1' selected ='selected'>sdsds</option>";
 		$("#select001").append(opt1);
 		var opt2 = "<option value='557' name='asd2' id='idid2' selected ='selected'>sds2ds</option>";
 		$("#select001").append(opt2);
 		$("#select001").val(["557","556"]).trigger('change');
	   //  $("#select").val('1').trigger("change");
	   //$("#select").select2('data',{id:"itemid",text:"item text"});
	 // $('#select').select2('val', {"id": 100,"text": 'Lorem Ipsum'});
	  //$("#select").select2({tags:["red", "green", "blue"]});
//  	 $('#select').select2({data:{"id": "sad", "text": "asdas"}})
	 //  $("#select").val("sadd").change();
	     //$('#select').val([1,2,3,4,5,6]).change();
 }
	function showSelect(){
		
		alert($("#select001").val());
			
	}
	               
	                 
	</script> 
</head>
<body>
<body>
<form action="${pageContext.request.contextPath}/select/select2submit"  method="post">
	<label class="control-label col-sm-1">个性标签（checkbox）: </label>
	<div class="col-sm-3">
		<select class="select_gallery-multiple" multiple="multiple" style="width:100%;" name="outline" id="select001">
			<!-- <optgroup label="这样真的好么？">
				<option value="0">打野</option>
				<option value="01" id="option01">上单</option>
				<option value="02">中单</option>
				<option value="03">送人头</option>
			</optgroup> 
			<optgroup label="职位">
				<option value="1">土豪</option>
				<option value="2">屌丝</option>
				<option value="3">单身dog</option>
				<option value="4">苹果粉</option>
				<option value="5">苦逼程序员</option>
			</optgroup>-->
		</select>
		<select  name="outline2" id="select2" class="select_gallery-multiple" multiple="multiple" >
			 <optgroup label="这样真的好么？">
				<option value="0">打野</option>
				<option value="01">上单</option>
				<option value="02">中单</option>
				<option value="03">送人头</option>
			</optgroup> 
			<optgroup label="职位">
				<option value="1">土豪</option>
				<option value="2">屌丝</option>
				<option value="3">单身dog</option>
				<option value="4">苹果粉</option>
				<option value="5">苦逼程序员</option>
			</optgroup>
			
		</select>
				<select  name="outline3" id="select3" >
			 <optgroup label="这样真的好么？">
				<option value="0">打野</option>
				<option value="01">上单</option>
				<option value="02">中单</option>
				<option value="03">送人头</option>
			</optgroup> 
			<optgroup label="职位">
				<option value="1">土豪</option>
				<option value="2">屌丝</option>
				<option value="3">单身dog</option>
				<option value="4">苹果粉</option>
				<option value="5">苦逼程序员</option>
			</optgroup>
		</select>
		
	</div>
	<input type="submit" value="submit" />
	<input type="button" value="selectAdd" onclick="addSelect()"/>
	<input type="button" value="显示select2" onclick="showSelect()"/>
	</form>
</body>
</body>
</html>