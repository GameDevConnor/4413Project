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
				<th id="th-id">ID</th>
				<th id="th-name">Name</th>
				<th id="th-dsec">Description</th>
				<th id="th-brand">Brand</th>
				<th id="th-category">Category</th>
				<th id="th-price">Price</th>		
				<th id="th-qty">Quantity</th>			
				<th id="th-button">Action</th>		
			</tr>
		</thead>

		<tbody>
		  <c:forEach items="${itemList}" var="item"> 
			 <tr>
			 	<td id="tr-id">${item.id}</td>
				<td id="tr-name">${item.name}</td>
				<td id="tr-dsec">${item.description}</td>
 			    <td id="tr-brand">${item.brand}</td>
			    <td id="tr-category">${item.category}</td>
			    <td id="tr-price">${item.price}</td> 
			    <td id="tr-qty"><input name="'qty'+${item.id}" type="number" value='${item.quantity}' /></td>

				<td id="tr-button">
			    	<a href="/4413Project/${initParam.paramI}?action=update&id=${item.id}">
			    	<input type="submit" value='Update' />
			    	</a>
		    	</td> 	    	
			</tr>   
           </c:forEach>
           
			<tr>
				<td id="tr-id"><input name="id" type="text" /></td>
				<td id="tr-name"><input name="name" type="text" /></td>
				<td id="tr-dsec"><input name="dsec" type="text" /></td>
 			    <td id="tr-brand"><input name="brand" type="text" /></td>
			    <td id="tr-category"><input name="catgory" type="text" /></td>
			    <td id="tr-price"><input name="price" type="text" /></td> 
			    <td id="tr-qty"><input name="qty" type="text" /></td>
			    <td id="tr-button">
			    	<a href="/4413Project/${initParam.paramI}?action=add&id=${item.id}">
			    	<input type="submit" value='Add New' />
			    	</a>
		    	</td> 	    	
			</tr>	
		</tbody>
	</table>
</body>
</html>