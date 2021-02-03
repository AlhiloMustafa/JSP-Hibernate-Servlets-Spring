<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<! DOCTYPE html>

<html>

<head>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>List Customers</title>

</head>

<body>



	<div id="wrapper">
		<div id="header">
		<h3></h3>
			<h1>Welcome ${welcomemail}!!</h1>
			
			<h2>Manage Users:</h2>
			 
			
		</div>
	</div>

	<div id="content">
		<table class="table">
			<tr>
				<th scope="col">First Name</th>
				<th scope="col">Last Name</th>
				<th scope="col">Email</th>
				<th scope="col">Password</th>
				<th scope="col">Update</th>

			</tr>

			<c:forEach var="oneCustomer" items="${customers }">


				<c:url var="updatelink" value="/customer/updateform">
					<c:param name="customerId" value="${oneCustomer.id}" />
				</c:url>



				<tr>
					<td>${oneCustomer.getFirstname() }</td>
					<td>${oneCustomer.getLastname() }</td>
					<td>${oneCustomer.getEmail() }</td>
					<td>${oneCustomer.getPassword() }</td>
					<td><a href="${updatelink }">update</a></td>



				</tr>
			</c:forEach>

		</table>

		<div>


			<button type="button" onclick="window.location.href='newuserform'">New
				Customer</button>


		</div>


	</div>

</body>

</html>