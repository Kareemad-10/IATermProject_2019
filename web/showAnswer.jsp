<%-- 
    Document   : showAnswer
    Created on : Dec 21, 2019, 6:49:11 PM
    Author     : Kareem E.Farouk
--%>

<%@page import="java.util.Vector"%>
<%@page import="mvc.model.Objects.Answer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Answers' Details </title>
        <script type="text/javascript">
            function GO(ele){
                var form1 = document.getElementById("form1");
                form1.submit();
            }
            function checkIF(ele) {
                     var para1 = document.getElementById("P1");
                     var para2 = document.getElementById("P2");
                     var para3 = document.getElementById("P3");
                     var para4 = document.getElementById("P4");
                     var text1 = document.getElementById("T1");
                     var text2 = document.getElementById("T2");
                     var text3 = document.getElementById("T3");
                     var text4 = document.getElementById("T4");
                     var form1 = document.getElementById("form1");
                     if(ele.id==="u"){
                         para1.style.visibility = "visible";
                         para2.style.visibility = "visible";
                         para3.style.visibility = "visible";
                         para4.style.visibility = "visible";
                         
                         text1.type = "text";
                         text2.type = "text";
                         text3.type = "text";
                         text4.type = "text";
                         form1.action = "aUpdate";
                     }
                     else if(ele.id==="d"){
                         para1.style.visibility = "visible";
                         para2.style.visibility = "hidden";
                         para3.style.visibility = "hidden";
                         para4.style.visibility = "hidden";
                         text1.type = "text";
                         text2.type = "hidden";
                         text3.type = "hidden";
                         text4.type = "hidden";
                         form1.action = "aDelete";
                     }
                     else{
                         para1.style.visibility = "visible";
                         para2.style.visibility = "visible";
                         para3.style.visibility = "visible";
                         para4.style.visibility = "visible";
                         
                         text1.type = "text";
                         text2.type = "text";
                         text3.type = "text";
                         text4.type = "text";
                         form1.action = "aAdd";
                     }
            }
        </script>
    </head>
    <body>
    <center><h2>All Answers In Database</h2></center>
    <%
           HttpSession se = request.getSession();
           Vector v = new Vector();
           v = (Vector) se.getAttribute("a");
    %>
    <form action="" name="Y" id="form1" method="POST">
        <center><table  border='1' cellpadding='0' cellspacing='0'>
        <tr>
           <td align=center width=200px height=50px><b><em>Answer ID</td>
           <td align=center width=200px height=50px><b><em>Answer Text</td>
           <td align=center width=200px height=50px><b><em>Question ID Related</td>
           <td align=center width=200px height=50px><b><em>Correct?</td>
        </tr>
        <%
            
            for(int i=0; i<v.size(); i++){
                Answer a = new Answer();
                a = (Answer) v.get(i);
        %>
        <tr>
            <td align=center width=200px height=50px>
                <%=a.getID()%>
            </td>
            <td align=center width=500px height=50px>
                <%=a.getText()%>
            </td>
            <td align=center width=200px height=50px>
                <%=a.getQID()%>
            </td>
            <td align=center width=200px height=50px>
                <%=a.getCorrectOrnot()%>
            </td>
        <%
        }
        %> 
        </table>
        <center>
            <br><input type="radio" name="notSelected" id="u" onclick="checkIF(this)" value="">Update
            <input type="radio" name="notSelected" id="d" onclick="checkIF(this)" value="">Delete
            <input type="radio" name="notSelected" id="a" onclick="checkIF(this)" value="">Add
                <p style="visibility: hidden" id="P1">Enter Answer ID: </p>
                <input type="hidden" name="Id" id="T1" value="">
                <p style="visibility: hidden" id="P2">Enter Answer Text: </p>
                <input type="hidden" name="Text" id="T2" value="">
                <p style="visibility: hidden" id="P3">Enter Related QID: </p>
                <input type="hidden" name="QID" id="T3" value="">
                <p style="visibility: hidden" id="P4">Correct_Ans or, Not: </p>
                <input type="hidden" name="Correct" id="T4" value="">
        </center>
        <br> <input type="button" value="Go" id="goBtn" onclick="GO(this)" style="width: 200px; height: 50px; color: brown; background-color: aqua;">
    </form>
    </body>
</html>
