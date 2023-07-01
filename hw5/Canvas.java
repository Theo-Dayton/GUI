/*
 * Canvas class, canvas page to draw on
 */

import java.awt.*;
import javax.swing.*;

public class Canvas extends JPanel {
    public Model model;
    public Main parent;

    public Canvas (Main parent, Model model) {
        this.model = model;
        this.parent = parent;
    }

    public void paintComponent(Graphics g) {
        //System.out.println("canvas");
        super.paintComponent(g);
        model.drawAll(g,parent.getFrameNumber());
    }
    
    public void resetCanvas() {
        model.clearList();
    }
    public void addShip(String name, int length) {
        model.addShip(name, length);
    }

    public void toggleTimer() {
        model.toggleTimer(parent.getTimer());
    }

    public void speedUp() {
        model.speedUp(parent);
    }

    public void slowDown() {
        model.slowDown(parent);
    }

    public void disableButtons() {
        parent.disableButtons();
    }
    
}
