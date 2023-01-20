package P1;

import java.sql.*;

public class Main {
    public static void main(String [] args){
        // verbind maken met database bedrijf
        String PGurl = "jdbc:postgresql://localhost/ovchip?user=postgres&password=H.azem123";

        try {
            Connection conn = DriverManager.getConnection(PGurl);

            // Voer een query  uit
            Statement st = conn.createStatement();
            String query = "SELECT achternaam, geboortedatum from reiziger  ";


            ResultSet rs = st.executeQuery(query);

            String achternaam;
            Date geboorteDatum;


            while (rs.next()) {
                achternaam = rs.getString("achternaam");
                geboorteDatum = rs.getDate("geboortedatum");

                System.out.println("Domainklasse.Reiziger achternaam:" + achternaam);
                System.out.println("Domainklasse.Reiziger Geboortedatum:" + geboorteDatum);

//                rs.close();
//                st.close();
//                conn.close();
            }
        } catch (SQLException sqlex) {
            System.err.println("[SQLException] 'Het ophalen van data is niet gelukt!'" + sqlex.getMessage());
        }

    }
}
