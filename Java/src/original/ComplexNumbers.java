package original;

import java.awt.Menu;
import java.awt.MenuBar;
import javax.swing.*;

/**
 *
 * @author Adrian Wälchli
 */
public class ComplexNumbers{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        Map gauss = new Map(8, 1);
//        
//        JFrame frame = new JFrame();
//        frame.setSize(600, 600);
//        frame.setResizable(false);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.add(gauss);
//        
//        frame.setVisible(true);
//        
//        gauss.repaint();
//        
//        gauss.addComplex(new Complex(4, 2));
//        gauss.addComplex(new Complex(0.5, -2));
//        gauss.addComplex(new Complex(8, -8));
//        gauss.addComplex(new Complex(6, -2));
//        gauss.addComplex(new Complex(-1, 4));
//        gauss.addComplex(new Complex(-7, -3));
//        
//        MenuBar m_bar = new MenuBar();
//        
//        Menu file = new Menu("File");
//        Menu view = new Menu("View");
//        
//        m_bar.add(file);
//        m_bar.add(view);
//        
//        frame.setMenuBar(m_bar);
        
        
        
        ComplexFunction c = new ComplexFunction();
        
        JFrame frame = new JFrame("f(z) = (z^2 - 1) * (z - 2 - i)^2 / (z^2 + 2 + 2i)");
        frame.setSize(600, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(c);
        
        frame.setVisible(true);
        
        //c.repaint();
        
    }
}
