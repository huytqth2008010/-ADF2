package managestudent.danhsach;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import managestudent.Main;
import managestudent.model.Student;

import javax.sound.sampled.Line;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TableView<Student> tbview;
    public TableColumn<Student,String> txtName;
    public TableColumn<Student,Integer> txtAge;
    public TableColumn<Student,Integer> txtMark;

    public void home() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../home/home.fxml"));
        Main.mainStage.setScene(new Scene(root,600,400));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtName.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
        txtAge.setCellValueFactory(new PropertyValueFactory<Student,Integer>("age"));
        txtMark.setCellValueFactory(new PropertyValueFactory<Student,Integer>("mark"));

        ObservableList<Student> ds = FXCollections.observableArrayList();
        //Lay sinh vien tu file  student.bin fr nap vao danh sach
   try {
       FileInputStream fis = new FileInputStream("student.bin");
       DataInputStream dis = new DataInputStream(fis);
       int line = 0;
       String  txt = dis.readLine();
       String[] str = new String[3];
       while (txt!=null){
           str[line] = txt;
           line++;
           txt = dis.readLine();
           if (line >=3){
               Student sv = new Student(str[0],Integer.parseInt(str[1]),Integer.parseInt(str[2]));
               ds.add(sv);
               line=0;
           }
       }
       tbview.setItems(ds);
   }catch (IOException f){
       System.out.println("error");
   }
    }
}
