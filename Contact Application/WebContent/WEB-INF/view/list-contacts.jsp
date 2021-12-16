<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Contacts</title>
	
	

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body>

	<div id="wrapper">
	 <div id="header">
			<h2>Contacts</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
		
			<input type="button" value="Add Contact "
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
		 
		 
			<input type="button" value="Sort contact "
				   onclick="window.location.href='sortedlist'; return false;"
				   class="add-button"
			/>
			
		
			<table>
				<tr>
				   <th> Image </th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email </th>
					<th>Phone Number </th>
					<th>Action </th>
				</tr>
				
				
				<c:forEach var="tempUser" items="${contacts}">
				
				
				<c:url var="updateLink" value="/contact/showFormForupdate">
						<c:param name="customerId" value="${tempUser.id}" />
					</c:url>
					<c:url var="deleteLink" value="/contact/delete">
						<c:param name="customerId" value="${tempUser.id}" />
					</c:url>	
					<tr>
						<td><img width="100" height="100" src="getContactPhoto/<c:out value='${tempUser.id}'/>"></td>
						<td> ${tempUser.firstName} </td>
						<td> ${tempUser.lastName} </td>
						<td> ${tempUser.email} </td>
						<td> ${tempUser.phoneno} </td>
						<td>
						
							|
								<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
						</td>
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>






