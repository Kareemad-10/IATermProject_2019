<%-- 
    Document   : showExamTypes
    Created on : Dec 19, 2019, 6:52:14 AM
    Author     : Kareem E.Farouk
--%>

<%@page import="mvc.model.Objects.Exam"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Exams' Details </title>
        <script type="text/javascript">
            function GO(ele){
                var form1 = document.getElementById("form1");
                form1.submit();
            }
            function checkIF(ele) {
                     var para1 = document.getElementById("P1");
                     var para2 = document.getElementById("P2");
                     var text1 = document.getElementById("T1");
                     var text2 = document.getElementById("T2");
                     var form1 = document.getElementById("form1");
                     if(ele.id==="u"){
                         para1.style.visibility = "visible";
                         para2.style.visibility = "visible";
                         text1.type = "text";
                         text2.type = "text";
                         form1.action = "updateType";
                     }
                     else if(ele.id==="d"){
                         para1.style.visibility = "visible";
                         para2.style.visibility = "hidden";
                         text1.type = "text";
                         text2.type = "hidden";
                         form1.action = "deleteType";
                     }
                     else{
                         para1.style.visibility = "visible";
                         para2.style.visibility = "visible";
                         text1.type = "text";
                         text2.type = "text";
                         form1.action = "addType";
                     }
            }
        </script>
    </head>
    <body>
    <center><h2>All Available Exam Types In Database</h2></center>
    <%
           HttpSession se = request.getSession();
           Vector v = new Vector();
           v = (Vector) se.getAttribute("examTypes");
           String username = (String)se.getAttribute("username");
    %>
    <h3 align="right" style="color: deeppink"> Hello! <%=username %> </h3>

    <form action="" name="Y" id="form1" method="POST">
        <center><table  border='1' cellpadding='0' cellspacing='0'>
        <tr>
           <td align=center width=200px height=50px><b><em>Exam Type ID</td>
           <td align=center width=200px height=50px><b><em>Exam Type</td>
        </tr>
        <%
            
            for(int i=0; i<v.size(); i++){
                Exam e = new Exam();
                e = (Exam) v.get(i);
        %>
        <tr>
            <td align=center width=200px height=50px>
                <%=e.getID()%>
            </td>
            <td align=center width=200px height=50px>
                <%=e.getType()%>
            </td>
        <%
        }
        %> 
        </table>
        <center>
            <br><input type="radio" name="notSelected" id="u" onclick="checkIF(this)" value="">Update
            <input type="radio" name="notSelected" id="d" onclick="checkIF(this)" value="">Delete
            <input type="radio" name="notSelected" id="a" onclick="checkIF(this)" value="">Add
                <p style="visibility: hidden" id="P1">Enter Exam ID: </p>
                <input type="hidden" name="Id" id="T1" value="">
                <p style="visibility: hidden" id="P2">Enter Exam Type: </p>
                <input type="hidden" name="Type" id="T2" value="">
        </center>
        <br> <input type="button" value="Go" id="goBtn" onclick="GO(this)" style="width: 200px; height: 50px; color: brown; background-color: aqua;">
    </form>
    </body>
</html>
