<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Random"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="mypackage.LoadData"%>
<%
	String ET = request.getParameter("ET").toString();
	session.setAttribute("ET", ET);
	ArrayList<String> MyQ = (ArrayList<String>) session.getAttribute("Qes");
	ArrayList<String> allAns = (ArrayList<String>) session.getAttribute("Ans");

	Random rand = new Random();
	LoadData ld = new LoadData();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><%=ET%> Exam</title>
<link rel="stylesheet" type="text/css" href="cssFile.css?v=3" />

</head>
<body>
	<input id="ET" value="<%=ET%>" type="text">
	<h1 align="center" style="font-style: oblique;"><%=ET%> Exam</h1><h2 id ="timer_ID" align="right"> </h2>
	<%
		int Q = 0;
		for (int i = 0; i < MyQ.size(); i += 2) {
	%>
	<label id="Qlabel"> Q[<%=MyQ.get(i)%>] : <%=MyQ.get(i + 1)%>
	</label>
	<br>
	<%
		for (int j = 0; j < 4; j++) {
	%><div id="Atd<%=allAns.get(Q)%>">
		<input class="ch<%=MyQ.get(i)%>" id="<%=MyQ.get(i)%>" value="<%=allAns.get(Q)%>" type="checkbox"
			onclick="myFunction(this.id);"> <label><%=allAns.get(Q + 1)%></label>
	</div>
	<br>
	<%
		Q += 2;
			}
	%>
	<br>
	<%
		}
	%>
	<input type="button" onclick="record();" value="Submit">
</body>
<script src="JSFile.js?v2" type="text/javascript"></script>
<script type="text/javascript">ExamTimer(1,5);</script> <!-- 01:05 -->
</html>