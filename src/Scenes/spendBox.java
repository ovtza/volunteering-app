package Scenes;

import Database.InsertRecords;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
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

public class spendBox {

    public static Scene spendBox(Stage app) {
        Scene spendBox;

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10.0D, 10.0D, 10.0D, 10.0D));
        grid.setVgap(8.0D);
        grid.setHgap(10.0D);
        grid.setAlignment(Pos.CENTER);
        Label numberLabel = new Label("Numer puszki:");
        GridPane.setConstraints(numberLabel, 0, 0);
        final TextField numberInput = new TextField();
        numberInput.setPromptText("Numer puszki");
        GridPane.setConstraints(numberInput, 1, 0);
        Label userLabel = new Label("Osoba wydajaca");
        GridPane.setConstraints(userLabel, 0, 1);
        final TextField userInput = new TextField();
        userInput.setPromptText("Osoba wydajaca");
        GridPane.setConstraints(userInput, 1, 1);
        Label timeLabel = new Label("Data i godzina:");
        GridPane.setConstraints(timeLabel, 0, 2);
        String time = (new SimpleDateFormat("dd.MM.yyyy HH:mm:ss")).format(Calendar.getInstance().getTime());
        Label timeInput = new Label(time);
        GridPane.setConstraints(timeInput, 1, 2);
        Button dodajButton = new Button("Dodaj");
        GridPane.setConstraints(dodajButton, 1, 3);
        Button btnmenu = new Button("Wroc do menu");
        GridPane.setConstraints(btnmenu, 0, 4);
        Button clear = new Button("Wyczysc pola");
        GridPane.setConstraints(clear, 0, 3);
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 4);
        btnmenu.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                actiontarget.setText("");
                numberInput.clear();
                userInput.clear();
                App.App.getPrimaryStage().setScene(menu.menuDisplay(app));
                app.setScene(menu.menuDisplay(app));
            }
        });
        clear.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                actiontarget.setText("");
                numberInput.clear();
                userInput.clear();
            }
        });
        dodajButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean result = Helpers.confirm.display("Potwierdzenie", "Czy jestes pewien?");
                if(result){
                    actiontarget.setFill(Color.GREEN);
                    actiontarget.setText("Dodano");
                    InsertRecords wydanePuszki = new InsertRecords();
                    wydanePuszki.insertSpendBox(numberInput.getText(), userInput.getText(), timeInput.getText());
                } else {
                    actiontarget.setFill(Color.RED);
                    actiontarget.setText("Anulowano");
                }
            }
        });
        grid.getChildren().addAll(numberLabel, numberInput, userLabel, userInput, timeLabel, timeInput, dodajButton, btnmenu, clear);
        spendBox = new Scene(grid, 650.0D, 450.0D);

        return spendBox;

    }
}
