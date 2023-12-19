<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="/4413Project/css/shopping.css" type="text/css" />
    <script type="text/javascript" src="/4413Project/js/jquery-1.9.1.js"></script>
    <script src="/4413Project/js/shopping.js"></script>
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

        <% String username = (String) session.getAttribute("currentUser"); %>
        <script>
                console.log("Current session user: "+ '<%=username%>');
        </script>
                
        <br />
        <jsp:include page="leftColumnForItems.jsp" flush="true" />
        <span class="label" style="margin-left: 15px;">Featured Products</span>
        <table id="featuredProducts">
            <tr>
              <!--  <td><span id="b001" class="tooltip_img1" data-product-id="product1"><img src="/4413Project/${initParam.imageURL}/the-little-prince-52.jpg" /></span></td>
                <td><span id="c001" class="tooltip_img1" data-product-id="product2"><img src="/4413Project/${initParam.imageURL}/IPad_Air.png" /></span></td>
                <td><span id="d001" class="tooltip_img1" data-product-id="product3"><img src="/4413Project/${initParam.imageURL}/laptop.png" /></span></td> -->
                <td><span id="b001" class="tooltip_img1" data-product-id="b001"><img src="/4413Project/${initParam.imageURL}/the-little-prince-52.jpg" /></span></td>
                <td><span id="c001" class="tooltip_img1" data-product-id="c001"><img src="/4413Project/${initParam.imageURL}/IPad_Air.png" /></span></td>
                <td><span id="d001" class="tooltip_img1" data-product-id="d001"><img src="/4413Project/${initParam.imageURL}/laptop.png" /></span></td>
            </tr>
        </table>
    </div>

	<div id="productDetails">
               <jsp:include page="header.jsp" flush="true" />
       <span id="closeButton" onclick="hideProductDetails()">Close</span>
               
       <!-- Product details will be displayed here -->
	</div>
 <script>
        $(document).ready(function() {
            $('.tooltip_img1').click(function() {
                var productId = $(this).data('product-id');
                displayProductDetails(productId);
            });
        });
        function displayProductDetails(productId) {
        	
        	
    		var xhttp = new XMLHttpRequest(); // create XMLHttpRequestObject
    		 
    		var url = "/4413Project/GetItemData";
    		var data='?a=' + productId;
    		data += "&comm=ajax";
    		
    		xhttp.onreadystatechange = function() {
    		if (xhttp.readyState == 4 && xhttp.status == 200) {
    			
    			var jsonResponse = JSON.parse(xhttp.responseText);
 
            // Simulating the item details with fake data
            var fakeData = {
              //  name: "Fake Product",
              //  description: "This is a fake product for demonstration purposes.",
              //  category: "Electronics",
              //  brand: "Fictional Brand",
              //  quantity: 10,
              //  price: 99.99
                
              
                name: jsonResponse.itemName,
                description: jsonResponse.itemDescription,
                category: jsonResponse.itemCategory,
                brand: jsonResponse.itemBrand,
                quantity: jsonResponse.itemQuantity,
                price: jsonResponse.itemPrice
            };
            // Update the product details section with fake data
            $('#productDetails').html('<span id="closeButton" onclick="hideProductDetails()">Close</span>'
                + '<h2>' + fakeData.name + '</h2>'
                + '<p>Description: ' + fakeData.description + '</p>'
                + '<p>Category: ' + fakeData.category + '</p>'
                + '<p>Brand: ' + fakeData.brand + '</p>'
                + '<p>Quantity: ' + fakeData.quantity + '</p>'
                + '<p>Price: $' + fakeData.price + '</p>');
            // Show the product details
            $('#productDetails').show();
            
    		}
    		}
    		xhttp.open("GET", url+data, true); // open connection
			xhttp.send(); // send
        }
    		
    		
        function hideProductDetails() {
            // Hide the product details
            $('#productDetails').hide();
        }
    </script>
</body>
</html>

