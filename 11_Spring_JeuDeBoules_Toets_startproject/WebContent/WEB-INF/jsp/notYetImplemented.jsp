<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.Enumeration"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Oops...</title>
</head>
<body>
	<h2>Helaas, deze functie is nog niet gemaakt.</h2>
	(URI is <%= (String)request.getAttribute("javax.servlet.forward.servlet_path") %>) <br/>
	Ga <a href="${pageContext.request.contextPath}/menu">terug</a> naar af.
</body>
</html>