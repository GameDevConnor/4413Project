<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="css/shopping.css" type="text/css" />
    <script type="text/javascript" src="js/jquery-1.9.1.js"></script>
    <script src="js/shopping.js"></script>
    <style>
        #centered {
            position: relative;
        }

        #featuredProducts {
            margin-top: 20px;
        }

        #productDetails {
            display: none;
            position: fixed;
            bottom: 0;
            left: 50%;
            transform: translateX(-50%);
            width: 80%; /* Adjust the width as needed */
            padding: 10px;
            border: 1px solid #ccc;
            background-color: #CBC3E3;
            color: white;
        }

        #closeButton {
            cursor: pointer;
            float: right;
            color: white;
        }
    </style>
</head>
<body>
    <div id="centered">
        <jsp:include page="header.jsp" flush="true" />
        <br />
        <jsp:include page="leftColumnForProducts.jsp" flush="true" />
        <span class="label" style="margin-left: 15px;">Featured Products</span>
        <table id="featuredProducts">
            <tr>
                <td><span class="tooltip_img1" data-product-id="product1"><img src="../${initParam.imageURL}/the-little-prince-52.jpg" /></span></td>
                <td><span class="tooltip_img1" data-product-id="product2"><img src="../${initParam.imageURL}/IPad_Air.png" /></span></td>
                <td><span class="tooltip_img1" data-product-id="product3"><img src="../${initParam.imageURL}/laptop.png" /></span></td>
            </tr>
        </table>
    </div>

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


