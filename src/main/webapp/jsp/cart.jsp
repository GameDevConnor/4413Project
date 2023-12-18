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


<form method='get' action='ItemControllerForAdmin'>

<input type='hidden' size='3' name='action' value='add' />

<c:forEach items="${sessionScope.cart.items}" var="e">
<tr><td> ${e.name} </td>
<td> ${e.description} </td>
<td> ${e.category} </td>
<td> ${e.brand} </td>
<td> ${e.price} </td>

<td><input type='input' size='5' value='${param[e.id]}' name='${e.id}'/></td>


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
	
	session.setAttribute("checkOutCart", purchases);
}



%>
<p>Total Price: <%= message %></p>


<a href="/4413Project/${initParam.paramI}?action=checkout&id=${item.id}">
			    	<!-- <input type="submit" value='Review/Update' /> -->
			    	<input type="submit" value='Check Out' />
			    	</a>


</body>
</html>