package Scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FileOfVolunteer {

    public static Scene FileOfVolunteerDisplay(Stage app) {
        Scene FileOfVolunteer;

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10.0D, 10.0D, 10.0D, 10.0D));
        grid.setVgap(8.0D);
        grid.setHgap(10.0D);
        grid.setAlignment(Pos.CENTER);
        Label numerdrukLabel = new Label("Wyszukaj wolontariusza:");
        GridPane.setConstraints(numerdrukLabel, 0, 0);
        TextField numerdrukInput = new TextField();
        numerdrukInput.setPromptText("Kod");
        GridPane.setConstraints(numerdrukInput, 1, 0);
        Button drukuj = new Button("Pokaz raport");
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 2);
        drukuj.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                File f = new File("Raporty");
                if (f.exists() && f.isDirectory()) {

                    actiontarget.setText("");
                } else {
                    actiontarget.setFill(Color.RED);
                    actiontarget.setText("Brak danych!");
                }
            }
        });
        GridPane.setConstraints(drukuj, 0, 1);
        String time = (new SimpleDateFormat("dd.MM.yyyy HH:mm:ss")).format(Calendar.getInstance().getTime());
        Label timeInput = new Label(time);
        GridPane.setConstraints(timeInput, 1, 1);
        Button btnmenu = new Button("Wroc");
        btnmenu.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                app.setTitle("Raporty");
                App.App.getPrimaryStage().setScene(reportsMenu.reportsMenuDisplay(app));
                app.setScene(reportsMenu.reportsMenuDisplay(app));
                actiontarget.setText("");
            }
        });
        GridPane.setConstraints(btnmenu, 0, 2);

        grid.getChildren().addAll(numerdrukLabel, numerdrukInput, drukuj, timeInput, btnmenu);
        FileOfVolunteer = new Scene(grid, 650.0D, 450.0D);
        return FileOfVolunteer;
    }
}
