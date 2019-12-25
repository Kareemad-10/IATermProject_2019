<%-- 
    Document   : HR_login
    Created on : Dec 11, 2019, 8:25:32 PM
    Author     : Kareem E.Farouk
--%>


<html>
    <head>
        <title> HR Login..1 </title>
        <style type="text/css">
               body {
                   background-color: darkkhaki;
               }
        </style>
        <script type="text/javascript">
            function validate(){
                var user = document.getElementById("texthr1").value;
                var pass = document.getElementById("texthr2").value;
                var form_hr = document.getElementById("f1");
                if((user==="")){
                    alert("Username can't be empty!");
                    document.getElementById("f1").action = "HR_login.jsp";
                    form_hr.submit();
                }
                if((pass==="")){
                    alert("Password can't be empty!");
                    document.getElementById("f1").action = "HR_login.jsp";
                    form_hr.submit(); 
                }
                if(!(user==="") && !(pass==="")){
                    document.getElementById("f1").action = "HR_Control";
                    form_hr.submit();
                }
            }
        </script>
    </head>
    <body>
        <center><h2> Login_HR</h2></center>
        <form name="form_hr" id="f1" action="" method="post">
            <center>
                <table>
                    <tr>
                        <td>
                            UserName:-
                        </td>
                        <td>
                            <input type="text" name="hrName" id="texthr1">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Password:-
                        </td>
                        <td>
                            <input type="password" name="hrPass" id="texthr2">
                        </td>
                    </tr>
                </table>
            </center><br>
            <center><input type="button" name="btn1_hr" value="Enter" id="btn_hr1" onclick="validate()"></center>
        </form>
    </body>
</html>
