/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*Fonction pour choisir la période dans la liste déroulante "période"
- Déclenchée par un click sur la liste*/
document.getElementById("periode").addEventListener("click", choixPeriode);

function choixPeriode(event) {
/*Variable qui prend pour valeur le choix sélectionné dans la liste déroulante "période"*/
	let periode = document.getElementById("periode").value;
/*Vider le div qui contient les éléments variables de la page*/
	let divPeriode = document.getElementById("divPeriode");
	while (divPeriode.firstChild) {
		divPeriode.removeChild(divPeriode.firstChild);
	}
	/*Créer une liste déroulante pour choisir une année*/
	let listeAnnee = document.createElement('select');
	listeAnnee.innerHTML = "<option value='2015'>2015</option><option value='2016'>2016</option><option value='2017'>2017</option><option value='2018'>2018</option>";
	listeAnnee.id = "listeAnnee";
        listeAnnee.name = "listeAnnee";
 	/*Créer un espace*/
	let espace = document.createElement('a');
	espace.textContent= " ";
	espace.id = "espace";
	/*Créer une liste déroulante pour choisir un mois*/
	let listeMois = document.createElement('select');
	listeMois.innerHTML = "<option value='Janvier'>Janvier</option><option value='Février'>Février</option><option value='Mars'>Mars</option><option value='Avril'>Avril</option><option value='Mai'>Mai</option><option value='Juin'>Juin</option><option value='Juillet'>Juillet</option><option value='Août'>Août</option><option value='Septembre'>Septembre</option><option value='Octobre'>Octobre</option><option value='Novembre'>Novembre</option><option value='Décembre'>Décembre</option>";
	listeMois.id = "listeMois";
        listeMois.name = "listeMois";
/*Afficher les éléments nécessaires pour choisir un seul mois*/
	if (periode === "Un mois") {
		/*Ajouter une liste déroulante pour choisir une année*/
		document.getElementById("divPeriode").appendChild(listeAnnee);
		/*Ajouter un espace*/
		document.getElementById("divPeriode").appendChild(espace);
		/*Ajouter une liste déroulante pour choisir un mois*/
		document.getElementById("divPeriode").appendChild(listeMois);
	}
/*Afficher les éléments nécessaires pour choisir une année entière (12 mois)*/
	if (periode === "Une année") {
		/*Ajouter une liste déroulante pour choisir une année*/
		document.getElementById("divPeriode").appendChild(listeAnnee);
	}
/*Afficher les éléments nécessaires pour choisir plusieurs mois 
(de la même année ou de différentes années)*/
	if (periode === "Plusieurs mois") {
		/*Ajouter une liste déroulante pour choisir une année*/
		document.getElementById("divPeriode").appendChild(listeAnnee);
		/*Ajouter un espace*/
		document.getElementById("divPeriode").appendChild(espace);
		/*Ajouter une liste déroulante pour choisir un mois*/
		document.getElementById("divPeriode").appendChild(listeMois);
		/*Créer et ajouter un bouton "+"*/
		let plusButton = document.createElement('input');
		plusButton.id = "plusButton";
		plusButton.class="";
		plusButton.type = "button";
		plusButton.value="+";
		document.getElementById("divPeriode").appendChild(plusButton);
		document.getElementById("plusButton").addEventListener("click", ajouterMois);
		/*Créer et ajouter un saut de ligne*/
		let sautLigne = document.createElement('br');
		document.getElementById("divPeriode").appendChild(sautLigne);
	}
}
/*Compteur des boutons "+/-"*/
let nbButton = 1;
/*Fonction pour ajouter une ligne de "choix plusieurs mois"
- Déclenchée par un click sur le bouton "+"*/
function ajouterMois(event) {
	/*Incrémenter le compteur des boutons "+/-"*/
	nbButton += 1;
	/*Créer et ajouter une liste déroulante pour choisir une année*/
	let listeAnnee = document.createElement('select');
	listeAnnee.innerHTML = "<option value='2015'>2015</option><option value='2016'>2016</option><option value='2017'>2017</option><option value='2018'>2018</option>";
	/*Incrémenter l'id de la liste déoulante "listeAnnée" en fonction du compteur*/
	listeAnnee.id = "listeAnnee" + nbButton;
	document.getElementById("divPeriode").appendChild(listeAnnee);
	/*Ajouter un espace*/
	let espace = document.createElement('a');
	espace.textContent= " ";
	espace.id = "espace" + nbButton;
	document.getElementById("divPeriode").appendChild(espace);
	/*Ajouter une liste déroulante pour choisir un mois*/
	let listeMois = document.createElement('select');
	listeMois.innerHTML = "<option value='Janvier'>Janvier</option><option value='Février'>Février</option><option value='Mars'>Mars</option><option value='Avril'>Avril</option><option value='Mai'>Mai</option><option value='Juin'>Juin</option><option value='Juillet'>Juillet</option><option value='Août'>Août</option><option value='Septembre'>Septembre</option><option value='Octobre'>Octobre</option><option value='Novembre'>Novembre</option><option value='Décembre'>Décembre</option>";
	/*Incrémenter l'id de la liste déoulante "listeMois" en fonction du compteur*/
	listeMois.id = "listeMois" + nbButton;
	document.getElementById("divPeriode").appendChild(listeMois);
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
function retirerMois(event) {
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
/*
// Site data.gouv où se trouve les fichiers OpenDamir
const url = "https://www.data.gouv.fr/fr/datasets/open-damir-base-complete-sur-les-depenses-dassurance-maladie-inter-regimes/#_";

// Télécharger les données du site
fetch(url, "GET")
.then( (response) => { 
	return response.json()
})
.then( (dataJSON) => { // dataJSON= les données renvoyées
	//Créer une liste de tous les fichiers de remboursements mensuels
	let listeFichiers = dataJSON.getElementsByClassName("resources-list").ChildNodes;
	//Variable contenant la période d'analyse choisie précédemment par l'utilisateur
	let periodeAnalyse = listeAnnee.value + listeMois.value;
	//Parcourir la liste des fichiers
	for (f of listeFichiers) {
		//Cibler le fichier correspondant à la période souhaitée
		if (f.value == "Fichier OpenDamir A" + periodeAnalyse + ".csv.gz") {
			//Récupérer l'url pour télécharger ce fichier
			let urlFichiers = listeFichiers.getElementsByClassName("btn btn-sm btn-primary").href;
			//Télécharger ce fichier
			fetch(urlFichiers, "GET")
			.then( (response) => { 
				return response.json()
			})
			.then( (dataJSON) => { // dataJSON= les données renvoyées
				//Manipuler les données du fichier
			}
			.catch( (error) => {  // gestion des erreurs
				console.log(error)
		} )
		}
	}
.catch( (error) => {  // gestion des erreurs
	console.log(error)
} )
*/