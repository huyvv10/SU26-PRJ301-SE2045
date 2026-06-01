<%-- 
    Document   : calculate
    Created on : May 25, 2026, 12:01:40 PM
    Author     : VU VAN HUY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rectangle calculation</title>
    </head>
    <body>
    <center><div><h2>Rectangle calculation</h2></div></center>
                <%
                    String l = request.getParameter("l"); 
                    String w = request.getParameter("w");
                    String me = request.getParameter("me");
                    if (l!=null && w!=null){
                        double ll=0.0, ww=0.0,rs=0.0;
                        try{
                            ll = Double.parseDouble(l);
                            ww = Double.parseDouble(w);
                            if (me.equals("pe"))
                                rs=(ll+ww)*2; 
                            else
                                rs = ll*ww;
                            if (me.equals("pe")){
                %>        
                <div id="txtOuput">Perimeter of the rectangle is: <%=rs%></div>
                <%}else{%>
                <div id="txtOuput">Area of the rectangle is: <%=rs%></div>
                <%}
                } catch (Exception e){ %>
                    <div id="txtError">Input must be a number.</div>
               <% }
                }
    %>

</body>
</html>
