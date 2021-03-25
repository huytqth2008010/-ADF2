package managestudent.home;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import managestudent.Main;

public class Controller {
    public void danhsach() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../danhsach/dssv.fxml"));
        Main.mainStage.setScene(new Scene(root,600,400));
    }
    public void themSV() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../add/addSV.fxml"));
        Main.mainStage.setScene(new Scene(root,600,400));
    }
}
