package Domainklasse;

import java.sql.Date;

public class Reiziger {
    public int reiziger_id;
    public String voorletters;
    public String tussenvoegsel;
    public String achternaam;
    public Date geboortedatum;

    public Reiziger (int rz_id, String vl, String tv, String an, Date gd){
        reiziger_id = rz_id;
        voorletters = vl;
        tussenvoegsel = tv;
        achternaam = an;
        geboortedatum = gd;
    }

    public int getId() {return reiziger_id;}

    public String getNaam() {
        return voorletters + tussenvoegsel + achternaam;
    }

    public Date getGeboortedatum() {
        return geboortedatum;
    }

    public int getReiziger_id() {
        return reiziger_id;
    }

    public void setReiziger_id(int reiziger_id) {
        this.reiziger_id = reiziger_id;
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

    public void setGeboortedatum(Date geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public String toString() {
        return "Id:" + " " + reiziger_id + " " + "Voorletters:" + " " + voorletters + " " + "Tussenvoegsel:" + " " + tussenvoegsel +
                " " + "Achternaam:" + " " + achternaam + " " + "Geboortedatum:" + " " + geboortedatum;
    }
}
