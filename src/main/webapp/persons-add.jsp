<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 17/09/2019
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>

<form action="/persons/add" method="post">
    <br>First name:<br>
    <input type="text" name="first_name">
    <br>Last name:<br>
    <input type="text" name="last_name">
    <br>Age:<br>
    <input type="text" name="age">
    <br>Phone number:<br>
    <input type="text" name="phone_number">
    <br><br>
    <input type="submit" value="Submit">
</form>

</body>
</html>