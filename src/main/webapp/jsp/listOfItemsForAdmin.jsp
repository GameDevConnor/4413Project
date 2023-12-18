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
				<th id="th-button"></th>	
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
			    <td id="tr-qty">			    
			    	<form method='get'>
					    <input type='hidden' size='3' name='action' value='update' />
					    <input type='hidden' size='3' name='id' value='${item.id}' />
					    <input name="qty${item.id}" type="number" value='${item.quantity}' min="0" step="1"/>
						<input type='submit' value='Update' />
					</form>
		    	</td> 	
		    	<td id="tr-dlt">
			    	<a href="/4413Project/${initParam.paramI}?action=delete&id=${item.id}">
			    	<input type="submit" value='Delete' />
			    	</a>
		    	</td> 	    	
			</tr>   
           </c:forEach>
           
			<tr>
				<td id="tr-id"><input id="id" type="text" /></td>
				<td id="tr-name"><input id="name" type="text" /></td>
				<td id="tr-dsec"><input id="dsec" type="text" /></td>
 			    <td id="tr-brand"><input id="brand" type="text" /></td>
			    <td id="tr-category"><input id="category" type="text" /></td>
			    <td id="tr-price"><input id="price" type="number" min="0" step="0.01" /></td> 
			    <td id="tr-qty"><input id="qty" type="number" min="0" step="1"/></td>
			    <td id="tr-buttonAdd">
			    	<button class="buttonAdd" onclick="insert(this)">Add New</button>
		    	</td> 	    	
			</tr>	
		</tbody>
	</table>
</body>
</html>