<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登陆界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="background-image:url(./image/background1.jpg)">
  
    <script type="text/javascript">
    function validate()
     {
      if(Login.account.value=="")
        { window.alert("账号不能为空，请您输入账号");
          return ;
        }
       if(Login.password.value=="")
        { window.alert("密码不能为空，请您输入密码");
          return ;
        }
       Login.submit();
  
     }
   </script>
   
    <h1 align="center">欢迎进入考试系统</h1>
    
    <div align="center">
    <form action="/JavaWebExamSystem/LoginAction.action"  method="post" name="Login">
    <br>
    <br>
    <br>
    <br>
    请您输入个人信息进行登录：
    <p>账号：<input type="text" name="account"/></p>
    <p>密码：<input type="password" name="password"/></p>
    <p>身份：
    <select name="identify">
       <option value="学生" >学生</option>
       <option value="老师">老师</option>
    </select>
    <p><input type="button" value="登录" onclick="validate()" />&nbsp;&nbsp;<input type="reset" value="重置"/></p>
    </form>
    </div>   
    </body>
</html>
