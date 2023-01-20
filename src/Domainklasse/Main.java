package Domainklasse;

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
        ReizigerDAOPsql rdao = new ReizigerDAOPsql(connection);
        testReizigerDAO(rdao);

        AdresDAOPsql adao = new AdresDAOPsql(connection);
        testAdresDao(adao);

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
        rdao.findById(4);
        System.out.println("Is na ReizigerDAO.update(), geupdate naar");
        String gbdatumMemari = "2000-01-01";
        Reiziger Memari = new Reiziger(4, "F", "", "Memari", Date.valueOf(gbdatumMemari));
        rdao.update(Memari);

//      FINDBYID
        System.out.println("\n[TEST]");
        rdao.findById(5);

        //FINDBYGEBOORTEDATUM
        System.out.println("\n[TEST]");
        String gebdatum = "2002-12-03";
        rdao.findByGbdatum(gebdatum);
    }


    private static void testAdresDao(AdresDAOPsql adao) throws SQLException {
        System.out.println("\n---------- Test AdresDAO -------------");

        // ALLE ADRESSEN OPHALEN, FINDALL METHOD
        List<Adres> adressen = adao.findAll();

        System.out.println("[Test] ReizigerDAO.findAll() geeft de volgende adressen:");
        for (Adres a : adressen) {
            System.out.println(a);
        }
        System.out.println();

        //SAVE
        Adres adres1 = new Adres(6, "3765CP", "521", "Smitsweg", "Soest",7);
        System.out.print("[Test] Eerst " + adressen.size() + " reizigers, na AdresDAO.save() ");
        adao.save(adres1);
        adressen = adao.findAll();
        System.out.println(adressen.size() + " adressen\n");

        //DELETE
        System.out.print("[Test] Eerst " + adressen.size() + " adressen, na AdresDAO.delete() ");
        adao.delete(adres1);
        adressen = adao.findAll();
        System.out.println(adressen.size() + " adressen\n");

        //UPDATE
        System.out.print("[Test] ");
        System.out.println("Is na AdresDAO.update(), geupdate naar");
        Adres jaarbeursplein = new Adres(2, "3521AL", "6", "Jaarbeursplein", "Utrecht", 2);
        adao.update(jaarbeursplein);

        //FINDBY_REIZIGER
        System.out.println("\n[TEST]");
        String gedt = "1998-08-11";
        Reiziger lubben = new Reiziger(3, "H", " ", "Lubben", Date.valueOf(gedt));
        adao.findByReiziger(lubben);
















    }

}
