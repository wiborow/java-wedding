<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 17/09/2019
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Login page</h2>
<form action="/login" method="post">
    <h3>User name:</h3>
    <input name="userName" type="text">

    <h3>Password</h3>
    <input name="password" type="password">
    <input type="submit" value="Login">

</form>
</body>
</html>
