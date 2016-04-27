
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author VictorManuel
 */
public class InterfazReloj extends Thread{
    private JLabel jlabel;
    
    public InterfazReloj(JLabel jlabel){
    this.jlabel = jlabel;
    }
    
    public void run(){
        while(true){
            Date actual = new Date();
            SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss");
            jlabel.setText(s.format(actual));
            
            try{
                sleep(1000);
            }catch(Exception e){
                System.out.println("Error en reloj digital (" + e.getMessage().toString() + ")");
            }
        }
        
    }
}
