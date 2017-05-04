<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 
  
 <body style="background-image:url(./image/ope.gif)">
 <div align="center">
<form action="/JavaWebExamSystem/add.action" method="post"> 
 请输入以下信息： <br>
 题目：<input type="text" name="title"><br>
 选项A：<input type="text" name="A"><br>
 选项B：<input type="text" name="B"><br>
 选项C：<input type="text" name="C"><br>
 选项D：<input type="text" name="D"><br>
 正确答案：<input name="answer" type="radio" value="A">A
 <input name="answer" type="radio" value="B">B
 <input name="answer" type="radio" value="C">C
 <input name="answer" type="radio" value="D">D<br>
 <input type="submit" value="确认增加">
</form>
</div>
</body>
</html>
