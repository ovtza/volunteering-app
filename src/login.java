import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class login {

    public static void loginDisplay(){

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
        ja.setOnAction(e -> popAnnouncement.displayInfo());
        logowanie.getChildren().addAll(LoginLabel, LoginInput, hasloLabel, hasloInput, ja, Zaloguj);
        Scene ScenaGlowna = new Scene(logowanie, 650.0D, 450.0D);
        Stage login = new Stage();
        login.setScene(ScenaGlowna);
        login.setTitle("Wolontariat 1.1");
        login.show();
    }



}
