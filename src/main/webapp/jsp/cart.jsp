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

<% Cart cart = (Cart) session.getAttribute("cart"); %>

<table border='1' cellpadding='6'>

<tr><th>Item Name</th><th>Item Description</th><th>Item Category</th><th>Item Brand</th><th>Item Price</th><th>Quantity</th></tr>



<c:forEach items="${sessionScope.cart.items}" var="e">
<tr><td> ${e.name} </td>
<td> ${e.description} </td>
<td> ${e.category} </td>
<td> ${e.brand} </td>
<td> ${e.price} </td>
<td><input type='input' size='5' value='1' name='qty${e.id}'/></td>


</c:forEach>

</table><br /><br />

<%   float totalPrice = cart.totalPrice(); %>
<p>Total Price: $<%= totalPrice %></p>


<a href="/4413Project/${initParam.paramI}?action=add&id=${item.id}">
			    	<!-- <input type="submit" value='Review/Update' /> -->
			    	<input type="submit" value='Check Out' />
			    	</a>


</body>
</html>