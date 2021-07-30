<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome-SahuWebApp</title>
<link rel="stylesheet" type="text/css" href="../css/PageStyle.css" />
</head>
<body>
	<%
	if (session.getAttribute("emailID") == null) {
		response.sendRedirect("../index.jsp");
	}
	%>
	<div class="topnav">
		<form method="post" action="http://localhost:8080/sahu-webapp/Home">
			<button type="submit" value=Home style="float: right">Log
				out</button>
		</form>
	</div>

	<div class="header">
		<h1>Hi ${firstname}!</h1>
		<h1>Welcome to Sahu Web App!</h1>
	</div>
	<div class="Form">
		<form method="get"
			action="http://localhost:8080/sahu-webapp/GetDetails">
			<button type="submit" value="View Details">View details.</button>
		</form>
	</div>
	<div class="datalist">
		${htmlContent}
	</div>
</body>
</html>