<%@ page language="java" import="java.util.*" import="dongfang.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <body style="background-image:url(./image/ope.gif)">
 <%
 String b=new String(request.getParameter("context").getBytes("iso8859-1"),"gb2312");
 String a=request.getParameter("id");
 String d=request.getParameter("score");
 OperationAdd c=new OperationAdd();
 c.add(a,b,d);
 response.sendRedirect("./Operation.jsp");
 %>
 <%=a%><br>
 <%=b%>
 </body>
</html>
