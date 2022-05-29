import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage menuStage) throws Exception{
        Label label = new Label("WORDLE-EX");
        BorderPane pane = new BorderPane(label);

        Scene scene = new Scene(pane, 1080,720);

        menuStage.setScene(scene);
        menuStage.setTitle("WORDLE-EX");
        menuStage.show();
    }
}
