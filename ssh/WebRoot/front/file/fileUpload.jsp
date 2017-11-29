<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
      
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<style>
  td{font-size:14px}
  center{font-size:14px}
</style>
<head>
    <title>文件上传下载</title>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="bootstrap/css/fileinput.min.css" rel="stylesheet">
	<link href="css/base.css" rel="stylesheet">
	<link href="css/common.css" rel="stylesheet">
</head>
<body ng-app="fileUploadModule">
	<div ng-controller="fileUploadController">
	   	<div class="container mt30">
		  <div class="row tc bc wp80">
			 <div class="panel panel-default">
			  <div class="panel-heading">文件上传</div>
			  <div class="panel-body">
			   <div class="row tc bc w800">
				<s:form action="importExcel" method="post" enctype="multipart/form-data">
				   <input id="input-b2" name="excel" type="file" class="file" data-show-preview="false"/>
				</s:form>
			  </div>
			  </div>
			</div>
		  </div>
		</div>
		
		<div class="container mt30">
		  <div class="row tc bc wp80">
			 <div class="panel panel-default">
			  <div class="panel-heading">文件下载</div>
			  <div class="panel-body">
			   <div class="row tc bc w800">
				<s:form action="exportExcel" method="post" enctype="multipart/form-data">
				   <input type="submit" class="file" name="exportExcel"  value="下载"/>
				</s:form>
			  </div>
			  </div>
			</div>
		  </div>
		</div>
	</div>
   
    <script src="js/jquery/jquery.js"></script>
    <script src="js/angularjs/angular.min.js"></script>
    <script src="js/angularjs/angular-messages.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="bootstrap/js/fileinput_locale_zh.js"></script>
    <script src="bootstrap/js/fileinput.min.js"></script>
    <script src="bootstrap/js/tooltip.js"></script>
   	<script src="js/fileUpload.js"></script>
</body>