<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.Random"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Exam Page</title>
<link rel="stylesheet" type="text/css" href="cssFile.css?v=1" />
</head>
<%
	ArrayList<String> ET = new ArrayList<String>();
	ET = (ArrayList<String>) session.getAttribute("Exams");
%>
<body id="myexam">
	<div id="mydiv">
		<%
			if (ET.size() == 0) {%>
			<h1>  You have already Done Your Exams </h1>
			<p>please wait for our response</p>

			<%} else {
				for (int i = 0; i < ET.size(); i++) {
		%>
		<input id="<%=i%>" name="<%=ET.get(i)%>" class="EB" type="submit"
			onclick="goto(this.name);" value="<%=ET.get(i)%>" disabled="disabled"><br>
		<%
				}
				ET.removeAll(ET);
			}
		%>
	</div>
</body>
<script src="JSFile.js" type="text/javascript"></script>
</html>