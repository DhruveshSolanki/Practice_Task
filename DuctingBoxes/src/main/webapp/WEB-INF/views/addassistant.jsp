<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String cl = (String) request.getAttribute("cl");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin | Add Assistant</title>
<%@include file="./base.jsp"%>
</head>
<body class="bg">
	<div class="container p-5">
		<div class="card mx-auto bg-light w-50">
			<div class="card-body p-3">
				<h2 class="text-center text-primary">${title} Assistant</h2>
				<div class="<%=cl%> text-center">${msg}</div>
				<form
					action="${pageContext.request.contextPath }/${action}/${u.uId}"
					method="post">
					<div class="form-group px-3">
						<label for="user email">Email:</label>
						<input type="email" name="uEmail" class="form-control" placeholder="Enter Email" value="${u.uEmail }">
					</div>
					<div class="form-group px-3">
						<label for="User Password">Password</label>
						<input type="text" name="uPassword" class="form-control" placeholder="Enter Password" value="${u.uPassword }">
					</div>
					<div class="form-group px-3">
						<label for="user role">Role</label>
						<input type="text" name="uRole" class="form-control" placeholder="Enter Role" value="${u.uRole }">
					</div>
					<div class="container text-center">
						<a href="${pageContext.request.contextPath }/adminhome" class="btn btn-danger px-3">Back</a>
						<button type="submit" class="btn btn-info px-3 ml-2">${title}</button>
					</div>
					</form>
			</div>
		</div>
	</div>
</body>
</html>