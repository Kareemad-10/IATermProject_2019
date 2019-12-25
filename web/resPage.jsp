<%-- 
    Document   : resPage
    Created on : Dec 23, 2019, 3:41:43 PM
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
           r = (Results) se.getAttribute("r");
           for (int i = 0; i < r.getcV().size(); i++) {
                    
           }
           out.print(r.getcV()+ " " + r.gettotalScoreV() + " " + r.getexamsScoreV() + " " + r.getexamsTypeV());
        %>
        <table  border='1' cellpadding='0' cellspacing='0'>
        <tr>
           <td align=center width=200px height=50px><b><em>Candidate ID</td>
           <td align=center width=200px height=50px><b><em>Exams</td>
           <td  align=center width=200px height=50px><b><em>CV</td>
           <td align=center width=1000px height=50px><b><em>Approved_Or_Not</td>
           <td align=center width=1000px height=50px><b><em>Selected Exams</td>
          
        </tr> 
        <tr>
            <td align=center width=200px height=50px>
                <%=can.getID()%>
            </td>
            <td align=center width=200px height=50px>
                <%=can.getUserName()%>
            </td>
            <td align=center width=200px height=50px>
                <a href=""><%=can.getCV()%></a>
            </td>
            <td align=center width=200px height=50px>
                <input type="checkbox" name="notApproved" class="approved" onclick="checkCan(this)" value=<%=can.getID()%>>
            </td>
            <td align=center width=1000px height=50px>
                <input type="checkbox" name="notSelected" class=<%=can.getID()%> onclick="checkExams(this)" value="IQ">IQ
                <input type="checkbox" name="notSelected" class=<%=can.getID()%> onclick="checkExams(this)" value="English">English
                <input type="checkbox" name="notSelected" class=<%=can.getID()%> onclick="checkExams(this)" value="Python">Python
                <input type="checkbox" name="notSelected" class=<%=can.getID()%> onclick="checkExams(this)" value="Java">Java
                <input type="checkbox" name="notSelected" class=<%=can.getID()%> onclick="checkExams(this)" value="Database">Database
            </td>
        </tr>
           <%
            }
           %> 
           </table><br> 
           <center><input type="button" value="Send Emails" onclick="SendEmails()" style="width: 200px; height: 50px;"></center>    
    </body>
</html>
