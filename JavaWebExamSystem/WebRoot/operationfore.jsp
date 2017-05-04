<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="ksxt.KsxtAction"%>
<%@ page import="ksxt.UploadAction"%>
<html>
  <body style="background-image:url(./image/ope.jpg)">
    <%
    //m1,m2,m3对应于要抽取简单题、中等题、复杂题数目
    int m1=1,m2=1,m3=1;
   	String account = (String)session.getAttribute("account");
   	String sname = (String)session.getAttribute("sname");
   	String sid2 = (String)session.getAttribute("sid2");
   	%>
   	<p align="right"><font color="red"><%=sname %></font>正在答题中</p>
   	二、操作题<br><br>
   	<!-- 操作题显示 -->
   	<%
   	//根据学号选出grade中操作题字符串opeid，若不为空则选出对应的操作题，否则随机选题
    KsxtAction grade = new KsxtAction();
    String opeid = grade.queryOpeid(account);
    //如果grade表中有操作题题号字符串，显示操作题
    if(opeid!=null){
    ArrayList operations = grade.operate(opeid,m1,m2,m3);
    for(int i= 0;i<operations.size();i++){
	grade = (KsxtAction)operations.get(i);%>
	<%=i+1 %>、<%=grade.getOtitle() %><br><br>
	<%}}//如果grade表中题号字符串不存在
	else{
    ArrayList operations = grade.operate("0",m1,m2,m3);
    for(int i= 0;i<operations.size();i++){
	grade = (KsxtAction)operations.get(i);%>
	<%=i+1 %>、<%=grade.getOtitle() %><br><br><%}}%>
	<!--上传文件form -->
    <form name="upload" action="/JavaWebExamSystem/loginSuccess.action" method="post" enctype="multipart/form-data">   
   	选择一个压缩文件：<input type="file" name="upload" />    
    <input onclick="add()" type="button" value="上传" />
    </form>
    <!--定义上传文件命名格式 -->
    <font color=red size="4">
   	注意：每道操作题答案为一个工程文件夹，第1-2题工程命名格式分别对应为test1,test2,不需要压缩。<br>
 	&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;然后将两道操作题答案放到一个文件夹中，压缩后上传。压缩文件夹命名格式为：
 	学号.zip 或者 学号.rar，即：<%=account %>.zip 或者 <%=account %>.rar<br>
 	&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;第三道操作题是大作业，在考试结束之前手机拍照后回去做。
    </font>  
    <!-- 显示提交结果 -->
    <script type="text/javascript">
    function add(){
    w = document.upload.upload.value;
    q = <%=account %>+".zip";
    if(w==""){
    window.alert("上传内容为空，请重新上传！");
    }else{
    var result=window.confirm("你确定上传吗？");
    if(result){
    upload.submit();
    }}
    }
    <%
    if(sid2=="f"){
    %>
    window.alert("上传失败！上传文件命名错误,请按格式命名后上传！");//在此时出现对话框，使程序暂停，CPU是否仍在此程序工作？？？？右上角好像在运行
    <%}else if(sid2=="e"){
    %>
    window.alert("上传出错，请重新上传！");
    <%}else{}
    session.setAttribute("sid2", "nulll");
    %>
   </script>
  </body>
</html>