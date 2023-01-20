package DAO;

import Domainklasse.Adres;
import Domainklasse.Reiziger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdresDAOPsql implements AdresDAO {
    private Connection conn;

    public AdresDAOPsql(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean save(Adres adres) {
        try {
            String query = "INSERT INTO adres (adres_id, postcode, huisnummer, straat, woonplaats, reiziger_id) VALUES (?,?,?,?,?,?);";
            PreparedStatement pst = conn.prepareStatement(query);

            pst.setInt(1, adres.getAdresId());
            pst.setString(2, adres.getPostcode());
            pst.setString(3, adres.getHuisnummer());
            pst.setString(4, adres.getStraat());
            pst.setString(5, adres.getWoonplaats());
            pst.setInt(6, adres.getReizigerId());
            pst.executeUpdate();

            pst.close();
            return true;

        } catch (SQLException e) {
            System.out.println("(Adres is toegevoegd)");
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
            pst.setInt(5, adres.getReizigerId());
            pst.setInt(6, adres.getAdresId());

            pst.executeUpdate();

            pst.close();
            return true;

        } catch (SQLException e) {
            System.out.println("(Adres is updated!)");
            return false;
        }
    }

    @Override
    public boolean delete(Adres adres) {
        try {
            String query = "DELETE FROM adres WHERE adres_id = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1,adres.getAdresId());

            pst.executeUpdate();
            pst.close();
            return true;

        }catch (SQLException e) {
            System.out.println("Adres is verwijderd!");
        }
        return false;
    }

    @Override
    public Adres findByReiziger(Reiziger reiziger) {
        try {
            String query = "SELECT * FROM adres WHERE reiziger_id = ?";

            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1,reiziger.getId());
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                int adrId = rs.getInt("adres_id");
                String poscd = rs.getString("postcode");
                String huisnm = rs.getString("huisnummer");
                String strt = rs.getString("straat");
                String wnpls = rs.getString("woonplaats");
                int reizId = rs.getInt("reiziger_id");

                System.out.println("Adres gegevens van reiziger met het volgend id: "+ reizId +  "\n"
                        + "Adresid:" + " " + adrId +  ",Postcode: "+ poscd +  ", Huisnummer:" + " " + huisnm  + ", Straat:" + " " + strt
                        + ", Woonplaats:" + " " + wnpls);
            }
            pst.close();

        }catch (SQLException e){
            e.printStackTrace();
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

            while (rs.next()) {
                int adrId = rs.getInt("adres_id");
                String pscd = rs.getString("postcode");
                String hnm = rs.getString("huisnummer");
                String strt = rs.getString("straat");
                String wnpls = rs.getString("woonplaats");
                int reizId = rs.getInt("reiziger_id");

                Adres adres = new Adres(adrId, pscd, hnm, strt, wnpls, reizId);
                adressen.add(adres);
            }
            pst.close();
            return adressen;



        }catch (SQLException e){
            e.printStackTrace();
            return null;

        }

    }
}

