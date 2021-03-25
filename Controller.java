package sample;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class Controller {
    public TextField tenSV;
    public TextField email;
    public TextArea ds;
    public Text txtValidate;

    private ArrayList<String> danhSachSV = new ArrayList<>();

    public void submit(){
        String n =  tenSV.getText();
        String e = email.getText();
        if(!n.isEmpty() && !e.isEmpty()){
            danhSachSV.add(n+"--"+e);
            String txt  ="";
            for(String s:danhSachSV){
                txt += s+"\n";
            }
            tenSV.setText("");
            email.setText("");
            txtValidate.setText("");
            ds.setText(txt);
        }else {
            txtValidate.setText("Vui lòng nhập email và tên");
            txtValidate.setDisable(false);
        }

    }
}
