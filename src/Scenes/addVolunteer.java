package Scenes;

import Database.InsertRecords;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class addVolunteer {

    public static Scene addVolunteer(Stage app) {
        Scene addVolunteer;

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10.0D, 10.0D, 10.0D, 10.0D));
        grid.setVgap(8.0D);
        grid.setHgap(10.0D);
        grid.setAlignment(Pos.CENTER);
        Label nameLabel = new Label("Imie:");
        GridPane.setConstraints(nameLabel, 0, 0);
        final TextField nameInput = new TextField();
        nameInput.setPromptText("Imie");
        GridPane.setConstraints(nameInput, 1, 0);
        Label surnameLabel = new Label("Nazwisko:");
        GridPane.setConstraints(surnameLabel, 0, 1);
        final TextField surnameInput = new TextField();
        surnameInput.setPromptText("Nazwisko");
        GridPane.setConstraints(surnameInput, 1, 1);
        Label numerLabel = new Label("Numer:");
        GridPane.setConstraints(numerLabel, 0, 2);
        final TextField numerInput = new TextField();
        numerInput.setPromptText("Numer");
        GridPane.setConstraints(numerInput, 1, 2);
        Label adresLabel = new Label("Adres zamieszkania:");
        GridPane.setConstraints(adresLabel, 0, 3);
        final TextField adresInput = new TextField();
        adresInput.setPromptText("Adres zamieszkania");
        GridPane.setConstraints(adresInput, 1, 3);
        Label dataLabel = new Label("Data i miejsce urodzenia:");
        GridPane.setConstraints(dataLabel, 0, 4);
        final TextField dataInput = new TextField();
        dataInput.setPromptText("Data i miejsce urodzenia");
        GridPane.setConstraints(dataInput, 1, 4);
        Label nrLabel = new Label("Nr i seria dowodu osobistego:");
        GridPane.setConstraints(nrLabel, 0, 5);
        final TextField nrInput = new TextField();
        nrInput.setPromptText("Nr i seria dowodu osobistego");
        GridPane.setConstraints(nrInput, 1, 5);
        Label kodLabel = new Label("Kod:");
        GridPane.setConstraints(kodLabel, 0, 6);
        final TextField kodInput = new TextField();
        kodInput.setPromptText("Kod");
        GridPane.setConstraints(kodInput, 1, 6);
        Label nruLabel = new Label("Numer umowy:");
        GridPane.setConstraints(nruLabel, 0, 7);
        final TextField nruInput = new TextField();
        nruInput.setPromptText("Numer umowy");
        GridPane.setConstraints(nruInput, 1, 7);
        Button btnmenu = new Button("Wroc do menu");
        GridPane.setConstraints(btnmenu, 0, 9);
        Button clear = new Button("Wyczysc pola");
        GridPane.setConstraints(clear, 0, 8);
        Button dodajButton = new Button("Dodaj");
        GridPane.setConstraints(dodajButton, 1, 8);
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 9);
        btnmenu.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                actiontarget.setText("");
                nameInput.clear();
                surnameInput.clear();
                numerInput.clear();
                adresInput.clear();
                dataInput.clear();
                nrInput.clear();
                kodInput.clear();
                nruInput.clear();
                App.App.getPrimaryStage().setScene(menu.menuDisplay(app));
                app.setScene(menu.menuDisplay(app));
            }
        });
        clear.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                actiontarget.setText("");
                nameInput.clear();
                surnameInput.clear();
                numerInput.clear();
                adresInput.clear();
                dataInput.clear();
                nrInput.clear();
                kodInput.clear();
                nruInput.clear();
            }
        });

        dodajButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean result = Helpers.confirm.display("Potwierdzenie", "Czy jestes pewien?");
                if(result){
                    actiontarget.setFill(Color.GREEN);
                    actiontarget.setText("Dodano");
                    InsertRecords wolontariusz = new InsertRecords();
                    wolontariusz.insertVolunteer(nameInput.getText(), surnameInput.getText(), numerInput.getText(), adresInput.getText(), dataInput.getText(), nrInput.getText(),kodInput.getText(),nruInput.getText());
                } else {
                    actiontarget.setFill(Color.RED);
                    actiontarget.setText("Anulowano");
                }
            }
        });
        grid.getChildren().addAll(
                nameLabel, nameInput, surnameLabel, surnameInput, numerLabel, numerInput, adresLabel, adresInput, dataLabel, dataInput,
                nrLabel, nrInput, kodLabel, kodInput, nruLabel, nruInput, dodajButton, btnmenu, clear);
        addVolunteer = new Scene(grid, 650.0D, 450.0D);


        return addVolunteer;
    }

}
