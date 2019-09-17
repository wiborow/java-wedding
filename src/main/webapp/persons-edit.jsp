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

<form action="/persons/edit" method="post"  >
    <c:set var = "person" value="${requestScope.personToEdit}"/>
    <input type="hidden" name="person_id" value="${param.person_id}">
    <br>Last name:<br>
    <%--    mozna dodawac na podstawie zmiennej utworzonej przy pomocy c:set pozyzej...--%>
    <input type="text" name="first_name" value=${person.firstName}>
    <br>Last name:<br>
    <%--    albo wyciagac bezposrednio z requestScope jak zawsze--%>
    <input type="text" name="last_name" value=${requestScope.personToEdit.lastName}>
    <br>Age:<br>
    <input type="text" name="age" value=${requestScope.personToEdit.age}>
    <br>Phone number:<br>
    <input type="text" name="phone_number" value=${requestScope.personToEdit.phoneNumber}>
    <br><br>
    <input type="submit" name="operationMode" value="SAVE">
</form>

</body>
</html>