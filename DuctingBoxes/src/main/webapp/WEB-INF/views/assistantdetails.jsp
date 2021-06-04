<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin | Assistant Details</title>
<%@include file="./base.jsp"%>
</head>
<body class="bg">
	<div class="container">
		<div class="row">
			<div class="btn-group col-md-6 offset-md-3">
				<a href="adminhome" class="btn btn-info w-50">Project Details</a> <a
					href="#" class="btn btn-info w-50 active">Assistant Details</a>
			</div>
		</div>
	</div>

	<div class="container">
		<table class="table table-bordered table-stript text-center">
			<thead>
				<tr class="table-info">
					<th>Id</th>
					<th>Email</th>
					<th>Password</th>
					<th>Role</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="u" items="${users}">
					<tr class="table-light">
						<td>${u.uId}</td>
						<td>${u.uEmail}</td>
						<td>${u.uPassword}</td>
						<td>${u.uRole}</td>
						<td><a href="deleteUser/${u.uId }"><i
								class="fas fa-trash text-danger"></i></a> <a
							href="toupdateUser/${u.uId}"><i
								class="fas fa-pen-nib text-primary pl-3"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="container text-center">
			<a class="btn btn-info" href="toadduser">Add Assistant</a>
		</div>
	</div>
</body>
</html>