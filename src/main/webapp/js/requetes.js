// cf. https://developers.google.com/chart/interactive/docs/gallery/piechart
google.charts.load('current', {'packages': ['map']});

let requete = document.getelementById("requete").value;
let enTeteData = new Array();
let pushData = new Array();
let titleData = new Array();

if (requete === "requete1") {
    enTeteData = ["Region", "Montant"];
    pushData = ["ligne.region", "ligne.montant"];
    titleData = "Montant des remboursements par Région";
}
if (requete === "requete2") {
    enTeteData = ["Region", "Tranche d'âge"];
    pushData = ["ligne.region", "ligne.trancheAge"];
    titleData = "Tranche d’âge la plus remboursée par région";
}
if (requete === "requete3") {
    enTeteData = ["Nature de la prestation", "Tranche d'âge"];
    pushData = ["ligne.nature", "ligne.trancheAge"];
    titleData = "Nature de la prestation la plus remboursée par tranche d'âge";
}
if (requete === "requete4") {
    enTeteData = ["Montant", "Secteur", "Tanche d'âge"];
    pushData = ["ligne.montant", "ligne.secteur", "ligne.trancheAge"];
    titleData = "Montant des dépenses par secteur privé/public par tranche d'âge)";
}
if (requete === "requete5") {
    enTeteData = ["Dépense", "Remboursement", "Spécialité du médecin exécutant"];
    pushData = ["ligne.depense", "ligne.remboursement", "ligne.specialite"];
    titleData = "Montant moyen de la dépense et du remboursement par spécialité du médecin exécutant";
}


function drawMap(result) {
    // On met le résultat au format attendu par google
    var data = [[enTeteData]];
    result.forEach( ligne => data.push([pushData.forEach(p => ligne.pushData[p])]));
    var dataTable = google.visualization.arrayToDataTable(data);

    var map = new google.visualization.Map(document.getElementById('affichage'));
    var options = {title: titleData};
    chart.draw(dataTable, options);
}

// Afficher les unités vendues pour la catégorie choisie
function doAjax() {
    //On change l'url en fonction de la requete choisie
    let url = requete;
    let moisDebut = document.getelementById("moisDebut").value;
    let anneeDebut = document.getelementById("anneeDebut").value;
    let moisFin = document.getelementById("moisFin").value;
    let anneeFin = document.getelementById("anneeFin").value;
    $.ajax({
        url: url,
        // Les données saisies dans le formlaire
        data : $('#formulaireCategorie').serialize(),
        dataType: "json",
        success: drawPiechart, // La fonction qui traite les résultats
        error: showError
    });
}

// Fonction qui traite les erreurs de la requête
function showError(xhr, status, message) {
    alert("Erreur: " + status + " : " + message);
}