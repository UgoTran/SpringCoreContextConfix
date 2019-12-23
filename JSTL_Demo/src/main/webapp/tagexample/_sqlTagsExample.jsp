<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 12/23/19
  Time: 10:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SQL Tags</title>
    <link rel="stylesheet" href="/style/_styleSheet.css">
</head>
<body>
<div>
    <c:out value="1. <sql:setDataSource>"/>
    <sql:setDataSource
            var="db"
            driver="org.mariadb.jdbc.Driver"
            password="root"
            user="root"
            url="jdbc:mysql://192.168.56.1:3310/classicmodels"/>
    <c:if test="${db != null}">
        <p id="result"><c:out value="Connect DB OK!!!"/></p>
    </c:if>
</div>

<div>
    <c:out value="2. <sql:query >"/>
    <sql:query var="rs" dataSource="${db}">
        SELECT productLine, textDescription, htmlDescription FROM productlines;
    </sql:query>

    <table border="1" width="100%">
        <caption>Product Line Table</caption>
        <tr>
            <th>Product Line</th>
            <th>Text Desc</th>
            <th>HTML Desc</th>
        </tr>
        <c:forEach var="table" items="${rs.rows}">
            <tr>
                <td><c:out value="${table.productLine}"/></td>
                <td><c:out value="${table.textDescription}"/></td>
                <td><c:out value="${table.htmlDescription}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
