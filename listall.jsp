<%@ page import="util.Item" %>
<%@ page import="java.util.List" %><%--
Created by IntelliJ IDEA.
User: Administrator
Date: 2017/5/8
Time: 14:41
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>本月明细</title>
	</head>
	<body style="text-align: center;">
		<h2>餐饮</h2>
		<div style="margin-bottom: 15px">
			<a href="zengjia.jsp" style="margin-left: 250px;margin-top: 70px;text-decoration: none;">返回首页</a>
		</div>

		<div style="margin-left: 115px">
			<form action="mohu" method="post">
				<input type="text" name="search">
				<input type="submit" value="搜索">
			</form>
		</div>
		<table border="1" cellpadding="5" style="text-align: center;margin:auto;">
			<thead>
				<tr>
					<td>编号</td>&nbsp;
					<td>时间</td>&nbsp;
					<td>商品</td>&nbsp;
					<td>价格</td>&nbsp;
					<td>删除</td>&nbsp;
				</tr>
				<thead>
					<c:forEach var="item" items="${listall}">
					<tr>
						<td><c:out value="${item.getId()}" /></td>
						<td><c:out value="${item.getDateTimes()}"/></td>
						<td><c:out value="${item.getGoods()}" /></td>
						<td><c:out value="${item.getSums()}" /></td>
						<td><a href="/delete?itemID=${item.getId()}">删除</a></td>
					</tr>
							</c:forEach>
		</table>
		<c:if test="${currentPage != 1}">
		<td><a href="listall?page=${currentPage - 1}">Previous</a></td>
		</c:if>

		<table border="1" cellpadding="5" cellspacing="5">
			<tr>
				<c:forEach begin="${currentPage}" end="${currentPage+5}" var="i">
				<c:choose>
				<c:when test="${currentPage eq i}">
				<td>${i}</td>
				</c:when>
				<c:otherwise>
				<td><a href="listall?page=${i}">${i}</a></td>
				</c:otherwise>
				</c:choose>
				</c:forEach>
			</tr>
		</table>
		<%--For displaying Next link --%>
		<c:if test="${currentPage lt noOfPages}">
		<td><a href="listall?page=${currentPage + 1}">Next</a></td>
		</c:if>
	</body>
</html>
