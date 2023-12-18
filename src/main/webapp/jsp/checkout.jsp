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



<% Purchase purchases = (Purchase) session.getAttribute("checkOutCart"); 
	
Cart cart = (Cart) session.getAttribute("cart");
cart.clear();

%>

<table border='1' cellpadding='6'>

<tr><th>Item Name</th><th>Item Description</th><th>Item Category</th><th>Item Brand</th><th>Item Price</th><th>Quantity</th></tr>


<c:forEach items="${sessionScope.purchases.items}" var="e">
<tr><td> ${e.item.name} </td>
<td> ${e.item.description} </td>
<td> ${e.item.category} </td>
<td> ${e.item.brand} </td>
<td> ${e.item.price} </td>
<td> ${e.quantity} </td>


</c:forEach>

</table><br /><br />


</body>
</html>