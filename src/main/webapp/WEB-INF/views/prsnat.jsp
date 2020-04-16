<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
	<title>PRS Nat</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/requetes.css">

</head>

<body>
	<h1>Liste des PRS Nat</h1>
	<table border='1'>
		<tr><th>Nat_Num</th><th>Nat clair</th></tr>
		<c:forEach var="p" items="${prs}">
			<tr>
				<td>${p.natNum}</td>
				<td>${p.natClair}</td>
			</tr>
		</c:forEach>
	</table>
	<hr>
	<a href="${pageContext.request.contextPath}/">Retour au menu</a>
</body>

</html>