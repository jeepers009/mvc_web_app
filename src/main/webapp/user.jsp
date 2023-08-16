<%--
  Created by IntelliJ IDEA.
  User: Игорь
  Date: 14.08.2023
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User info</title>
</head>
<body>
    <h1>User info:</h1>
    <c:choose>
        <c:when test="${not empty user}">
            <p>Id: ${user.getId()}</p>
            <p>Name: ${user.name}</p>
            <p>Email: ${user.email}</p>
        </c:when>
        <c:otherwise>
            <p>${message}</p>
        </c:otherwise>
    </c:choose>
</body>
</html>
