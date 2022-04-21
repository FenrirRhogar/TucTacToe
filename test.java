import javax.swing.*;
import java.awt.*;

public class test extends JFrame{
     public test(){
          setSize(400,400);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setLocationRelativeTo(null);
          setVisible(true);
     }

     public static void main(String a[]){
         new test();
     }

     public void paint(Graphics g){
          g.drawLine(200, 110, 500, 110);
          g.drawLine(200, 210, 500, 210);
          g.drawLine(300, 10, 300, 310);
          g.drawLine(400, 10, 500, 310);
     }
}