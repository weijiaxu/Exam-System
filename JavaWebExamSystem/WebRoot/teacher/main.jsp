<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="Dao.userdao" %>
<%@ page import="Action.ShowAction" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>选择题显示页面</title>	
  </head>
  
  <body style="background-image:url(./image/ope.gif)">
  <h1 align="center">以下是题库中的选择题：</h1>
   <form action="/JavaWebExamSystem/update.action?action=updateall" method="post" align="center">
   <table align="center" border="2">
   <tr>
  <td width="30">题号</td>
  <td width="200">题目</td>
  <td width="100">选项A</td>
  <td width="100">选项B</td>
  <td width="100">选项C</td>
  <td width="100">选项D</td>
  <td width="100">标准答案</td>
  <td width="30">分数</td>
  <td width="100">编辑</td>
  <td width="100">删除</td>
   </tr>
 
   <%userdao showdao=new userdao();
    ArrayList selections=showdao.show(); 
    for(int i=0;i<selections.size();i++)
    { ShowAction selection=(ShowAction)selections.get(i);
      String id=selection.getSelectid();
      String title=selection.getStitle();
       String A=selection.getOptionA();
       String B=selection.getOptionB();
       String C=selection.getOptionC();
       String D=selection.getOptionD();
        String answer=selection.getSanswer();
        String score=selection.getSinselscore();
     %>
   
     <tr>
     <td >
     <%=id %>
     </td>
     <td >
     <%=title %>
     </td>
     <td >
     <%=A %>
     </td>
     <td >
     <%=B %>
     </td>
     <td >
     <%=C%>
     </td>
     <td >
     <%=D %>
     </td>
     <td >
     <%=answer %>
     </td>
     <td >
     <%=score %>
     </td>
     <td >

       <a href="./teacher/update.jsp?id=<%=id %>&&title=<%=title %>&&A=<%=A%>&&B=<%=B%>&&C=<%=C%>&&D=<%=D%>&&score=<%=score%>&&answer=<%=answer%>">编辑该题</a>
     </td>
     <td >
     <a href="./teacher/delete.jsp?id=<%=id %>">删除该题</a>
     </td>  
    </tr>
    <%} %> 
   </table>
   <div align="center">
   <a href="./teacher/add.jsp" ><h3 align="center">新增选择题</h3></a>
   <select name="score">
   <option value="1">1</option>
   <option value="1.5">1.5</option>
   <option value="2">2</option>
   <option value="2.5">2.5</option>
   <option value="3">3</option>
   <option value="3.5">3.5</option>
   <option value="4">4</option>
   <option value="4.5">4.5</option>
   <option value="5">5</option>
   </select>
    <input type="submit" value="修改所有的选择题分数值">
    </div>
   </form>
  </body>
</html>
 