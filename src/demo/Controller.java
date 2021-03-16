package demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumnBase;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TableView<Student> table;

    @FXML
    private TableColumn<Student, String> nameColumn;

    @FXML
    private TableColumn<Student, Integer> ageColumn;

    @FXML
    private TableColumn<Student, Double> markColumn;

    private ObservableList<Student> studentList;

    @FXML
    private TextField nameText;

    @FXML
    private TextField ageText;

    @FXML
    private TextField markText;

    @FXML
    private AnchorPane ap;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        studentList = FXCollections.observableArrayList(
                new Student("Truong Quang Huy", 18, 10),
                new Student("Dao Minh Giang", 17, 4),
                new Student("Hoang Van Son", 15, 5)
        );
        nameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<Student, Integer>("age"));
        markColumn.setCellValueFactory(new PropertyValueFactory<Student, Double>("mark"));
        table.setItems(studentList);
    }

    public void add (ActionEvent e){
        Student newStudent = new Student();
        newStudent.setName(nameText.getText());
        newStudent.setAge(Integer.parseInt(ageText.getText()));
        newStudent.setMark(Integer.parseInt(markText.getText()));
        studentList.add(newStudent);
    }

    public void delete (ActionEvent e){
        Student selected = table.getSelectionModel().getSelectedItem();
        studentList.remove(selected);
    }
    public void sort(){
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getMark() < o2.getMark()) {
                    return o2.compareTo(o1);
                } else {
                   Collections.sort(studentList);
                   return o1.compareTo(o2);
                }
            }
        });
    }
}