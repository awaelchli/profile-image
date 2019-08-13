package original;

/**
 *
 * @author Adrian Wälchli
 */
public class Complex {

    private double re;
    private double im;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    public double getAbs() {
        return Math.sqrt(re * re + im * im);
    }

    public double getArg() {
        
        double arg = Math.atan(im / re);
        
        if(re < 0 && im  >= 0){
            arg += Math.PI;
        } else if(re < 0 && im < 0){
            arg -= Math.PI;
        } else if(re == 0 && im > 0){
            arg = Math.PI / 2.;
        } else if(re == 0 && im < 0){
            arg = - Math.PI / 2.;
        } else if(re == 0 && im == 0){
            arg = Double.NaN;
        }
        
        return arg;
    }
    
    public static Complex add(Complex c1, Complex c2){
        
        double x = c1.getRe() + c2.getRe();
        double y = c1.getIm() + c2.getIm();
        
        return new Complex(x, y);
    }
    
    public static Complex subtract(Complex c1, Complex c2){
        
        double x = c1.getRe() - c2.getRe();
        double y = c1.getIm() - c2.getIm();
        
        return new Complex(x, y);
    }
    
    public static Complex multiply(Complex c1, Complex c2){
        //(a + bi) * (c + di) =  ac - bd + (ad + bc)i

        double x = (c1.getRe() * c2.getRe()) - (c1.getIm() * c2.getIm());
        double y = (c1.getRe() * c2.getIm()) + (c1.getIm() * c2.getRe());
        
        return new Complex(x, y);
    }
    
    public static Complex divide(Complex c1, Complex c2){
        //(a + bi) / (c + di) = (ac + bd) / (c^2 + d^2) + (bc - ad) / (c^2 + d^2) i

        double nom = (c2.getRe() * c2.getRe()) + (c2.getIm() * c2.getIm());

        double x = ((c1.getRe() * c2.getRe()) + (c1.getIm() * c2.getIm())) / nom;
        double y = ((c1.getIm() * c2.getRe()) - (c1.getRe() * c2.getIm())) / nom;
        
        return new Complex(x, y);
    }
    
    public void add(Complex c) {
        add(this, c);
    }

    public void subtract(Complex c) {
        subtract(this, c);
    }

    public void multiply(Complex c) {
        multiply(this, c);
    }

    public void divide(Complex c) {
        divide(this, c);
    }
}
