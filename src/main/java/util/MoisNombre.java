/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author ulyss
 */
public class MoisNombre {
    
    public static String monthToNumber(String mois) {
        String result = "";
        //Convertir le mois en toutes lettres en mois en nombre
        switch(mois) {
            case "Janvier" :
                result = "01";
                break;
            case "Février" :
                result = "02";
                break;
            case "Mars" :
                result = "03";
                break;
            case "Avril" :
                result = "04";
                break;
            case "Mai" :
                result = "05";
                break;
            case "Juin" :
                result = "06";
                break;
            case "Juillet" :
                result = "07";
                break;
            case "Août" :
                result = "08";
                break;
            case "Septembre" :
                result = "09";
                break;
            case "Octobre" :
                result = "10";
                break;
            case "Novembre" :
                result = "11";
                break;
            case "Décembre" :
                result = "12";
                break;
            case "null" :
                result = "";
                break;
        }
        return result;
    }
}
