<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="grade.Grade" %>
<%@ page import="grade.BeforeAction" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'pingfeng.jsp' starting page</title>
    
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
   
   
<h1 align="center"> 操作题打分：
</h1><!-- 若您不想下载学生操作题答案，请到Tomcat根目录下Tomcat7.0\webapps\JavaWebExamSystem\upload文件夹下寻找 -->
<p align="center"><font color="red">下载不可用！若您想下载学生操作题答案，请到D:\upload文件夹下寻找</font></p>
<center>

   <form action="/JavaWebExamSystem/grade1.action"  name="ping">
    
    <%   BeforeAction beforeaction=new BeforeAction();
         ArrayList grades=beforeaction.query();
         //System.out.print(grades.size());
         session.setAttribute("grades", grades);
    %>
<table border=2>
    <tr>
     <td>学号</td>
     <td>操作题号</td>
     <td>操作题答案</td>
     <td>操作题分数</td>
     <td>总分</td>
     
    </tr>
    <%
     for(int i=0;i<grades.size();i++){
        Grade grade=(Grade)grades.get(i);
     %>
     
     <tr>
        <td><%=grade.getSno() %></td>
        <td><%=grade.getOpeid() %></td>
        <td><a href="./teacher/download.jsp?file=<%=grade.getSno()%>.zip">下载</a></td>
        <td><input type="text" name="opescore<%=i%>" value="<%=grade.getOpescore()%>"></td>
        <td><%=grade.getSumscore()%></td>
     </tr>
        <%} %>
       
    </table>
    <br>
    <br>
    <input type="submit" value="保存评分" />
     
   </form>
   </center>

    
  </body>
</html>
