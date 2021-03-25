package Asm.s2;

import demo.s4.Account;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TextField txtName;
    public TextField txtAge;
    public TextField txtMark;
    public Text txtValidate;
    public TableView<Student> txtRs;
    public TableColumn<Student,String> tenSV;
    public TableColumn<Student,Integer> tuoiSV;
    public TableColumn<Student,Integer> diemSV;
    public TableColumn<Student,Button> updateSV;
    public static Integer identity = 0;
    public static Student editSinhVien;
    ObservableList<Student> ds = FXCollections.observableArrayList();

    static boolean sortType = false;

    int index = -1;
    PreparedStatement pst = null;
    Connection conn = null;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tenSV.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
        tuoiSV.setCellValueFactory(new PropertyValueFactory<Student,Integer>("age"));
        diemSV.setCellValueFactory(new PropertyValueFactory<Student,Integer>("mark"));
        editable();
    }

    public void input(){
        try {
            String name =  txtName.getText();
            int age = Integer.parseInt(txtAge.getText());
            int mark = Integer.parseInt(txtMark.getText());
            if(!name.isEmpty()){
                Student s = new Student(name,age,mark);
                ds.add(s);
                txtValidate.setText("");
                txtName.setText("");
                txtAge.setText("");
                txtMark.setText("");
                txtRs.setItems(ds);
            }else {
                txtValidate.setText("Vui lòng nhập tên, tuổi và điểm thi");
                txtValidate.setDisable(false);
            }
        }catch (Exception e){
            txtValidate.setText("Vui lòng nhập tên, tuổi và điểm thi");
            txtValidate.setDisable(false);
        }
    }
    public void btnSort() {
        sortType = !sortType;
        if (sortType) {
            Collections.sort(ds, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return o1.getMark() - o2.getMark();
                }
            });
        } else {
            Collections.sort(ds, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return o2.getMark() - o1.getMark();
                }
            });
        }
        String txt = "";
        for (Student i : ds) {
            txt += i.getName() + "--" + i.getAge() + "--" + i.getMark() + "\n";
        }
    }
    public void editable(){
        tenSV.setCellFactory(TextFieldTableCell.forTableColumn());
        tenSV.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setName(e.getNewValue());
        });

        tuoiSV.setCellFactory(TextFieldTableCell.<Student, Integer>forTableColumn(new IntegerStringConverter()));
        tuoiSV.setOnEditCommit(e-> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setAge(e.getNewValue());
        });

        diemSV.setCellFactory(TextFieldTableCell.<Student, Integer>forTableColumn(new IntegerStringConverter()));
        diemSV.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setMark(e.getNewValue());
        });
        txtRs.setEditable(true);
    }


    //////// methode select users ///////

    public void getSelected(){
        index = txtRs.getSelectionModel().getSelectedIndex();
        if (index <= 1 ){
            return;
        }
        txtName.setText(tenSV.getCellData(index).toString());
        txtAge.setText(String.valueOf(tuoiSV.getCellData(index)));
        txtMark.setText(String.valueOf(diemSV.getCellData(index)));
    }
    public void btnEdit(){
        try {

            String name =  txtName.getText();
            int age = Integer.parseInt(txtAge.getText());
            int mark = Integer.parseInt(txtMark.getText());
            Student s = new Student(name,age,mark);

            ds.remove(index);
            txtRs.setEditable(ds.add(s));
            tenSV.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
            tuoiSV.setCellValueFactory(new PropertyValueFactory<Student,Integer>("age"));
            diemSV.setCellValueFactory(new PropertyValueFactory<Student,Integer>("mark"));
            txtRs.setItems(ds);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
