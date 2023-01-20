package Domainklasse;

public class Adres {
    private int adresId;
    private String postcode;
    private String huisnummer;
    private String straat;
    private String woonplaats;
    private int reizigerId;


    public Adres(int id_adres, String pscd, String hnm, String str, String wnpl, int id_reiziger){
        adresId = id_adres;
        postcode = pscd;
        huisnummer = hnm;
        straat = str;
        woonplaats = wnpl;
        reizigerId = id_reiziger;
    }

    public int getAdresId() {
        return adresId;
    }

    public void setAdresId(int adresId) {
        this.adresId = adresId;
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

    public int getReizigerId() {
        return reizigerId;
    }

    public void setReizigerId(int reizigerId) {
        this.reizigerId = reizigerId;
    }

    public String toString(){
        String s = "Adresid: " + adresId + ", Postcode: " + postcode + ", Huisnummer: " + huisnummer +
                ", Straat: " + straat + ", Woonplaats: " + woonplaats + ", ReizigerId: " + reizigerId;
        return s;
    }
}
