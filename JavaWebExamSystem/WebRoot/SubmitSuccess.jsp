<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'SubmitSuccess.jsp' starting page</title>
    
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
    
    <%
        String account=(String)session.getAttribute("account");
        String sname=(String)session.getAttribute("sname");
     %>
    <div align="center"><br>
      <h1>选择题提交成功</h1>
      <br>
      <br>
      <h2>学号:<font color="green"><%=account%></font></h2>
      <h2>姓名:<font color="green"><%=sname%></font></h2>
      <br>
      <br>
      <h1><a href="/JavaWebExamSystem/login.action">进入操作题页面进行答题</a></h1>
    </div>
  </body>
</html>
