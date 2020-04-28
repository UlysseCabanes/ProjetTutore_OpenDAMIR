/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gzip;

import dao.AgeBenSndsClairFacade;
import dao.BenResRegClairFacade;
import dao.BeneficiaireFacade;
import dao.DateTraitementFacade;
import dao.ExecutantFacade;
import dao.IndicateursFacade;
import dao.PrestationFacade;
import dao.PrsNatClairFacade;
import dao.PrsPpuSecClairFacade;
import dao.PseSpeSndsClairFacade;
import entity.AgeBenSndsClair;
import entity.BenResRegClair;
import entity.Beneficiaire;
import entity.DateTraitement;
import entity.Executant;
import entity.Indicateurs;
import entity.Prestation;
import entity.PrsNatClair;
import entity.PrsPpuSecClair;
import entity.PseSpeSndsClair;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import static javax.xml.bind.DatatypeConverter.parseInteger;

/**
 *
 * @author Alex
 */
/* Lire le contenu d'une URL web en format gzip*/
public class Gzip {

    /*
	Lit ligne par ligne
	@param gzipURL l'url du fichier à lire
        @param colonnes liste des colonnes de la ligne à lire
	@throws java.net.MalformedURLException
        retourne un ArrayList<int[]> de toutes les lignes, décomposées en élément de type int
     
    //(à modifier car float est plus adapte que int)
    public ArrayList<int[]> readGzipURL(String gzipURL, int[] colonnes) throws MalformedURLException, IOException, Exception {
        //convertit l'url (String) saisi en un objet (URL)
        URL url = new URL(gzipURL);
        //Lit le fichier ligne par ligne
        try (
                //créér la variable @line (String) qui va représenter chaque ligne du fichier
                InputStream in = url.openStream();
                GZIPInputStream gzipIn = new GZIPInputStream(in);
                LineNumberReader reader = new LineNumberReader(new InputStreamReader(gzipIn));) {
            String line;
            //Créer j un ArrayList<int[]> qui va être retourner
            ArrayList<int[]> j = new ArrayList<>();
            //Pour chaque ligne du fichier, apelle la fonction processLine()
            while ((line = reader.readLine()) != null) {
                //on saute la première ligne correspondants aux titres
                if (reader.getLineNumber() > 1) {
                    //on ajoute chaque ligne sous forme de int[] à j
                    j.add(processLine(reader.getLineNumber(), line, colonnes));
                }
            }
            return j;
        }

    }*/
    public void readGzipURL(String gzipURL) throws MalformedURLException, IOException, Exception {
        //convertit l'url (String) saisi en un objet (URL)
        URL url = new URL(gzipURL);
        //Lit le fichier ligne par ligne
        try (
                //créér la variable @line (String) qui va représenter chaque ligne du fichier
                InputStream in = url.openStream();
                GZIPInputStream gzipIn = new GZIPInputStream(in);
                LineNumberReader reader = new LineNumberReader(new InputStreamReader(gzipIn));) {
            String line;
            ArrayList<float[]> j = new ArrayList<float[]>();
            //Pour chaque ligne du fichier, 
            while ((line = reader.readLine()) != null) {
                //on ajoute chaque ligne sous forme de int[] à j
                if (reader.getLineNumber() > 1) {
                    int id = reader.getLineNumber();
                    //on ajoute chaque ligne sous forme de int[] à j
                    String[] processLine = processLine(reader.getLineNumber(), line);

                    //Création de AgeBenSnds correspondante à la ligne
                    AgeBenSndsClair ageBenSndsClair = new AgeBenSndsClair();
                    ageBenSndsClair.setAgeNum(Integer.parseInt(processLine[2]));
                    ageBenSndsClair.setAgeClair(Integer.parseInt(processLine[2]));
                    //Création de BenResReg correspondante à la ligne
                    BenResRegClair benResRegClair = new BenResRegClair();
                    benResRegClair.setRegNum(Integer.parseInt(processLine[3]));
                    benResRegClair.setRegClair(Integer.parseInt(processLine[3]));
                    //Création de PrsNat correspondante à la ligne
                    PrsNatClair prsNatClair = new PrsNatClair();
                    prsNatClair.setNatNum(Integer.parseInt(processLine[39]));
                    prsNatClair.setNatClair(Integer.parseInt(processLine[39]));
                    //Création de PrsPpuSec correspondante à la ligne
                    PrsPpuSecClair prsPpuSecClair = new PrsPpuSecClair();
                    prsPpuSecClair.setSecNum(Integer.parseInt(processLine[40]));
                    prsPpuSecClair.setSecClair(Integer.parseInt(processLine[40]));
                    //Création de PseSpeSnds correspondante à la ligne
                    PseSpeSndsClair pseSpeSndsClair = new PseSpeSndsClair();
                    pseSpeSndsClair.setSpeNum(Integer.parseInt(processLine[47]));
                    pseSpeSndsClair.setSpeClair(Integer.parseInt(processLine[47]));
                    
                    
                    
                    //Création de Benficiaire correspondante à la ligne
                    Beneficiaire beneficiaire = new Beneficiaire(id);
                    beneficiaire.setAgeBenSnds(ageBenSndsClair);
                    beneficiaire.setBenResReg(benResRegClair);
                    
                    //Création de DateTraitement correspondante à la ligne
                    DateTraitement dateTraitement = new DateTraitement(id);
                    dateTraitement.setFlxAnnMoi(Integer.parseInt(processLine[0]));
                    
                    //Création de Executant correspondante à la ligne
                    Executant executant = new Executant(id);
                    executant.setPseSpeSnds(pseSpeSndsClair);
                    //Création de Indicateurs correspondante à la ligne
                    Indicateurs indicateurs = new Indicateurs(id);
                    indicateurs.setPrsPaiMnt(Double.parseDouble(processLine[20]));
                    indicateurs.setPrsRemMnt(Double.parseDouble(processLine[22]));
                    //Création de Prestation correspondante à la ligne
                    Prestation prestation = new Prestation(id);
                    prestation.setBeneficiaire(beneficiaire);
                    prestation.setDateTraitement(dateTraitement);
                    prestation.setExecutant(executant);
                    prestation.setIndicateurs(indicateurs);
                    prestation.setPrsNat(prsNatClair);
                    prestation.setPrsPpuSec(prsPpuSecClair);
                    
                    //prestation relié a chaque objet
                    beneficiaire.setPrestation(prestation);
                    dateTraitement.setPrestation(prestation);
                    executant.setPrestation(prestation);
                    indicateurs.setPrestation(prestation);
                    /*
                    //initialisation des attributs des classes XxClair
                    ArrayList<Beneficiaire> beneficiaires=new ArrayList<Beneficiaire>();
                    beneficiaires.add(beneficiaire);
                    ageBenSndsClair.setBeneficiaireList(beneficiaires);
                    benResRegClair.setBeneficiaireList(beneficiaires);
                    
                    ArrayList<Prestation> prestations=new ArrayList<Prestation>();
                    prestations.add(prestation);
                    prsPpuSecClair.setPrestationList(prestations);
                    prsNatClair.setPrestationList(prestations);
                    
                    ArrayList<Executant> executants=new ArrayList<Executant>();
                    executants.add(executant);
                    pseSpeSndsClair.setExecutantList(executants);*/
                    
                    
                    System.out.println("Test ok");
                    
                    AgeBenSndsClairFacade ageBenSndsClairFacade=new AgeBenSndsClairFacade();
                    System.out.println("Test 1");
                    BenResRegClairFacade benResRegClairFacade=new BenResRegClairFacade();
                    BeneficiaireFacade beneficiaireFacade=new BeneficiaireFacade();
                    DateTraitementFacade dateTraitementFacade=new DateTraitementFacade();
                    ExecutantFacade executantFacade=new ExecutantFacade();
                    System.out.println("Test 2");
                    IndicateursFacade indicateursFacade= new IndicateursFacade();
                    PrestationFacade prestationFacade=new PrestationFacade();
                    PrsNatClairFacade prsNatClairFacade=new PrsNatClairFacade();
                    PrsPpuSecClairFacade prsPpuSecClairFacade=new PrsPpuSecClairFacade();
                    PseSpeSndsClairFacade pseSpeSndsClairFacade=new PseSpeSndsClairFacade();
                    System.out.println(ageBenSndsClair);
                    ageBenSndsClairFacade.create(ageBenSndsClair);
                    System.out.println("Test 3");
                    benResRegClairFacade.create(benResRegClair);
                    beneficiaireFacade.create(beneficiaire);
                    dateTraitementFacade.create(dateTraitement);
                    executantFacade.create(executant);
                    indicateursFacade.create(indicateurs);
                    prestationFacade.create();
                    prsNatClairFacade.create(prsNatClair);
                    prsPpuSecClairFacade.create(prsPpuSecClair);
                    pseSpeSndsClairFacade.create(pseSpeSndsClair);
                    System.out.println("ok"+"\n");
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                }
            }
        }

    }

    /*
        traite une ligne lue
        
        @param lineNumber le numéro de la ligne, numéroté à partir de 1
        @param line la ligne lue
        @param colonnes liste des colonnes de la ligne à lire
        retourne la ligne sous forme de tableau de int avec les colonnes sélectionnées
     
    //(à modifier car float est plus adapte que int)
    protected int[] processLine(int lineNumber, String line, int[] colonnes) {
        //définit le séparateur des éléments de la ligne
        String SEPARATEUR = ";";
        //découpe chaque élément de la ligne en données seul dans un tableau de String
        String[] mots = line.split(SEPARATEUR);
        //Créer la variable à retourner @chaine correspondants aux éléments de la ligne souhaités du tableau @mots, aux index correpondants a chaque éléments du tableau @colonnes
        int[] chaine = new int[colonnes.length];

        for (int i = 0; i < colonnes.length; i++) {
            //@chaine se concstitue de int résultants de la conversion des éléments String du tableau mots[]
            chaine[i] = Integer.parseInt(mots[colonnes[i]]);
        }
        //System.out.printf("Ligne n° %d : %n %s %n", lineNumber, chaine);
        return chaine;

    }*/
    protected String[] processLine(int lineNumber, String line) {
        //définit le séparateur des éléments de la ligne
        String SEPARATEUR = ";";
        //découpe chaque élément de la ligne en données seul dans un tableau de String
        String[] mots = line.split(SEPARATEUR);
        //Créer la variable à retourner @chaine correspondants aux éléments de la ligne souhaités du tableau @mots, aux index correpondants a chaque éléments du tableau @colonnes
        String[] chaine = new String[55];

        for (int i = 0; i < 55; i++) {
            if (mots[i].isEmpty() == true) {
                chaine[i] = "";
            } else {
                //@chaine se concstitue de int résultants de la conversion des éléments String du tableau mots[]
                chaine[i] = mots[i];
            }

        }
        //System.out.printf("Ligne n° %d : %n %s %n", lineNumber, chaine);
        return chaine;

    }

}
