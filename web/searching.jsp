<%-- 
    Document   : searching
    Created on : Dec 21, 2019, 9:56:06 PM
    Author     : Kareem E.Farouk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Searching Page_HR... </title>
        <script type="text/javascript">
            function Choice(ele) {
                var P = document.getElementById("P");
                var T = document.getElementById("TT");
                ele.name = "Checked";
                if(ele.checked){
                     P.style.visibility = "visible";
                     T.type = "text";
                }
                else{
                    P.style.visibility = "hidden";
                    T.type = "hidden";
                } 
            };
        </script>
    </head>
    <body>
        <%
           HttpSession se = request.getSession();
           String username = (String)se.getAttribute("username"); 
        %>
        <h2><b><em>Select the Searching Criteria:-</em></b></h2>
        <center>
            <h3 align="right" style="color: deeppink"> Hello! <%=username %> </h3>
            <form name="form1" action="doSearch" id="f_Search" method="POST">
                <br><br><input type="checkbox" name="cb" value="cName" onclick="Choice(this)"/>  Candidate Name
                <br><br><input type="checkbox" name="cb" value="cEmail" onclick="Choice(this)"/> Candidate Email
                <br><br><input type="checkbox" name="cb" value="TTYPE" onclick="Choice(this)"/>    Exam Type
                <br><br><input type="checkbox" name="cb" value="e_Date" onclick="Choice(this)"/> Exam Date
                <br><br><p>----------------------------------------------------------------------------</p>
                <P id="P" style="visibility: hidden;"> Enter a Search Key:    </P><input type="hidden" name="key" id="TT" value="" style="width: 200px; height: 20px;">
                <br><br><input type="submit" id="btn_Search" style="width: 200px; height: 50px; background-color: darkturquoise;"> 
                <br><br><input type="hidden" name="X" value="Searching" id="XX">
            </form> 
        </center>
    </body>
</html>
