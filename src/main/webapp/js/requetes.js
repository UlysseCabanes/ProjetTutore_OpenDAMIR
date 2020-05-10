/* global google */

//Doc Google Charts https://developers.google.com/chart/interactive/docs/gallery

//Importer chaque type de Google Chart
//Requêtes 1 et 2 => Carte de France (régions)
google.charts.load('current', {'packages': ['geochart']});
//Requête 3 => Tableau
google.charts.load('current', {'packages': ['table']});
//Requêtes 4 et 5 => Histogramme
google.charts.load('current', {'packages': ['corechart']});

//Savoir quelle requête doit être effectuée
let requete;

//Fonction pour créer et ajouter la Google Chart
function drawChart(result) {
    if (requete === "requete1") {
        //On met le résultat au format attendu par google
        let data = [["Région","Montant"]];
        //Ajouter au tableau de données les résultats du DTO
        result.forEach( ligne => data.push([ligne.region, ligne.montant]));
        //Convertir le tableau de données en table de données
        let dataTable = google.visualization.arrayToDataTable(data);
        //Créer un affichage dans le div d'id "affichage"
        let geochart = new google.visualization.GeoChart(document.getElementById("affichage"));
        //Définir les options
        let options = {
            title: "Montant des remboursements par Région",
            displayMode: 'regions',
            region: 'FR',
            resolution: 'provinces',
        };
        //Ajouter la geochart avec son titre
        geochart.draw(dataTable, options);
    }
    if (requete === "requete2") {
        //On met le résultat au format attendu par google
        let data = [["Région","Tranche d'âge"]];
        //Ajouter au tableau de données les résultats du DTO
        result.forEach( ligne => data.push([ligne.libelle, ligne.trancheAge]));
        //Convertir le tableau de données en table de données
        let dataTable = google.visualization.arrayToDataTable(data);
        //Créer un affichage dans le div d'id "affichage"
        let geochart = new google.visualization.GeoChart(document.getElementById("affichage"));
        //Définir les options
        let options = {
            title: "Tranche d’âge la plus remboursée par région",
            displayMode: 'regions',
            region: 'FR',
            resolution: 'provinces'
        };
        //Ajouter la geochart avec son titre
        geochart.draw(dataTable, options);
    }
    if (requete === "requete3") {
        //On met le résultat au format attendu par google
        let data = [["Nature de la prestation","Tranche d'âge"]];
        //Ajouter au tableau de données les résultats du DTO
        result.forEach( ligne => data.push([ligne.libelle, ligne.trancheAge]));
        //Convertir le tableau de données en table de données
        let dataTable = google.visualization.arrayToDataTable(data);
        //Créer un affichage dans le div d'id "affichage"
        let table = new google.visualization.Table(document.getElementById("affichage"));
        //Définir les options
        let options = {title: "Tranche d’âge la plus remboursée par région"};
        //Ajouter le piechart avec son titre
        table.draw(dataTable, options);
    }
    if (requete === "requete4") {
        //On met le résultat au format attendu par google
        let data = [["Tanche d'âge", "Montant privé", "Montant public"]];
        //Ajouter au tableau de données les résultats du DTO
        result.forEach( ligne => data.push([ligne.libelle, ligne.montant1, ligne.montant2]));
        //Convertir le tableau de données en table de données
        let dataTable = google.visualization.arrayToDataTable(data);
        //Définir les options
        let materialOptions = {
            width: 900,
            chart: {
                title: "Montant des dépenses des secteurs privé et public par tranche d'âge"
            },
            series: {
                0: { axis: "Privé"},
                1: { axis: "Public"}
            },
            axes: {
                y: {
                    montant: {side: "left", label: "Montant(€)"}
                }
            }
        };
        //Créer un affichage dans le div d'id "affichage"
        let columnchart = new google.charts.Bar(document.getElementById("affichage"));
        //Ajouter le piechart avec son titre
        columnchart.draw(dataTable, google.charts.Bar.convertOptions(materialOptions));
    }
    if (requete === "requete5") {
        // On met le résultat au format attendu par google
        let data = [["Spécialité du médecin exécutant", "Dépense moyenne", "Remboursement moyen"]];
        //Ajouter au tableau de données les résultats du DTO
        result.forEach( ligne => data.push([ligne.libelle, ligne.montant1, ligne.montant2]));
        //Convertir le tableau de données en table de données
        let dataTable = google.visualization.arrayToDataTable(data);
        //Définir les options
        var view = new google.visualization.DataView(dataTable);
        view.setColumns([0, 1,
                       { calc: "stringify",
                         sourceColumn: 1,
                         type: "string",
                         role: "annotation" },
                       2]);

        var options = {
        title: "Montant moyen de la dépense et du remboursement par spécialité du médecin exécutant",
        width: 1200,
        height: 2700,
        bar: {groupWidth: "75%"},
        legend: { position: "none" },
      };
        //Créer un affichage dans le div d'id "affichage"
        let barchart = new google.visualization.BarChart(document.getElementById("affichage"));
        //Ajouter le piechart avec son titre
        barchart.draw(view, options);
    }
}

document.getElementById("formRequetes").addEventListener("submit", doAjax);
//Fonction appelée au "submit" du formulaire "formulaireRequetes"
function doAjax() {
    requete = document.getElementById("requete").value;
    //document.getElementById("formRequetes").submit();
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