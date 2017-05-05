<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<meta character="UTF-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimal-ui">
	<title>JSP增加学生信息mysql</title>
	<link rel="stylesheet" href="css/zhuye.css" type="text/css">
</head>
<body bgcolor="#cc99ff">
	<h1>增加新的条目</h1>
	<a href="mysql-ref.jsp" target="_blank"> 本月明细 </a>
	<h2>添加新记录</h2>

<script>
	function validate(){
		x=document.AddRecord
		input1=x.DateTimes.value
		input2=x.Goods.value
		input3=x.Sums.value
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
<form name="AddRecord" action="zengjia" method="post" onsubmit="return validate()">
<br/> 时间:
<input type="text" name="DateTimes" style="color:#888;" value="<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" />" required>
<br/>物品:
<input type="text" id="TheGoods" name="Goods" required>
<br/>总价:
<input type="text" name="Sums" required>
<br/>
<p id="demo" style="color:red;"></p>
<br/> <input type="submit" name="submit" value="提交餐饮记录">  &nbsp;   <input type="submit" name="submit1" class="button" value="提交日常用品记录">
</form>
<span >本月消费总额是(从本月1号到现在): ￥</span>
<span style="color:blue; font-size:29"><jsp:include page="./mysql.jsp" /></span>
<img src="graph.png" alt="every month sum(money)" style="width:300px;height:200px;">
</body>
</html>
