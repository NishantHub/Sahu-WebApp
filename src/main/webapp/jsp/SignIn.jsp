<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignIn-SahuWebapp</title>
<link rel="stylesheet" type="text/css" href="../css/PageStyle.css" />
</head>
<body>
<div class="topnav">
		<form method="post" action="http://localhost:8080/sahu-webapp/Home">
			<button type= "submit" value=Home>Home</button>
		</form>
	</div>
	<div class="header">
		<h1>Login Page</h1>
		<p>Provide below details to Login.</p>
	</div>
	
	<div class="message">
		<h2>${message}</h2>
	</div>

	<form method="post" action="http://localhost:8080/sahu-webapp/SignIn">

		<div class="Form">
			<input type="text" name="Email ID."
				placeholder="Enter your Email ID.">
		</div>
		<div class="Form">
			<input type="password" name="Password"
				placeholder="Enter your password.">
		</div>
		<div class="Form">
			<button type="submit" value="Signup">Sign In</button>
		</div>
		<div class="Form">
			<p>New User? Click below link to register.</p>
			<a href="http://localhost:8080/sahu-webapp/jsp/SignUp.jsp">Sign Up</a>
		</div>
	</form>
</body>
</html>