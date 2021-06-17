package Helpers;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class popAnnouncement {


        public static void displayInfo() {
            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("Informacje");
            window.setMinWidth(250.0D);
            Button closeButton = new Button("Zamknij");
            Button wersja = new Button("Wersja");
            closeButton.setOnAction(e -> window.close());
            wersja.setOnAction(e -> create("Wersja aplikacji", "1.1"));
            Label label1 = new Label();
            label1.setText("E-mail:");
            Hyperlink mail = new Hyperlink("szymon@owca.pro");
            Label label2 = new Label();
            label2.setText("Strona www:");
            Hyperlink www = new Hyperlink("https://github.com/ovtza/volunteering-app");
            VBox layout = new VBox(10.0D);
            layout.getChildren().addAll(label1, mail, label2, www, wersja, closeButton);
            layout.setAlignment(Pos.CENTER);
            Scene scene = new Scene(layout, 400.0D, 230.0D);
            window.setScene(scene);
            window.showAndWait();

    }

        public static void create(String title, String text){
            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle(title);
            window.setMinWidth(250.0D);
            Button closeButton = new Button("Zamknij");

            closeButton.setOnAction(e -> window.close());

            Label label = new Label();
            label.setText(text);
            VBox layout = new VBox(10.0D);
            layout.getChildren().addAll(label, closeButton);
            layout.setAlignment(Pos.CENTER);
            Scene scene = new Scene(layout, 230.0D, 130.0D);
            window.setScene(scene);
            window.showAndWait();
        }


}
