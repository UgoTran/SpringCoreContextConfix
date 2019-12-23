<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 12/23/19
  Time: 8:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Function Tags Example</title>\
    <link href="../style/_styleSheet.css" rel="stylesheet">
</head>
<body>

<div>
    <c:out value="1. fn:contains()"/>
    <c:set var="String" value="Welcome to Hive Tech"/>

    <c:if test="${fn:contains(String, 'Hive Tech')}">
        <p>Found Hivetech string<p>
    </c:if>

    <c:if test="${fn:contains(String, 'Hivetech')}">
        <p>Found hivetech string<p>
    </c:if>
</div>

<div>
    <c:out value="2. fn:containsIgnoreCase()"/>
    <c:set var="String" value="Welcome to Hive Tech"/>

    <c:if test="${fn:containsIgnoreCase(String, 'Hive Tech')}">
        <p>Found Hive Tech string<p>
    </c:if>

    <c:if test="${fn:containsIgnoreCase(String, 'hive tech')}">
        <p>Found hive tech string<p>
    </c:if>
</div>

<div>
    <c:out value="3. fn:endsWith()"/>
    <c:set var="String" value="Welcome to JSP programming"/>

    <c:if test="${fn:endsWith(String, 'programming')}">
        <p>String ends with programming<p>
    </c:if>

    <c:if test="${fn:endsWith(String, 'JSP')}">
        <p>String ends with JSP<p>
    </c:if>
</div>

<div>
    <c:set var="string1" value="It is first String."/>
    <c:set var="string2" value="It is <xyz>second String.</xyz>"/>

    <p>Index-1 : ${fn:indexOf(string1, "first")}</p>
    <p>Index-2 : ${fn:indexOf(string2, "second")}</p>
</div>


</body>
</html>
