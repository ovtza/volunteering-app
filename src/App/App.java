package App;

import DocumentHandle.GeneratePDF;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    private static Stage pStage;


    @Override
    public void init() throws Exception {
        System.out.println("Start");
        Database.Create.createNewDatabase("wolontariat-baza.db");
        Database.CreateTable.createAllTables();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        setPrimaryStage(primaryStage);
        pStage = primaryStage;
       // primaryStage.setScene();
        login.loginDisplay(pStage);

    }

    @Override
    public void stop() throws Exception {
        System.out.println("Koniec");
    }

    public static Stage getPrimaryStage() {
        return pStage;
    }

    public static void setPrimaryStage(Stage pStage) {
        App.pStage = pStage;
    }
}
