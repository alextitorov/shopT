<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Продажи</title>
    <style>
        <%@include file="css/main.css" %>
    </style>
</head>
<body>
<%@include file="include/header.html"%>
<h1>Продажи</h1>
<table border="1px">
    <tr>
        <th>Id</th>
        <th>Дата</th>
        <th>Позиций</th>
        <th>Сумма</th>
        <th>Статус</th>
    </tr>
    <c:forEach var="sale" items="${sales}">
        <tr>
            <td>
                <a href="<%=request.getContextPath()%>/sale/orderInfo?saleId=${sale.id}">${sale.id}</a>
            </td>
            <td>${sale.date}</td>
            <td>${sale.amount}</td>
            <td>${sale.totalSum}</td>
            <td>${sale.state}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>