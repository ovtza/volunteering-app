package Scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class HandOverTheBox {
    public static Scene HandOverTheBox(Stage app){

        Scene HandOverTheBox;

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10.0D, 10.0D, 10.0D, 10.0D));
        grid.setVgap(8.0D);
        grid.setHgap(10.0D);
        grid.setAlignment(Pos.CENTER);
        Label nameLabel = new Label("Numer puszki:");
        GridPane.setConstraints(nameLabel, 0, 0);
        final TextField nameInput = new TextField();
        nameInput.setPromptText("Numer puszki");
        GridPane.setConstraints(nameInput, 1, 0);
        Label userLabel = new Label("Osoba odbieraj");
                GridPane.setConstraints(userLabel, 0, 1);
        final TextField userInput = new TextField();
        userInput.setPromptText("Osoba odbierajaca");
        GridPane.setConstraints(userInput, 1, 1);
        Label timeLabel = new Label("Data i godzina:");
        GridPane.setConstraints(timeLabel, 0, 2);
        String time2 = (new SimpleDateFormat("dd.MM.yyyy HH:mm:ss")).format(Calendar.getInstance().getTime());
        Label timeInput = new Label(time2);
        GridPane.setConstraints(timeInput, 1, 2);
        Button dodajButton = new Button("Dodaj");
        GridPane.setConstraints(dodajButton, 1, 3);
        Button btnmenu = new Button("Wroc do menu");
        GridPane.setConstraints(btnmenu, 0, 4);
        Button clear = new Button("Wyczysc pola");
        GridPane.setConstraints(clear, 0, 3);
        final Text actiontarget = new Text();
        GridPane.setConstraints(actiontarget, 1, 4);

        btnmenu.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                actiontarget.setText("");
                nameInput.clear();
                userInput.clear();
                App.App.getPrimaryStage().setScene(menu.menuDisplay(app));
                app.setScene(menu.menuDisplay(app));
            }
        });
        clear.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                actiontarget.setText("");
                nameInput.clear();
                userInput.clear();
            }
        });
        grid.getChildren().addAll(nameLabel, nameInput, userLabel, userInput, timeLabel, timeInput, dodajButton, btnmenu, actiontarget, clear);
        HandOverTheBox = new Scene(grid, 650.0D, 450.0D);
        return HandOverTheBox;
    }
}
