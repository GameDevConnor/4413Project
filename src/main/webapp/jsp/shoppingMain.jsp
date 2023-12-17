<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html >

<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<link rel="stylesheet" href="/4413Project/css/shopping.css" type="text/css" />
	<script type="/4413Project/text/javascript" src="js/jquery-1.9.1.js"></script>
	<script src="/4413Project/js/shopping.js"></script>
</head>
<body>
	<div id="centered">

		<jsp:include page="header.jsp" flush="true" />
		
		<% String username = request.getParameter("username"); %>
		<script>
			console.log("Current user: "+ '<%=username%>');
		</script>
		<br />
		<jsp:include page="leftColumnForProducts.jsp" flush="true" />
		<span class="label" style="margin-left: 15px;">Featured Products</span>
		<table >
			<tr>
				<td><span class="tooltip_img1">
					<img src="/4413Project/${initParam.imageURL}/the-little-prince-52.jpg" /></span></td>
				<td><span class="tooltip_img1">
					<img src="/4413Project/${initParam.imageURL}/IPad_Air.png" /></span></td>
				<td><span class="tooltip_img1">
					<img src="/4413Project/${initParam.imageURL}/laptop.png" /></span>
				</td>
			</tr>
<!--			<tr>
				<td><span class="tooltip_img1">
					<img src="../${initParam.imageURL}/IPad_Air.png" /></span></td>
			</tr>
			<tr>
				<td><span class="tooltip_img1">
					<img src="../${initParam.imageURL}/laptop.png" /></span>
				</td>
			</tr>  -->
		</table>
	</div>
</body>
</html>