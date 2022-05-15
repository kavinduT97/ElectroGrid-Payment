<%@ page import="com.Payment"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
	<html>
		<head>
		<meta charset="ISO-8859-1">
		<title>Payment Management</title>
		
		<link rel="stylesheet" href="Views/bootstrap.min.css">
		<script src="Components/jquery.min.js"></script>
		<script src="Components/Payments.js"></script>
		
		
		</head>
		
	<body>
	
	<center>
	<h1>Payment Management</h1>
	</center>
	<div class="container">
		<div class="row">
			<div class="col">
				<form id="formPayment" name="formPayment" method="post" action="Payments.jsp">
			Electricity Account No:
					<input id="Payment_Account" name="Payment_Account" type="text"
					class="form-control form-control-sm">
					<br> Customer Name:
					<input id="Customer_Name" name="Customer_Name" type="text"
					class="form-control form-control-sm">
					<br> Date:
					<input id="Payment_Date" name="Payment_Date" type="text"
					class="form-control form-control-sm">
					<br> Amount:
					<input id="Payment_Amount" name="Payment_Amount" type="text"
					class="form-control form-control-sm">
					<br>						
					<input id="btnSave" name="btnSave" type="button" value="Save"
					class="btn btn-primary btn-lg">
					<input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">
				</form>
				
			</div>
		</div>
	</div>
	<br>
				<div id="alertSuccess" class="alert alert-success"></div>
				<div id="alertError" class="alert alert-danger"></div>
	<br>
		
		<div id="divItemsGrid">
			 <%
			     Payment payObj = new Payment(); 
				 out.print(payObj.readpayment()); 
			 %>
		</div>

		
		
	</body>
	</html>