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
    <title>sdf</title>

</head>
<body>
<caption><h2>餐饮</h2></caption>
<table border="1" cellpadding="5">
    <tr>
        <td>times</td>&nbsp;
        <td>goods</td>&nbsp;
        <td>money</td>&nbsp;
        <td>del</td>&nbsp;

    </tr>
    <c:forEach var="item" items="${listall}">
        <tr>
            <td><c:out value="${item.getDateTimes()}" /></td>
            <td><c:out value="${item.getGoods()}" /></td>
            <td><c:out value="${item.getSums()}" /></td>
            <td><a href="">删除</a></td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
