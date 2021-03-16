package sample;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.ArrayList;

public class Controller {
    public TextField tenSV;
    public TextField Email;
    public TextArea ds;
    public Text txtValidate;
    private ArrayList<String> danhsachSv = new ArrayList<>();
    public void submit(){
        String name = tenSV.getText();
        String gmail = Email.getText();

        if (!name.isEmpty() && !name.isEmpty()){
            danhsachSv.add(name+"---"+gmail);
            String txt ="";
            for (String s:danhsachSv){
                txt += s+"\n";
            }
            tenSV.setText("");
            Email.setText("");
            txtValidate.setText("");
            ds.setText(txt);
        }else{
            txtValidate.setText("Vui long nhao nhap email va ten");
            txtValidate.setDisable(false);
        }

    }
}
