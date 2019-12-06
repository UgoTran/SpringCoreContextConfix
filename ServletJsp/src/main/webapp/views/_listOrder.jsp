<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer Management Application</title>
</head>
<body>
<header>

</header>

<table border="2">
    <tr>
        <th>ID</th>
        <th>Order Date</th>
        <th>Required Date</th>
        <th>Shipped Date</th>
        <th>Status</th>
        <th>Comments</th>
        <th>Customer Name</th>

        <%--        <th>Action</th>--%>
    </tr>

    <c:forEach var="orders" items="${listOrder}">
        <tr>
            <td><c:out value="${orders.orderNumber}"/></td>
            <td><c:out value="${orders.orderDate}"/></td>
            <td><c:out value="${orders.requiredDate}"/></td>
            <td><c:out value="${orders.shippedDate}"/></td>
            <td><c:out value="${orders.status}"/></td>
            <td><c:out value="${orders.comments}"/></td>
            <td><c:out value="${orders.customerName}"/></td>
                <%--            <td><a href="edit?id=<c:out value='${cust.id}' />">Edit</a>--%>
                <%--                &nbsp;&nbsp;&nbsp;&nbsp; <a--%>
                <%--                        href="delete?id=<c:out value='${cust.id}' />">Delete</a></td>--%>

            <!--  <td><button (click)="updateTodo(todo.id)" class="btn btn-success">Update</button>
                      <button (click)="deleteTodo(todo.id)" class="btn btn-warning">Delete</button></td> -->
        </tr>
    </c:forEach>
</table>
<%--<jsp:include page="../common/footer.jsp"></jsp:include>--%>
</body>
</html>
