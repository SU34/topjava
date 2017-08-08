<%@ page import="ru.javawebinar.topjava.util.TimeUtil" %><%--
  Created by IntelliJ IDEA.
  User: hp_lu_evg
  Date: 06.08.17
  Time: 0:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://example.com/functions" prefix="f" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <style>
        .exceeded {
            color: red;
        }

        .notExceeded {
            color: green;
        }
    </style>
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
        <td>id</td>
        <td colspan="2">actions</td>
    </tr>
    <jsp:useBean id="meals" scope="request" type="java.util.List"/>
    <c:forEach items="${meals}" var="meal" varStatus="status">
        <jsp:useBean id="meal" scope="page" type="ru.javawebinar.topjava.model.MealWithExceed"/>
        <tr class="${meal.exceed ? 'exceeded' : 'notExceeded'}">

            <td>#${status.index+1}</td>
            <td>${meal.description}</td>
            <td>
                    <%--<fmt:parseDate value="${meal.dateTime}" pattern="y-M-dd'T'H:m" var="parseDate"/>--%>
                    <%--<fmt:formatDate value="${parseDate}" pattern="yyyy.MM.dd HH:mm"/></td>--%>
                    <%--<td>${f:formatLocalDateTime(meal.dateTime,'yyyy-MM-dd hh:mm:ss')}</td>--%>
            <td><%=TimeUtil.dateTimeToString(meal.getDateTime())%>
            </td>
            <td>${meal.calories}</td>
            <td>${meal.exceed}</td>
            <td>${meal.id}</td>
            <td>
                <form action="${pageContext.request.contextPath}/meals" method="get">
                    <input type="hidden" value="${meal.id}" name="id">
                    <input type="submit" value="редактировать">
                    <input type="hidden" value="edit" name="action">
                </form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/meals" method="get">
                    <input type="submit" value="удалить">
                    <input type="hidden" value="${meal.id}" name="id">
                    <input type="hidden" value="delete" name="action">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<br>
<form action="${pageContext.request.contextPath}/meals" method="get">
    <table>
        <tr>
            <td><input type="submit" value="создать пищу"></td>
            <input type="hidden" value="new" name="action">
        </tr>
    </table>
</form>
</body>
</html>
