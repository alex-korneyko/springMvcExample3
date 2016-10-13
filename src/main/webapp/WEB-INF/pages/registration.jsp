<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Registration page</title>
</head>
<body>
<h1>Registration</h1>

<form name="form_registration" action="registrationResult" method="post">

    <c:if test="${passwordsNotMatch != null}">
        <p>Passwords does not match!</p>
    </c:if>

    <table>
        <tr>
            <td><label for="name">Name:</label> </td>
            <td><input type="text" name="name" id="name"></td>
        </tr>
        <tr>
            <td><label for="surname">Surname:</label> </td>
            <td><input type="text" name="surname" id="surname"></td>
        </tr>
        <tr>
            <td><label for="login">Login:</label> </td>
            <td><input type="text" name="login" id="login"></td>
        </tr>
        <tr>
            <td><label for="password1">Password</label> </td>
            <td><input type="password" name="password1" id="password1"></td>
        </tr>
        <tr>
            <td><label for="password2">Re-enter password</label> </td>
            <td><input type="password" name="password2" id="password2"></td>
        </tr>
    </table>
    <input type="submit" value="Submit">
</form>
</body>
</html>
