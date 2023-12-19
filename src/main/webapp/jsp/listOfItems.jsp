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
		<c:if test="${param.itemList != null}" > 
		<span class="label" style="margin-left: 15px;"> List of ${param.itemList}  Items
		</span>
		</c:if>
	</div>

	 
	<table id="grid">
		<thead>
			<tr>
				<th id="th-name">Name</th>
				<th id="th-brand">Brand</th>
				<th id="th-category">Category</th>
				<th id="th-price">Price</th>		
				<th id="th-qty">QuantityInStock</th>			
				<!-- <th id="th-button"></th> -->	
				<th id="th-button2"></th>	
			</tr>
		</thead>

		<tbody>
		  <c:forEach items="${itemList}" var="item"> 
			 <tr>
				<td>${item.name}</td>
 			    <td>${item.brand}</td>
			    <td>${item.category}</td>
			    <td>${item.price}</td> 
			    <td>${item.quantity}</td>
			    <!-- <td>
			    	<a href="/4413Project/${initParam.paramI}?action=review&id=${item.id}">
			    	<input type="submit" value='View Details' />
			    	</a>
		    	</td>  -->

				<td>
			    	<a href="/4413Project/${initParam.paramI}?action=add&id=${item.id}">
			    	<!-- <a href="/4413Project/cart?action=add&id=${item.id}&qty${item.id}=1"> -->
			    	<input type="submit" value='Add To Cart' />
			    	</a>
		    	</td> 	    	
			</tr>   
           </c:forEach>
		</tbody>
	</table>
</body>
</html>