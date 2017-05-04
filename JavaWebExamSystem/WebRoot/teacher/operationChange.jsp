<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <%
 String i=request.getParameter("id");
 %>
  <body style="background-image:url(./image/ope.gif)">
  <h3 align="center">正在修改第  <%=i%> 题</h3>
  <div align="center">
  <form action="./teacher/OperationChange1.jsp"  >
  <input type="hidden" value="<%=i%>" name="id1">
         新内容<input type="text" name="context" >
             分数<input type="text" name="score">     
       <input type="submit" value="确认修改">
  </form>
  </div>
  </body>
  </html>
