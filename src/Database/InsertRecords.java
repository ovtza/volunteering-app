package Database;

import javax.xml.crypto.Data;
import java.sql.*;

public class InsertRecords {

    private Connection connect() {

        String url = "jdbc:sqlite:wolontariat-baza.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    public void insert(String name, double capacity) {
        String sql = "INSERT INTO employees(name, capacity) VALUES(?,?)";

        try{
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setDouble(2, capacity);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertVolunteer(String imie, String Nazwisko, String numer, String Adres, String DataMiejsce, String NrDow, String Kod, String NrUmowy){
        String sql = "INSERT INTO `wolontariusze`(`Imie`, `Nazwisko`, `Numer`, `Adres`, `DataMiejsce`, `NrDow`, `Kod`, `NumerUmowy`) VALUES (?,?,?,?,?,?,?,?)";

        try{
            Connection conn = this.connect();
            PreparedStatement v = conn.prepareStatement(sql);

            v.setString(1, imie);
            v.setString(2, Nazwisko);
            v.setString(3, numer);
            v.setString(4, Adres);
            v.setString(5, DataMiejsce);
            v.setString(6, NrDow);
            v.setString(7, Kod);
            v.setString(8, NrUmowy);

            v.executeUpdate();
            System.out.println("Dodano wolontariusza do bazy"  + "[" + imie + " " + Nazwisko + "]");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void insertCompany(String nazwa, String Reprezentant, String Kod){
        String sql = "INSERT INTO `firmy`(`Nazwa`, `Reprezentant`, `Kod`) VALUES (?, ?, ?)";

        try{
            Connection conn = this.connect();
            PreparedStatement v = conn.prepareStatement(sql);

            v.setString(1, nazwa);
            v.setString(2, Reprezentant);
            v.setString(3, Kod);


            v.executeUpdate();
            System.out.println("Dodano firme do bazy" + "[" + nazwa + "]");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void insertBox(String nazwa, String kod, String rodzaj){
        String sql = "INSERT INTO `puszki`(`Nazwa`, `Kod`, `Rodzaj`) VALUES (?, ?, ?)";
        try{
            Connection conn = this.connect();
            PreparedStatement v = conn.prepareStatement(sql);

            v.setString(1, nazwa);
            v.setString(2, kod);
            v.setString(3, rodzaj);


            v.executeUpdate();
            System.out.println("Dodano puszke do bazy" + "[" + nazwa + "]");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    public void insertSpendBox(String nazwa, String osobawydajaca, String data){
        String sql = "INSERT INTO `wydanepuszki`(`numer`, `OsobaWydajaca`, `Data`) VALUES (?, ?, ?)";
        try{
            Connection conn = this.connect();
            PreparedStatement v = conn.prepareStatement(sql);

            v.setString(1, nazwa);
            v.setString(2, osobawydajaca);
            v.setString(3, data);


            v.executeUpdate();
            System.out.println("Dodano puszke do bazy" + "[" + nazwa + "]");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    public void insertHandOverTheBox(String nazwa, String osobaodbierajaca, String data){
        String sql = "INSERT INTO zdanepuszki(`numer`, `OsobaOdbierajaca`, `Data`) VALUES (?, ?, ?)";
        try{
            Connection conn = this.connect();
            PreparedStatement v = conn.prepareStatement(sql);

            v.setString(1, nazwa);
            v.setString(2, osobaodbierajaca);
            v.setString(3, data);


            v.executeUpdate();
            System.out.println("Dodano puszke do bazy" + "[" + nazwa + "]");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    public static void main(String[] args) {

        InsertRecords app = new InsertRecords();

    }

}