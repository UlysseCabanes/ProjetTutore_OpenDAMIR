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
		<img src="images/logoAM.jpg" alt="Logo Assurance Maladie" id="logoAM">
		<h1>OpenDAMIR Explorer</h1>
		<img src="images/logoMarianne.jpg" alt="Logo République Française" id="logoMarianne">
	</header>
	<body>
		<h2>- Remboursements de l'Assurance Maladie de Septembre 2015, Juin 2016, Février 2017 et Mai 2018</h2>
		<br>
		<form action="index.html">
			<input type="submit" id="accueil" value="Retour à l'accueil">
		</form>
		<br>
		<p>Fichiers téléchargés</p>
		<div id="afficherFichiers">
			<ul>
				<li>A201509.csv</li>
				<li>A201606.csv</li>
				<li>A201702.csv</li>
				<li>A201805.csv</li>
			</ul>
		</div>
		<br><br>
		<p>Choisissez une requête à effectuer :</p>
		<div id="requetes">	
			<input type="button" id="requete1" value="Montant total des remboursements par région">
			<input type="button" id="requete2" value="Tranche d'âge la plus remboursée par région + montant">
			<input type="button" id="requete3" value="Nature de la prestation la plus remboursée par tranche d'âge">
			<input type="button" id="requete4" value="Montant moyen des remboursements par spécialité du médecin exécutant">
			<input type="button" id="requete5" value="Montant des dépenses dans les secteurs privé/public par tranche d'âge">
		</div>
		<script type="text/javascript" src="js/requetes.js"></script>
	</body>
</html>
