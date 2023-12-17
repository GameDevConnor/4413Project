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
				<th id="th-name">Product Name</th>
				<th id="th-brand">Brand</th>
				<th id="th-category">Category</th>
				<th id="th-price">Price</th>		
				<th id="th-qty">Quantity</th>			
				<th id="th-button"></th>	
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
			    <td>
			    	<a href="/4413Project/${initParam.paramI}?action=review&id=${item.id}">
			    	<!-- <input type="submit" value='Review/Update' /> -->
			    	<input type="submit" value='View Details' />
			    	</a>
		    	</td> 
		    	
		    	<!-- If current user is admin: display update button to update qty -->
		    	<!-- If current user is customer: display add button to add to shopping cart -->
	    		<c:choose>
					<c:when test="${sessionScope.currentUser eq 'admin@yorku.ca'}">
						<td>
					    	<a href="/4413Project/${initParam.paramI}?action=update&id=${item.id}">
					    	<input type="submit" value='Update' />
					    	</a>
				    	</td> 
					</c:when>
					<c:otherwise>
						<td>
					    	<a href="/4413Project/${initParam.paramPO}?action=add&id=${item.id}">
					    	<input type="submit" value='Add To Cart' />
					    	</a>
				    	</td> 
					</c:otherwise>
				</c:choose>		    	
			</tr>   
           </c:forEach>
		</tbody>
	</table>
	<c:if test="${sessionScope.currentUser eq 'admin@yorku.ca'}">
		<br />
		<input class="addNew" type="submit" value='Add New Item' />
	</c:if>
</body>
</html>