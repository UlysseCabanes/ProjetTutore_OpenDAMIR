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
        <link rel="stylesheet" type="text/css" href="CSS/requetes.css">
    </head>
    <header>
        <img src="images/logoAM.jpg" alt="Logo Assurance Maladie" id="logoAM">
        <h1>OpenDAMIR Explorer</h1>
        <img src="images/logoMarianne.jpg" alt="Logo République Française" id="logoMarianne">
    </header>
    <body>
        <h2>- Remboursements de l'Assurance Maladie</h2>
        <a href="importationFichiers.html">Importer des fichiers OpenDAMIR</a>
        <br><br>
        <a>Choisissez une requête à effectuer :</a>
        <br><br>
        <div id="requetes">
            <form id="formRequetes" onsubmit="return false">
                <input type="hidden" id="colonnes" name="colonnes">
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
                <br><br>
                <input type="submit" id="requete1" value="Montant total des remboursements par région">
                <input type="submit" id="requete2" value="Tranche d'âge la plus remboursée par région + montant">
                <input type="submit" id="requete3" value="Nature de la prestation la plus remboursée par tranche d'âge">
                <input type="submit" id="requete4" value="Montant des dépenses dans les secteurs privé/public par tranche d'âge">
                <input type="submit" id="requete5" value="Montant moyen de la dépense par spécialité du médecin exécutant">
                <input type="submit" id="requete6" value="Montant moyen des remboursements par spécialité du médecin exécutant">
            </form>
        </div>
        <script type="text/javascript" src="js/requetes.js"></script>
    </body>
</html>