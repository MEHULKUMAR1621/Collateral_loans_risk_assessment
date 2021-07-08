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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

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
		
		<table class="table table-bordered table-hover">
            <thead>
                <tr>
                    <th>Application ID</th>
                    <th>Loan Amount</th>
                    <th>Tenure(in years)</th>
                    <th>Collateral Details</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${LoanList}" var="loan">
                    <tr>
                        <td>${loan.applicationId}</td>
                        <td>${loan.loanAmount}</td>
                        <td>${loan.tenure}</td>
                        
                        <td>${loan.collateralDetails}</td>
                        <td class="status">${loan.status}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    
    <script>
	    $('.status:contains("Accepted")').css('color', 'green');
		$('.status:contains("Rejected")').css('color', 'red');
		$('.status:contains("Pending")').css('color', 'blue');
    </script>
        
		
	</div>
	</div>
	
	<%--  <p>${sessionScope.token}</p> --%>
	<%@ include file="common/footer.jsp"%>
</body>
</html>