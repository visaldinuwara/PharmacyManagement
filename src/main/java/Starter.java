import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Starter extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        stage=new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("View/LoginPage.fxml"))));
        stage.show();
    }
}
