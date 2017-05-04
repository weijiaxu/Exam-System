<%@ page language="java" import="java.util.*,singleselect.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>单选页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  
  <body >&nbsp; 
   
  <script type="text/javascript">
       function sinTest(){
          var result=window.confirm("您确认提交吗？");
          if(result){
             singleselects.submit();
          }
       }
       
  </script>
   
     <% 
        String account=(String)session.getAttribute("account");
        String sname=(String)session.getAttribute("sname");
        SinSelOperation sso=new SinSelOperation();
        //您希望每个学生挑选的选择题题目个数sinnumn
        int sinnum=20;
        ArrayList sinsels=sso.main(sinnum,account);
        session.setAttribute("sinnum", sinnum);
        
     %>
   <div  align="right" ><font color="red"><%=sname%></font>正在考试中</div>
   
   <div align="center" >      
   <form action="/JavaWebExamSystem/SingleTest.action" name="singleselects" method="post">
   <table border=0  width="100%" height="100%" >
     <%
        for(int i=0;i<sinsels.size();i++){
            SingleSelect sinsel=(SingleSelect)sinsels.get(i);
      %>
     <tr height="50">
           <td colspan=4><%=i+1%>.<c:out value="<%=sinsel.getStitle()%>" escapeXml="true"/></td> 
     </tr>
     
     <tr height="100">
       <td><input type="radio" name="s<%=i%>"  value="A">A.<c:out value="<%=sinsel.getOptionA()%>" escapeXml="true"/></td>
       <td><input type="radio" name="s<%=i%>"  value="B">B.<c:out value="<%=sinsel.getOptionB()%>" escapeXml="true"/></td>
       <td><input type="radio" name="s<%=i%>"  value="C">C.<c:out value="<%=sinsel.getOptionC()%>" escapeXml="true"/></td>
       <td><input type="radio" name="s<%=i%>"  value="D">D.<c:out value="<%=sinsel.getOptionD()%>" escapeXml="true"/></td>
     </tr>
     <%} %>
     </table>
     
     <h2>提交成功之后进入操作题页面答题</h2>
     <input type="button" name="sub" value="提交" onclick="sinTest()"  style="width:120px; height:60px;color:red;font-size:30px;" >
     
     </form>
     </div>
     
  <h2 align="center">如果你是第二次登陆，想直接进入操作题页面请点击此按钮<a href="/JavaWebExamSystem/login.action"><input value="进入" type="button"></a></h2>
  </body>
</html>
