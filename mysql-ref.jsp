<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List things Records</title>
</head>
<body>
    <sql:setDataSource
        var="myDS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/monthconsume"
        user="root" password="sqllife"
   />
     
    <sql:query var="listUsers" dataSource="${myDS}">
        SELECT times,goods,money from things where times between DATE_FORMAT(now(),'%Y-%m-1') and DATE_FORMAT(now(),'%Y-%m-%d') order by times;
    </sql:query>
     
    <sql:query var="listdetail" dataSource="${myDS}">
        SELECT times,goods,money from detail where times between DATE_FORMAT(now(),'%Y-%m-1') and DATE_FORMAT(now(),'%Y-%m-%d') order by times;
    </sql:query>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>生活用品</h2></caption>
            <tr>
                <th>times</th>
                <th>goods</th>
                <th>money</th>
            </tr>
            <c:forEach var="user" items="${listUsers.rows}">
                <tr>
                    <td><c:out value="${user.times}" /></td>
                    <td><c:out value="${user.goods}" /></td>
                    <td><c:out value="${user.money}" /></td>
                </tr>
            </c:forEach>
         </table>
         <table border="1" cellpadding="5">
            <caption><h2>餐饮</h2></caption>
            <tr>
                <th>times</th>
                <th>goods</th>
                <th>money</th>
            </tr>
            <c:forEach var="user" items="${listdetail.rows}">
                <tr>
                    <td><c:out value="${user.times}" /></td>
                    <td><c:out value="${user.goods}" /></td>
                    <td><c:out value="${user.money}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
