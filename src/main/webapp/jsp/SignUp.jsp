<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../css/PageStyle.css" />
<title>SignUp-SahuWebapp</title>

</head>
<body>
	<div class="topnav">
		<form method="post" action="http://localhost:8080/sahu-webapp/Home">
			<button type= "submit" value=Home>Home</button>
		</form>
	</div>
	<div class="header">
		<h1>Registration Page</h1>
		<p>Provide below details to register.</p>
	</div>
	<div class="message">
		<h2>${message}</h2>
	</div>
	
	<form method="post" action="http://localhost:8080/sahu-webapp/SignUp">

	<div class="Form">
		<input type="text" name="First Name"
			placeholder="Enter your first name">
	</div>
	<div class="Form">
		<input type="text" name="Last Name" placeholder="Enter your last name">
	</div>
	<div class="Form">
		<input type="text" name="Email ID" placeholder="Enter your Email ID.">
	</div>
	<div class="Form">
		<input type="password" name="Password"
			placeholder="Enter your password">
	</div>
	<div class="Form">
		<button type="submit" value="SignUp">Sign Up</button>
	</div>
</form>


</body>
</html>