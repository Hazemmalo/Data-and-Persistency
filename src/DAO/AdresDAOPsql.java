package DAO;

import Domainklasse.Adres;
import Domainklasse.Reiziger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdresDAOPsql implements AdresDAO {
    private Connection conn;

    public AdresDAOPsql(Connection conn) {
        this.conn = conn;
    }


    @Override
    public boolean save(Adres adres) {
        try {
            String query = "INSERT INTO adres (adres_id, postcode, huisnummer, straat, woonplaats, reiziger_id) VALUES (?,?,?,?,?,?;";
            PreparedStatement pst = conn.prepareStatement(query);

            pst.setInt(1, adres.getAdres_id());
            pst.setString(2, adres.getPostcode());
            pst.setString(3, adres.getHuisnummer());
            pst.setString(4, adres.getStraat());
            pst.setString(5, adres.getWoonplaats());
            pst.setInt(6, adres.getReiziger_id());
            int row = pst.executeUpdate();

            if (row > 0 ) {
                System.out.println("(Adres is toegevoegd)");
            }
            pst.close();
            return true;

        } catch (Exception e) {
            System.out.println("(Adres is al toegevoegd)");
            return false;
        }
    }

    @Override
    public boolean update(Adres adres) {
        try {
            String query = "UPDATE adres SET postcode = ?, huisnummer = ?, straat = ?, woonplaats = ?, reiziger_id = ? WHERE adres_id = ?";
            PreparedStatement pst = conn.prepareStatement(query);

            pst.setString(1, adres.getPostcode());
            pst.setString(2, adres.getHuisnummer());
            pst.setString(3, adres.getStraat());
            pst.setString(4, adres.getWoonplaats());
            pst.setInt(5, adres.getReiziger_id());
            pst.setInt(6, adres.getAdres_id());
            int row = pst.executeUpdate();

            if (row > 0) {
                System.out.println("(adres is geupdate)");
            }
            pst.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean delete(Adres adres) {
        try {
            String query = "DELETE FROM adres WHERE adres_id = ?";
            PreparedStatement pst = conn.prepareStatement(query);

            pst.setInt(1, adres.getAdres_id());
            int row = pst.executeUpdate();

            if (row > 0) {
                System.out.println("(Adres is verwijdert)");
            }
            pst.close();
            return true;

        } catch (Exception e) {
            System.out.println("(Adres is al verwijdert)");
            return false;
        }

    }

    @Override
    public Adres findByReiziger(Reiziger reiziger) {
        try {
            String query = "SELECT * from adres WHERE reiziger_id = ?";
            PreparedStatement pst = conn.prepareStatement(query);

            pst.setInt(1, reiziger.getId());
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                int adrid = rs.getInt("adres_id");
                String psc = rs.getString("postcode");
                String hnmr = rs.getString("huisnummer");
                String strt = rs.getString("straat");
                String wnps = rs.getString("woonplaats");
                int reizid = rs.getInt("reiziger_id");

                System.out.println("Gegevens van reiziger met ID: " + reizid + "\n" + "Adresid:" + adrid + " " + "Postcode:" +  psc + " " + "Huisnummer:"
                        + hnmr + " " +  "Straat:" + strt + " " + "Woonplaats:" + wnps);
            }
            pst.close();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }


    @Override
    public List<Adres> findAll() {
        try {
            String query = "SELECT * FROM adres";
            PreparedStatement pst = conn.prepareStatement(query);

            ResultSet rs = pst.executeQuery();
            List<Adres> adressen = new ArrayList<>();

            while (rs.next()){
                int adrid = rs.getInt("adres_id");
                String psc = rs.getString("postcode");
                String hnmr = rs.getString("huisnummer");
                String strt = rs.getString("straat");
                String wnps = rs.getString("woonplaats");
                int reizid = rs.getInt("reiziger_id");
                Adres adres = new Adres(adrid, psc, hnmr, strt, wnps, reizid);
                adressen.add(adres);
            }
            pst.close();
            return adressen;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
