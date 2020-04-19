<%-- 
    Document   : requetes
    Created on : 8 avr. 2020, 15:35:40
    Author     : ulyss
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Page des requetes</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/requetes.css">
	</head>
	<header>
		<img src="${pageContext.request.contextPath}/images/logoAM.jpg" alt="Logo Assurance Maladie" id="logoAM">
		<h1>OpenDAMIR Explorer</h1>
		<img src="${pageContext.request.contextPath}/images/logoMarianne.jpg" alt="Logo République Française" id="logoMarianne">
	</header>
	<body>
            <br>
            <a href="${pageContext.request.contextPath}/">Retour au menu</a>
            <br>
            <h2>- Remboursements de l'Assurance Maladie de${periodeChoisie}</h2>
		<p>Fichier(s) téléchargé(s)</p>
		<div id="afficherFichiers">
                    <ul>
                    <c:forEach var="clesFic" items="${clesFichiers}">
                        <li>${clesFic}</li>
                    </c:forEach>
                    </ul>
		</div>
		<br><br>
		<p>Choisissez une requête à effectuer :</p>
		<div id="requetes">
                    <form action="" method="GET">
			<input type="button" id="requete1" value="Montant total des remboursements par région">
			<input type="button" id="requete2" value="Tranche d'âge la plus remboursée par région + montant">
			<input type="button" id="requete3" value="Nature de la prestation la plus remboursée par tranche d'âge">
			<input type="button" id="requete4" value="Montant moyen des remboursements par spécialité du médecin exécutant">
			<input type="button" id="requete5" value="Montant des dépenses dans les secteurs privé/public par tranche d'âge">
                    </form>
                </div>
	</body>
</html>