import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void init() throws Exception {
        System.out.println("Start");
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Aplikacja");
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Koniec");
    }
}
