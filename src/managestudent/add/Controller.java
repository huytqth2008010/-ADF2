package managestudent.add;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import managestudent.Main;

import java.io.*;
import java.util.ArrayList;

public class Controller{
    public TextField txtName;
    public TextField txtAge;
    public TextField txtMark;


    public void input(){
        try {
            // lấy sinh viên từ sudent
            FileInputStream fis = new FileInputStream("student.bin");
            DataInputStream dis = new DataInputStream(fis);
            String  txt = dis.readLine();
            ArrayList<String> arr= new ArrayList<>();
            while (txt!=null){
                arr.add(txt);
                txt = dis.readLine();
            }


            FileOutputStream sos = new FileOutputStream("student.bin");
            DataOutputStream dos = new DataOutputStream(sos);
            dos.writeBytes(txtName.getText()+"\n");
            dos.writeBytes(txtAge.getText()+"\n");
            dos.writeBytes(txtMark.getText()+"\n");
            for (String s:arr){
                dos.writeBytes(s+"\n");
            }
            txtName.setText("");
            txtAge.setText("");
            txtMark.setText("");

        }catch (FileNotFoundException f){
            System.out.println("File not found");
        }catch (IOException io){
            System.out.println("File orror");
        }
    }
    public void home() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../home/home.fxml"));
        Main.mainStage.setScene(new Scene(root,600,400));
    }
}
