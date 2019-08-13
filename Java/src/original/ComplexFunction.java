/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package original;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Adrian Wälchli
 */
public class ComplexFunction extends JPanel{
    
    @Override
    public void paint(Graphics g){
        
        double x0 = getWidth() / 2.;
        double y0 = getHeight() / 2.;
        
        double scale = 150;
        
        double range = 2;
        double step = 0.001;
        
        for(double re = -range; re < range; re += step){
            for(double im = -range; im < range; im += step){
                
                Complex z = new Complex(re, im);
                
                Complex fz = function1(z);
                
                double z_re = z.getRe();
                double z_im = z.getIm();
                
                double x = x0 + (z_re * scale);
                double y = y0 - (z_im * scale);
                
                double arg = fz.getArg();
                if(arg < 0){
                    arg = 2 * Math.PI + arg;
                }
                
                float h = (float) (arg / (2 * Math.PI));
                float s = 1; 
                float v = 1; 
                
                Color color = Color.getHSBColor(h, s, v);
                
                g.setColor(color);
                g.drawLine((int) x, (int) y, (int) x, (int) y);
            }
        }
    }
    
    
    
    private static Complex function1(Complex z){
        
        //f(z) = (z^2 - 1) * (z - 2 - i)^2 / (z^2 + 2 + 2i)
        Complex z_square = Complex.multiply(z, z);
        Complex z_1 = new Complex(-1, 0);
        Complex z_2 = new Complex(-2, -1);
        Complex z_3 = new Complex(2, 2);
        
        Complex p1 = Complex.add(z_square, z_1);
        Complex p2 = Complex.add(z, z_2);
        Complex p3 = Complex.add(z_square, z_3);
        
        Complex p2_square = Complex.multiply(p2, p2);
        
        return Complex.divide(Complex.multiply(p1, p2_square), p3);
    }
    
    private static Complex function2(Complex z, int depth){
        if(depth == 1){
            return Complex.multiply(z, z);
        }else{
            return Complex.add(function2(z, depth - 1), z);
        }
    }
}
