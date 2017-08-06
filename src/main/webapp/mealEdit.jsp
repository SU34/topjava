<jsp:useBean id="meal" scope="request" type="ru.javawebinar.topjava.model.Meal"/>
<%--
  Created by IntelliJ IDEA.
  User: evg_uh
  Date: 07.08.17
  Time: 0:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>edit meal</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/meals/edit/save" method="post">
    <table border="1">
        <tr>
            <td>описание</td>
            <td>дата и время</td>
            <td>калории</td>
            <td>action</td>
        </tr>
        <tr>
            <td><input type="text" name="description" value="${meal.description}"></td>
            <td><input type="text" name="dateTime" value="${meal.dateTime}"></td>
            <td><input type="text" name="calories" value="${meal.calories}"></td>
            <input type="hidden" name="id" value="${meal.id}">
            <td><input type="submit" value="save"></td>
        </tr>
    </table>
</form>
</body>
</html>
