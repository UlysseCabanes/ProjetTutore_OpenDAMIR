/* global google */

//Doc Google Charts https://developers.google.com/chart/interactive/docs/gallery/geochart

//Importer chaque type de Google Chart
//Requêtes 1 et 2 => Carte de France (régions)
google.charts.load('current', {'packages': ['geochart']});
//Requête 3 => Tableau
google.charts.load('current', {'packages': ['corechart']});
//Requêtes 4 et 5 => Histogramme
google.charts.load('current', {'packages': ['barchart']});

//Savoir quelle requête doit être effectuée
let requete = document.getElementById("requete").value;

//Fonction pour créer et ajouter la Google Chart
function drawChart(result) {
    if (requete === "requete1") {
        //On met le résultat au format attendu par google
        var data = [["Région","Montant"]];
        //Ajouter au tableau de données les résultats du DTO
        result.forEach( ligne => data.push([ligne.region, ligne.montant]));
        //Convertir le tableau de données en table de données
        var dataTable = google.visualization.arrayToDataTable(data);
        //Créer un affichage dans le div d'id "affichage"
        var geochart = new google.visualization.GeoChart(document.getElementById("affichage"));
        //Définir le titre en fonction de la requête effectuée
        var options = {title: "Montant des remboursements par Région"};
        //Ajouter la geochart avec son titre
        geochart.draw(dataTable, options);
    }
    if (requete === "requete2") {
        //On met le résultat au format attendu par google
        var data = [["Région","Tranche d'âge"]];
        //Ajouter au tableau de données les résultats du DTO
        result.forEach( ligne => data.push([ligne.libelle, ligne.trancheAge]));
        //Convertir le tableau de données en table de données
        var dataTable = google.visualization.arrayToDataTable(data);
        //Créer un affichage dans le div d'id "affichage"
        var geochart = new google.visualization.GeoChart(document.getElementById("affichage"));
        //Définir le titre en fonction de la requête effectuée
        var options = {title: "Tranche d’âge la plus remboursée par région"};
        //Ajouter la geochart avec son titre
        geochart.draw(dataTable, options);
    }
    if (requete === "requete3") {
        //On met le résultat au format attendu par google
        var data = [["Nature de la prestation","Tranche d'âge"]];
        //Ajouter au tableau de données les résultats du DTO
        result.forEach( ligne => data.push([ligne.libelle, ligne.trancheAge]));
        //Convertir le tableau de données en table de données
        var dataTable = google.visualization.arrayToDataTable(data);
        //Créer un affichage dans le div d'id "affichage"
        var piechart = new google.visualization.PieChart(document.getElementById("affichage"));
        //Définir le titre en fonction de la requête effectuée
        var options = {title: "Tranche d’âge la plus remboursée par région"};
        //Ajouter le piechart avec son titre
        piechart.draw(dataTable, options);
    }
    if (requete === "requete4") {
        //On met le résultat au format attendu par google
        var data = [["Montant", "Secteur", "Tanche d'âge"]];
        //Ajouter au tableau de données les résultats du DTO
        result.forEach( ligne => data.push([ligne.montant, ligne.secteur, ligne.trancheAge]));
        //Obligatoire pour créer un barchart
        var view = new google.visualization.DataView(data);
        
        //Définir les colonnes
        view.setColumns([0, 1, 2,
            { calc: "stringify",
              sourceColumn: 1,
              type: "string",
              role: "annotation" }
        ]);
        
        var options = {
            title: "Montant des dépenses des secteurs privé et public par tranche d'âge",
            width: 600,
            height: 400,
            bar: {groupWidth: "95%"},
            legend: { position: "none" }
        };
        //Créer un affichage dans le div d'id "affichage"
        var barchart = new google.visualization.BarChart(document.getElementById("affichage"));
        //Ajouter le piechart avec son titre
        barchart.draw(view, options);
    }
    if (requete === "requete5") {
        // On met le résultat au format attendu par google
        var data = [["Dépense", "Remboursement", "Spécialité du médecin exécutant"]];
        //Ajouter au tableau de données les résultats du DTO
        result.forEach( ligne => data.push([ligne.depense, ligne.remboursement, ligne.specialite]));
        //Obligatoire pour créer un barchart
        var view = new google.visualization.DataView(data);
        //Définir les colonnes
        view.setColumns([0, 1,
            { calc: "stringify",
              sourceColumn: 1,
              type: "string",
              role: "annotation" },
            2]);
        
        var options = {
            title: "Montant des dépenses par secteur privé/public par tranche d'âge)",
            width: 600,
            height: 400,
            bar: {groupWidth: "95%"},
            legend: { position: "none" }
        };
        //Créer un affichage dans le div d'id "affichage"
        var barchart = new google.visualization.BarChart(document.getElementById("affichage"));
        //Ajouter le piechart avec son titre
        barchart.draw(view, options);
    }
}

//Fonction appelée au "submit" du formulaire "formulaireRequetes"
function doAjax() {
    console.log("TEST");
    //On définit l'url en fonction de la requete choisie
    let url = "service/" + requete;
    $.ajax({
        url: url,
        // Les données saisies dans le formlaire
        data : $('#formRequetes').serialize(),
        dataType: "json",
        success: drawChart, // En cas de succès, on crée la GeoChart
        error: showError //En cas d'erreur, on affiche le message d'erreur
    });
}

// Fonction qui traite les erreurs de la requête
function showError(xhr, status, message) {
    alert("Erreur: " + status + " : " + message);
}