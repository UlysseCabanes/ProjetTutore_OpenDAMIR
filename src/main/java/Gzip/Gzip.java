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
import java.sql.Statement;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.zip.GZIPInputStream;
import java.net.URL;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/* Lire le contenu d'une URL web en format gzip*/

public class Gzip{

	/*
	Lit ligne par ligne
	@param gzipURL l'url du fichier à lire
	@throws java.net.MalformedURLException
	*/

	public void readGzipURL(String gzipURL) throws MalformedURLException, IOException, Exception {
            
            URL url = new URL(gzipURL);
            
            ////
        //Connexion à la bdd pour pouvoir executer commande SQL
            Properties props = new Properties ();
        //Donner id de connexion, avec mot de passe
            props.setProperty ("Alex", "/");
        //Création de la variable connection pour cr
            Connection connection = DriverManager.getConnection("java:app/comptoirs");
            Statement stmt =connection.createStatement();
            
            ////
		try (
			InputStream in = url.openStream();
			GZIPInputStream gzipIn = new GZIPInputStream(in);
			LineNumberReader reader= new LineNumberReader(new InputStreamReader(gzipIn));
                ){
                    String line;
                    while ((line = reader.readLine()) !=null) {
                        processLine(reader.getLineNumber(),line); 
                       
                            
                    ////        
                // Load the data
                String filename = gzipURL;
                String tablename = "AGE_BEN_SNDS_CLAIR";
                stmt.execute("LOAD DATA INFILE \"" + filename + "\" INTO TABLE " + tablename);
                    ////

                        
                        
                    }
                
                }
                    
                        
        }
        
        
        /*
        traite une ligne lue
        
        @param lineNumber le numéro de la ligne, numéroté à partir de 1
        @param line la ligne lue
        */
        protected void processLine(int lineNumber, String line) {
            System.out.printf("Ligne n° %d : %n %s %n", lineNumber, line);
             
        }
}
