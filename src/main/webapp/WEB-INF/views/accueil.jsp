<%-- 
    Document   : accueil
    Created on : 8 mai 2020, 14:49:24
    Author     : Alex
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page d'accueil</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/accueil.css">
    </head>
    <header>
        <img src="${pageContext.request.contextPath}/images/logoAM.jpg" alt="Logo Assurance Maladie" id="logoAM">
        <h1>OpenDAMIR Explorer</h1>
        <img src="${pageContext.request.contextPath}/images/logoMarianne.jpg" alt="Logo République Française" id="logoMarianne">
    </header>
    <body>
        <h2>- Accueil</h2>
        <a href="${pageContext.request.contextPath}/damir/requetes">Statistiques sur l'Assurance Maladie</a>
        <br><br>
        <a href="${pageContext.request.contextPath}/gestionFichiers.html">Gérer les fichiers Open DAMIR</a>
        <br>
        <p>La base de données contient le(s) fichier(s) Open DAMIR pour les dates suivante(s) :</p>
        <table id="fichiers">
            <thead>
                <tr>
                    <th>Mois</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="date" items="${toutesLesDates}">
                    <tr>
                        <td>${date}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>