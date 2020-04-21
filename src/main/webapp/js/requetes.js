/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
for (let i = 1; i <= 6; i++) {
    document.getElementById("requete" + i).addEventListener("click", effectuerRequete);
}

function effectuerRequete(event) {
    let tab = new Array();
    switch(event.target.id) {
        case "requete1" :
            tab = ["3","22"];
        break;
        case "requete2" :
            tab=["2","3","22"];
        break;
        case "requete3" :
            tab=["2","39"];
        break;
        case "requete4" :
            tab=["2","20","40"];
        break;
        case "requete5" :
            tab=["20","47"];
        break;
        case "requete6" :
            tab=["22","47"];
        break;
    }
    document.getElementById("colonnes").value = tab;

    document.getElementById("formRequetes").action="requetes/stats";
    document.getElementById("formRequetes").method="GET";
    document.getElementById("formRequetes").submit();
}