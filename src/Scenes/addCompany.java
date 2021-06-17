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

public class addCompany {

    public static Scene addCompany(Stage app) {
        Scene addCompany;
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10.0D, 10.0D, 10.0D, 10.0D));
        grid.setVgap(8.0D);
        grid.setHgap(10.0D);
        grid.setAlignment(Pos.CENTER);
        Label nameLabel = new Label("Nazwa firmy:");
        GridPane.setConstraints(nameLabel, 0, 0);
        final TextField nameInput = new TextField();
        nameInput.setPromptText("Nazwa firmy");
        GridPane.setConstraints(nameInput, 1, 0);
        Label PersonLabel = new Label("Osoba reprezentujaca firme");
        GridPane.setConstraints(PersonLabel, 0, 1);
        final TextField PersonInput = new TextField();
        PersonInput.setPromptText("Dane osoby");
        GridPane.setConstraints(PersonInput, 1, 1);
        Label kodLabel = new Label("Kod:");
        GridPane.setConstraints(kodLabel, 0, 2);
        final TextField kodInput = new TextField();
        kodInput.setPromptText("Kod");
        GridPane.setConstraints(kodInput, 1, 2);
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
                nameInput.clear();
                PersonInput.clear();
                kodInput.clear();
                App.App.getPrimaryStage().setScene(menu.menuDisplay(app));
                app.setScene(menu.menuDisplay(app));
            }
        });
        clear.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                actiontarget.setText("");
                nameInput.clear();
                PersonInput.clear();
                kodInput.clear();
            }
        });
        dodajButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean result = Helpers.confirm.display("Potwierdzenie", "Czy jestes pewien?");
                if(result){
                    actiontarget.setFill(Color.GREEN);
                    actiontarget.setText("Dodano");
                    InsertRecords firma = new InsertRecords();
                    firma.insertCompany(nameInput.getText(), PersonInput.getText(), kodInput.getText());
                     } else {
                    actiontarget.setFill(Color.RED);
                    actiontarget.setText("Anulowano");
                }
            }
        });
        grid.getChildren().addAll(nameLabel, nameInput, PersonLabel, PersonInput, kodLabel, kodInput, dodajButton, btnmenu, clear);
        addCompany = new Scene(grid, 650.0D, 450.0D);

        return addCompany;
    }


}
