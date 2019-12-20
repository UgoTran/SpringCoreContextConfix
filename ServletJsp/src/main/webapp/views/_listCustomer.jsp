<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="xml" %>
<%@ taglib uri="http://java.sun.com/jstl/sql" prefix="sql" %>

<html>
<head>
    <title>Customer Management Application</title>
</head>
<body>
<header>

</header>

<a href="/customer/add">Add new customer</a>

<c:catch var ="catchtheException">
    <% int x = 2/0;%>
</c:catch>

<c:if test = "${catchtheException != null}">
    <p>The type of exception is : ${catchtheException} <br />
        There is an exception: ${catchtheException.message}</p>
</c:if>

<table border="2">
    <tr>
        <th>ID</th>
        <th>Full Name</th>
        <th>Last Name</th>
        <th>First Name</th>
        <th>Phone</th>
        <th>Address line 1</th>
        <th>Address line 2</th>
        <th>City</th>
        <th>State</th>
        <th>Postal Code</th>
        <th>Country</th>
        <th>Refer EMP</th>
        <th>Credit Limit</th>
        <th>Birthday</th>
        <th>ProfilePhoto</th>
        <th>Action</th>
    </tr>

    <c:forEach var="cust" items="${listCustomer}">
        <tr>
            <td><c:out value="${cust.customerNumber}"/></td>
            <td>
                <a href="info?customerNumber=<c:out value='${cust.customerNumber}' />">
                    <c:out value="${cust.customerName}"/>
                </a>
            </td>
            <td><c:out value="${cust.contactLastName}"/></td>
            <td><c:out value="${cust.contactFirstName}"/></td>
            <td><c:out value="${cust.phone}"/></td>
            <td><c:out value="${cust.addressLine1}"/></td>
            <td><c:out value="${cust.addressLine2}"/></td>
            <td><c:out value="${cust.city}"/></td>
            <td><c:out value="${cust.state}"/></td>
            <td><c:out value="${cust.postalCode}"/></td>
            <td><c:out value="${cust.country}"/></td>
            <td><c:out value="${cust.salesRepEmployeeNumber}"/></td>
            <td><c:out value="${cust.creditLimit}"/></td>
            <td><c:out value="${cust.birthday}"/></td>
            <td>
                <c:out value="${cust.profilePhotoName}"/>
                <div style="border: 2px solid hotpink; width: 36px; height: 36px;">
                    <img src="${cust.profilePhotoName}"
                         id="photoOutput"
                         alt="${cust.customerName} profile photo"
                         height="35" width="35">
                </div>

            </td>
            <td>
                <a href="info?customerNumber=<c:out value='${cust.customerNumber}' />">Edit</a>
                <a href="delete?customerNumber=<c:out value='${cust.customerNumber}' />">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<%--<jsp:include page="../common/footer.jsp"></jsp:include>--%>
</body>
</html>
