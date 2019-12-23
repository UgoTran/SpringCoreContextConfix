<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 12/23/19
  Time: 8:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Core Tags Example</title>
    <link rel="stylesheet" href="../style/_styleSheet.css"/>
</head>
<body>
<div>
    <c:out value="1. <c:choose>, <c:when>, <c:otherwise> Example "/>
    <c:set  var="num" value="10"></c:set>
    <c:choose>
        <c:when test="${num%2==0}">
            <c:out value="${num} is even number"></c:out>
        </c:when>
        <c:otherwise>
            <c:out value="${num} is odd number"></c:out>
        </c:otherwise>
    </c:choose>
</div>

<div>
    <c:out value="2. <c:forEach>"/>
    <c:forEach var="j" begin="1" end="3">
    Item <c:out value="${j}"/><p>
    </c:forEach>
</div>

<div>
    <c:out value="3. <c:forTokens>"/>
    <c:forTokens items="Rahul-Nakul-Rajesh" delims="-" var="name">
    <c:out value="${name}"/><p>
    </c:forTokens>
</div>

<div>
    <c:out value="4. <c:url>"/>
    <c:url value="../index.jsp"/>
</div>

</body>
</html>
