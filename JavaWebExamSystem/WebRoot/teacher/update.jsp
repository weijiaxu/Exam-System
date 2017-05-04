<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  <body style="background-image:url(./image/ope.gif)">
  <div  align="center">
   <form action="/JavaWebExamSystem/update.action" method="post">
   
 <%
   
   String id=new String(request.getParameter("id").getBytes("iso8859-1"),"UTF-8");
   String answer=new String(request.getParameter("answer").getBytes("iso8859-1"),"UTF-8");
   session.setAttribute("answer", answer);
   session.setAttribute("id", id);
   String title=new String(request.getParameter("title").getBytes("iso8859-1"),"UTF-8");
   String A=new String(request.getParameter("A").getBytes("iso8859-1"),"UTF-8");
   String B=new String(request.getParameter("B").getBytes("iso8859-1"),"UTF-8");
   String C=new String(request.getParameter("C").getBytes("iso8859-1"),"UTF-8");
   String D=new String(request.getParameter("D").getBytes("iso8859-1"),"UTF-8");
 %>
   请修改第<%=id %>题对应的信息：<br/>
 题目：<input type="text" name="title" value=<%=title%>><br>
 选项A：<input type="text" name="A" value=<%=A%>><br>
 选项B：<input type="text" name="B" value=<%=B%>><br>
 选项C：<input type="text" name="C" value=<%=C%>><br>
 选项D：<input type="text" name="D" value=<%=D%>><br>
 正确答案：<%=answer%>
 修改为：<input name="answer" type="radio" value="A">A
 <input name="answer" type="radio" value="B">B
 <input name="answer" type="radio" value="C">C
 <input name="answer" type="radio" value="D">D<br>
该题分数：<input type="text" name="score" value=<%=request.getParameter("score")%>><br>
 <input type="submit" value="提交修改">
 </form>
 </div>
 </body>
</html>
