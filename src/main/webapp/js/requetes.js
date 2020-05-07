// cf. https://developers.google.com/chart/interactive/docs/gallery/geochart
google.charts.load('current', {'packages': ['geochart']});

let requete = document.getElementById("requete").value;

function drawGeoChart(result) {
    if (requete === "requete1") {
        // On met le résultat au format attendu par google
        var data = [["Région","Montant"]];
        result.forEach( ligne => data.push([ligne.region, ligne.montant)]));
        titleData = "Montant des remboursements par Région";
    }
    if (requete === "requete2") {
        // On met le résultat au format attendu par google
        var data = [["Région","Tranche d'âge"]];
        result.forEach( ligne => data.push([ligne.region, ligne.trancheAge)]));
        titleData = "Tranche d’âge la plus remboursée par région";
    }
    if (requete === "requete3") {
        // On met le résultat au format attendu par google
        var data = [["Nature de la prestation","Tranche d'âge"]];
        result.forEach( ligne => data.push([ligne.nature, ligne.trancheAge)]));
        titleData = "Nature de la prestation la plus remboursée par tranche d'âge";
    }
    if (requete === "requete4") {
        // On met le résultat au format attendu par google
        var data = [["Montant", "Secteur", "Tanche d'âge"]];
        result.forEach( ligne => data.push([ligne.montant, ligne.secteur, ligne.trancheAge)]));
        titleData = "Montant des dépenses par secteur privé/public par tranche d'âge)";
    }
    if (requete === "requete5") {
        enTeteData = ["Dépense", "Remboursement", "Spécialité du médecin exécutant"];
        pushData = ["ligne.depense", "ligne.remboursement", "ligne.specialite"];
        titleData = "Montant moyen de la dépense et du remboursement par spécialité du médecin exécutant";
        // On met le résultat au format attendu par google
        var data = [["Dépense", "Remboursement", "Spécialité du médecin exécutant"]];
        result.forEach( ligne => data.push([ligne.depense, ligne.remboursement, ligne.specialite)]));
        titleData = "Montant des dépenses par secteur privé/public par tranche d'âge)";
    }
    var dataTable = google.visualization.arrayToDataTable(data);

    var geochart = new google.visualization.GeoChart(document.getElementById("affichage"));
    var options = {title: titleData};
    chart.draw(dataTable, options);
}

function doAjax() {
    //On change l'url en fonction de la requete choisie
    let url = "service/" + requete;
    
    $.ajax({
        url: url,
        // Les données saisies dans le formlaire
        data : $('#formulaireRequetes').serialize(),
        dataType: "json",
        success: drawGeoChart, // En cas de succès, on crée la GeoChart
        error: showError //En cas d'erreur, on affiche le message d'erreur
    });
}

// Fonction qui traite les erreurs de la requête
function showError(xhr, status, message) {
    alert("Erreur: " + status + " : " + message);
}