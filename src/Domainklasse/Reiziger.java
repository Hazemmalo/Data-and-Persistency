package Domainklasse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reiziger {
    public int reizigerId;
    public String voorletters;
    public String tussenvoegsel;
    public String achternaam;
    public Date geboortedatum;

    private Adres adres;


    public Reiziger(int id_reiziger, String vrltrs, String tusvgsl, String achternm, Date gebdtm) {
        reizigerId = id_reiziger;
        voorletters = vrltrs;
        tussenvoegsel = tusvgsl;
        achternaam = achternm;
        geboortedatum = gebdtm;

    }

    public int getId() {
        return reizigerId;
    }

    public void setId(int id) {
        this.reizigerId = id;
    }

    public String getVoorletters() {
        return voorletters;
    }

    public void setVoorletters(String voorletters) {
        this.voorletters = voorletters;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public java.sql.Date getGeboortedatum() {return (java.sql.Date) geboortedatum ;}

    public void setGeboortedatum(Date geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public String toString(){
        String s = "Id:" + " " + reizigerId + " " + "Voorletters:" + " " + voorletters + " " + "Tussenvoegsel:" + " " + tussenvoegsel +
                " " + "Achternaam:" + " " + achternaam + " " + "Geboortedatum:" + " " + geboortedatum;
        return s;
    }
}