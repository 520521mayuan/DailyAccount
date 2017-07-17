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
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<html>
    <head>
	<title>本月明细</title>
    </head>
    <body style="text-align: center;">
	<jsp:include page="./include/header.html" />
	<div>
	    <form class="form-inline"  role="form" action="mohu" method="post">
		<div class="input-group">
		    <input type="text" class="form-control" id="name" name="search" placeholder="请输入关键字">
		</div>
		<div class="input-group">
		    <input type="submit" class="btn btn-default" value="搜索">
		</div>
		<div class="input-group">
		    <button type="button" class="btn btn-default"><a href="zengjia.jsp">返回首页</a></button>
		</div>
	    </form>
	</div>
	
	<div>
	    <div>
		<table class="table" border="1" cellpadding="5" style="text-align: center;margin:auto;">
		    <thead>
			<tr>
			    <td>编号</td>&nbsp;
			    <td>时间</td>&nbsp;
			    <td>商品</td>&nbsp;
			    <td>价格</td>&nbsp;
			    <td>删除</td>&nbsp;
			</tr>
			<thead>
			    <c:forEach var="item" items="${page.getPageData()}">
				<tr>
				    <td><c:out value="${item.getId()}" /></td>
				    <td><c:out value="${item.getDateTimes()}"/></td>
				    <td><c:out value="${item.getGoods()}" /></td>
				    <td><c:out value="${item.getSums()}" /></td>
				    <td><a href="./delete?itemID=${item.getId()}">删除</a></td>
				</tr>
			    </c:forEach>
			</thead>
		</table>
	    </div>
	    <div style="width: 500px;margin:0 auto;padding-top: 15px">
		<a href="./listall?pagenumber=1">首页</a>
		<a href="./listall?pagenumber=${page.getPreviousNumber()}">上一页</a>
		<a href="./listall?pagenumber=${page.getNextNumber()}">下一页</a>
		<a href="./listall?pagenumber=${page.getPageCount()}">末页</a>
		当前第${page.getPagenumber()}页,总共${page.getPageCount()}页
	    </div>
	</div>
    </body>
</html>
