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
			 <tr>
				<td>${user.username}</td>
 			    <td>${user.password}</td>
			    <td>${user.firstName}</td>
			    <td>${user.lastName}</td>
			    <td><button>Review/Update</button></td> 
			</tr>   
           </c:forEach>
		</tbody>
	</table>
</body>
</html>