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
        retourne un ArrayList<int[]> de toutes les lignes, décomposées en élément de type int
     */
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

    }

    public ArrayList<float[]> readGzipURL(String gzipURL) throws MalformedURLException, IOException, Exception {
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
                    //on ajoute chaque ligne sous forme de int[] à j
                    j.add(processLine(reader.getLineNumber(), line));
                }
            }
            return j;
        }

    }

    /*
        traite une ligne lue
        
        @param lineNumber le numéro de la ligne, numéroté à partir de 1
        @param line la ligne lue
        @param colonnes liste des colonnes de la ligne à lire
        retourne la ligne sous forme de tableau de int avec les colonnes sélectionnées
     */
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

    }
    protected float[] processLine(int lineNumber, String line) {
        //définit le séparateur des éléments de la ligne
        String SEPARATEUR = ";";
        //découpe chaque élément de la ligne en données seul dans un tableau de String
        String[] mots = line.split(SEPARATEUR);
        //Créer la variable à retourner @chaine correspondants aux éléments de la ligne souhaités du tableau @mots, aux index correpondants a chaque éléments du tableau @colonnes
        float[] chaine = new float[55];

        for (int i = 0; i < 55; i++) {
            if (mots[i].isEmpty()==true){
                chaine[i]=0;
            }
            else{
                 //@chaine se concstitue de int résultants de la conversion des éléments String du tableau mots[]
            chaine[i] = Float.parseFloat(mots[i]);
            }
           
        }
        //System.out.printf("Ligne n° %d : %n %s %n", lineNumber, chaine);
        return chaine;

    }

}
