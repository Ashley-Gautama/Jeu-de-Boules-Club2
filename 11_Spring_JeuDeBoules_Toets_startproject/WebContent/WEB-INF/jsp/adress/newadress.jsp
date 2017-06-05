<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create adress</title>
</head>
<body>
	<form:form method="POST" modelAttribute="adress"
		action="${pageContext.request.contextPath}/adress/create">
		<table>
			<tr>

				<td>street</td>
				<td> <form:input path="street" /></td>



			</tr>

			<tr>

				<td>city</td>
				<td><form:input path="city" /></td>

			</tr>
			<tr>
				<td>zipcode</td>
				<td><form:input path="zipcode" /></td>
			</tr>
			<tr>



				<td>member</td>
				<td><form:checkboxes items="${members}" path="member"
						itemValue="id" itemLabel="fullName" /></td>

			</tr>



		</table>
		<p>
			<input type="submit" value="create adress" />
		</p>
	</form:form>
</body>
</html>