<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html >
 
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<link rel="stylesheet" href="/4413Project/css/admin.css" type="text/css" />
	<script type="text/javascript" src="/4413Project/js/jquery-1.9.1.js"></script>
	<script src="/4413Project/js/admin.js"></script>
	<title>Admin - Main</title>
</head>
<body>
	<div id="centered">
		<% String username = (String) session.getAttribute("currentUser"); %>
        <script>
                console.log("Current user: "+ '<%=username%>');
        </script>
		<jsp:include page="header.jsp" flush="true" />
		<br />
		<jsp:include page="leftColumnForAdmin.jsp" flush="true" />
		
		<span class="label" style="margin-inline: 10% 10%;">Welcome! Select Your Desired Resource On The Left</span>
		<!-- <p class="label" style="vertical-align: middle;">Welcome! Select Your Desired Resource On The Left</p> -->
	</div>
</body>
</html>