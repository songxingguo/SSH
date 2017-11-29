<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'studentAdd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="bootstrap/css/fileinput.min.css" rel="stylesheet">
	<link href="css/base.css" rel="stylesheet">
	<link href="css/common.css" rel="stylesheet">
  </head>
  
  <body>
    <!-- 学生编辑-->
	<center>
	<div class="container mt30" ng-controller="studentController">
	  <div class="row wp60">
		 <div class="panel panel-default">
		  <div class="panel-heading">学生信息-修改</div>
		  <div class="panel-body">
			<div class="container mt20 w bc">	   
				<form class="form-horizontal" action="stuEdit.action">
				  <div class="form-group">
				    <label for="clas" class="col-sm-2 control-label">班级</label>
				    <div class="col-sm-9">
			     		<s:select cssClass="form-control" 
						  list="clas" listKey="cNo" listValue="cNo" name="cNo"/>
				    </div>
				  </div> 
				  <div class="form-group">
				    <label for="stuNo" class="col-sm-2 control-label">学号</label>
				    <div class="col-sm-9">
				      <input type="text" class="form-control" id="stuNo" name="stuNo" value='<s:property value="stu.stuNo"/>' placeholder="学号">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="stuName" class="col-sm-2 control-label">姓名</label>
				    <div class="col-sm-9">
				      <input type="text" class="form-control" id="stuName" name="stuName" value='<s:property value="stu.stuName"/>' placeholder="姓名">
				    </div>
				  </div>
	  			  <div class="form-group">
				    <label for="stuAge" class="col-sm-2 control-label"  >年龄</label>
				    <div class="col-sm-9">
				      <input type="text" class="form-control" id="stuAge" name="stuAge" value='<s:property value="stu.stuAge"/>' placeholder="年龄">
				    </div>
				  </div>
				  
				  <center class="mt30">
				  	<input type="submit" class="btn btn-default btn-primary mr30" value="保存">
				  	<a class="btn btn-default" href="stus.action" >返回</a>
				  </center>
				</form> 
		  	</div>
	  </div>
	</div>
	</center>
	
	<script src="js/jquery/jquery.js"></script>
    <script src="js/angularjs/angular.min.js"></script>
    <script src="js/angularjs/angular-messages.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="bootstrap/js/fileinput.min.js"></script>
    <script src="bootstrap/js/tooltip.js"></script>
   	<script src="js/student.js"></script>
   	<script src="js/extendPagination.js"></script>
  </body>
</html>

