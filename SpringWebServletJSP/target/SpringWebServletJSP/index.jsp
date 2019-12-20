<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Spring 3 JSP Servlet</title>
</head>
<body>
<c:if test="${todos.size() > 0}">
    <c:out value="Total ToDo Count: ${todos.size()}" />
</c:if>
<p> </p>
<c:choose>
    <c:when test="${todos.size() > 0}">
        <table border="1">
            <tr>
                <th>ToDo ID</th>
                <th>ToDo Description</th>
            </tr>
            <c:forEach items="${todos}" var="todo">
                <tr>
                    <td>${todo.id}</td>
                    <td>${todo.desc}</td>
                </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        No ToDo found!
    </c:otherwise>
</c:choose>
<p> </p>
<div>
    <p>
        <c:if test="${!empty error}">
            <c:out value="${error}" />
        </c:if>
    </p>
    <form method="post" action="todo">
        <label>Input ToDo id:</label> <input type="text" name="id" id="id" />
        <input type="submit" name="ToDoSubmit" value="Get ToDo" />
    </form>
    <p>
        <c:if test="${!empty todo}">
            <c:out value="ToDo id: ${todo.id}" />
            <br />
            <c:out value="ToDo desc: ${todo.desc}" />
        </c:if>
    </p>
</div>
</body>
</html>