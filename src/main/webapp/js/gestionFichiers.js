/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
//IMPORTATION
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*Fonction pour choisir la période dans la liste déroulante "période"
- Déclenchée par un click sur la liste*/
document.getElementById("periode").addEventListener("click", choixPeriode);

function choixPeriode() {
    /*Variable qui prend pour valeur le choix sélectionné dans la liste déroulante "période"*/
    let periode = document.getElementById("periode").value;
    /*Vider le div qui contient les éléments variables de la page*/
    let divPeriode = document.getElementById("divPeriode");
    while (divPeriode.firstChild) {
        divPeriode.removeChild(divPeriode.firstChild);
    }
    /*Créer une liste déroulante pour choisir un mois*/
    let listeMois = document.createElement('select');
    listeMois.innerHTML = "<option value='Janvier'>Janvier</option><option value='Février'>Février</option><option value='Mars'>Mars</option><option value='Avril'>Avril</option><option value='Mai'>Mai</option><option value='Juin'>Juin</option><option value='Juillet'>Juillet</option><option value='Août'>Août</option><option value='Septembre'>Septembre</option><option value='Octobre'>Octobre</option><option value='Novembre'>Novembre</option><option value='Décembre'>Décembre</option>";
    listeMois.id = "listeMois";
    listeMois.name = "listeMois";
    /*Créer un espace*/
    let espace = document.createElement('a');
    espace.textContent= " ";
    espace.id = "espace";
    /*Créer une liste déroulante pour choisir une année*/
    let listeAnnee = document.createElement('select');
    listeAnnee.innerHTML = "<option value='2015'>2015</option><option value='2016'>2016</option><option value='2017'>2017</option><option value='2018'>2018</option>";
    listeAnnee.id = "listeAnnee";
    listeAnnee.name = "listeAnnee";
    /*Afficher les éléments nécessaires pour choisir un seul mois*/
    if (periode === "Un mois") {
        /*Ajouter une liste déroulante pour choisir un mois*/
        document.getElementById("divPeriode").appendChild(listeMois);
        /*Ajouter un espace*/
        document.getElementById("divPeriode").appendChild(espace);
        /*Ajouter une liste déroulante pour choisir une année*/
        document.getElementById("divPeriode").appendChild(listeAnnee);
    }
    /*Afficher les éléments nécessaires pour choisir une année entière (12 mois)*/
    if (periode === "Une année") {
        /*Ajouter une liste déroulante pour choisir une année*/
        document.getElementById("divPeriode").appendChild(listeAnnee);
    }
    /*Afficher les éléments nécessaires pour choisir plusieurs mois 
    (de la même année ou de différentes années)*/
    if (periode === "Plusieurs mois") {
        //Réinitialiser le compteur de boutons
        nbButton = 0;
        /*Ajouter une liste déroulante pour choisir un mois*/
        listeMois.id = "listeMois" + nbButton;
        document.getElementById("divPeriode").appendChild(listeMois);
        /*Ajouter un espace*/
        espace.id = "espace" + nbButton;
        document.getElementById("divPeriode").appendChild(espace);
        /*Ajouter une liste déroulante pour choisir une année*/
        listeAnnee.id = "listeAnnee" + nbButton;
        document.getElementById("divPeriode").appendChild(listeAnnee);
        /*Créer et ajouter un bouton "+"*/
        let plusButton = document.createElement('input');
        plusButton.id = "plusButton" + nbButton;
        plusButton.class="";
        plusButton.type = "button";
        plusButton.value="+";
        document.getElementById("divPeriode").appendChild(plusButton);
        document.getElementById("plusButton" + nbButton).addEventListener("click", ajouterMois);
        /*Créer et ajouter un saut de ligne*/
        let sautLigne = document.createElement('br');
        document.getElementById("divPeriode").appendChild(sautLigne);
    }
}

/*Compteur des boutons "+/-"*/
let nbButton;

/*Fonction pour ajouter une ligne de "choix plusieurs mois"
- Déclenchée par un click sur le bouton "+"*/
function ajouterMois() {
    /*Incrémenter le compteur des boutons "+/-"*/
    nbButton += 1;
    /*Ajouter une liste déroulante pour choisir un mois*/
    let listeMois = document.createElement('select');
    listeMois.innerHTML = "<option value='Janvier'>Janvier</option><option value='Février'>Février</option><option value='Mars'>Mars</option><option value='Avril'>Avril</option><option value='Mai'>Mai</option><option value='Juin'>Juin</option><option value='Juillet'>Juillet</option><option value='Août'>Août</option><option value='Septembre'>Septembre</option><option value='Octobre'>Octobre</option><option value='Novembre'>Novembre</option><option value='Décembre'>Décembre</option>";
    /*Incrémenter l'id de la liste déoulante "listeMois" en fonction du compteur*/
    listeMois.id = "listeMois" + nbButton;
    document.getElementById("divPeriode").appendChild(listeMois);
    /*Ajouter un espace*/
    let espace = document.createElement('a');
    espace.textContent= " ";
    espace.id = "espace" + nbButton;
    document.getElementById("divPeriode").appendChild(espace);
    /*Créer et ajouter une liste déroulante pour choisir une année*/
    let listeAnnee = document.createElement('select');
    listeAnnee.innerHTML = "<option value='2015'>2015</option><option value='2016'>2016</option><option value='2017'>2017</option><option value='2018'>2018</option>";
    /*Incrémenter l'id de la liste déoulante "listeAnnée" en fonction du compteur*/
    listeAnnee.id = "listeAnnee" + nbButton;
    document.getElementById("divPeriode").appendChild(listeAnnee);
    /*Créer et ajouter un bouton "+"*/
    let plusButton = document.createElement('input');
    /*Incrémenter l'id du bouton "+"*/
    plusButton.id = "plusButton" + nbButton;
    plusButton.class="";
    plusButton.type = "button";
    plusButton.value="+";
    document.getElementById("divPeriode").appendChild(plusButton);
    document.getElementById("plusButton" + nbButton).addEventListener("click", ajouterMois);
    /*Créer et ajouter un bouton "-"*/
    let moinsButton = document.createElement('input');
    /*Incrémenter l'id du bouton "-"*/
    moinsButton.id = "moinsButton" + nbButton;
    moinsButton.class="";
    moinsButton.type = "button";
    moinsButton.value="-";
    document.getElementById("divPeriode").appendChild(moinsButton);
    document.getElementById("moinsButton" + nbButton).addEventListener("click", retirerMois);
    /*Créer et ajouter un saut de ligne*/
    let sautLigne = document.createElement('br');
    document.getElementById("divPeriode").appendChild(sautLigne);
}

/*Fonction pour retirer une ligne de "choix plusieurs mois"
- Déclenchée par un click sur le bouton - */
function retirerMois() {
    /*Retirer la dernière liste déoulante "listeAnnée" du div*/
    let divPeriode = document.getElementById("divPeriode");
    let listeAnnee = document.getElementById("listeAnnee" + nbButton);
    divPeriode.removeChild(listeAnnee);
    /*Retirer le dernier espace du div*/
    let espace = document.getElementById("espace" + nbButton);
    divPeriode.removeChild(espace);
    /*Retirer la dernière liste déoulante "listeMois" du div*/
    let listeMois = document.getElementById("listeMois" + nbButton);
    divPeriode.removeChild(listeMois);
    /*Retirer le dernier bouton "+" du div*/
    let plusButton = document.getElementById("plusButton" + nbButton);
    divPeriode.removeChild(plusButton);
    /*Retirer le dernier bouton "-" du div*/
    let moinsButton = document.getElementById("moinsButton" + nbButton);
    divPeriode.removeChild(moinsButton);
    /*Retirer le dernier saut de ligne du div*/
    divPeriode.removeChild(divPeriode.lastChild);
    /*Décrémenter le compteur des boutons +/- */
    nbButton -= 1;
}

document.getElementById("formPeriode").addEventListener("submit", periodeChoisie);

function periodeChoisie() {
    //Variable qui prend pour valeur le choix sélectionné dans la liste déroulante "période"
    let periode = document.getElementById("periode").value;
    //Créer un tableau pour afficher la période choisie
    let tab = new Array();
    //Créer un tableau pour enregistrer le ou les mois choisi(s)
    let tabMois = new Array();
    //Créer un tableau pour enregistrer l'année ou les années choisie(s)
    let tabAnnees = new Array();
    //Vérifier quelle période a été choisie
    if (periode === "Un mois") {
        //Mois
        tabMois = document.getElementById("listeMois").value;
        //Annee
        tabAnnees = document.getElementById("listeAnnee").value;
        //Affichage
        tab =  " " + tabMois + " " + tabAnnees;
    }
    if (periode === "Une année") {
        //Mois null == tous les mois de l'année
        tabMois = "null";
        //Annee
        tabAnnees = document.getElementById("listeAnnee").value;
        //Affichage
        tab =  " " + tabAnnees;
    }
    if (periode === "Plusieurs mois") {
        //Prcourir tous les couples Mois-Années
        for (let i = 0; i <= nbButton; i++) {
            //Mois n°i
            tabMois[i] = document.getElementById("listeMois" + i).value; 
            //Année n°i
            tabAnnees[i] = document.getElementById("listeAnnee" + i).value;
            //Affichage du couple Mois-Année n°i
            tab[i] = " " + tabMois[i] + " " + tabAnnees[i];
        }
    }
    //Transmission des tableaux au document html par le biais d'éléments de type "hidden" 
    //pour les transmettre ensuite au controller
    document.getElementById("periodeChoisie").value = tab;
    document.getElementById("moisChoisis").value = tabMois;
    document.getElementById("anneesChoisies").value = tabAnnees;
    //Modifier les paramètres du form pour qu'il soit envoyé
    //au controller avec les valeurs mises à jour
    document.getElementById("formPeriode").action="damir/gestion/importation";
    document.getElementById("formPeriode").method="GET";
    document.getElementById("formPeriode").submit();
}

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
//SUPPRESSION
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*Fonction pour choisir la période dans la liste déroulante "période"
- Déclenchée par un click sur la liste*/
document.getElementById("periode2").addEventListener("click", choixPeriode2);

function choixPeriode2() {
    /*Variable qui prend pour valeur le choix sélectionné dans la liste déroulante "période"*/
    let periode2 = document.getElementById("periode2").value;
    /*Vider le div qui contient les éléments variables de la page*/
    let divPeriode2 = document.getElementById("divPeriode2");
    while (divPeriode2.firstChild) {
        divPeriode2.removeChild(divPeriode2.firstChild);
    }
    /*Créer une liste déroulante pour choisir un mois*/
    let listeMois2 = document.createElement('select');
    listeMois2.innerHTML = "<option value='Janvier'>Janvier</option><option value='Février'>Février</option><option value='Mars'>Mars</option><option value='Avril'>Avril</option><option value='Mai'>Mai</option><option value='Juin'>Juin</option><option value='Juillet'>Juillet</option><option value='Août'>Août</option><option value='Septembre'>Septembre</option><option value='Octobre'>Octobre</option><option value='Novembre'>Novembre</option><option value='Décembre'>Décembre</option>";
    listeMois2.id = "listeMois2";
    listeMois2.name = "listeMois2";
    /*Créer un espace*/
    let espace2 = document.createElement('a');
    espace2.textContent= " ";
    espace2.id = "espace2";
    /*Créer une liste déroulante pour choisir une année*/
    let listeAnnee2 = document.createElement('select');
    listeAnnee2.innerHTML = "<option value='2015'>2015</option><option value='2016'>2016</option><option value='2017'>2017</option><option value='2018'>2018</option>";
    listeAnnee2.id = "listeAnnee2";
    listeAnnee2.name = "listeAnnee2";
    /*Afficher les éléments nécessaires pour choisir un seul mois*/
    if (periode2 === "Un mois") {
        /*Ajouter une liste déroulante pour choisir un mois*/
        document.getElementById("divPeriode2").appendChild(listeMois2);
        /*Ajouter un espace*/
        document.getElementById("divPeriode2").appendChild(espace2);
        /*Ajouter une liste déroulante pour choisir une année*/
        document.getElementById("divPeriode2").appendChild(listeAnnee2);
    }
    /*Afficher les éléments nécessaires pour choisir une année entière (12 mois)*/
    if (periode2 === "Une année") {
        /*Ajouter une liste déroulante pour choisir une année*/
        document.getElementById("divPeriode2").appendChild(listeAnnee2);
    }
    /*Afficher les éléments nécessaires pour choisir plusieurs mois 
    (de la même année ou de différentes années)*/
    if (periode2 === "Plusieurs mois") {
        //Réinitialiser le compteur de boutons
        nbButton2 = 0;
        /*Ajouter une liste déroulante pour choisir un mois*/
        listeMois2.id = "listeMois2" + nbButton2;
        document.getElementById("divPeriode2").appendChild(listeMois2);
        /*Ajouter un espace*/
        espace2.id = "espace2" + nbButton2;
        document.getElementById("divPeriode2").appendChild(espace2);
        /*Ajouter une liste déroulante pour choisir une année*/
        listeAnnee2.id = "listeAnnee2" + nbButton2;
        document.getElementById("divPeriode2").appendChild(listeAnnee2);
        /*Créer et ajouter un bouton "+"*/
        let plusButton2 = document.createElement('input');
        plusButton2.id = "plusButton2" + nbButton2;
        plusButton2.class="";
        plusButton2.type = "button";
        plusButton2.value="+";
        document.getElementById("divPeriode2").appendChild(plusButton2);
        document.getElementById("plusButton2" + nbButton2).addEventListener("click", ajouterMois2);
        /*Créer et ajouter un saut de ligne*/
        let sautLigne2 = document.createElement('br');
        document.getElementById("divPeriode2").appendChild(sautLigne2);
    }
}

/*Compteur des boutons "+/-"*/
let nbButton2;

/*Fonction pour ajouter une ligne de "choix plusieurs mois"
- Déclenchée par un click sur le bouton "+"*/
function ajouterMois2() {
    /*Incrémenter le compteur des boutons "+/-"*/
    nbButton2 += 1;
    /*Ajouter une liste déroulante pour choisir un mois*/
    let listeMois2 = document.createElement('select');
    listeMois2.innerHTML = "<option value='Janvier'>Janvier</option><option value='Février'>Février</option><option value='Mars'>Mars</option><option value='Avril'>Avril</option><option value='Mai'>Mai</option><option value='Juin'>Juin</option><option value='Juillet'>Juillet</option><option value='Août'>Août</option><option value='Septembre'>Septembre</option><option value='Octobre'>Octobre</option><option value='Novembre'>Novembre</option><option value='Décembre'>Décembre</option>";
    /*Incrémenter l'id de la liste déoulante "listeMois" en fonction du compteur*/
    listeMois2.id = "listeMois2" + nbButton2;
    document.getElementById("divPeriode2").appendChild(listeMois2);
    /*Ajouter un espace*/
    let espace2 = document.createElement('a');
    espace2.textContent= " ";
    espace2.id = "espace2" + nbButton2;
    document.getElementById("divPeriode2").appendChild(espace2);
    /*Créer et ajouter une liste déroulante pour choisir une année*/
    let listeAnnee2 = document.createElement('select');
    listeAnnee2.innerHTML = "<option value='2015'>2015</option><option value='2016'>2016</option><option value='2017'>2017</option><option value='2018'>2018</option>";
    /*Incrémenter l'id de la liste déoulante "listeAnnée" en fonction du compteur*/
    listeAnnee2.id = "listeAnnee2" + nbButton2;
    document.getElementById("divPeriode2").appendChild(listeAnnee2);
    /*Créer et ajouter un bouton "+"*/
    let plusButton2 = document.createElement('input');
    /*Incrémenter l'id du bouton "+"*/
    plusButton2.id = "plusButton2" + nbButton2;
    plusButton2.class="";
    plusButton2.type = "button";
    plusButton2.value="+";
    document.getElementById("divPeriode2").appendChild(plusButton2);
    document.getElementById("plusButton2" + nbButton2).addEventListener("click", ajouterMois2);
    /*Créer et ajouter un bouton "-"*/
    let moinsButton2 = document.createElement('input');
    /*Incrémenter l'id du bouton "-"*/
    moinsButton2.id = "moinsButton2" + nbButton2;
    moinsButton2.class="";
    moinsButton2.type = "button";
    moinsButton2.value="-";
    document.getElementById("divPeriode2").appendChild(moinsButton2);
    document.getElementById("moinsButton2" + nbButton2).addEventListener("click", retirerMois2);
    /*Créer et ajouter un saut de ligne*/
    let sautLigne2 = document.createElement('br');
    document.getElementById("divPeriode2").appendChild(sautLigne2);
}

/*Fonction pour retirer une ligne de "choix plusieurs mois"
- Déclenchée par un click sur le bouton - */
function retirerMois2() {
    /*Retirer la dernière liste déoulante "listeAnnée" du div*/
    let divPeriode2 = document.getElementById("divPeriode2");
    let listeAnnee2 = document.getElementById("listeAnnee2" + nbButton2);
    divPeriode2.removeChild(listeAnnee2);
    /*Retirer le dernier espace du div*/
    let espace2 = document.getElementById("espace2" + nbButton2);
    divPeriode2.removeChild(espace2);
    /*Retirer la dernière liste déoulante "listeMois" du div*/
    let listeMois2 = document.getElementById("listeMois2" + nbButton2);
    divPeriode2.removeChild(listeMois2);
    /*Retirer le dernier bouton "+" du div*/
    let plusButton2 = document.getElementById("plusButton2" + nbButton2);
    divPeriode2.removeChild(plusButton2);
    /*Retirer le dernier bouton "-" du div*/
    let moinsButton2 = document.getElementById("moinsButton2" + nbButton2);
    divPeriode2.removeChild(moinsButton2);
    /*Retirer le dernier saut de ligne du div*/
    divPeriode2.removeChild(divPeriode2.lastChild);
    /*Décrémenter le compteur des boutons +/- */
    nbButton2 -= 1;
}

document.getElementById("formPeriode2").addEventListener("submit", periodeChoisie2);

function periodeChoisie2() {
    //Variable qui prend pour valeur le choix sélectionné dans la liste déroulante "période"
    let periode2 = document.getElementById("periode2").value;
    //Créer un tableau pour afficher la période choisie
    let tab2 = new Array();
    //Créer un tableau pour enregistrer le ou les mois choisi(s)
    let tabMois2 = new Array();
    //Créer un tableau pour enregistrer l'année ou les années choisie(s)
    let tabAnnees2 = new Array();
    //Vérifier quelle période a été choisie
    if (periode2 === "Un mois") {
        //Mois
        tabMois2 = document.getElementById("listeMois2").value;
        //Annee
        tabAnnees2 = document.getElementById("listeAnnee2").value;
        //Affichage
        tab2 =  " " + tabMois2 + " " + tabAnnees2;
    }
    if (periode2 === "Une année") {
        //Mois null == tous les mois de l'année
        tabMois2 = "null";
        //Annee
        tabAnnees2 = document.getElementById("listeAnnee2").value;
        //Affichage
        tab2 =  " " + tabAnnees2;
    }
    if (periode2 === "Plusieurs mois") {
        //Prcourir tous les couples Mois-Années
        for (let i = 0; i <= nbButton2; i++) {
            //Mois n°i
            tabMois2[i] = document.getElementById("listeMois2" + i).value; 
            //Année n°i
            tabAnnees2[i] = document.getElementById("listeAnnee2" + i).value;
            //Affichage du couple Mois-Année n°i
            tab2[i] = " " + tabMois2[i] + " " + tabAnnees2[i];
        }
    }
    //Transmission des tableaux au document html par le biais d'éléments de type "hidden" 
    //pour les transmettre ensuite au controller
    document.getElementById("periodeChoisie2").value = tab2;
    document.getElementById("moisChoisis2").value = tabMois2;
    document.getElementById("anneesChoisies2").value = tabAnnees2;
    //Modifier les paramètres du form pour qu'il soit envoyé
    //au controller avec les valeurs mises à jour
    document.getElementById("formPeriode2").action="damir/gestion/suppression";
    document.getElementById("formPeriode2").method="GET";
    document.getElementById("formPeriode2").submit();
}