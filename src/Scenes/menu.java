package Scenes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class menu {


    public static Scene menuDisplay(Stage app) {

        Scene menu;

        final Button addVolunteerBtn = new Button("Dodaj wolontariusza");
        final Button addCompanyBtn = new Button("Dodaj firme");
        final Button addBoxBtn = new Button("Dodaj puszek");
        final Button spendBoxBtn = new Button("Wydaj puszke");
        final Button HandOverTheBoxBtn = new Button("Zdaj puszke");
        final Button reportsBtn = new Button("Raporty");
        final Button logOutBtn = new Button("Wyloguj");
        final Button infoBtn = new Button("info");


        app.setTitle("Menu - Wolontariat");


        addVolunteerBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                app.setTitle("Dodaj wolontariusza");
                App.App.getPrimaryStage().setScene(addVolunteer.addVolunteer(app));
                app.setScene(addVolunteer.addVolunteer(app));
            }
        });
        addCompanyBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                app.setTitle("Dodaj firme");
                App.App.getPrimaryStage().setScene(addCompany.addCompany(app));
                app.setScene(addCompany.addCompany(app));
            }
        });
        addBoxBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                app.setTitle("Dodaj puszke");
                App.App.getPrimaryStage().setScene(addBox.addCollectionBox(app));
                app.setScene(addBox.addCollectionBox(app));
            }
        });
        spendBoxBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                app.setTitle("Wydaj puszke");
                App.App.getPrimaryStage().setScene(spendBox.spendBox(app));
                app.setScene(spendBox.spendBox(app));
            }
        });
        HandOverTheBoxBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                app.setTitle("Zdaj puszke");
                App.App.getPrimaryStage().setScene(HandOverTheBox.HandOverTheBox(app));
                app.setScene(HandOverTheBox.HandOverTheBox(app));
            }
        });
        reportsBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                app.setTitle("Raporty");
                App.App.getPrimaryStage().setScene(reportsMenu.reportsMenuDisplay(app));
                app.setScene(reportsMenu.reportsMenuDisplay(app));

            }
        });
        logOutBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {

                app.close();
            }
        });
        infoBtn.setOnAction(e -> Helpers.popAnnouncement.displayInfo());

        final VBox Start = new VBox(10.0D);
        Start.setAlignment(Pos.CENTER);
        Start.setPrefWidth(300.0D);
        addVolunteerBtn.setMinWidth(Start.getPrefWidth());
        addCompanyBtn.setMinWidth(Start.getPrefWidth());
        addBoxBtn.setMinWidth(Start.getPrefWidth());
        spendBoxBtn.setMinWidth(Start.getPrefWidth());
        HandOverTheBoxBtn.setMinWidth(Start.getPrefWidth());
        reportsBtn.setMinWidth(Start.getPrefWidth());
        logOutBtn.setMinWidth(Start.getPrefWidth());
        infoBtn.setMinWidth(Start.getPrefWidth());


        Start.getChildren().addAll(addVolunteerBtn, addCompanyBtn, addBoxBtn, spendBoxBtn, HandOverTheBoxBtn, reportsBtn, logOutBtn, infoBtn);

        menu = new Scene(Start, 650.0D, 450.0D);
        App.App.getPrimaryStage().setScene(addBox.addCollectionBox(app));
        app.setScene(addBox.addCollectionBox(app));



        return menu;
    }
}
