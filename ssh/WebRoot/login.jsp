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
    
    <title>登录页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="css/base.css" rel="stylesheet">
  </head>
  
  <body>
	 <div class="row mt50" ng-app="loginModule"> 
	   <div class="bc w500" ng-controller="loginController">
	        <form name="login" class="form-horizontal" action="login.action" method="post">
	         <div class="form-group has-feedback col-sm-11" id="username">	           
			    <input type="text"  class="form-control"  name="username" 
		        	placeholder="账号" ng-model="username" 
		        	  ng-change="changeState('username', login.username.$invalid)"  required>
	         </div>
	         	         
	         <div class="form-group has-feedback col-sm-11" id="password">
	           <label class="sr-only" for="password"></label>
               <input type="password" class="form-control" 
              	placeholder="密码" name="password" ng-minlength="3" ng-model="password" 
	        	  ng-change="changeState('password', login.password.$invalid)" required/>
	          </div>
	          
	         <div class="col-sm-11"><h3 class="mb10"><s:actionerror/></h3></div>
	         <div class="form-group col-sm-11">
	            <button class="btn btn-lg btn-primary btn-block" ng-disabled="login.$invalid" type="submit">安 全 登 录</button>
	         </div>
	       </form>
	   	</div>
	  </div>
	  
    <script src="js/jquery/jquery.js"></script>
    <script src="js/angularjs/angular.min.js"></script>
    <script src="js/angularjs/angular-messages.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="bootstrap/js/tooltip.js"></script>
    <script src="js/login.js"></script>
  </body>
</html>