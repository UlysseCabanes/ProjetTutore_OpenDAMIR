/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gzip;

import java.io.IOException;

/**
 *
 * @author Alex
 */
public class Main {
    //10001 premieres lignes
    private static final String DAMIR_201812_SMALL = "https://mycore.core-cloud.net/index.php/s/j9DEDyt2w6FTx6P/download";

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, Exception {
      
        int[] colonnes = {0,5,8,42};
        Gzip downloader=new Gzip();
        downloader.readGzipURL(DAMIR_201812_SMALL, colonnes);
    }
}
