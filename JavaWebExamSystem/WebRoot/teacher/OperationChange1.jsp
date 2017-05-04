<%@ page language="java" import="java.util.*" import="dongfang.*"   pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title> 修改页面 </title> 
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
   String a=new String(request.getParameter("id1").getBytes("iso8859-1"),"UTF-8");
   String b=new String(request.getParameter("context").getBytes("iso8859-1"),"UTF-8");
   String d=new String(request.getParameter("score").getBytes("iso8859-1"),"UTF-8");
   %> 
   <%
   OperationChange c=new OperationChange();
   c.change(a,b,d);   
   response.sendRedirect("./Operation.jsp");
    %>  
  </body>
</html>
