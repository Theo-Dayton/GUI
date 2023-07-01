/*
 * Canvas class, canvas page to draw on
 */

import java.awt.*;
import javax.swing.*;

public class Canvas extends JPanel {
    private int x,y,width,length;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(x,y,width,length);
    }
    public void resetCanvas(Graphics g) {
        x = y = width = length = 0;
    }

    public void setValues(int x, int y, int width, int length) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.length = length;
    }

    public int getx() {
        return this.x;
    }

    public int gety() {
        return this.y;
    }

    public void setx(int x) {
        this.x = x;
    }

    public void sety(int y) {
        this.y = y;
    }

    // public void paintComponent (Graphics g) {
    //     super.paintComponent(g);
    //     //g.drawRect(50,50, 200,100);
    // }
}
