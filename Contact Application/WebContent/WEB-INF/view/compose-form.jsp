<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
	<title>Save Customer</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-contact-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Contact Application</h2>
		</div>
	</div>

	<div id="container">
		<h3>Create Contact </h3>
	
		<form:form action="saveContact" modelAttribute="contact" enctype="multipart/form-data"  method="POST" >
		<form:hidden path="id" />
			<table>
				<tbody>
					<tr>
					<td><form:label path="image">Select a file to upload</form:label></td>
            <td><input type="file" name="fileUpload" /></td>
					
					</tr>
				
					<tr>
						<td><label>First Name:</label></td>
						<td><form:input path="firstName" /></td>
					</tr>

					<tr>
						<td><label>Last Name:</label></td>
						<td><form:input path="lastName" /></td>
					</tr>
					<tr>
						<td><label>Email :</label></td>
						<td><form:input path="email" /></td>
					</tr>
					
					<tr>
						<td><label>Phone No:</label></td>
						<td><form:input path="phoneno" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/contact/list">Back to List</a>
		</p>
	
	</div>

</body>

</html>