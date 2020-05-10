/* global google */

//Doc Google Charts https://developers.google.com/chart/interactive/docs/gallery

//Importer chaque type de Google Chart
//Requêtes 1 et 2 => Carte de France (régions)
google.charts.load('current', {'packages': ['geochart']});
//Requête 3 => Tableau
google.charts.load('current', {'packages': ['table']});
//Requête 4 => Histogramme vertical
google.charts.load('current', {'packages':['corechart', 'bar']});
//Requête 5 => Histogramme horizontal
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
        let data = [["Tranche d'âge", "Nature de la prestation"]];
        let data1 = [["Tranche d'âge", "Nature de la prestation", "Nombre de prestations"]];
        //Ajouter au tableau de données les résultats du DTO
        result.forEach( ligne => data1.push([ligne.trancheAge, ligne.nature, ligne.nbPrestations]));
        //Convertir le tableau de données en table de données
        let max1 = ["","",0];
        let max2 = ["","",0];
        let max3 = ["","",0];
        let max4 = ["","",0];
        let max5 = ["","",0];
        let max6 = ["","",0];
        let max7 = ["","",0];
        let max8 = ["","",0];
        let max9 = ["","",0];
        for (let d of data1) {
            if(d[0] === "0-19 ANS" && d[2] >= max1[2]) {
                max1 = d;
            }
            if(d[0] === "20 - 29 ANS" && d[2] >= max2[2]) {
                max2 = d;
            }
            if(d[0] === "30 - 39 ANS" && d[2] >= max3[2]) {
                max3 = d;
            }
            if(d[0] === "40 - 49 ANS" && d[2] >= max4[2]) {
                max4 = d;
            }
            if(d[0] === "50 - 59 ANS" && d[2] >= max5[2]) {
                max5 = d;
            }
            if(d[0] === "60 - 69 ANS" && d[2] >= max6[2]) {
                max6 = d;
            }
            if(d[0] === "70 - 79 ANS" && d[2] >= max7[2]) {
                max7 = d;
            }
            if(d[0] === "80 ANS ET +" && d[2] >= max8[2]) {
                max8 = d;
            }
            if(d[0] === "AGE INCONNU" && d[2] >= max9[2]) {
                max9 = d;
            }
        }
            data.push([max1[0], max1[1]], 
                      [max2[0], max2[1]],
                      [max3[0], max3[1]],
                      [max4[0], max4[1]],
                      [max5[0], max5[1]],
                      [max6[0], max6[1]],
                      [max7[0], max7[1]],
                      [max8[0], max8[1]],
                      [max9[0], max9[1]],
            );
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
        let data1 = [["Tanche d'âge", "Secteur", "Montant public"]];
        //Ajouter au tableau de données les résultats du DTO
        result.forEach( ligne => data1.push([ligne.trancheAge, ligne.secteur, ligne.montant]));
        //On met le résultat au format attendu par google
        let data = [["Tanche d'âge", "Montant privé", "Montant public"]];
        data.push([data1[1][0], data1[1][2], data1[10][2]],
                  [data1[2][0], data1[2][2], data1[11][2]],
                  [data1[3][0], data1[3][2], data1[12][2]],
                  [data1[4][0], data1[4][2], data1[13][2]],
                  [data1[5][0], data1[5][2], data1[14][2]],
                  [data1[6][0], data1[6][2], data1[15][2]],
                  [data1[7][0], data1[7][2], data1[16][2]],
                  [data1[8][0], data1[8][2], data1[17][2]],
                  [data1[9][0], data1[9][2], data1[18][2]],
        );
        //Convertir le tableau de données en table de données
        let dataTable = google.visualization.arrayToDataTable(data);
        //Définir les options
        let materialOptions = {
            height: 500,
            chartArea: {
                top: 100
            },
            title: "Montant des dépenses des secteurs privé et public par tranche d'âge",
            series: {
                0: { axis: "montant"}
            },
            axes: {
                y: {
                    montant: {side: "left", label: "Montant(€)"}
                }
            }
        };
        //Créer un affichage dans le div d'id "affichage"
        let columnchart = new google.visualization.ColumnChart(document.getElementById("affichage"));
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
        chartArea: {
            top: 100
        },
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