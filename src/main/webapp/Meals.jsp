<%--
  Created by IntelliJ IDEA.
  User: hp_lu_evg
  Date: 06.08.17
  Time: 0:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Meals</title>
</head>
<body>
<h1>Meals</h1>
<c:forEach items="${meals}" var="meal" varStatus="status">
    <table>
        <tr>
            <td>${meal}</td>
        </tr>
    </table>
</c:forEach>
</body>
</html>
