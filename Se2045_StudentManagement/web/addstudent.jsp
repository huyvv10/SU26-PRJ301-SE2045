<%-- 
    Document   : addstudent
    Created on : Jun 11, 2026, 8:00:13 AM
    Author     : VU VAN HUY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new student</title>
    </head>
    <body>
    <center><h1>Add new student</h1></center>
    <form action="addstudent" method="post">
        <table border="0">
            <tr>
                <td>Student Id</td>
                <td><input type="text" name="txtId" id="txtId"></td>
            </tr>
            <tr>
                <td>Student name</td>
                <td><input type="text" name="txtName" id="txtName"></td>
            </tr>
            <tr>
                <td>Student Age</td>
                <td><input type="number" name="txtAge" id="txtAge"></td>
            </tr>
            <tr>
                <td>Student DOB</td>
                <td><input type="text" name="txtDob" id="txtDob"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Add" id="btnAdd"></td>
            </tr>
        </table>
    </form>
</body>
</html>
