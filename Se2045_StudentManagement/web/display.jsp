<%-- 
    Document   : display
    Created on : Jun 4, 2026, 9:21:02 AM
    Author     : VU VAN HUY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student management</title>
    </head>
    <body>
    <center><h1>STUDENT LIST</h1></center>
    <table border="1">
        <thead>
            <tr>
                <th>N0</th>
                <th>ID</th>
                <th>Name</th>
                <th>Age</th>
                <th>DOB</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="i" items="${stdList}" varStatus="no">
            <tr>
                <td>${no.count}</td>
                <td>${i.id}</td>
                <td>${i.name}</td>
                <td>${i.age}</td>
                <td>${i.dob}</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>

    </body>
</html>
