<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
 
	<div>
		<c:if test="${param.poList != null}" > 
		<span class="label" style="margin-left: 15px;"> List of ${param.poList} Purchase Orders
		</span>
		</c:if>
	</div>

	 
	<table id="grid">
		<thead>
			<tr>
				<th id="th-id">PO ID</th>
				<th id="th-username">Username</th>
				<th id="th-firstName">First Name</th>
				<th id="th-lastName">Last Name</th>		
				<th id="th-iName">Item Name</th>	
				<th id="th-qty">Quantity</th>		
				<th id="th-price">Price</th>			
				<th id="th-date">Date</th>			
			</tr>
		</thead>

		<tbody>
		  <c:forEach items="${poList}" var="po"> 
			 <tr>
			 	<td id="tr-id">${po.id}</td>
				<td id="tr-username">${po.user.username}</td>
				<td id="tr-firstName">${po.user.firstName}</td>
 			    <td id="tr-lastName">${po.user.lastName}</td>
			    <td id="tr-iName">${po.item.name}</td>
			    <td id="tr-qty">1</td>		<!-- {po.quantity} -->
				<td id="tr-price">${po.item.price}</td>	
			    <td id="tr-date">${po.dateOfCreation}</td> 			    			    	
			</tr>   
           </c:forEach>	
		</tbody>
	</table>
</body>
</html>