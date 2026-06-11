<%-- 
    Document   : updatestudent
    Created on : Jun 11, 2026, 9:08:07 AM
    Author     : VU VAN HUY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update student info</title>
    </head>
    <body>
    <center><h1>Update student info</h1></center>
    <form action="update" method="post">
        <table border="0">
            <tr>
                <td>Student Id</td>
                <td><input type="text" name="txtId" id="txtId" readonly value="${stdX.id}"></td>
            </tr>
            <tr>
                <td>Student name</td>
                <td><input type="text" name="txtName" id="txtName" value="${stdX.name}"></td>
            </tr>
            <tr>
                <td>Student Age</td>
                <td><input type="number" name="txtAge" id="txtAge" value="${stdX.age}"></td>
            </tr>
            <tr>
                <td>Student DOB</td>
                <td><input type="text" name="txtDob" id="txtDob" value="${stdX.dob}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update" id="btnUpdate"></td>
            </tr>
        </table>
    </form>
</body>
</html>
