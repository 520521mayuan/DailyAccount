<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<meta character="UTF-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimal-ui">
	<title>JSP增加学生信息mysql</title>
	<link rel="stylesheet" href="css/common.css" type="text/css" />
        <link rel="stylesheet" href="css/responsive.css" type="text/css" />
<style type="text/css">
input[type=submit] {
    width: 100%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}
input[type=text], select {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}
</style>
</head>
<body bgcolor="#cc99ff">
<h1>增加新的条目</h1>
<a href="mysql-ref.jsp" target="_blank"> 本月明细 </a>
<h2>添加新记录</h2>
<script>
function inputFocus(i){
	if(i.value==i.defaultValue){ i.value=""; i.style.color="#000"; }
}
function inputBlur(i){
	if(i.value==""){ i.value=i.defaultValue; i.style.color="#888"; }
}
function validate(){
	x=document.AddRecord
	input1=x.xuehao.value
	input2=x.xingming.value
	input3=x.zhuanye.value
	var matches = /^(\d{4})-(\d{2})-(\d{2})$/.exec(input1);
	if(input2.length > 15){
		alert("哎呀，你这个赌噶菜，这里的输入不能超过15个字，精简一下")
		return false
	}
	else if(matches == null){
		document.getElementById('demo1').innerHTML="时间格式：yyyy-mm-dd"
		alert("噶菜，时间的格式不对")
		return false
	}
	else if(isNaN(parseFloat(input3)) || input3 > 999.99){
		document.getElementById('demo').innerHTML="输入的价钱需是数字且小于999.99"
		alert("噶菜，总价输入不对……")
		return false
	}
	else{
		return true
	}
}
</script>
<c:set var="now" value="<%=new java.util.Date()%>" />
<%--
Date dat = <fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss" />
Date today = new Date(); 
String dat = today.toString();
--%>
<form name="AddRecord" action="zengjia" method="post" onsubmit="return validate()">
<br/> 时间:
<input type="text" name="xuehao" style="color:#888;" value="<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" />" required>
<%--<input type="text" name="xuehao" style="color:#888;" value="<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" />" onfocus="inputFocus(this)" onblur="inputBlur(this)" />
--%>
<br/>物品:
<input type="text" id="TheGoods" name="xingming" required>
<br/>总价:
<input type="text" name="zhuanye" required> 
<br/>
<p id="demo" style="color:red;"></p>
<br/> <input type="submit" name="submit" value="提交餐饮记录">  &nbsp;   <input type="submit" name="submit1" class="button" value="提交日常用品记录">
</form>
<span >本月消费总额是(从本月1号到现在): ￥</span>
<span style="color:blue; font-size: 29"><jsp:include page="./mysql.jsp" /></span>
<img src="graph.png" alt="every month sum(money)" style="width:300px;height:200px;">
</body>
</html>
