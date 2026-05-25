<%-- 
    Document   : demojsp
    Created on : May 25, 2026, 10:40:41 AM
    Author     : VU VAN HUY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%!
            String name = "Vũ Văn Huy";
            int i,n = 10;
            public char toChar(int i){
                return (char)(65+i);
            }
        %>
        <h1>Hello <%=name %> </h1>
        <table border="1px">
            <tr>
                <th>STT</th>
                <th>Họ và Tên</th>
                <th>Ghi chú</th>
            </tr>
            <%
                for (i=0; i<n; i++) {
            %>
            <tr>
                <td><%=i+1%></td>
                <td>Nguyễn Văn <%=toChar(i)%></td>
                <td></td>
            </tr>
            
            <% } %>
        </table>
        <p><%=i%></p>
    </body>
</html>
