package Domainklasse;

import DAO.AdresDAO;
import DAO.AdresDAOPsql;
import DAO.ReizigerDAO;
import DAO.ReizigerDAOPsql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    private static Connection connection;


    public static void main(String[] args) throws SQLException {
        getConnection();
        ReizigerDAOPsql rado = new ReizigerDAOPsql(connection);
        testReizigerDAO(rado);

        AdresDAOPsql adao = new AdresDAOPsql(connection);
        testAdresDAO(adao);
    }

    public static void getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost/ovchip?user=postgres&password=H.azem123";
        connection = DriverManager.getConnection(url);
    }

    public static void closeConnection() throws SQLException {
        connection.close();
    }

    private static void testReizigerDAO(ReizigerDAO rdao) throws SQLException {
        System.out.println("\n---------- Test ReizigerDAO -------------");

        // Haal alle reizigers op uit de database
        List<Reiziger> reizigers = rdao.findAll();
        System.out.println("[Test] ReizigerDAO.findAll() geeft de volgende reizigers:");
        for (Reiziger r : reizigers) {
            System.out.println(r);
        }
        System.out.println();

        //SAVE
        String gbdatum = "1981-03-14";
        Reiziger sietske = new Reiziger(77, "S", "", "Boers", java.sql.Date.valueOf(gbdatum));
        System.out.print("[Test] Eerst " + reizigers.size() + " reizigers, na ReizigerDAO.save() ");
        rdao.save(sietske);
        reizigers = rdao.findAll();
        System.out.println(reizigers.size() + " reizigers\n");


        //DELETE
        //Voorletters moeten hetzelfde zijn bij deze Method!
        System.out.print("[Test] Eerst " + reizigers.size() + " reizigers, na ReizigerDAO.delete() ");
        rdao.delete(sietske);
        reizigers = rdao.findAll();
        System.out.println(reizigers.size() + " reizigers\n");

        //UPDATE
        //Voorletters moeten hetzelfde zijn bij deze Method!
        System.out.print("[Test] ");
        rdao.findById(3);
        System.out.println("Is na ReizigerDAO.update(), geupdate naar");
        String gbdatumLubben = "2001-01-01";
        Reiziger Lubben = new Reiziger(3, "H", "Van", "Persie", Date.valueOf(gbdatumLubben));
        rdao.update(Lubben);

//      FINDBYID
        System.out.println("\n[TEST]");
        rdao.findById(1);

        //FINDBYGEBOORTEDATUM
        System.out.println("\n[TEST]");
        String geboortedt = "2002-10-22";
        rdao.findByGbdatum(geboortedt);
    }


    private static void testAdresDAO(AdresDAO adao) throws SQLException {
        System.out.println("\n---------- Test AdresDAO -------------");

        //FINDALL METHOD/OPHALEN ALLE REIZIGERS
        List<Adres> adressen = adao.findAll();
        System.out.println("[Test] AdresDAO.findAll() geeft de volgende adressen:");
        for (Adres a : adressen) {
            System.out.println(a);
        }
        System.out.println();

        //SAVE
        Adres adres1 = new Adres(8,"3554BV","82","C.Roobolstraat","Utrecht",7);
        System.out.print("[Test] Eerst " + adressen.size() + " adressen, na AdresDAO.save()");
        adao.save(adres1);
        adressen = adao.findAll();
        System.out.println(adressen.size() + " adressen\n");


        //DELETE
        //Voorletters moeten hetzelfde zijn bij deze Method!
        System.out.print("[Test] Eerst " + adressen.size() + " adressen, na AdresDAO.delete() ");
        adao.delete(adres1);
        adressen = adao.findAll();
        System.out.println(adressen.size() + " adressen\n");

        //UPDATE
        //AdresId moeten hetzelfde zijn bij deze Method!
        System.out.print("[Test] ");
        System.out.println("De ingevulde reiziger is na AdresDAO.update(), geupdate naar");
        Adres Visscherplein = new Adres(1,"3511LX","36","Visscherplein","Utrecht",1);
        adao.update(Visscherplein);

        //FIND ADRES BY REIZIGER
        System.out.println("\n[TEST]");
        String gd = "2002-09-17";
        Reiziger Rijn1 = new Reiziger(1, "G", "van", "Rijn", java.sql.Date.valueOf(gd));
        adao.findByReiziger(Rijn1);


    }



}
