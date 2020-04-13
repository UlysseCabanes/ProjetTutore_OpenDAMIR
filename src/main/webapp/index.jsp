<%-- 
    Document   : index
    Created on : 10 avr. 2020, 16:23:40
    Author     : ulyss
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Page d'accueil</title>
    <link rel="stylesheet" type="text/css" href="CSS/accueil.css">
</head>
<header>
    <img src="images/logoAM.jpg" alt="Logo Assurance Maladie" id="logoAM">
    <h1>OpenDAMIR Explorer</h1>
    <img src="images/logoMarianne.jpg" alt="Logo République Française" id="logoMarianne">
</header>
<body>
    <h2>- Accueil</h2>
    <br>
    <p>Choisissez une periode à étudier :</p>
    <select id="periode">
        <option value="Un mois" selected>Un mois</option>
        <option value="Une année">Une année</option>
        <option value="Plusieurs mois">Plusieurs mois</option>
    </select>
    <br><br>
    <form action="requetes.jsp">
        <div id="divPeriode">
            <select id="listeAnnee">
                <option value='2015'>2015</option>
                <option value='2016'>2016</option>
                <option value='2017'>2017</option>
                <option value='2018'>2018</option>
            </select>
            <select id="listeMois">
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
        </div>
        <br>
        <div id="divBouton">
            <input type="submit" id="okButton" value="OK">
        </div>
    </form>
    <script type="text/javascript" src="js/accueil.js"></script>
</body>
</html>