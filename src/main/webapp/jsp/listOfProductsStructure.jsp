<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html >

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<link rel="stylesheet" href="../css/shopping.css" type="text/css" />
	<script src="../js/jquery-1.9.1.js"></script>
	<script src="../js/shopping.js" type="text/javascript"></script>
</head>

<body>
	<div id="centered">

		<jsp:include page="header.jsp" flush="true" />
		<br />
		<jsp:include page="leftColumnForProducts.jsp" flush="true" />
		<div>
			<span class="label" style="margin-left: 15px;">List of All Products</span>
		</div>

		<jsp:include page="listOfProducts.jsp" flush="true" />


	</div>


</body>
</html>
