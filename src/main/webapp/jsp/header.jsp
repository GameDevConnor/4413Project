<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html >
<head>
	<link rel="stylesheet" href="/4413Project/css/header.css" type="text/css" />
	<!--<script src="/4413Project/js/jquery-1.9.1.js" type="text/javascript"></script> -->
	<script src="/4413Project/js/header.js" type="text/javascript"></script>
</head>
<body>
<div class="header">
	<h2>
		<span style="margin-left: 15px; margin-top: 15px; " class="label">Shop Here
			<span style= "color: white;"> - Find Your Dream Product</span></span>
	</h2>
	
	<div class="headerButtons">

		<!-- <a id="visible" href=""><button id="visible" onClick="shoppingCart()">Shopping Cart</button></a> -->
		<a id="visible" href="">Shopping Cart</a> 
		<a id="visible" href="/4413Project/${initParam.paramC}?action=review&username=${sessionScope.currentUser}">View Profile</a>
		<form class='signOut' name="signOut" onsubmit="return signOut()">			
			<button type="submit">Sign Out</button>
			<input type='hidden' name='action' value='signOut'>
		</form>
	</div>
</div>
</body>