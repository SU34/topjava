<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<table>
    <tr>
        <td><h1><spring:message code="test.title.main"/></h1></td>
    </tr>

    <table>
        <c:forEach items="${meals}" varStatus="status" var="meal">
            <tr>
                <td>${meal} - это пользователь</td>
            </tr>
        </c:forEach>
    </table>

</table>