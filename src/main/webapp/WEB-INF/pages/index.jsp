<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11.10.2016
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page</title>
</head>
<body>
<h1>Hello world!!!</h1>

    <a href="customLoginPage">Login page</a>
    <br>
    <a href="registration">Registration page</a>
    <br>
    <a href="adminPage">Admin page</a>
    <br>
    <a href="userPage">User page</a>
    <br>
    <a href="${pageContext.request.contextPath}/logout">Logout</a>

</body>
</html>
