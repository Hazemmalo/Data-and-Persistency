package Domainklasse;

public class Adres {
    private int adres_id;
    private String postcode;
    private String huisnummer;
    private String straat;
    private String woonplaats;
    private int reiziger_id;

    public Adres (int ad_id, String poc, String hnm, String st, String wp, int rz_id){
        adres_id = ad_id;
        postcode = poc;
        huisnummer = hnm;
        straat = st;
        woonplaats = wp;
        reiziger_id = rz_id;
    }

    public int getAdres_id() {
        return adres_id;
    }

    public void setAdres_id(int adres_id) {
        this.adres_id = adres_id;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getHuisnummer() {
        return huisnummer;
    }

    public void setHuisnummer(String huisnummer) {
        this.huisnummer = huisnummer;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public int getReiziger_id() {
        return reiziger_id;
    }

    public void setReiziger_id(int reiziger_id) {
        this.reiziger_id = reiziger_id;
    }

    public String toString() {
        return "Id:" + " " + adres_id + " " + "Straatnaam:" + " " + straat + " " + "Huisnummer:" + " " + huisnummer +
                " " + "Postcode:" + " " + postcode + " " + "Woonplaats:" + " " + woonplaats + " " + "Reizigerid:" + reiziger_id;
    }
}
