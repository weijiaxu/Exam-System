<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@  page import="ksxt.KsxtAction"%>
<html>
	<body style="background-image:url(./image/ope.gif)">
	<!-- 实现每个学号对应一个下载链接 -->
		文件下载
		<hr>
    <%
    	KsxtAction student = new KsxtAction();
        ArrayList students = student.querySno();
    %>
    <%
    for(int i= 0;i<students.size();i++){
student = (KsxtAction)students.get(i);
%>
<%=i+1 %>、
	<%
	String s = student.getSno();%>
<%=student.getSno() %>&nbsp;&nbsp;&nbsp;&nbsp;
		<%
		String a=s+".zip"; out.println(a);%>
		<a href="/JavaWebExamSystem/teacher/download.jsp?file=<%=a %>">下载</a><br>
<%
}
%>
	</body>
</html>
