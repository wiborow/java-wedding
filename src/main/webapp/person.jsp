<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 17/09/2019
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>SERWIS</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
                     integrity="sha384-ggOyR0iXCbMQv3Xipma34MDdH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<%--${param.editable}--%>
<%--${param[editable]}--%>
<%--${param['editable']}--%>

<table class="table" style="width: 0">
    <thead>
    <tr>
            <th scope="col">First Name</th>
            <th scope="col">Last Name</th>
            <th scope="col">Phone number</th>
            <th scope="col">Age</th>
            <th scope="col">Address</th>
            <th scope="col" colspan="2"><button class="btn btn-success">Add new</button></th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.personList}" var="person">
            <form action="${pageContext.request.contextPath}/persons/crud" method="post">
                <tr>
                    <c:if test="${person.id ne param.editable}">
                    <td style="display:none"><input type="hidden" name="id" value=${person.id}></td>
                    <td>${person.firstName}</td>
                    <td>${person.lastName}</td>
                    <td>${person.phoneNumber}</td>
                    <td>${person.age}</td>
                    <td>${person.address}</td>

                    <td>
                        <button type="submit" name="actionType" value="delete" class="btn btn-default"
                                                             aria-label="Left Align">
                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                        </button>
                    </td>
                    <td>
                        <button type="submit" name="actionType" value="editableForId" class="btn btn-default btn-lg">
                            <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
                        </button>
                    </td>
                <tr>
                    </c:if>

                    <c:if test="${person.id eq param.editable}">
                <tr>
                    <td style="display:none"><input type="hidden" name="id" value=${person.id}></td>
                <td colspan="5">
                    <div class="form-group row">
                        <label for="first_name" class="col-sm-2 col-form-label">First name</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="first_name" value="${person.firstName}">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="last_name" class="col-sm-2 col-form-label">Last name</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="last_name" value="${person.lastName}">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="last_name" class="col-sm-2 col-form-label">Phone number</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="phone_number" value="${person.phoneNumber}">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="last_name" class="col-sm-2 col-form-label">Age</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="age" value="${person.age}">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="last_name" class="col-sm-2 col-form-label">Address</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="address" value="${person.address}">
                        </div>
                    </div>
                </td>
                    <td>
                        <button type="submit" name="actionType" value="update" class="btn btn-default btn-lg">
                            <span class="glyphicon glyphicon-ok" aria-hidden="true">Confirm</span>
                        </button>
                    </td>
                </tr>
                </c:if>
            </form>
        </c:forEach>
    </tbody>
</table>

<h2>Add new person</h2>

<form action="${pageContext.request.contextPath}/persons" method="post">
    <input type="text" name="first_name">
    <input type="text" name="last_name">
    <input type="text" name="phone_number" type="tel">
    <input type="text" name="age" type="number">
    <input type="text" name="address">
    <button type="submit" class="btn btn-default btn-lg">
            <span class="glyphicon glyphicon-ok"></span> Add new person!
        </button>

</form>
</body>
</html>
