<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html >
<head>
<link rel="stylesheet" href="/4413Project/css/admin.css" type="text/css" />
<script src="js/admin.js" type="/4413Project/text/javascript"></script>
<script src="/4413Project/js/jquery-1.9.1.js" type="text/javascript"></script>
</head>

<div class="leftbar">
	<ul id="menu">
		<li><div>
			<a class="link1" href="/4413Project/jsp/adminMain.jsp"> 
				<span class="label" style="margin-left: 15px;">Home</span>
			</a>
		</div></li>
		<li><div>
			<a class="link1" href="/4413Project/${initParam.paramC}?action=allUsers">
				<span style="margin-left: 15px;" class="label">All Users</span>
			</a>
		</div></li>
		<li><div>
			<a class="link1" href="/4413Project/${initParam.paramPH}">
			<span style="margin-left: 15px;" class="label">All Purchases</span></a>
		</div></li>
		<li><div>
			<a class="link1" href="/4413Project/${initParam.paramI}?action=allItems">
			<span class="label" style="margin-left: 15px;">All Items</span></a>
		</div></li>
	</ul>
<!-- 	<form class="search">
		SearchUser: <input type="hidden" name="action" value="searchUser" /> <input id="text"
			type="text" name="keyWord" size="12" /> <span
			class="tooltip_message">?</span>
		<p />
		<input id="submit" type="submit" value="Search" />
	</form> -->


</div>
