<%-- 
    Document   : cuuchuong
    Created on : May 25, 2026, 11:21:13 AM
    Author     : VU VAN HUY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bảng cửu chương</title>
    </head>
    <body>
    <center><h1>Hello World!</h1></center>
    <form action="cuuchuong.jsp" method="post">
        <label>Nhập số nguyên dương</label><br>
        <input type="text" name="num" placeholder="Nhập một số nguyên dương."> <br>
        <input type="submit" value="Submit">        
    </form>
    <%
       String num = request.getParameter("num");
       int n=0;
       if (num!=""){
            try {
               n = Integer.parseInt(num);
            } catch(Exception e){
                System.out.println(e);
            }
        }
    %>
    <p></p>
    <table> 
        <%
            for (int i=0; i<=10; i++){
        %>
        <tr>
            <td><%=n%></td>
            <td>x</td>
            <td><%=i%></td>
            <td>=</td>
            <td><%=n*i%></td>
        </tr>
        <%}%>
    </table>

</body>
</html>
