<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<>
<c:set var="number" value="15"/>
<p> result = ${number + 45}</p>
<c:remove var="number"/>
<c:if test="${empty number}">
    <p>Not found</p>
</c:if>
    <c:choose>
        <c:when test="${number == 1}">
            <p>equals 1</p>
        </c:when>
        <c:otherwise>
            <p>Not Found</p>
        </c:otherwise>
    </c:choose>
<c:url var="linkUrl" value="https://yandex.ru"/>
this is the <a href="${linkUrl}"> link</a>
<br>

<c:url var="linkUrl" value="https://yandex.ru">
    <c:param name="param" value="15"/>
</c:url>
this is the <a href="${linkUrl}"> link</a>

<ol>
<c:forEach var="cook" items="${cookie}">
    <li>
        <p><c:out value="${cook.value.name}"/></p>
        <p><c:out value="${cook.value.value}"/></p>
    </li>
</c:forEach>
</ol>
</body>
</html>
