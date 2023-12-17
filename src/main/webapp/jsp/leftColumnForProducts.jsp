<%@page language="java" contentType="text/html"%>


<%-- <%@page import="java.util.Enumeration"%> --%>
<%-- <%@page import="java.util.Hashtable"%> --%>
<%-- <%@page import="java.util.List"%> --%>
<%-- <%@page import="java.util.ArrayList"%> --%>
<%-- <%@page import="java.util.Iterator"%> --%>
<%-- <%@page import="model.Book"%> --%>
<%-- <%@page import="model.Category"%> --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="/4413Project/css/shopping.css" type="text/css" />
<script src="/4413Project/js/shopping.js" type="text/javascript"></script>
<script src="/4413Project/js/jquery-1.9.1.js" type="text/javascript"></script>
</head>

<div class="leftbar">
	<ul id="menu">
		<li><div>
				<a class="link1" href="/4413Project/jsp/shoppingMain.jsp"> <span class="label"
					style="margin-left: 15px;">Home</span>
				</a>
			</div></li>
		<li><div>
				<a class="link1" href="/4413Project/${initParam.paramP}?action=allItems"><span
					style="margin-left: 15px;" class="label">All Products</span></a>
			</div></li>
		<li><div>
				<span class="label" style="margin-left: 15px;">Categories </span>
			</div>
			<ul>
				
			  <c:forEach items="${categoryList}" var="item">
     
			    		     
				<li><a class="label"
					href="/4413Project/${initParam.param1}?action=category&categoryId=${item.id}&category=${item.categoryDescription}">
					<span  class="label" style="margin-left: 30px;">
						${item.categoryDescription} </span></a>
				</li>
     
              </c:forEach>
				
				
				
			</ul></li>
<!-- 		<li><div> -->
<!-- 				<span class="label" style="margin-left: 15px;">Contact Us</span> -->

<!-- 			</div></li> -->
	</ul>
	
	<form class="search">
		Search: <input type="hidden" name="action" value="search" /> <input id="text"
			type="text" name="keyWord" size="12" /> <span
			class="tooltip_message">?</span>
		<p />
		<input id="submit" type="submit" value="Search" />
	</form>


</div>






