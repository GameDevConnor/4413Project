<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<link rel="stylesheet" href="/4413Project/css/admin.css" type="text/css" />
	<script src="/4413Project/js/jquery-1.9.1.js"></script>
	<script src="/4413Project/js/admin.js" type="text/javascript"></script>
	<title>Shopping Cart</title>
</head>

<body>
	<div id="centered">
	<% String username = (String) session.getAttribute("currentUser"); %>
		<jsp:include page="header.jsp" flush="true" />
		<br />
		<jsp:include page="leftColumnForItems.jsp" flush="true" />
		 
		<div>
			<span class="label" style="margin-left: 15px;">Shopping Cart of <%=username %></span>
		</div>

		<jsp:include page="cart.jsp" flush="true" />
 		
	</div>


</body>
</html>