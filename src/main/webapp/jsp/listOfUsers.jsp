<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
 
	<div>
		<c:if test="${param.user != null}" > 
			<span class="label" style="margin-left: 15px;"> List of ${param.user}  Users</span>
		</c:if>
	</div>
	
	<% String username = (String) session.getAttribute("currentUser"); %>
	<script>
		console.log("Current session user: "+ '<%=username%>');
	</script> 

	 
	<table id="grid">
		<thead>
			<tr>
				<th id="th-username">Username</th>
				<th id="th-password">Password</th>
				<th id="th-firstName">First Name</th>
				<th id="th-lastName">Last Name</th>		
				<th id="th-button"></th>			
			</tr>
		</thead>

		<tbody>
		  <c:forEach items="${userList}" var="user">
		  
			<script>
				console.log("User +1");
			</script> 
			
			 <tr>
				<td>${user.username}</td>
 			    <td>${user.password}</td>
			    <td>${user.firstName}</td>
			    <td>${user.lastName}</td>
			    <td>
			    	<a href="/4413Project/${initParam.paramC}?action=review&username=${user.username}">
			    	<!-- <input type="submit" value=Review/Update /> -->
			    	<input type="submit" value=Review />
			    	</a>
		    	</td> 
			</tr>   
           </c:forEach>
		</tbody>
	</table>
</body>
</html>