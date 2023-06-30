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
        System.out.println("canvas");
        super.paintComponent(g);
        for (Ship s : model.getList()) {
            s.paintComponent(g);
        }
    }
    
    public void resetCanvas() {
        model.clearList();
    }

    public void addShip(String name) {
        model.addShip(name);
    }

    public void toggleRotate() {
        model.rotate();
    }

    
}
