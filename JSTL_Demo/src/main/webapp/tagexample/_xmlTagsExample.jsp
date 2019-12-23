<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 12/23/19
  Time: 8:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>XML Tags Example</title>
    <link rel="stylesheet" href="/style/_styleSheet.css">
</head>
<body>
<div>
    <c:out value="1. <x:out>"/>
    <h3>Vegetable Information:</h3>
    <c:set var="vegetable">
        <vegetables>
            <vegetable>
                <name>onion</name>
                <price>40/kg</price>
            </vegetable>
            <vegetable>
                <name>Potato</name>
                <price>30/kg</price>
            </vegetable>
            <vegetable>
                <name>Tomato</name>
                <price>90/kg</price>
            </vegetable>
        </vegetables>
    </c:set>
    <x:parse xml="${vegetable}" var="output"/>
    <b>Name of the vegetable is</b>:
    <x:out select="$output/vegetables/vegetable[1]/name" /><br>
    <b>Price of the Potato is</b>:
    <x:out select="$output/vegetables/vegetable[2]/price" />
</div>
<div>
    <c:out value="2. <x:parse>"/>
    <h3>Books Info:</h3>
    <c:import var="bookInfo" url="/xml/novels.xml"/>

    <x:parse xml="${bookInfo}" var="output"/>
    <p>First Book title: <x:out select="$output/books/book[1]/name" /></p>
    <p>First Book price: <x:out select="$output/books/book[1]/price" /></p>
    <p>Second Book title: <x:out select="$output/books/book[2]/name" /></p>
    <p>Second Book price: <x:out select="$output/books/book[2]/price" /></p>
</div>

<div>
    <c:out value="3. <x:set>"/>
    <p>
        Gán giá trị của thẻ vào một variable,
        <C:out value="<x:set attributes/> "/>
    </p>
    <c:set var="book">
        <books>
            <book>
                <name>Three mistakes of my life</name>
                <author>Chetan Bhagat</author>
                <price>200</price>
            </book>
            <book>
                <name>Tomorrow land</name>
                <author>Brad Bird</author>
                <price>2000</price>
            </book>
        </books>
    </c:set>
    <x:parse xml="${book}" var="output"/>
    <x:set var="fragment" select="$output/books/book[2]/price"/>
    <b>The price of the Tomorrow land book</b>:
    <x:out select="$fragment" />
</div>

</body>
</html>
