<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="css/admin.css" type="text/css" />
<script src="js/admin.js" type="text/javascript"></script>
<script src="js/jquery-1.9.1.js" type="text/javascript"></script>
</head>

<div class="leftbar">
	<ul id="menu">
		<li><div>
			<a class="link1" href="adminMain.jsp"> 
				<span class="label" style="margin-left: 15px;">Home</span>
			</a>
		</div></li>
		<li><div>
			<a class="link1" href="../${initParam.paramC}">
				<span style="margin-left: 15px;" class="label">All Users</span>
			</a>
		</div></li>
		<li><div>
			<a class="link1" href="${initParam.paramPH}">
			<span style="margin-left: 15px;" class="label">All Purchases</span></a>
		</div></li>
		<li><div>
			<a class="link1" href="${initParam.param1}?action=allItems">
			<span class="label" style="margin-left: 15px;">All Products</span></a>
		</div></li>
	</ul>
	<form class="search">
		Search: <input type="hidden" name="action" value="search" /> <input id="text"
			type="text" name="keyWord" size="12" /> <span
			class="tooltip_message">?</span>
		<p />
		<input id="submit" type="submit" value="Search" />
	</form>


</div>
