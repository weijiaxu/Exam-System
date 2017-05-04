<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page  import="dongfang.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>操作题后台</title>
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
 //将数据从数据库去出来
 OperationShow operationShow=new OperationShow();
 ArrayList operations=operationShow.con();
  %> 
  <body style="background-image:url(./image/ope.gif)">
   <!-- 将数据在table中显示出来 -->
  <table border=2 align="center"  height="70%" width="100%">
  <tr >
  <td>题号</td>
  <td>内容</td>
  <td>该题分数</td>
  <td>修改</td>
  <td>删除</td>
  </tr>
  <tr>
  <%
  //将数据库中取出来的数据，在table表中显示出来  
  for(int i=0;i<operations.size();i++)
  {
  Operation opera=(Operation)operations.get(i);
  request.setCharacterEncoding("gb2312");
  response.setContentType("text/html;charset=gb2312");
   %>  
  <td  align="center"> <%=opera.getOpearationid() %></td>
  <td ><%=opera.getOtitle()%></td>
  <td > <%=opera.getSinopescore()%></td>
  <td ><a href="./teacher/operationChange.jsp?id=<%=opera.getOpearationid() %>"> 修改   </a></td>
  <td ><a href="./teacher/operationDel.jsp?id=<%=opera.getOpearationid() %>"> 删除   </a></td>
  </tr> 
  <%} %>
  </table>
  <form action="./teacher/OperationAdd.jsp">
      题号<input type="text"name="id">内容<input type="text" name="context">分数<input type="text" name="score"><input type="submit" value="新增题目">
  </form>
  </body>
  </html>