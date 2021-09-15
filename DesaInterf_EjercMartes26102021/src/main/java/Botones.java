import javax.swing.*;
import java.awt.*;

public class Botones extends JFrame {

    public void iniciar() {
        JFrame f = new JFrame("Primera ventana en Java");
//        f.setBounds(0, 0, 300, 100);
        f.setSize(400,300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       JButton b1, b2, b3;
       b1 = new JButton("Rojo");
       b2 = new JButton("Azul");
       b3 = new JButton("verde");

       JPanel panel = new JPanel();

       panel.add(b1);
       panel.add(b2);
       panel.add(b3);

       f.getContentPane().add(panel);
       f.setVisible(true);
    }

    public Botones() {
        iniciar();
    }

    public static void main(String[] args) {
        new Botones();
    }

}
