<%-- 
    Document   : requetes
    Created on : 6 mai 2020, 14:19:28
    Author     : ulyss
--%>

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
    <h2>- Remboursements de l'Assurance Maladie </h2>
     <a href="${pageContext.request.contextPath}/">Accueil</a>
     <br><br>
    <a href="${pageContext.request.contextPath}/importationFichiers.html">Importer des fichiers OpenDAMIR</a>
    <br><br>
    <div id="requetes">
        <form id="formRequetes" action="doAjax()">
            <label>Choisissez une requete à effectuer :</label> 
            <br><br>
            <select name="requete">
                <option value="requete1">Montant total des remboursements par région</option>
                <option value="requete2">Tranche d'âge la plus remboursée par région + montant</option>
                <option value="requete3">Nature de la prestation la plus remboursée par tranche d'âge</option>
                <option value="requete4">Montant des dépenses dans les secteurs privé/public par tranche d'âge</option>
                <option value="requete5">Montant moyen de la dépense et du remboursement par spécialité du médecin exécutant</option>
            </select>
            <label>de</label> 
            <select name="moisDebut">
                <option value='Janvier'>Janvier</option>
                <option value='Février'>Février</option>
                <option value='Mars'>Mars</option>
                <option value='Avril'>Avril</option>
                <option value='Mai'>Mai</option>
                <option value='Juin'>Juin</option>
                <option value='Juillet'>Juillet</option>
                <option value='Août'>Août</option>
                <option value='Septembre'>Septembre</option>
                <option value='Octobre'>Octobre</option>
                <option value='Novembre'>Novembre</option>
                <option value='Décembre'>Décembre</option>
            </select>
            <select name="anneeDebut">
                <option value='2015'>2015</option>
                <option value='2016'>2016</option>
                <option value='2017'>2017</option>
                <option value='2018'>2018</option>
            </select>
            <label>à</label> 
            <select name="moisFin">
                <option value='Janvier'>Janvier</option>
                <option value='Février'>Février</option>
                <option value='Mars'>Mars</option>
                <option value='Avril'>Avril</option>
                <option value='Mai'>Mai</option>
                <option value='Juin'>Juin</option>
                <option value='Juillet'>Juillet</option>
                <option value='Août'>Août</option>
                <option value='Septembre'>Septembre</option>
                <option value='Octobre'>Octobre</option>
                <option value='Novembre'>Novembre</option>
                <option value='Décembre'>Décembre</option>
            </select>
            <select name="anneeFin">
                <option value='2015'>2015</option>
                <option value='2016'>2016</option>
                <option value='2017'>2017</option>
                <option value='2018'>2018</option>
            </select>
            <input type="submit" value="OK">
        </form>
    </div>
    <!-- Le graphique apparaît ici -->
    <div id="affichage" style="width: 1000px; height: 500px;"></div>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/requetes.js"></script>
</body>
</html>