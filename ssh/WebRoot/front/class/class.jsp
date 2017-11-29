<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	<title>班级信息</title>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="css/base.css" rel="stylesheet">
</head>
<body>	
    <div class="container mt30">
	  <div class="row w">
		 <div class="panel panel-default">
		  <div class="panel-heading">班级信息</div>
		  <div class="panel-body">
			<div class="container mt20 wp95" ng-controller="studentController">	    
			   <div class="col-lg-12">
<%-- 			  	<form class="form-inline mt15" action="stus.action">
					<div class="form-group">
					  <label for="exampleInputFile">属性</label>
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
				  
				</form> --%>
		
				<s:form action="importExcel" method="post" enctype="multipart/form-data" class="mt10">
					<a class="btn btn-info mr20" data-toggle="modal" data-target="#addClass">新增</a>
				</s:form>
				
				<table class="table table-bordered">
					<tr bgcolor="black" style="color:white">
					  <th class="tc">ID</th>
					  <th>编号</th>
					  <th class="tc">操作</th>
					</tr>
					<s:iterator var="c" value="clas" status="st"> 
					 	<tr>	
					 	  <td class="tc"><s:property value="#c.claId"/></td>
					 	  <td><s:property value="#c.cNo" /></td>
					 	  <td class="tc">
						 	  <a href="#editClass" role="button" class="btn" data-toggle="modal">编辑</a>
						 	  &nbsp;&nbsp;
						 	  <a href="classDelete.action?cid=${c.cid}">删除</a>
					 	  </td>
						</tr>
					</s:iterator>
				</table>
			</div>
			
			<!-- 学生新增 -->
			<s:include value="classAdd.jsp"></s:include>
			
		    <!-- 学生编辑 -->
			<s:include value="classEdit.jsp"></s:include>
			
			</div>
		  </div>
		</div>
	  </div>
	</div>

    <script src="js/jquery/jquery.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
</body>
