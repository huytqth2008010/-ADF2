package Asm.s3.editSV;

import Asm.s3.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import java.io.*;
import java.util.ArrayList;

public class Controller {
    public void update() {
    }
    public void studentList(){
    }
    public void home() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../home/home.fxml"));
        Asm.s3.Main.mainStage.setScene(new Scene(root, 600, 400));
        Main.mainStage.show();
    }
}
