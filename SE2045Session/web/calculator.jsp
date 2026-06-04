<%-- 
    Document   : calculator
    Created on : Jun 1, 2026, 11:24:14 AM
    Author     : VU VAN HUY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculator</title>
    </head>
    <body>
        <h1>FPT Calculator</h1>
        <form action="sessioncalculator" method="post">
            <table border="0">
                <tr>
                    <td>Number 1</td>
                    <td><input type="text" name="txtNum1" id="txtNum1" value="${n1}" /></td>
                </tr>
                <tr>
                    <td>Number 2</td>
                    <td><input type="text" name="txtNum2" id="txtNum2" value="${n2}" /></td>
                </tr>
                <tr>
                    <td>Operators</td>
                    <td>
                        <input type="radio" name="op" value="+" id="rbSum" checked />Sum<br>
                        <input type="radio" name="op" value="-" id="rbSub" />Subtract<br>
                        <input type="radio" name="op" value="*" id="rbProd" />Product<br>
                        <input type="radio" name="op" value="/" id="rbQuo" />Quotient<br>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Calculate" id="btnCal"></td>
                </tr>
            </table>            
        </form>
        <hr>
        <table border="1">
            <thead>
                <tr>
                    <th>Number 1</th>
                    <th>Operator</th>
                    <th>Number 2</th>
                    <th></th>
                    <th>Result</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="i" items="${lstData}">
                <tr>
                    <td style="text-align: center">${i.n1}</td>
                    <td>${i.op}</td>
                    <td>${i.n2}</td>
                    <td>=</td>
                    <td>${i.rs}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
