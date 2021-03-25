package demo.s3;

import javafx.application.Platform;
import javafx.scene.text.Text;


public class StartTimer{
    public Text txtMin;
    public Text txtSec;

    public Integer min =0;
    public Integer sec =30;

    public void startTimer(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (min>=0){
                    while (sec>=0){
                        try {
                            txtMin.setText(min.toString());
                            txtSec.setText(sec.toString());
                            sec --;
                            if (sec<0){
                                sec =59;
                                min--;
                            }
                        }catch (Exception e){}
                    }
                }
                try {
                    Thread.sleep(3000);
                    Platform.exit();
                }catch (Exception e){}
            }
        }).start();
    }
}
