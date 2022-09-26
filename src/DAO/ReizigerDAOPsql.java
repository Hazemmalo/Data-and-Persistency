package DAO;

import Domainklasse.Reiziger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReizigerDAOPsql implements ReizigerDAO {
    private Connection conn;

    public ReizigerDAOPsql(Connection conn) {
        this.conn = conn;

    }

    @Override
    public boolean save(Reiziger reiziger) {
        try {
            String query = "INSERT INTO reiziger (reiziger_id,voorletters,tussenvoegsel,achternaam,geboortedatum) VALUES (?,?,?,?,?);";
            PreparedStatement pst = conn.prepareStatement(query);

            pst.setInt(1, reiziger.getId());
            pst.setString(2, reiziger.getVoorletters());
            pst.setString(3, reiziger.getTussenvoegsel());
            pst.setString(4, reiziger.getAchternaam());
            pst.setDate(5, reiziger.getGeboortedatum());
            int row = pst.executeUpdate();

            if (row > 0 ) {
                System.out.println("(Reiziger is toegevoegd)");
            }
            pst.close();
            return true;

        } catch (Exception e) {
            System.out.println("(Reiziger is al toegevoegd)");
            return false;
        }


    }

    @Override
    public boolean update(Reiziger reiziger) {
        try {
            String query = "UPDATE reiziger SET reiziger_id = ?, tussenvoegsel = ?, achternaam = ?, geboortedatum = ? WHERE voorletters = ?";
            PreparedStatement pst = conn.prepareStatement(query);

            pst.setInt(1, reiziger.getReiziger_id());
            pst.setString(2, reiziger.getTussenvoegsel());
            pst.setString(3, reiziger.getAchternaam());
            pst.setDate(4, reiziger.getGeboortedatum());
            pst.setString(5, reiziger.getVoorletters());
            int row = pst.executeUpdate();

            if (row > 0) {
                System.out.println("(Reiziger is geupdate)");
            }
            pst.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean delete(Reiziger reiziger) {
        try {
            String query = "DELETE FROM reiziger WHERE voorletters = ?";
            PreparedStatement pst = conn.prepareStatement(query);

            pst.setString(1, reiziger.getVoorletters());
            int row = pst.executeUpdate();

            if (row > 0) {
                System.out.println("(Reiziger is verwijdert)");
            }
            pst.close();
            return true;

        } catch (Exception e) {
            System.out.println("(Reiziger is al verwijdert)");
            return false;
        }
    }

    @Override
    public Reiziger findById(int id) {
        try {
            String query = "SELECT * from reiziger WHERE reiziger_id = ?";
            PreparedStatement pst = conn.prepareStatement(query);

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                int identiteit = rs.getInt("reiziger_id");
                String voorlttrs = rs.getString("Voorletters");
                String tussenvsl = rs.getString("tussenvoegsel");
                String achternm = rs.getString("achternaam");
                Date gbdatum = rs.getDate("geboortedatum");

                System.out.println("Gegevens van reiziger met ID: " + id + "\n" + "Voorletters:" + voorlttrs + " " + "Tussenvoegsel:" +  " " + tussenvsl + "Achternaam:"
                        + achternm + " " +  "Geboortedatum:" + gbdatum);
            }
            pst.close();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    @Override
    public List<Reiziger> findByGbdatum(String datum) {
        try {
            String query = "SELECT * FROM reiziger WHERE geboortedatum = ?";
            PreparedStatement pst = conn.prepareStatement(query);

            pst.setDate(1, java.sql.Date.valueOf(datum));
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                int identiteit = rs.getInt("reiziger_id");
                String voorlttrs = rs.getString("Voorletters");
                String tussenvsl = rs.getString("tussenvoegsel");
                String achternm = rs.getString("achternaam");
                Date gbdatum = rs.getDate("geboortedatum");

                System.out.println("\n" + "Gegevens van reiziger met het volgende geboortedatum: " + gbdatum + "\n" + "Voorletters:" + voorlttrs + " " + "Tussenvoegsel:"
                        + tussenvsl + " " +  "Achternaam:" + achternm + " " + "Id:" + identiteit);

            }
            pst.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Reiziger> findAll() {
        try {
            String query = "SELECT * FROM reiziger";
            PreparedStatement pst = conn.prepareStatement(query);

            ResultSet rs = pst.executeQuery();
            List<Reiziger> reizigers = new ArrayList<Reiziger>();

            while (rs.next()){
                int identiteit = rs.getInt("reiziger_id");
                String voorlttrs = rs.getString("Voorletters");
                String tussenvsl = rs.getString("tussenvoegsel");
                String achternm = rs.getString("achternaam");
                Date gbdatum = rs.getDate("geboortedatum");
                Reiziger reiziger = new Reiziger(identiteit, voorlttrs, tussenvsl, achternm, (java.sql.Date) gbdatum);
                reizigers.add(reiziger);
            }
            pst.close();
            return reizigers;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


    }
}
