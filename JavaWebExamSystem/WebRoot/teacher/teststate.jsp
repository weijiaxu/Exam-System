<%@ page language="java" import="java.util.*" import="dongfang.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>考试后台管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <% test teststate=new test();%>  
  
  <body style="background-image:url(./image/ope.gif)">
  <div align="center">
  <h1>学生考试状态管理</h1>
  <!-- 1 -->
  <!-- 1 -->
  <!-- 1 --> 
  <!-- 没有考试的学生 -->
  <br>
 <%ArrayList student_notonline=new ArrayList();
   student_notonline=teststate.notonline();%>
  <h3> <%=student_notonline.size()%>人没有考试<br></h3>
 <table border=1>
  <tr>
  <td align="center">学号</td>
  <td align="center">姓名</td>
  
  <!--  <td>身份</td>-->
  </tr>
  <tr>
  <%
  //将数据库中取出来的数据，在table表中显示出来  
  for(int i=0;i<student_notonline.size();i++)
  {
  student student1=(student)student_notonline.get(i);
   %>  
  <td align="center"> <%=student1.getSno() %></td>
  <td align="center"><%=student1.getSname()%></td>
  </tr> 
  <%}
  student_notonline.clear(); %>
  </table>
   <% student_notonline.clear(); %>
  
  <!-- 2-->
  <!-- 2-->
  <!-- 2-->
 <!-- 正在考试的学生 -->
<br>
 <%ArrayList student_online=new ArrayList();
 student_online=teststate.online();%>
 <h3> <%=student_online.size() %>人正在考试<br></h3>
 <table border=1>
  <tr >
  <td align="center">学号</td>
  <td align="center">姓名</td>
   <!--  <td>身份</td>-->
  </tr>
  <tr>
  <%
  //将数据库中取出来的数据，在table表中显示出来  
  for(int i=0;i<student_online.size();i++)
  {
  student student=(student)student_online.get(i);
  //request.setCharacterEncoding("gb2312");
  //response.setContentType("text/html;charset=gb2312");
   %>  
  <td align="center"> <%=student.getSno() %></td>
  <td align="center"><%=student.getSname()%></td>
  <!--<td > <%=student.getIdentify()%></td>-->
  </tr> 
  <%}
 %>
  </table>
 <%//student_online.clear(); %>
  <!-- 3 -->
  <!-- 3 -->
  <!-- 3 -->
  <!-- 考试完成的学生 -->
 <br>
  <%ArrayList student_finished=new ArrayList();
  student_finished=teststate.finished();%>
  <h3 > <%=student_finished.size() %>人考试完成<br></h3>
  <table border=1>
  <tr >
  <td align="center">学号</td>
  <td align="center">姓名</td>
  <!--  <td>身份</td>-->
  </tr>
  <tr>
  <%
  for(int i=0;i<student_finished.size();i++)
  {
  student student3=(student)student_finished.get(i);
   %>  
  <td align="center"> <%=student3.getSno() %></td>
  <td align="center"><%=student3.getSname()%></td>
  <!--<td > <%=student3.getIdentify()%></td>  -->
  </tr> 
  <%}
  %>
  </table>
  <%student_finished.clear();  %>
  </div>
  </body>
</html>
