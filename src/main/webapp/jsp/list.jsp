<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
 
	<div>
		<c:if test="${param.category != null}" > 
		<span class="label" style="margin-left: 15px;"> List of ${param.category}  Products
		</span>
		</c:if>
	</div>

	 
	<table id="grid">
		<thead>
			<tr>
				<th id="th-name">Product Name</th>
				<th id="th-brand">Brand</th>
				<th id="th-category">Category</th>
				<th id="th-price">Price</th>		
				<th id="th-qty">Quantity</th>			
			</tr>
		</thead>

		<tbody>
		  <c:forEach items="${items}" var="item"> 
			 <tr>
				<%-- <th scope="row" id="r100"> ${book.bookTitle}</th> --%>
				<td>${item.name}</td>
 			    <td>${item.brand}</td>
			    <td>${item.category}</td>
			    <td>${item.price}</td> 
			</tr>   
           </c:forEach>
		</tbody>
	</table>
</body>
</html>