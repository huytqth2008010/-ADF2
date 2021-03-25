package Asm.s3.home;

import Asm.s3.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Controller {
    public void screenDS() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../student_list/dssv.fxml"));
        Main.mainStage.setTitle("Danh sách sinh viên");
        Main.mainStage.setScene(new Scene(root, 600, 400));
        Main.mainStage.show();
    }
    public void screenAdd() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../addSV/addSV.fxml"));
        Main.mainStage.setTitle("Them sinh vien");
        Main.mainStage.setScene(new Scene(root, 600, 400));
        Main.mainStage.show();
    }
    public void screenEdit() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../editSV/editSV.fxml"));
        Main.mainStage.setTitle("Chinh sua sinh vien");
        Main.mainStage.setScene(new Scene(root, 600, 400));
        Main.mainStage.show();
    }
}
