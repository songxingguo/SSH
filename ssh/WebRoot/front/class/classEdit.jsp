<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'classEdit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <!-- 班级编辑-->
	<form class="form-horizontal" action="claEdit.action">
	<div class="modal fade" id="editClass" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">班级编辑</h4>
	      </div>
	      <div class="modal-body">
			  <div class="form-group">
			    <label for="claId" class="col-sm-2 control-label">ID</label>
			    <div class="col-sm-9">
			      <input type="text" class="form-control" id="claId" name="claId" placeholder="ID">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="cNo" class="col-sm-2 control-label">编号</label>
			    <div class="col-sm-9">
			      <input type="text" class="form-control" id="cNo" name="cNo" placeholder="编号">
			    </div>
			  </div>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        <button type="submit" class="btn btn-primary">保存</button>
	      </div>
	    </div>
	  </div>
	</div> 
	</form>
  </body>
</html>
