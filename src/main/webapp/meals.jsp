<%--
  Created by IntelliJ IDEA.
  User: hp_lu_evg
  Date: 06.08.17
  Time: 0:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://example.com/functions" prefix="f" %>
<html>
<head>
    <title>Meals</title>
</head>
<body>
<h1>Meals</h1>
<h3><a href="index.html">Home</a></h3>
<table border="1">
    <tr>
        <td>#</td>
        <td>description</td>
        <td>dateTime</td>
        <td>calories</td>
        <td>exceed</td>
        <td colspan="2">actions</td>
    </tr>
    <%--<jsp:useBean id="meals" scope="request" type="java.util.List"/>--%>
    <c:forEach items="${meals}" var="meal" varStatus="status">
        <%--<jsp:useBean id="meal" scope="request" type="ru.javawebinar.topjava.model.MealWithExceed"/>--%>
        <c:if test="${meal.exceed == true}"><tr bgcolor="red"></c:if>
        <c:if test="${meal.exceed == false}"><tr></c:if>
        <td>#${status.index+1}</td>
        <td>${meal.description}</td>
        <td>${f:formatLocalDateTime(meal.dateTime,'yyyy-MM-dd hh:mm:ss')}</td>
        <td>${meal.calories}</td>
        <td>${meal.exceed}</td>
        <td>
            <form action="${pageContext.request.contextPath}/meals/edit" method="post">
                <input type="submit" value="редактировать">
            </form>
        </td>
        <td>
            <form action="${pageContext.request.contextPath}/meals/del" method="post">
                <input type="submit" value="удалить">
                <input value="${meal.id}" name="id">
            </form>
        </td>
        </tr>
    </c:forEach>
</table>

<br>
<form action="${pageContext.request.contextPath}/meals/create" method="post">
    <table>
        <tr>
            <td>
                <input type="datetime" name="dateTime">
            </td>
            <td>
                <input type="text" name="description">
            </td>
            <td>
                <input type="number" name="calories">
            </td>
            <td>
                <%--<input type="number" name="id" value="${}">--%>
            </td>
            <td>
                <input type="submit" value="создать пищу">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
