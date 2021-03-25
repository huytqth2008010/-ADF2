package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Controller {
    public void screenDS() throws Exception{
//        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("asm1.fxml"));
        Main.mainStage.setTitle("Danh sách sinh viên");
        Main.mainStage.setScene(new Scene(root, 600, 700));
        Main.mainStage.show();
    }
    public void addSV() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("themSV.fxml"));
        Main.mainStage.setTitle("Danh sách sinh viên");
        Main.mainStage.setScene(new Scene(root, 600, 700));
        Main.mainStage.show();
    }
    public void black() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Main.mainStage.setTitle("Danh sách sinh viên");
        Main.mainStage.setScene(new Scene(root, 600, 700));
        Main.mainStage.show();
    }
    public void commit() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("asm1.fxml"));
        Main.mainStage.setTitle("Danh sách sinh viên");
        Main.mainStage.setScene(new Scene(root, 600, 700));
        Main.mainStage.show();
    }
}
