<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
 

<!DOCTYPE html >
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<script src="/4413Project/js/jquery-1.9.1.js"></script>
	<link rel="stylesheet" href="../css/shopping.css" type="text/css" />
	<script src="/4413Project/js/shopping.js"></script>
</head>

<body>
	<div id="centered">

		<jsp:include page="header.jsp" flush="true" />
		<br />
		<jsp:include page="leftColumnForProducts.jsp" flush="true" />
		
		<div>
			<span class="label" style="margin-left: 15px;">Search results</span>
		</div>

		<jsp:include page="listOfUsers.jsp" flush="true" />



	</div>


</body>
</html>

