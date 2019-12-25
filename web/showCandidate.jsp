<%-- 
    Document   : showCandidate
    Created on : Dec 15, 2019, 1:07:55 PM
    Author     : Kareem E.Farouk
--%>

<%@page import="mvc.model.Objects.Candidate"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Candidates' Details</title>
        <script type="text/javascript">
            var Ordering = "";
            var textT;
            function checkCan(ele){
                if(ele.checked){
                    ele.name="Approved";
                    Ordering+= "/";
                }
            }
            function checkExams(ele){
                if(ele.checked){
                    ele.name = ele.className;
                    Ordering+=ele.value;
                    Ordering+="-";
                }
            }
            function SendEmails() {
               var form = document.getElementById('form1');
               texT = document.getElementById('TH');
               texT.value = Ordering;
               form.action="selectExams";
               form.submit();
            }
        </script>
    </head>
    <body>
        
        <%
           HttpSession se = request.getSession();
           Vector v = new Vector();
           v = (Vector) se.getAttribute("can");
           String username = (String)se.getAttribute("username"); 
        %>
        <h3 align="right" style="color: deeppink"> Hello! <%=username %> </h3>
        <form action="" id="form1" method="POST">
        <table  border='1' cellpadding='0' cellspacing='0'>
        <tr>
           <td align=center width=200px height=50px><b><em>Candidate ID</td>
           <td align=center width=200px height=50px><b><em>Candidate User Name</td>
           <td  align=center width=200px height=50px><b><em>CV</td>
           <td align=center width=200px height=50px><b><em>Approved_Or_Not</td>
           <td align=center width=1000px height=50px><b><em>Selected Exams</td>
        </tr>
        <%
            
            for(int i=0; i<v.size(); i++){
                Candidate can = new Candidate();
                can = (Candidate) v.get(i);
        %>        
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
           <br>
           <input type="hidden" id="TH" name="OrdersStr" value="">
           <br>
           <center><input type="button" value="Send Emails" onclick="SendEmails()" style="width: 200px; height: 50px;"></center>    
        </form>      
    </body>
</html>
