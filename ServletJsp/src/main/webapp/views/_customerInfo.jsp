<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>HiveTech</title>
    <link rel="shortcut icon" href="#">
</head>
<body>
<h1>Customer Management</h1>
<a href="/customer/list">List All Customer</a>
<a href="/index.jsp">Go to home page</a>
<%--Xu ly form edit/add --%>
<c:if test="${requsetAcction == 'add'}">
    <form action="/customer/add" method="post">
</c:if>

<c:if test="${selectedCustomer != null}">
    <form action="/customer/edit" method="post">
</c:if>
        <table>
            <tr>
                <th>ID</th>
                <td>
                     <input type="text" name="customerNumber" size="45" readonly="true" style="border: pink"
                           value="<c:out value="${selectedCustomer.customerNumber}"/>"
                    />
                </td>
            </tr>
            <tr>
                <th>Full Name</th>
                <td>
                    <input type="text" name="customerName" size="45"
                           value="<c:out value="${selectedCustomer.customerName}"/>"
                    />
                </td>
            </tr>
            <tr>
                <th>Contact Last Name</th>
                <td>
                    <input type="text" name="contactLastName" size="45"
                           value="<c:out value="${selectedCustomer.contactLastName}"/>"
                    />
                </td>
            </tr>
            <tr>
                <th>Contact First Name</th>
                <td>
                    <input type="text" name="contactFirstName" size="45"
                           value="<c:out value="${selectedCustomer.contactFirstName}"/>"
                    />
                </td>
            </tr>
            <tr>
                <th>Phone</th>
                <td>
                    <input type="text" name="phone" size="45"
                           value="<c:out value="${selectedCustomer.phone}"/>"
                    />
                </td>
            </tr>
            <tr>
                <th>Address line 1</th>
                <td>
                    <input type="text" name="addressLine1" size="45"
                           value="<c:out value="${selectedCustomer.addressLine1}"/>"
                    />
                </td>
            </tr>
            <tr>
                <th>Address line 2</th>
                <td>
                    <input type="text" name="addressLine2" size="45"
                           value="<c:out value="${selectedCustomer.addressLine2}"/>"
                    />
                </td>
            </tr>
            <tr>
                <th>City</th>
                <td>
                    <input type="text" name="city" size="45"
                           value="<c:out value="${selectedCustomer.city}"/>"
                    />
                </td>
            </tr>
            <tr>
                <th>State</th>
                <td>
                    <input type="text" name="state" size="45"
                           value="<c:out value="${selectedCustomer.state}"/>"
                    />
                </td>
            </tr>
            <tr>
                <th>Postal Code</th>
                <td>
                    <input type="text" name="postalCode" size="45"
                           value="<c:out value="${selectedCustomer.postalCode}"/>"
                    />
                </td>
            </tr>
            <tr>
                <th>Country</th>
                <td>
                    <input type="text" name="country" size="45"
                           value="<c:out value="${selectedCustomer.country}"/>"
                    />
                </td>
            </tr>
            <tr>
                <th>Sales Refer EMP</th>
                <td>
                    <input type="text" name="salesRepEmployeeNumber" size="45"
                           value="<c:out value="${selectedCustomer.salesRepEmployeeNumber}"/>"
                    />
                </td>
            </tr>
            <tr>
                <th>Credit Limit</th>
                <td>
                    <input type="text" name="creditLimit" size="45"
                           value="<c:out value="${selectedCustomer.creditLimit}"/>"
                    />
                </td>
            </tr>
            <tr>
                <th>Birthday</th>
                <td>
                    <input type="text" name="birthday" size="45"
                           value="<c:out value="${selectedCustomer.birthday}"/>"
                    />
                </td>
            </tr>
            <tr>
                <td>
                    <c:choose>
                        <c:when test="${requsetAcction == 'add'}">
                            <input type="submit" value="ADD"/>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="SAVE"/>
                        </c:otherwise>
                    </c:choose>

                    <input type="reset" value="Back"/>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>