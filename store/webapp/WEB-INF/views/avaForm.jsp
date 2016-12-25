<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Загрузка аватара</title>
</head>
<body>
    <h1>Загрузка аватара</h1>
    <h2>Выберите файл:</h2>
    <form:form method="post" action="uploadAva" enctype="multipart/form-data">
        <table>
            <tr>
                <td>Файл: </td>
                <td><input name="avatar" type="file" />
                    <input type="submit" value="Upload" /></td>
            </tr>
        </table>
    </form:form>
    <c:if test="${not empty avatar}">
        <img src="<%=request.getContextPath()%>/image?type=avatar&id=${buyerId}" style="height: 100px;"/>
        ${avatar}
    </c:if>
</body>
</html>
