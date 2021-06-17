package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

    public static void createAllTables() {
        String url = "jdbc:sqlite:wolontariat-baza.db";


        String wolontariuszeSQL = "CREATE TABLE IF NOT EXISTS wolontariusze ( id integer NOT NULL , `Imie` VARCHAR NOT NULL , `Nazwisko` VARCHAR NOT NULL , `Numer` INT NOT NULL , `Adres` VARCHAR NOT NULL , `DataMiejsce` TEXT NOT NULL , `NrDow` INT NOT NULL , `Kod` INT NOT NULL , `NumerUmowy` INT NOT NULL , PRIMARY KEY (`id`) ) ";
        String firmySQL = "CREATE TABLE IF NOT EXISTS  firmy ( `id` integer NOT NULL , `Nazwa` TEXT NOT NULL , `Reprezentant` TEXT NOT NULL , `Kod` INT NOT NULL , PRIMARY KEY (`id`))";
        String puszkiSQL = "CREATE TABLE IF NOT EXISTS  puszki( `id` integer NOT NULL , `nazwa` TEXT NOT NULL , `kod` INT NOT NULL , `rodzaj` TEXT NOT NULL, PRIMARY KEY (`id`))";
        String wydanePuszkiSQL = "CREATE TABLE IF NOT EXISTS wydanepuszki( `id` integer NOT NULL, `numer` INT NOT NULL , `OsobaWydajaca` TEXT NOT NULL , `Data` DATETIME NOT NULL , PRIMARY KEY (`id`))";
        String zdanePuszkiSQL = "CREATE TABLE IF NOT EXISTS zdanepuszki( `id` integer NOT NULL, `numer` INT NOT NULL , `OsobaOdbierajaca` TEXT NOT NULL , `Data` DATETIME NOT NULL , PRIMARY KEY (`id`))";

        try{
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.execute(wolontariuszeSQL);
            stmt.execute(firmySQL);
            stmt.execute(puszkiSQL);
            stmt.execute(wydanePuszkiSQL);
            stmt.execute(zdanePuszkiSQL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        createAllTables();
    }

}