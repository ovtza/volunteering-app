package App;

import Scenes.menu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    private static Stage pStage;


    @Override
    public void init() throws Exception {
        System.out.println("Start");
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
