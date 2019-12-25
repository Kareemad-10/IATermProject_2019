<%-- 
    Document   : examPage
    Created on : Dec 23, 2019, 4:02:34 PM
    Author     : Kareem E.Farouk
--%>

<%@page import="mvc.model.Objects.Results"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
           HttpSession se = request.getSession();
           Results r = new Results();
           r = (Results) se.getAttribute("r2");
           out.print(r.getcV()+ " " + r.getexamsTypeV() + r.getQTV() + " " +  r.getATV());
        %> 
    </body>
</html>
