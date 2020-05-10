/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gzip;

import entity.DateTraitement;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Alex
 */
@SessionScoped
@Named("moisPresentsDansBDD")
public class MoisPresentsDansBDD extends DateTraitement implements Serializable {

    TreeSet<Date> toutesLesDates = new TreeSet<>();
    TreeSet<String> dates = new TreeSet<>();

    public MoisPresentsDansBDD() {
    }

    public TreeSet<Date> getDatesEnDate() {
        return toutesLesDates;
    }

    public TreeSet<String> getDatesEnString() {
        return dates;
    }

    public void setToutesLesDates(TreeSet<Date> toutesLesDates) {
        this.toutesLesDates = toutesLesDates;
    }

    public void setDates(TreeSet<String> dates) {
        this.dates = dates;
    }

    public void setMoisPresent(List<DateTraitement> toutesLesDateTraitement) {
        TreeSet<Date> treeSet = new TreeSet<>();
        TreeSet<String> arrayList=new TreeSet<>();
                
        //Parcourir toutes les entités "date de traitemet" de la BDD
        for (DateTraitement d : toutesLesDateTraitement) {
            Date dateD = d.getFlxAnnMoi();
            //Vérifier que la date n'a pas déjà été prise en compte
            if (!treeSet.contains(dateD)) {
                //Ajouter la date à la liste
                treeSet.add(dateD);
                SimpleDateFormat formatter = new SimpleDateFormat("MMMM yyyy");
                String strDate = formatter.format(dateD);
                //Ajouter la date convertie à la liste
                arrayList.add(strDate);
            }
        }
        this.setDates(arrayList);
        this.setToutesLesDates(treeSet);        
    }

}
