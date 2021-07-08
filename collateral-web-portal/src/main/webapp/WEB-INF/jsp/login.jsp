<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login Page</title>
<link rel="stylesheet"  href="/portal/css/bootstrap.min.css">
<link rel="stylesheet" href="/portal/css/name.css/" type="text/css"/>
<script src="/portal/js/bootstrap.min.js"></script>
<style type="text/css">

p{
color: white;
}
</style>
</head>
<body>
	<%@ include file="common/header1.jsp"%>

<div class="container">

	<!-- <h1>Activities</h1>  -->
	<h1>
	<!-- <button type="button" class="btn btn-primary btn-lg btn-block">ACTIVTIES</button> -->
	<button type="button" class="btn btn-secondary btn-lg btn-block">Login</button></h1>
	<!-- <h1>
		<a class="btn btn-deep-orange"><i class="fas fa-clone left"></i> Activities</a>
		</h1> -->


	<div class="sub-container">
		<div class="row">
		
			<div class="col-lg-6">
			<spring:url value="/loginAdmin" var="loginUrl"></spring:url>
			<form:form method="get" modelAttribute="model"
							action="${loginUrl}">
			<center>
				<img class="image" src="/portal/image/login_admin.png" alt="Snow"
					style="width: 300px; height: 300px;"><br>
					<center>
					<button type="submit" style="width: 250px;"  class="btn btn-info">Admin Login</button></center>
			</form:form>
			</div>
		
		
			<div class="col-lg-6">
			<spring:url value="/loginCustomer" var="loginUrl"></spring:url>
			<form:form method="get" modelAttribute="model"
							action="${loginUrl}">
				<img class="image" src="/portal/image/login_user.png" alt="Mountains"
					style="width: 300px; height: 300px;"><br>
					<center>
						<button type="submit" style="width: 250px;" class="btn btn-warning">Customer Login</button></center>
			</form:form>
			</div>
		</div>

		
	</div>
	</div>
	
			<%@ include file="common/footer.jsp"%>
			
</body>
</html>