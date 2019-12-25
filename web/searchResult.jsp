<%-- 
    Document   : searchResult
    Created on : Dec 23, 2019, 11:23:16 AM
    Author     : Kareem E.Farouk
--%>

<%@page import="java.util.Vector"%>
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
           Vector v = new Vector();
           v = (Vector) se.getAttribute("result");
           if(v.size()==0){
               out.print("<B><em> Error 404 -- No Results");
           }
           else{
            for (int i = 0; i < v.size(); i++) {
                  if((v.get(i).equals("candidate"))){
                       out.print("<br>");
                  }
                  else if((v.get(i).equals("hrexam"))){
                        out.print("<br>");
                  }
                  else{
                        out.print(v.get(i));
                    }
            }
            }
        %>
    </body>
</html>
