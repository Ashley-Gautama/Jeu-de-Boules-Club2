<%-- 
    Document   : menuform
    Created on : Dec 15, 2013, 12:58:25 AM
    Author     : huub
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hoofdmenu</title>
    </head>

    <body>
        <h2>Dit is het Spring hoofdmenu</h2>
        <h3>${message}</h3>
        <a href="${pageContext.request.contextPath}/member/memberlist">Ledenlijst</a><br>
        <a href="${pageContext.request.contextPath}/team/teamlist">Teamlijst</a><br>
		<a href= "${pageContext.request.contextPath}/clinic/list">Cliniclijst</a><br>
		<a href= "${pageContext.request.contextPath}/adress/listadresses">Adressenlijst</a><br>
		
    </body>
</html>
