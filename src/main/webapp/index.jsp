<%@ page import="ru.javawebinar.topjava.AuthorizedUser" %>
<%@ taglib prefix="fn" uri="http://topjava.javawebinar.ru/functions" %>
<html>
<head>
    <meta charset="UTF-8">
    <title> !! Java Enterprise (Topjava)</title>
</head>
<body>
<h3>Проект <a href="https://github.com/JavaWebinar/topjava" target="_blank">Java Enterprise (Topjava)</a></h3>
<hr>

<form action="${fn:setId(xxx)}" method="post">
    <select id="xxx" name="xxx">
        <option  value="1" selected>user_1</option>
        <option  value="2">user_2</option>
        <option  value="3">user_3</option>
    </select>
    <input type="submit" value="accept">
</form>




<ul>
    <li><a href="users">Users</a></li>
    <li><a href="meals">Meals</a></li>
</ul>
</body>
</html>
