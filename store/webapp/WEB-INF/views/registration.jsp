<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Регистрация</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>

<table>
    <h1>Регистрация</h1>
    <form:form action="registration" method="post" modelAttribute="buyerDTO">
        <form:hidden path="id"/>
        <tr>
            <th>Имя:</th>
            <td><form:input path="name"/></td>
            <td><form:errors path="name" cssClass="error"></form:errors> </td>
        </tr>
        <tr>
            <th>Пароль:</th>
            <td><input name="password" type="password"/></td>
            <td><form:errors path="password" cssClass="error"></form:errors> </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Зарегистрироваться"></td>
        </tr>
        <tr>
            <td colspan="2">
                <a href="<%=request.getContextPath()%>/login">Я уже зарегистрирован</a>
            </td>
        </tr>
    </form:form>
</table>

</body>
</html>
