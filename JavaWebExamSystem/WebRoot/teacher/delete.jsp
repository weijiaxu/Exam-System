<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

  <body style="background-image:url(./image/ope.gif)">
  <div align="center">
  <form action="/JavaWebExamSystem/delete.action">
  <% String id=request.getParameter("id"); 
     session.setAttribute("id", id);
  %> 
  
 <h2><strong>你确认删除第<%=id %>题吗？ </strong></h2> 
 <input type="submit" value="确认">
 <input type="button" value="取消" onClick="window.location.href='main.jsp'">
 </form>
 </div>
  </body>
  
</html>
