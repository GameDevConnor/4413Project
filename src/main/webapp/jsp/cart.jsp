<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	<%@ page import="model.Cart" %>
	<%@ page import="model.Item" %>
	<%@ page import="model.Purchase" %>
	<%@ page import="java.util.List" %>
	<%@ page import="java.util.ArrayList" %>
	
	<% Cart cart = (Cart) session.getAttribute("cart"); %>
	
	<table border='1' cellpadding='6'>
	
	<tr><th>Item Name</th><th>Item Description</th><th>Item Category</th><th>Item Brand</th><th>Item Price</th><th>Quantity</th></tr>
	
	
	<form method='get' action='items'>	
		<input type='hidden' size='3' name='action' value='add' />
		
		<c:forEach items="${sessionScope.cart.items}" var="e">
			<tr><td> ${e.name} </td>
			<td> ${e.description} </td>
			<td> ${e.category} </td>
			<td> ${e.brand} </td>
			<td> ${e.price} </td>
			
			<td><input type='number' size='5' value='1' name='${e.id}' min='0' max='${e.quantity}' step='1'/></td>
		</c:forEach>
		
		</table><br /><br />
		
		<input type='submit' value='Update' />	 
	</form>


	<%   
		float totalPrice = 0;		
		Purchase purchases = new Purchase();		
		for (Item item : cart.getCart()) {			
			if (request.getParameter(item.getId()) != null) {
				int quantity = Integer.parseInt(request.getParameter(item.getId()));
				
				totalPrice += item.getPrice() * quantity;
				purchases.add(new Purchase((String) session.getAttribute("currentUser"), item, quantity));
			}
			else {
				totalPrice = 0;
				break;
			}			
		}
		
		String message = "";		
		if (totalPrice == 0) {
			message = "Enter a quantity for ALL ITEMS then hit Update";
		}
		else {
			message = "$" + Float.toString(totalPrice);			
			session.setAttribute("purchases", purchases);
		}
	%>
	
	<p>Total Price: <%= message %></p>


	<a class="link1" href="/4413Project/${initParam.paramI}?action=checkout">
	   	<!-- <input type="submit" value='Review/Update' /> -->
	   	<input type="submit" value='Check Out' /> 
   	</a>
   	
   	<fieldset>
	<form class="creditCard">
	   	<c:if test="${cart != null&& !cart.isEmpty()}">   		
	   		<p><b>Please enter your credit card info before checking out:</b></p>
		    <p>
		        <label for="creditCardNumber">Card Number: </label>
		        <input id='creditCardNumber' name='creditCardNumber' type="tel" inputmode="numeric" pattern="[0-9\s]{13,19}" autocomplete="cc-number" maxlength="19" placeholder="xxxx xxxx xxxx xxxx"/>
		    </p>
		    <p>
		        <label for="creditCardCVV">CVV: </label>
		        <input id='creditCardCVV' name='creditCardCVV' type="number" min='000' maxlength="3" placeholder="000"/>
		    </p>
		    <p>
		        <label for="creditCardExpiryMonth">Expiry Date: </label>
		        <input id='creditCardExpiryMonth' name='creditCardExpiryMonth' type="month"/>  
		    </p>
	   	</c:if>
	</form>
	</fieldset>	
</body>
</html>