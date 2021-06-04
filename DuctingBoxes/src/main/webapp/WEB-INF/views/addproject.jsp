<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String cl = (String) request.getAttribute("cl");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin | Add Project</title>
<%@include file="./base.jsp"%>
</head>
<body class="bg">
	<div class="container p-5">

		<div class="card mx-auto bg-light w-50">

			<div class="card-body p-3">
				<h2 class="text-center text-primary">${title} Project</h2>
				<div class="<%=cl%> text-center">${msg}</div>
				<form action="${pageContext.request.contextPath }/${action}/${p.pId }" method="post">
					<div class="form-group px-3">
						<label for="project name">Title:</label>
						<input type="text" name="pTitle" class="form-control" placeholder="Enter Title" value="${p.pTitle }">
					</div>
					<div class="form-group px-3">
						<label for="project description">Description:</label>
						<div>
							<textarea class="form-control" name="pDescription" style="resize:none" placeholder="Enter Description" rows="4" >${p.pDescription}</textarea>
						</div>
					</div>
					<div class="form-group px-3">
						<div class="form-row">
							<div class="col-md-4">
								<label for="city">City:</label>
								<input type="text" name="pCity" class="form-control" placeholder="Enter City" value="${p.pCity}">
							</div>
							<div class="col-md-4">
								<label for="state">State:</label>
								<input type="text" name="pState" class="form-control" placeholder="Enter State" value="${p.pState}">
							</div>
							<div class="col-md-4">
								<label for="Country">Country:</label>
								<input type="text" name="pCountry" class="form-control" placeholder="Enter Country" value="${p.pCountry}">
							</div>
						</div>
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