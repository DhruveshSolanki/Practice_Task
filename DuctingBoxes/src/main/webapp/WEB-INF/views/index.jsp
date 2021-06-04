<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String cl = (String) request.getAttribute("cl");
%>

<!doctype html>
<html lang="en">
<head>
<title>Login</title>
<%@include file="./base.jsp"%>
</head>
<body class="bg">

	<div class="container p-5">

		<div class="card mx-auto bg-light" style="width: 40%;">

			<div class="card-body p-3">
				<h2 class="text-center text-primary">Login</h2>
				<div class="<%=cl%> text-center">${msg}</div>
				<form action="loginprocess" method="post">

					<div class="form-group px-3">
						<label for="uid">User Id:</label>
						<div class="input-group">
							<div class="input-group-prepend">
								<span class="input-group-text"> <i class="fas fa-user text-primary"></i></span>
							</div>
							<input type="text" class="form-control"
								placeholder="Enter User ID" name="uId">
						</div>
					</div>
					<div class="form-group px-3">
						<label for="pwd">Password:</label>
						<div class="input-group">
							<div class="input-group-prepend">
								<span class="input-group-text"> <i class="fas fa-lock text-primary"></i></span>
							</div>
							<input type="password" class="form-control"
								placeholder="Enter password" name="uPassword">
						</div>
					</div>
					<div class="text-center p-3">
						<button type="submit" class="btn btn-info">Login</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>

