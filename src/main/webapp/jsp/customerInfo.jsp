<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<link rel="stylesheet" href="css/customerInfoStyle.css" type="text/css" />
	<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
	<script src="js/customerInfo.js"></script>
	<title>Customer Info Display</title>
</head>
<body>
	<header>
		<h3>Find Your Dream Product</h3>	
	</header>
	
	<section>
	<fieldset>
		<legend>Customer Info Display</legend>
		
		<form class='infoForm' name="infoForm" onsubmit="return validate()">

		<div class="parallel">
		<section class="sec1">
		<h2>Login Info</h2>
		<p>
			<b><label for="username">Username: ${user.username}</label></b>
		</p>
		<p>
			<b><label for="password">Password: *</label></b>
			<input id='password' name='password' type="text" value=${user.password} required> 
		</p>
		</section>
		
		<section class="sec2">
		<h2>Full Name</h2>
		<p>
			<b><label for="firstname">First Name: *</label></b>
            <input id='firstname' name='firstname' type="text" value=${user.firstName} required>
		</p>
		<p>
            <b><label for="lastname">Last Name: *</label></b>
            <input id='lastname' name='lastname' type="text" value=${user.lastName} required> 
		</p>
		</section>
		</div>
<!-- 
		<section class="sec3">
		<!-- Section for Credit card. Assume one card per customer. 
		<h2>Credit Card</h2>
		<p>
			<b><label for="creditCardNumber">Card Number: </label></b>
			<input id='creditCardNumber' name='creditCardNumber' 
			type="tel" inputmode="numeric" pattern="[0-9\s]{13,19}" 
			autocomplete="cc-number" maxlength="19" 
			placeholder="xxxx xxxx xxxx xxxx"/>
		</p>
		<p>
			<b><label for="creditCardCVV">CVV: </label></b>
			<input id='creditCardCVV' name='creditCardCVV' type="number" maxlength="3" placeholder="000"/>
		</p>
		<p>
			<b><label for="creditCardExpiryMonth">Expiry Date: </label></b>
			<input id='creditCardExpiryMonth' name='creditCardExpiryMonth' type="month"/>  
		</p>
		</section>
 -->
		<section class="sec4">
		<h2>Shipping Info</h2>
		<p>
			<b><label for="street">Street: </label></b>
			<input id='street' name='street' type="text" value=${user.address.street}/>
		</p>
	<!-- 	<p>
			<b><label for="city">City: </label></b>
			<input id='city' name='city' type="text" value=${user.address.province}/>
		</p> -->
		<p>
			<b><label for="province">Province: </label></b>
			<input id='province' name='province' type="text" value=${user.address.province} />
		</p>
		<p>
			<b><label for="country">Country: </label></b>
			<input id='country' name='country' type="text" value=${user.address.country} />
		</p>
		<p>
			<b><label for="zip">Zip: </label></b>
			<input id='zip' name='zip' type="text" value=${user.address.zip} />
		</p>
		<p>
			<b><label for="phone">Phone: </label></b>
			<input id='phone' name='phone' type="text" maxlength="12" value=${user.address.phone} />
		</p>
		</section>
		
		<section class="sec5">
		<h2>Purchase Histories</h2>
			<jsp:include page="listOfPurchaseHistries.jsp" flush="true" />
		</section>

		<section class="sec6">
		<div class="container">
	 		<button class="button" type="submit">Update Info</button>  			
		</div>
		</section>
	</form>
	</fieldset>
	</section>
	
	<footer>
	<aside>
		<h5><strong><i>York University - EECS 4413 Project</i></strong></h5>
		
	</aside>
	</footer>

</body>
</html>