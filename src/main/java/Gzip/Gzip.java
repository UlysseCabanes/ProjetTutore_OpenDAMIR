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
import java.text.SimpleDateFormat;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import static javax.xml.bind.DatatypeConverter.parseInteger;

/**
 *
 * @author Alex
 */
/* Lire le contenu d'une URL web en format gzip*/
public class Gzip {

    PrsPpuSecClairFacade prsPpuSecClairFacade;

    PseSpeSndsClairFacade pseSpeSndsClairFacade;

    PrestationFacade prestationFacade;

    PrsNatClairFacade prsNatClairFacade;

    IndicateursFacade indicateursFacade;

    DateTraitementFacade dateTraitementFacade;

    ExecutantFacade executantFacade;

    BeneficiaireFacade beneficiaireFacade;

    BenResRegClairFacade benResRegClairFacade;

    AgeBenSndsClairFacade ageBenSndsClairFacade;
/*
    public Gzip() throws NamingException {
        this.executantFacade = lookupExecutantFacadeBean();
        this.ageBenSndsClairFacade = lookupAgeBenSndsClairFacadeBean();
        this.benResRegClairFacade = lookupBenResRegClairFacadeBean();
        this.beneficiaireFacade = lookupBeneficiaireFacadeBean();
        this.dateTraitementFacade = lookupDateTraitementFacadeBean();
        this.indicateursFacade = lookupIndicateursFacadeBean();
        this.prsNatClairFacade = lookupPrsNatClairFacadeBean();
        this.prestationFacade = lookupPrestationFacadeBean();
        this.pseSpeSndsClairFacade = lookupPseSpeSndsClairFacadeBean();
        this.prsPpuSecClairFacade= lookupPrsPpuSecClairFacadeBean();
    }*/

    

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
        System.out.println("controller.testDAOController.readGzipURL() demarre.............");
        URL url = new URL(gzipURL);
        //Lit le fichier ligne par ligne
        try (
                //créér la variable @line (String) qui va représenter chaque ligne du fichier
                InputStream in = url.openStream();
                GZIPInputStream gzipIn = new GZIPInputStream(in);
                LineNumberReader reader = new LineNumberReader(new InputStreamReader(gzipIn));) {
            String line;
            //Pour chaque ligne du fichier, 
            while ((line = reader.readLine()) != null) {
                //on ajoute chaque ligne sous forme de int[] à j
                if (reader.getLineNumber() > 1) {
                    
                    int id = reader.getLineNumber()+prestationFacade.findAll().size();
                    //on ajoute chaque ligne sous forme de int[] à j
                    String[] processLine = processLine(reader.getLineNumber(), line);

                    //Création de Benficiaire correspondante à la ligne
                    Beneficiaire beneficiaire = new Beneficiaire(id);
                    beneficiaire.setAgeBenSnds(ageBenSndsClairFacade.find(Integer.parseInt(processLine[2])));
                    beneficiaire.setBenResReg(benResRegClairFacade.find(Integer.parseInt(processLine[3])));
                    //Création de DateTraitement correspondante à la ligne
                    DateTraitement dateTraitement = new DateTraitement(id);
                    //Transfomrer la date de type int en type date
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.FRENCH);
                    Date date = formatter.parse(processLine[0]+"01");
                    dateTraitement.setFlxAnnMoi(date);

                    //Création de Executant correspondante à la ligne
                    Executant executant = new Executant(id);
                    executant.setPseSpeSnds(pseSpeSndsClairFacade.find(Integer.parseInt(processLine[47])));
                    //Création de Indicateurs correspondante à la ligne
                    Indicateurs indicateurs = new Indicateurs(id);
                    indicateurs.setPrsPaiMnt(Double.parseDouble(processLine[20]));
                    indicateurs.setPrsRemMnt(Double.parseDouble(processLine[22]));
                    //Création de Prestation correspondante à la ligne
                    Prestation prestation = new Prestation(id);
//                    prestation.setBeneficiaire(beneficiaire);
//                    prestation.setDateTraitement(dateTraitement);
//                    prestation.setExecutant(executant);
//                    prestation.setIndicateurs(indicateurs);
                    prestation.setPrsNat(prsNatClairFacade.find(Integer.parseInt(processLine[39])));
                    prestation.setPrsPpuSec(prsPpuSecClairFacade.find(Integer.parseInt(processLine[40])));

                    //prestation relié a chaque objet
                    beneficiaire.setPrestation(prestation);
                    dateTraitement.setPrestation(prestation);
                    executant.setPrestation(prestation);
                    indicateurs.setPrestation(prestation);

                   
                    //Création des entités dans bdd
                    prestationFacade.create(prestation);
                    beneficiaireFacade.create(beneficiaire);
                    dateTraitementFacade.create(dateTraitement);
                    executantFacade.create(executant);
                    indicateursFacade.create(indicateurs);
                    
                    
                    System.out.println("une ligne lue" + "\n");
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
/*
    private AgeBenSndsClairFacade lookupAgeBenSndsClairFacadeBean() throws NamingException {
       
            Context c = new InitialContext();
            return (AgeBenSndsClairFacade) c.lookup("java:global/io.github.bastide_OpenDAMIR_war_1.0/AgeBenSndsClairFacade!dao.AgeBenSndsClairFacade");
        
    }

    private BenResRegClairFacade lookupBenResRegClairFacadeBean() throws NamingException {
        
            Context c = new InitialContext();
            return (BenResRegClairFacade) c.lookup("java:global/io.github.bastide_OpenDAMIR_war_1.0/BenResRegClairFacade!dao.BenResRegClairFacade");
        
    }

    private BeneficiaireFacade lookupBeneficiaireFacadeBean() throws NamingException {
       
            Context c = new InitialContext();
            return (BeneficiaireFacade) c.lookup("java:global/io.github.bastide_OpenDAMIR_war_1.0/BeneficiaireFacade!dao.BeneficiaireFacade");
        
    }

    private ExecutantFacade lookupExecutantFacadeBean() throws NamingException {
       
            Context c = new InitialContext();
            return (ExecutantFacade) c.lookup("java:global/io.github.bastide_OpenDAMIR_war_1.0/ExecutantFacade!dao.ExecutantFacade");
        
    }

    private DateTraitementFacade lookupDateTraitementFacadeBean() throws NamingException {
       
            Context c = new InitialContext();
            return (DateTraitementFacade) c.lookup("java:global/io.github.bastide_OpenDAMIR_war_1.0/DateTraitementFacade!dao.DateTraitementFacade");
        
    }

    private IndicateursFacade lookupIndicateursFacadeBean() throws NamingException {
       
            Context c = new InitialContext();
            return (IndicateursFacade) c.lookup("java:global/io.github.bastide_OpenDAMIR_war_1.0/IndicateursFacade!dao.IndicateursFacade");
       
    }

    private PrsNatClairFacade lookupPrsNatClairFacadeBean() throws NamingException {
       
            Context c = new InitialContext();
            return (PrsNatClairFacade) c.lookup("java:global/io.github.bastide_OpenDAMIR_war_1.0/PrsNatClairFacade!dao.PrsNatClairFacade");
       
    }

    private PrestationFacade lookupPrestationFacadeBean() throws NamingException {
      
            Context c = new InitialContext();
            return (PrestationFacade) c.lookup("java:global/io.github.bastide_OpenDAMIR_war_1.0/PrestationFacade!dao.PrestationFacade");
        
    }

    private PseSpeSndsClairFacade lookupPseSpeSndsClairFacadeBean() throws NamingException {
       
            Context c = new InitialContext();
            return (PseSpeSndsClairFacade) c.lookup("java:global/io.github.bastide_OpenDAMIR_war_1.0/PseSpeSndsClairFacade!dao.PseSpeSndsClairFacade");
        
    }

    private PrsPpuSecClairFacade lookupPrsPpuSecClairFacadeBean() throws NamingException {
            Context c = new InitialContext();
            return (PrsPpuSecClairFacade) c.lookup("java:global/io.github.bastide_OpenDAMIR_war_1.0/PrsPpuSecClairFacade!dao.PrsPpuSecClairFacade");
       
    }*/

}
