<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 17/09/2019
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table style="width:100%; border: 1px">
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Age</th>
            <th>Phone number</th>
        </tr>
        Persons: ${param.personList}
    <c:forEach var="person" items="${param.personList}">
        <tr>
            <td>${person.firstName}</td>
            <td>${person.lastName}</td>
            <td>${person.age}</td>
            <td>${person.phoneNumber}</td>
        </tr>
    </c:forEach>
    </table>
</body>
</html>
