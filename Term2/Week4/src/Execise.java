import javax. swing.*;
import java.awt.*;


public class Execise{
    Execise(){
        JFrame frm = new JFrame( "our first GUI example") ;
        frm.setSize(200,200);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel lab = new JLabel( "Hello Java GUIs with Swing");
        frm.add(lab);
        frm.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Execise();
            }
        });

    }

}




