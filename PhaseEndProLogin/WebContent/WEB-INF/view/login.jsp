
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>



<html>

<head>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<title>Manger Users Login Form</title>
</head>

<body>
<div class="fadeIn first">
	<h1>Login form :</h1>
	<font color="red">${errorMessage}</font>
	<form method="post">
		User Name (Email Used) : <input type="text" name="email" /> Password
		: <input type="password" name="password" /> <input type="submit" />
	</form>
	<p>
		If you do not have an account register as <a
			href="${pageContext.request.contextPath}/customer/newuserform">New
			User .</a>
	</p>
</div>
</body>

</html>