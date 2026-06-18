<%-- 
    Document   : displayproducts
    Created on : Jun 18, 2026, 8:28:23 AM
    Author     : VU VAN HUY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product main</title>
    </head>
    <body>
    <center><h1>Product Main</h1></center>
    <form action="displayproducts" method="post">
        <table border="0">
            <tr>
                <td>Search name</td>
                <td><input type="text" name="txtKw" id="txtKw" /></td>
                <td><input type="submit" value="Search" td="btnSearch" /></td>
            </tr>
            <tr>
                <td>Category</td>
                <td>
                    <select name="cboCat" id="cboCat">
                        <option value="all">---All product---</option>
                        <c:forEach var="c" items="${catList}" varStatus="n">
                        <option value="${c.catId}">${c.catName}</option>
                        </c:forEach>
                    </select>
                </td>
                <td><input type="submit" value="Add new product" td="btnAddProduct" /></td>
            </tr>
        </table>
       <br>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Qty</th>
                    <th>Price</th>
                    <th>Import Date</th>
                    <th>Category</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="p" items="${prdList}" varStatus="n0">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.name}</td>
                    <td>${p.qty}</td>
                    <td>${p.price}</td>
                    <td>${p.importDate}</td>
                    <td>${p.catId}</td>
                    <td>
                        <a href="edit?pid=${p.id}">Edit | 
                        <a href="delete?pid=${p.id}">Delete
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table> 
    </form>
</body>
</html>
