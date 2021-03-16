package asm.s1;
import java.util.*;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Student{
    public TextField EnterName;
    public TextField EnterAge;
    public TextField EnterMark;
    public Text txtValidate;
    public TextArea ds;
    //Tạo mảng để lưu trữ SV
    public ArrayList<String> danhsachSv = new ArrayList<>();
    // Name column
    public void submit(){
        String name = EnterName.getText();
        String age = EnterAge.getText();
        String mark = EnterMark.getText();

        if (!name.isEmpty() && !name.isEmpty()){
            danhsachSv.add("Name: "+name+"   Age: "+age+"   Mark: "+mark);
            String txt ="";
            for (String s:danhsachSv){
                txt += s+"\n";
            }
            EnterName.setText("");
            EnterAge.setText("");
            EnterMark.setText("");
            txtValidate.setText("");
            ds.setText(txt);
        }else {
            txtValidate.setText("Vui lòng nhập đủ thông tin");
            txtValidate.setDisable(false);
        }
    }
    public void sapxep() {

    } 
}
