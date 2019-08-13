package original;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Adrian Wälchli
 */
public class Map extends JPanel {

    private ArrayList<Complex> c_list;
    
    private double range, interval;
    private double rangeoffset;
    
    private double x0, y0;
    
    private double p_circumf;

    public Map(double range, double interval) {
        setInterval(interval);
        setRange(range);
        
        this.rangeoffset = 15;
        p_circumf = 10;

        c_list = new ArrayList<>();
    }

    @Override
    public void paint(Graphics g) {

        x0 = getWidth() / 2.;
        y0 = getHeight() / 2.;

        drawGridLines(g);
        drawCoordSystem(g);

        for (Complex z : c_list) {
            double _x = z.getRe();
            double _y = z.getIm();

            double m = (x0 - rangeoffset) / range;

            double x_1 = x0 + _x * m;
            double y_1 = y0 - _y * m;

            double x = x_1 - (p_circumf / 2.);
            double y = y_1 - (p_circumf / 2.);
            
            g.setColor(Color.blue);
            g.drawLine((int) x0, (int) y0, (int) x_1, (int) y_1);
            
            g.setColor(Color.red);
            g.fillOval((int) x, (int) y, (int) p_circumf, (int) p_circumf);
            
        }

    }

    public void addComplex(Complex c) {
        c_list.add(c);
        repaint();
    }

    public void removeComplex(Complex c) {
        c_list.remove(c);
        repaint();
    }

    private void drawCoordSystem(Graphics g) {
        g.drawLine(0, (int) y0, (int) getWidth(), (int) y0);
        g.drawLine((int) x0, 0, (int) x0, (int) getHeight());
    }

    private void drawGridLines(Graphics g) {

        double length = x0 - rangeoffset;
        double steps = range / interval;
        double gap = length / steps;

        for (int mark = 1; mark <= steps; mark++) {
            double markX = x0 + gap * mark;
            double _markX = x0 - gap * mark;
            double markY = y0 - gap * mark;
            double _markY = y0 + gap * mark;

            g.setColor(Color.LIGHT_GRAY);

            g.drawLine((int) markX, 0, (int) markX, getHeight());
            g.drawLine((int) _markX, 0, (int) _markX, getHeight());

            g.drawLine(0, (int) markY, getWidth(), (int) markY);
            g.drawLine(0, (int) _markY, getWidth(), (int) _markY);

            g.setColor(Color.BLACK);

            double dp = 2;

            double _marknumber = Math.floor(Math.pow(10, dp) * mark * range / steps) * Math.pow(10, -dp);
            String marknumber = Double.toString(_marknumber);

            if (_marknumber == Math.floor(_marknumber)) {
                marknumber = Integer.toString((int) _marknumber);
            }

            g.drawString(marknumber, (int) markX - 3, (int) (y0 + 14));
            g.drawString("-" + marknumber, (int) _markX - 7, (int) (y0 + 14));

            g.drawString(marknumber, (int) (x0 + 4), (int) markY + 4);
            g.drawString("-" + marknumber, (int) (x0 + 4), (int) _markY + 4);
        }
    }

    public final void setInterval(double interval) {
        if (interval > 0) {
            this.interval = interval;
        } else {
            this.interval = 1;
        }
        repaint();
    }

    public final void setRange(double range) {
        if (range > 0) {
            this.range = range;
        } else {
            this.range = 1;
        }
        repaint();
    }
    
    public void setMarkerDimension(int circumference){
        p_circumf = circumference;
        repaint();
    }
}
