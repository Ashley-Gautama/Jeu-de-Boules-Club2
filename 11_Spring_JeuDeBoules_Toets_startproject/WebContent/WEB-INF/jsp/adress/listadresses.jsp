<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adresses</title>
</head>
<body>
	<table border="1px" cellpadding="0" cellspacing="0">
	
		<tr>
			<td><strong>street</strong></td>
			<td><strong>city</strong></td>
			<td><strong>zipcode</strong></td>
			<td><strong>membername</td>
			</strong>
		</tr>
		<c:forEach var="adress" items="${adresses}">
			<tr>
				<td><a href="${pageContext.request.contextPath}/adress/${adress.id}">${adress.street}</a></td>
				<td>${adress.city}</td>
				<td>${adress.zipcode}</td>
				<td>${adress.member.firstName} ${adress.member.lastName}</td>
			</tr>
		</c:forEach>
	</table>
	<p> <a href="${pageContext.request.contextPath}/adress/newadress"> maak nieuw adres</a></p>
</body>
</html>