package Scenes;

import Database.InsertRecords;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class addBox {






    public static Scene addCollectionBox(Stage app) {
        Scene add;

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10.0D, 10.0D, 10.0D, 10.0D));
        grid.setVgap(8.0D);
        grid.setHgap(10.0D);
        grid.setAlignment(Pos.CENTER);
        Label nameLabel = new Label("Numer puszki:");
        GridPane.setConstraints(nameLabel, 0, 0);
        final TextField nameInput = new TextField();
        nameInput.setPromptText("Numer puszki:");
        GridPane.setConstraints(nameInput, 1, 0);
        Label codeLabel = new Label("Kod puszki:");
        GridPane.setConstraints(codeLabel, 0, 1);
        final TextField codeInput = new TextField();
        codeInput.setPromptText("Kod puszki");
        GridPane.setConstraints(codeInput, 1, 1);
        Label typeLabel = new Label("Rodzaj puszki:");
        GridPane.setConstraints(typeLabel, 0, 2);
        final ComboBox<String> BoxType = new ComboBox<>();
        BoxType.getItems().add("Metalowa");
        BoxType.getItems().add("Tekturowa");
        GridPane.setConstraints(BoxType, 1, 2);
        Button dodajButton = new Button("Dodaj");
        GridPane.setConstraints(dodajButton, 1, 3);
        Button clear = new Button("Wyczysc pola");
        GridPane.setConstraints(clear, 0, 3);
        Button btnmenu = new Button("Wroc do menu");
        GridPane.setConstraints(btnmenu, 0, 4);
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 4);
        btnmenu.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                actiontarget.setText("");
                nameInput.clear();
                codeInput.clear();
                App.App.getPrimaryStage().setScene(menu.menuDisplay(app));

                app.setScene(menu.menuDisplay(app));
            }
        });
        clear.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                actiontarget.setText("");
                nameInput.clear();
                codeInput.clear();
            }
        });
        dodajButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean result = Helpers.confirm.display("Potwierdzenie", "Czy jestes pewien?");
                if(result){
                    actiontarget.setFill(Color.GREEN);
                    actiontarget.setText("Dodano");
                    InsertRecords puszka = new InsertRecords();
                    puszka.insertBox(nameInput.getText(), codeInput.getText(), BoxType.getSelectionModel().getSelectedItem());
                } else {
                    actiontarget.setFill(Color.RED);
                    actiontarget.setText("Anulowano");
                }
            }
        });
        grid.getChildren().addAll(nameLabel, nameInput, codeLabel, codeInput, typeLabel, BoxType, dodajButton, btnmenu, clear);
        add = new Scene(grid, 650.0D, 450.0D);

        
        return add;


    }
}
