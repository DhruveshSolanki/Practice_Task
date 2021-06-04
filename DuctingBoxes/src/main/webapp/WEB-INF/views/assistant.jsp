<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assistant | Home</title>
<%@include file="./base.jsp"%>
</head>
<body class="bg">
	<div class="container">
		<table class="table table-bordered table-stript text-center">
			<caption class="text-center text-dark"
				style="caption-side: top; font-family: Times New Roman, Times, serif; font-weight: bold; font-size: 30px;">Ducting
				Details</caption>
			<thead>
				<tr class="table-info">
					<th>Id</th>
					<th>Name</th>
					<th>Latitude</th>
					<th>Longitude</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="d" items="${duct}">
					<tr class="table-light">
						<td>${d.dId}</td>
						<td>${d.dName}</td>
						<td>${d.dLatitude}</td>
						<td>${d.dLongitude}</td>
						<td><a href="deleteduct/${d.dId }"><i
								class="fas fa-trash text-danger"></i></a> <a
							href="toupdateduct/${d.dId }"><i
								class="fas fa-pen-nib text-primary pl-3"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="container text-center">
			<a class="btn btn-info" href="toaddduct">Add Duct Box</a>
		</div>
	</div>
</body>
</html>