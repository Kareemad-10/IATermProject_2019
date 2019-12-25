<%-- 
    Document   : HR_Home
    Created on : Dec 12, 2019, 3:17:04 AM
    Author     : Kareem E.Farouk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style type="text/css">
            body{
                background-color: burlywood;
            }
        </style>
        <title><%
                 HttpSession se = request.getSession();
                 String username = (String)se.getAttribute("username"); 
                 out.print("HR Home Page... ");
                %>
        </title>
        <script type="text/javascript">
            function Select(ele){
                var form = document.getElementById("form1");
                var T = document.getElementById("XX");
                if(ele.id === "1"){
                    form.action = "showCandidate";
                }
                else if(ele.id === "2"){
                    form.action = "showAvailableExams";
                }
                else if(ele.id === "3"){
                    form.action = "showAvailableQuestions";
                }
                else if(ele.id === "4"){
                    form.action = "showAvailableAnswers";
                }
                else if(ele.id === "5"){
                    T.value = "Home";
                    form.action = "doSearch";
                }
                else if(ele.id === "6"){
                    T.value = "Home";
                    form.action = "examResult";
                }
                else if(ele.id === "7"){
                    T.value = "Home";
                    form.action = "exam";
                }
                form.submit();
            }
        </script>
    </head>
    <body>
    <Center> <h1>HR-Home-Page</h1> </Center>
    <h3 align="right" style="color: deeppink"> Hello! <%=username %> </h3>
    <form action="" method="POST" id="form1">       
        <center>
            <br><input type="button" name="btn1" id="1" onclick="Select(this)" value="Show Regiseterd Candidates" style="width: 200px; height: 50px;">
            <br><input type="button" name="btn1" id="2" onclick="Select(this)" value="Show Available Exam Types" style="width: 200px; height: 50px;">
            <br><input type="button" name="btn1" id="3" onclick="Select(this)" value="Show Available Questions" style="width: 200px; height: 50px;">
            <br><input type="button" name="btn1" id="4" onclick="Select(this)" value="Show Available Answers" style="width: 200px; height: 50px;">
            <br><input type="button" name="btn1" id="5" onclick="Select(this)" value="Do Search" style="width: 200px; height: 50px;">
            <br><input type="button" name="btn1" id="6" onclick="Select(this)" value="Exams' Results" style="width: 200px; height: 50px;">
            <br><input type="button" name="btn1" id="7" onclick="Select(this)" value="Exams_Candidates" style="width: 200px; height: 50px;">
            <input type="hidden" name="X" id="XX" value="">
        </center>
    </form> 
    </body>
</html>
