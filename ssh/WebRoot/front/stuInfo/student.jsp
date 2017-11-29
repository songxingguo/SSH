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
    <title>学生信息</title>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="bootstrap/css/fileinput.min.css" rel="stylesheet">
	<link href="css/base.css" rel="stylesheet">
	<link href="css/common.css" rel="stylesheet">
</head>
<body ng-app="studentModule">
	<div class="container mt30" ng-controller="studentController">
	  <div class="row w">
		 <div class="panel panel-default">
		  <div class="panel-heading">学生信息</div>
		  <div class="panel-body">
			<div class="container mt20 wp95">	    
			   <div class="col-lg-12">
			  	<form class="form-inline mt15" action="stus.action">
					<div class="form-group">
					  <label for="exampleInputFile">属性</label>
					  
				      <label for="exampleInputFile">班级</label>
  					  <s:select cssClass="form-control" 
  					  	list="clas" listKey="cNo" listValue="cNo" name="cNo"/>
							 
					  <s:select cssClass="form-control" 
							  list="#{'stuNo':'学号', 'stuName':'姓名', 'stuAge':'年龄'}"
							  name="proName" value="stuNo" ng-model="proName" ng-change="gradeChange(proName)"/>
							   
					    <select name="operate" id="operate"  class="form-control"> 
					    	<option value="%">包含</option>
					    	<option value="=">等于</option>
					    </select>
					    
					    <input type="text" class="form-control" name="proValue">
					</div>
				    <button type="submit" class="btn btn-default">搜索</button>
				  
				</form>
		
				<s:form action="importExcel" method="post" enctype="multipart/form-data" class="mt10">
					<s:a cssClass="btn btn-info mr20" action="addStu.action">新增</s:a>
				</s:form>
				
				<table class="table table-bordered">
					<tr bgcolor="black" style="color:white">
					  <th class="tr">班级</th>
					  <th>学号</th>
					  <th>姓名</th>
					  <th class="tr">年龄</th>
					  <th class="tc">操作</th>
					</tr>
					<s:iterator var="s" value="stus" status="st"> 
					 	<tr>	
					 	  <td class="tr"><s:property value="#s.cla.cNo"/></td>
					 	  <td><s:property value="#s.stuNo"/></td>
					 	  <td><s:property value="#s.stuName" /></td>
					 	  <td class="tr"><s:property value="#s.stuAge"/></td>
					 	  <td class="tc">
						 	  <a href="editStu.action?sid=${s.sid}" >编辑</a>
						 	  <a href="stuDelete.action?sid=${s.sid}" >删除</a>
					 	  </td>
						</tr>
					</s:iterator>
				</table>
				
				<h2>共 <s:property value="stuCount"/> 条</h2>
				
				<div id="callBackPager"></div>
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
    <script src="bootstrap/js/fileinput.min.js"></script>
    <script src="bootstrap/js/tooltip.js"></script>
   	<script src="js/student.js"></script>
   	<script src="js/extendPagination.js"></script>
</body>