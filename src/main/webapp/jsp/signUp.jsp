<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<link rel="stylesheet" href="/4413Project/css/signUpStyle.css" type="text/css" />
	<script type="text/javascript" src="/4413Project/js/jquery-1.9.1.js"></script>
	<script src="/4413Project/js/signUp.js"></script>
	<title>Customer Sign Up</title>
</head>
<body>
	<header>
		<h3>Find Your Dream Product</h3>	
	</header>
	
	<section>
	<fieldset>
		<legend>Welcome, ${username}! Please Sign Up Before Shopping</legend>
		
		<form class='signUpForm' name="signUpForm" onsubmit="return validate()">

		<div class="parallel">
			<section class="sec1">
			<h2>Login Info</h2>
			<p>
				<b><label for="username">Username:  ${username}</label></b>
				<!-- <input id='username' name='username' type="text" value="${username}" placeholder="name@email.com"> -->
				<input type='hidden' name='username' value='${username}' >
			</p>
			<p>
				<b><label for="password">Password: </label></b>
				<input id='password' name='password' type="password" value="${password}">
			</p>
			</section>
				
			<section class="sec2">
			<h2>Full Name</h2>
			<p>
				<b><label for="firstname">First Name: </label></b>
	            <input id='firstname' name='firstname' type="text">
			</p>
			<p>
	            <b><label for="lastname">Last Name: </label></b>
	            <input id='lastname' name='lastname' type="text">
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
			<input id='street' name='street' type="text"/>
		</p>
		<!-- <p>
			<b><label for="city">City: </label></b>
			<input id='city' name='city' type="text"/>
		</p> -->
		<p>
			<b><label for="province">Province: </label></b>
			<input id='province' name='province' type="text"/>
		</p>
		<p>
			<b><label for="country">Country: </label></b>
			<input id='country' name='country' type="text"/>
		</p>
		<p>
			<b><label for="zip">Zip: </label></b>
			<input id='zip' name='zip' type="text"/>
		</p>
		<p>
			<b><label for="phone">Phone: </label></b>
			<input id='phone' name='phone' type="text" maxlength="12" placeholder="xxx-xxx-xxxx" />
		</p>
		</section>

		<section class="sec5">
		<div class="container">
			<input type='hidden' name='action' value='insert'>
	 		<button class="button" type="submit">Sign Up</button>  			
		</div>
		</section>
		
		<h5><strong><i>* Please fill in all fields</i></strong></h5>
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