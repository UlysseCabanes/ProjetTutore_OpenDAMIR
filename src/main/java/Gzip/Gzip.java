/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gzip;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.zip.GZIPInputStream;

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
     */
    public  ArrayList<int[]> readGzipURL(String gzipURL, int[] colonnes) throws MalformedURLException, IOException, Exception {
        //convertit l'url (String) saisi en un objet (URL)
        URL url = new URL(gzipURL);
        //Lit le fichier ligne par ligne
        try (
                //créér la variable @line (String) qui va représenter chaque ligne du fichier
                InputStream in = url.openStream();
                GZIPInputStream gzipIn = new GZIPInputStream(in);
                LineNumberReader reader = new LineNumberReader(new InputStreamReader(gzipIn));) {
            String line;
            ArrayList<int[]> j=new ArrayList<int[]>();
            //Pour chaque ligne du fichier, apelle la fonction processLine()
            while ((line = reader.readLine()) != null) {
                if (reader.getLineNumber()>1){
                j.add(processLine(reader.getLineNumber(), line, colonnes));
                }
            }
            return j;
        }

    }
    
    public String readGzipURL(String gzipURL) throws MalformedURLException, IOException, Exception {
        //convertit l'url (String) saisi en un objet (URL)
        URL url = new URL(gzipURL);
        //Lit le fichier ligne par ligne
        try (
                //créér la variable @line (String) qui va représenter chaque ligne du fichier
                InputStream in = url.openStream();
                GZIPInputStream gzipIn = new GZIPInputStream(in);
                LineNumberReader reader = new LineNumberReader(new InputStreamReader(gzipIn));) {
            String line;
            String j = "";
            //Pour chaque ligne du fichier, 
            while ((line = reader.readLine()) != null) {
                j = j + line + "\n";
            }
            return j;
        }

    }

    /*
        traite une ligne lue
        
        @param lineNumber le numéro de la ligne, numéroté à partir de 1
        @param line la ligne lue
        @param colonnes liste des colonnes de la ligne à lire
     */
    protected int[] processLine(int lineNumber, String line, int[] colonnes) {
        //définit le séparateur des éléments de la ligne
        String SEPARATEUR = ";";
        //découpe chaque élément de la ligne en données seul dans un tableau de String
        String[] mots = line.split(SEPARATEUR);
        //Créer la variable à retourner @chaine correspondants aux éléments de la ligne souhaités du tableau @mots, aux index correpondants a chaque éléments du tableau @colonnes
        System.out.println(mots[colonnes[0]]);
        int[] chaine = {};       
        for (int i = 0; i < colonnes.length-1; i++) {       
            chaine[i]=Integer.parseInt(mots[colonnes[i]]);

        } 
        //System.out.printf("Ligne n° %d : %n %s %n", lineNumber, chaine);
        return chaine;

    }
    
    
}
