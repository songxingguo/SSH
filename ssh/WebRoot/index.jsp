<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>菜单</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="css/base.css" rel="stylesheet">

  </head>
  
  <body>
   	<div class="container mt30">
	  <div class="row tc bc w500">
		 <div class="panel panel-default">
		  <div class="panel-heading">菜单栏</div>
		  <div class="panel-body">
			<div class="list-group">
			  <a href="stus.action" class="list-group-item">学生信息</a>
			  <a href="clas.action" class="list-group-item">班级信息</a>
			  <a href="excleUpload.action" class="list-group-item">上传下载</a>
			</div>
		  </div>
		</div>
	  </div>
	</div>
  </body>
</html>
