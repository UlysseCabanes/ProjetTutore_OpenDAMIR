/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gzip;

/**
 *
 * @author Alex
 */
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.zip.GZIPInputStream;
import java.net.URL;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

/* Lire le contenu d'une URL web en format gzip*/

public class Gzip{

	/*
	Lit ligne par ligne
	@param gzipURL l'url du fichier à lire
	@throws java.net.MalformedURLException
	*/

	public void readGzipURL(String gzipURL) throws MalformedURLException, IOException {
		URL url = new URL(gzipURL);
		try (
			InputStream in = url.openStream();
			GZIPInputStream gzipIn = new GZIPInputStream(in);
			LineNumberReader reader= new LineNumberReader(new InputStreamReader(gzipIn));
                ){
                    String line;
                    while ((line = reader.readLine()) !=null) {
                        processLine(reader.getLineNumber(),line); 
                        
                        
                    }
                
                }
                    
                        
        }
        
        
        /*
        traite une ligne lue
        
        @param lineNumber le numéro de la ligne, numéroté à partir de 1
        @param line la ligne lue
        */
        protected void processLine(int lineNumber, String line){
            System.out.printf("Ligne n° %d : %n %s %n", lineNumber, line);
        }
}
