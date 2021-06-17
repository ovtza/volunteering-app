package Scenes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class reportsMenu {

    public static Scene reportsMenuDisplay(Stage app) {
        Scene reportsMenu;

        final Button FileOfBoxBtn = new Button("Kartoteka puszki");
        final Button FileOfVolunteerBtn = new Button("Kartoteka wolontariusza");
        final Button ReleaseReportBtn = new Button("Raport wydania");
        final Button SentenceReportBtn = new Button("Raport zdania");
        final Button goBackBtn = new Button("Wroc do menu");

        FileOfBoxBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                app.setTitle("Kartoteka puszki");
                App.App.getPrimaryStage().setScene(FileOfBox.FileOfBoxDisplay(app));
                app.setScene(FileOfBox.FileOfBoxDisplay(app));

            }
        });
        FileOfVolunteerBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                app.setTitle("Kartoteka wolontariusza");
                App.App.getPrimaryStage().setScene(FileOfVolunteer.FileOfVolunteerDisplay(app));
                app.setScene(FileOfVolunteer.FileOfVolunteerDisplay(app));

            }
        });
        ReleaseReportBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                app.setTitle("Raport wydania");
                App.App.getPrimaryStage().setScene(ReleaseReport.ReleaseReportDisplay(app));
                app.setScene(ReleaseReport.ReleaseReportDisplay(app));

            }
        });
        SentenceReportBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                app.setTitle("Raport zdania");
                App.App.getPrimaryStage().setScene(SentenceReport.SentenceReportDisplay(app));
                app.setScene(SentenceReport.SentenceReportDisplay(app));

            }
        });
        goBackBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                app.setTitle("Menu");
                App.App.getPrimaryStage().setScene(menu.menuDisplay(app));
                app.setScene(menu.menuDisplay(app));

            }
        });

        final VBox Start = new VBox(10.0D);

        Start.setAlignment(Pos.CENTER);
        Start.setPrefWidth(300.0D);
        FileOfBoxBtn.setMinWidth(Start.getPrefWidth());
        FileOfVolunteerBtn.setMinWidth(Start.getPrefWidth());
        ReleaseReportBtn.setMinWidth(Start.getPrefWidth());
        SentenceReportBtn.setMinWidth(Start.getPrefWidth());
        goBackBtn.setMinWidth(Start.getPrefWidth());



        Start.getChildren().addAll(FileOfBoxBtn, FileOfVolunteerBtn, ReleaseReportBtn, SentenceReportBtn, goBackBtn);

        reportsMenu = new Scene(Start, 650.0D, 450.0D);
        App.App.getPrimaryStage().setScene(addBox.addCollectionBox(app));
        app.setScene(addBox.addCollectionBox(app));


        return reportsMenu;
        }
    }


