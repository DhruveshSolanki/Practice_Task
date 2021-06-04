<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String cl = (String) request.getAttribute("cl");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assistant | Add Duct</title>
<%@include file="./base.jsp"%>
</head>
<body class="bg">
	<div class="container p-5">
		<div class="card mx-auto bg-light w-50">
			<div class="card-body p-3">
				<h2 class="text-center text-primary">${title} Duct</h2>
				<div class="<%=cl%> text-center">${msg}</div>
				<form
					action="${pageContext.request.contextPath }/${action}/${d.dId }"
					method="post">
					<div class="form-group px-3">
						<label for="duct name">Name:</label>
						<input type="text" name="dName" class="form-control" placeholder="Enter Duct Name" value="${d.dName }">
					</div>
					<div class="form-group px-3">
						<label for="duct latitude">Latitude:</label>
						<input type="text" name="dLatitude" class="form-control" placeholder="Enter Latitude" value="${d.dLatitude }">
					</div>
					<div class="form-group px-3">
						<label for="duct longitude">Longitude:</label>
						<input type="text" name="dLongitude" class="form-control" placeholder="Enter Longitude" value="${d.dLongitude }">
					</div>
					<div class="container text-center">
						<a href="${pageContext.request.contextPath }/assistanthome" class="btn btn-danger px-3">Back</a>
						<button type="submit" class="btn btn-info px-3 ml-2">${title}</button>
					</div>
					</form>
			</div>
		</div>
	</div>
</body>
</html>