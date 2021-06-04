<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin | Home</title>
<%@include file="./base.jsp"%>
</head>
<body class="bg">
	<div class="container">
		<div class="row">
			<div class="btn-group col-md-6 offset-md-3">
				<a href="adminhome" class="btn btn-info w-50 active">Project Details</a>
				<a href="assistantdetails" class="btn btn-info w-50">Assistant Details</a>
			</div>
		</div>
	</div>
	
	<div class="container">
		<table class="table table-bordered table-stript text-center">
			<thead>
				<tr class="table-info">
				<th>Id</th>
				<th>Title</th>
				<th>Description</th>
				<th>City</th>
				<th>State</th>
				<th>Country</th>
				<th>Action</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="p" items="${projects}">
                <tr class="table-light">
                    <td>${p.pId}</td>
                    <td>${p.pTitle}</td>
                    <td>${p.pDescription}</td>
                    <td>${p.pCity}</td>
                    <td>${p.pState}</td>
                    <td>${p.pCountry}</td>
                    <td>
                    <a href="deleteproject/${p.pId }"><i class="fas fa-trash text-danger"></i></a>
                    <a href="toupdateproject/${p.pId }"><i class="fas fa-pen-nib text-primary pl-3"></i></a>
                    </td>
                </tr>
            </c:forEach>
			</tbody>
		</table>
		<div class="container text-center">
			<a class="btn btn-info" href="toaddproject">Add Project</a>
		</div>
	</div>
</body>
</html>