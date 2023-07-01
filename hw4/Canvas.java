/*
 * Canvas class, canvas page to draw on
 */

import java.awt.*;
import javax.swing.*;

public class Canvas extends JPanel {
    public Model model;

    public Canvas (Model model) {
        this.model = model;
    }

    public void paintComponent(Graphics g) {
        //System.out.println("canvas");
        super.paintComponent(g);
        for (Ship s : model.getList()) {
            s.paintComponent(getGraphics());
        }
        repaint();
    }
    
    public void resetCanvas() {
        model.clearList();
    }
    public void addRandomShip() {
        model.addRandomToList();
    }
    public void toggleRotate() {
        model.rotate();
    }

    
}
