<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html >
<html>
<head>
<link rel="stylesheet" href="/4413Project/css/shopping.css" type="text/css" />
<script src="/4413Project/js/shopping.js" type="text/javascript"></script>
<script src="/4413Project/js/jquery-1.9.1.js" type="text/javascript"></script>
</head>
<body>
<div class="leftbar">
	<ul id="menu">
		<li><div>
			<a class="link1" href="/4413Project/jsp/shoppingMain.jsp"> 
				<span class="label" style="margin-left: 15px;">Home</span>
			</a>
		</div></li>
		
		<li><div>
			<a class="link1" href="/4413Project/${initParam.paramI}?action=allItems">
				<span style="margin-left: 15px;" class="label">All Items</span>
			</a>
		</div></li>
			
		<li><div>
				<span class="label" style="margin-left: 15px;">Categories </span>
			</div>
			<ul>
			  <c:forEach items="${categoryList}" var="category">		     
				<li><a class="label"
					href="/4413Project/items?action=categoryList&category=${category}">
					<span  class="label" style="margin-left: 30px;"> ${category} </span></a>
				</li>
              </c:forEach>	
			</ul>
		</li>
		
		<li><div>
			<span class="label" style="margin-left: 15px;">Brands </span>
			</div>
			<ul>
			  <c:forEach items="${brandList}" var="brand">		     
				<li><a class="label"
					href="/4413Project/items?action=brandList&brand=${brand}">
					<span  class="label" style="margin-left: 30px;"> ${brand} </span></a>
				</li>
              </c:forEach>	
			</ul>
		</li>
	</ul>
	
	<form class="search" action="/4413Project/items">
		Search: 
		<input type="hidden" name="action" value="search" /> 
		<input id="text" type="text" name="keyWord" size="12" /> 
		<span class="tooltip_message">?</span>
		<p />
		<input id="search" type="submit" value="Search" />
	</form>
</div>
</body>
</html>





