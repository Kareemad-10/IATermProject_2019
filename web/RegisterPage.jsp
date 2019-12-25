<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%
	String un = session.getAttribute("un").toString();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Register Page</title>
<link rel="stylesheet" href="cssFile.css">
<script src="JSFile.js?v=1" type="text/javascript"></script>
</head>
<body id="mybody">

	<div id="CorDiv">
		<label> Welcome </label>
		<%=un%>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div id="RegDiv">
		<form id="myform" method="get" action="Registeration"
			onsubmit="return ValidReg();">
			<table id="Rtb">
				<tr id="mytr">
					<td id="e1">E-mail</td>
					<td><input id="em" type="email" name="EM"
						oninput="EMail_exicte()"></td>
					<td><label id="show_response" style="color: white;"></label></td>

					<td><input id="show" type="hidden" value="Show Approval state"
						name="SHOW" onclick="checkApproval()"></td>
					<td><label id="show_approval" style="color: white;"></label></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr id="mytr">
					<td id="e1">CV</td>
					<td align="right"><input id="cv" type="file" name="CV"></td>
				</tr>
				<tr id="mytr">
					<td id="e1">Telephone Number</td>
					<td><input id="tele" type="number" name="TELE"></td>
				</tr>
				<tr>
					<td></td>
					<td><input id="sbt" type="hidden" value="Register" name="REG"></td>
				</tr>
				<tr>
					<td><input id = "examsB" type="hidden" value="List of Exmas" onclick="show_exams()"/></td>
				</tr>																<!-- goto LoadExams.servlet -->
			</table>
		</form>
	</div>

</body>

</html>