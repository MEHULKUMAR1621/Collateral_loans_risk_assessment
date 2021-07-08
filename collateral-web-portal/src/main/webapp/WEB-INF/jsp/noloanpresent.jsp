<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>View Loan Status</title>
<link rel="stylesheet" href="/portal/css/bootstrap.min.css">
<link rel="stylesheet" href="/portal/css/name.css/" type="text/css" />
<script src="/portal/js/bootstrap.min.js"></script>
<style type="text/css">
body{
/* background-image: url("/portal/image/bank_background1.jpg"); */
/* background-color: blue; */
}
</style>
</head>
<body>
	<%-- <jsp:include page="./common/nav.jsp" /> --%>
	<%@ include file="common/header2.jsp"%>
	
	

	<div class="container">

	
	<h1><button type="button" class="btn btn btn-primary btn-lg btn-block">LOAN APPLICATIONS</button></h1>


<div class="sub-container">

	<p style="color:red;">You have not applied for any loans.</p>
        
	</div>
	</div>
	
	<%--  <p>${sessionScope.token}</p> --%>
	<%@ include file="common/footer.jsp"%>
</body>
</html>