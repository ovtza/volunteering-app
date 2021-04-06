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
            closeButton.setOnAction(e -> window.close());
            Label label1 = new Label();
            label1.setText("E-mail:");
            Hyperlink mail = new Hyperlink("szymon@owca.pro");
            Label label2 = new Label();
            label2.setText("Strona www:");
            Hyperlink www = new Hyperlink("https://owca.pro");
            Label label3 = new Label();
            label3.setText("Wersja 1.1");
            VBox layout = new VBox(10.0D);
            layout.getChildren().addAll(label1, mail, label2, www, label3, closeButton);
            layout.setAlignment(Pos.CENTER);
            Scene scene = new Scene(layout, 400.0D, 230.0D);
            window.setScene(scene);
            window.showAndWait();

    }


}
