<%-- 
    Document   : showExamTypes
    Created on : Dec 19, 2019, 6:52:14 AM
    Author     : Kareem E.Farouk
--%>

<%@page import="mvc.model.Objects.Question"%>
<%@page import="mvc.model.Objects.Exam"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Questions' Details </title>
        <script type="text/javascript">
            function GO(ele){
                var form1 = document.getElementById("form1");
                form1.submit();
            }
            function checkIF(ele) {
                     var para1 = document.getElementById("P1");
                     var para2 = document.getElementById("P2");
                     var para3 = document.getElementById("P3");
                     var text1 = document.getElementById("T1");
                     var text2 = document.getElementById("T2");
                     var text3 = document.getElementById("T3");
                     var form1 = document.getElementById("form1");
                     if(ele.id==="u"){
                         para1.style.visibility = "visible";
                         para2.style.visibility = "visible";
                         para3.style.visibility = "visible";
                         text1.type = "text";
                         text2.type = "text";
                         text3.type = "text";
                         form1.action = "qUpdate";
                     }
                     else if(ele.id==="d"){
                         para1.style.visibility = "visible";
                         para2.style.visibility = "hidden";
                         para3.style.visibility = "hidden";
                         text1.type = "text";
                         text2.type = "hidden";
                         text3.type = "hidden";
                         form1.action = "qDelete";
                     }
                     else{
                         para1.style.visibility = "visible";
                         para2.style.visibility = "visible";
                         para3.style.visibility = "visible";
                         text1.type = "text";
                         text2.type = "text";
                         text3.type = "text";
                         form1.action = "qAdd";
                     }
            }
        </script>
    </head>
    <body>
    <center><h2>All Available Questions In Database</h2></center>
    <%
           HttpSession se = request.getSession();
           Vector v = new Vector();
           v = (Vector) se.getAttribute("q");
           String username = (String)se.getAttribute("username");
    %>
    <h3 align="right" style="color: deeppink"> Hello! <%=username %> </h3>
    <form action="" name="Y" id="form1" method="POST">
        <center><table  border='1' cellpadding='0' cellspacing='0'>
        <tr>
           <td align=center width=200px height=50px><b><em>Question ID</td>
           <td align=center width=200px height=50px><b><em>Question Text</td>
           <td align=center width=200px height=50px><b><em>Question Type</td>
        </tr>
        <%
            
            for(int i=0; i<v.size(); i++){
                Question q = new Question();
                q = (Question) v.get(i);
        %>
        <tr>
            <td align=center width=200px height=50px>
                <%=q.getID()%>
            </td>
            <td align=center width=1000px height=50px>
                <%=q.getText()%>
            </td>
            <td align=center width=200px height=50px>
                <%=q.getType()%>
            </td>
        <%
        }
        %> 
        </table>
        <center>
            <br><input type="radio" name="notSelected" id="u" onclick="checkIF(this)" value="">Update
            <input type="radio" name="notSelected" id="d" onclick="checkIF(this)" value="">Delete
            <input type="radio" name="notSelected" id="a" onclick="checkIF(this)" value="">Add
                <p style="visibility: hidden" id="P1">Enter Question ID: </p>
                <input type="hidden" name="Id" id="T1" value="">
                <p style="visibility: hidden" id="P2">Enter Question Text: </p>
                <input type="hidden" name="Text" id="T2" value="">
                <p style="visibility: hidden" id="P3">Enter Question Type: </p>
                <input type="hidden" name="Type" id="T3" value="">
        </center>
        <br> <input type="button" value="Go" id="goBtn" onclick="GO(this)" style="width: 200px; height: 50px; color: brown; background-color: aqua;">
    </form>
    </body>
</html>
