package Asm.s3.student_list;

import Asm.s3.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;
import managestudent.model.Student;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TableView<Student> tbview;
    public TableColumn<Student,String> txtName;
    public TableColumn<Student,Integer> txtAge;
    public TableColumn<Student,Integer> txtMark;
    int index = -1;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtName.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
        txtAge.setCellValueFactory(new PropertyValueFactory<Student,Integer>("age"));
        txtMark.setCellValueFactory(new PropertyValueFactory<Student,Integer>("mark"));
        // Chỉnh sửa trực tiếp
        txtName.setCellFactory(TextFieldTableCell.forTableColumn());
        txtName.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setName(e.getNewValue());
        });

        txtAge.setCellFactory(TextFieldTableCell.<Student, Integer>forTableColumn(new IntegerStringConverter()));
        txtAge.setOnEditCommit(e-> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setAge(e.getNewValue());
        });

        txtMark.setCellFactory(TextFieldTableCell.<Student, Integer>forTableColumn(new IntegerStringConverter()));
        txtMark.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setMark(e.getNewValue());
        });
        tbview.setEditable(true);

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
    public void getSelected(){
        index = tbview.getSelectionModel().getSelectedIndex();
        if (index <= -1){
            return;
        }
        txtName.setText(txtName.getCellData(index).toString());
        txtAge.setText(String.valueOf(txtAge.getCellData(index)));
        txtMark.setText(String.valueOf(txtMark.getCellData(index)));
    }

    public void home() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../home/home.fxml"));
        Asm.s3.Main.mainStage.setScene(new Scene(root, 600, 400));
        Main.mainStage.show();
    }
    public void edit() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../editSV/editSV.fxml"));
        Asm.s3.Main.mainStage.setScene(new Scene(root, 600, 400));
        Main.mainStage.show();
    }


}
