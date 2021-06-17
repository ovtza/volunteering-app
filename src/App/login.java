package App;

import Helpers.popAnnouncement;
import Scenes.menu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class login {

    public static void loginDisplay(Stage pStage) {

        GridPane logowanie = new GridPane();
        logowanie.setPadding(new Insets(10.0D, 10.0D, 10.0D, 10.0D));
        logowanie.setVgap(8.0D);
        logowanie.setHgap(10.0D);
        logowanie.setAlignment(Pos.CENTER);
        Label LoginLabel = new Label("Login:");
        GridPane.setConstraints(LoginLabel, 0, 0);
        final TextField LoginInput = new TextField();
        LoginInput.setPromptText("Login");
        GridPane.setConstraints(LoginInput, 1, 0);
        Label hasloLabel = new Label("Haslo:");
        GridPane.setConstraints(hasloLabel, 0, 1);
        final PasswordField hasloInput = new PasswordField();
        hasloInput.setPromptText("Haslo");
        GridPane.setConstraints(hasloInput, 1, 1);
        Button Zaloguj = new Button("Zaloguj sie");
        GridPane.setConstraints(Zaloguj, 1, 3);
        Button ja = new Button("Informacje");
        GridPane.setConstraints(ja, 0, 3);
        final Label action = new Label("");
        GridPane.setConstraints(action, 1, 4);
        ja.setOnAction(e -> Helpers.popAnnouncement.displayInfo());
        logowanie.getChildren().addAll(LoginLabel, LoginInput, hasloLabel, hasloInput, ja, Zaloguj, action);
        Scene ScenaGlowna = new Scene(logowanie, 650.0D, 450.0D);
        ScenaGlowna.getStylesheets().add("style.css");
        Stage app = new Stage();
        App.getPrimaryStage().setScene(ScenaGlowna);

        app.setScene(ScenaGlowna);
        app.setTitle("Wolontariat 1.1 - Menu");
        app.show();


        Zaloguj.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("Proba zalogowania");

                if (LoginInput.getText().equals("admin") && hasloInput.getText().equals("admin")) {
                    app.setScene(menu.menuDisplay(app));
                    System.out.println("Zalogowano");
                } else {
                    action.setTextFill(Color.RED);
                    action.setText("Zle dane!");
                }

            }
        });

    }


}
