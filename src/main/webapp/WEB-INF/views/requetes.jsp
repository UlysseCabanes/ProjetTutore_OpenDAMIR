<%-- 
    Document   : requetes
    Created on : 6 mai 2020, 14:19:28
    Author     : ulyss
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Page des requetes</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/requetes.css">
    <!-- On charge JQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <!-- On charge l'API Google -->
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
</head>
<header>
    <img src="${pageContext.request.contextPath}/images/logoAM.jpg" alt="Logo Assurance Maladie" id="logoAM">
    <h1>OpenDAMIR Explorer</h1>
    <img src="${pageContext.request.contextPath}/images/logoMarianne.jpg" alt="Logo République Française" id="logoMarianne">
</header>
<body>
    <br>
     <a href="${pageContext.request.contextPath}/damir/accueil/showAccueil">Accueil</a>
     <br><br>
    <a href="${pageContext.request.contextPath}/gestionFichiers.html">Importer des fichiers OpenDAMIR</a>
    <h2>- Statistiques sur les remboursements de l'Assurance Maladie</h2>
    <div id="requetes">
        <form id="formRequetes" onsubmit="return false">
            <label>Choisissez une requete à effectuer :</label> 
            <br><br>
            <select id="requete">
                <option value="requete1">Montant total des remboursements par région</option>
                <option value="requete2">Tranche d'âge la plus remboursée par région (avec montant)</option>
                <option value="requete3">Nature de la prestation la plus remboursée par tranche d'âge</option>
                <option value="requete4">Montant des dépenses dans les secteurs privé et public par tranche d'âge</option>
                <option value="requete5">Montant moyen de la dépense et du remboursement par spécialité du médecin exécutant</option>
            </select>  
            <label>de</label> 
            <input type="date" id="minDate" name="minDate" value="this.htmlValue" min="2015-01-01" max="2018-12-31">
            <label>à</label> 
            <input type="date" id="maxDate" name="maxDate" value="this.htmlValue" min="2015-01-01" max="2018-12-31">
            <input type="submit" value="OK">
        </form>
    </div>
    <!-- Le graphique apparaît ici -->
    <div id="affichage" style="width: 1000px; height: 500px;"></div>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/requetes.js"></script>
</body>
</html>