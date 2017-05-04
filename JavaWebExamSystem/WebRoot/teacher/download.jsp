<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 定义点击下载时出现的对话框 -->
<%
		String filename = request.getParameter("file");
	    //告诉客户端出现下载框，并指定下载框中的文件名
		response.setHeader("Content-Disposition","attachment;filename="+filename);   
    	//指定文件类型   
		response.setContentType("application/x-zip-compressed");   
		//指定文件
		RequestDispatcher rd = request.getRequestDispatcher("/D:/upload/" + filename);//必须写为"/upload/"
		rd.forward(request, response);
		out.clear();
		pageContext.pushBody();
 %>