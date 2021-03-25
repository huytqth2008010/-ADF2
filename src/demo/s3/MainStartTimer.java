package demo.s3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainStartTimer extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("time.fxml"));
        primaryStage.setTitle("Đồng hồ đếm giờ");
        primaryStage.setScene(new Scene(root, 600, 250));
        primaryStage.show();
    }
}
