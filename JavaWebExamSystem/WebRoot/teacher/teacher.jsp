<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>功能选择页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="background-image:url(./image/background1.jpg)">
    <div align="center">
    <form action=/JavaWebExamSystem/Teacher.action  method="post">
    <br>
    <br>
    <br>
    <br>
            选择功能
    <p><input  name="forward" type="radio" value="pingfeng">操作题打分</p>
    <p><input  name="forward" type="radio" value="main">对选择题库的维护</p>
    <p><input  name="forward" type="radio" value="operation">对操作题库的维护</p>
    <p><input  name="forward" type="radio" value="teststate">查看当前考试状态</p>
    <input type="submit" value="进入">
    </form>
    </div>
   </body>
</html>
    