/*
 * Canvas class, canvas page to draw on
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Canvas extends JPanel implements MouseListener {
    public Model model;
    public Main parent;

    public Canvas (Main parent, Model model) {
        this.model = model;
        this.parent = parent;
        addMouseListener (this);
    }

    public void paintComponent(Graphics g) {
        //System.out.println("canvas");
        super.paintComponent(g);
        model.drawAll(g,parent.getFrameNumber());
    }
    
    public void resetCanvas() {
        model.clearList();
        repaint();
        
    }
    public void addShip(String name, int length) {
        model.addShip(name, length, parent.getFrameNumber());
        repaint();
    }

    public void removeShip() {
        model.removeShip();
        repaint();
    }

    public void zoom(String direction) {
        model.zoom(direction);
        repaint();
    }

    public void updateScore() {
        parent.setScore(model.gamePoints);
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

    public void mousePressed(MouseEvent event) {
        System.out.println ("Mouse down at " + event.getPoint().x + ", " + event.getPoint().y);
        model.mousePress(event, parent.getFrameNumber());
        repaint();
    }

        // MouseListener defines all of these, so we must supply them 
        public void mouseReleased (MouseEvent event) {} 
        public void mouseClicked (MouseEvent event) {} 
        public void mouseEntered (MouseEvent event) {} 
        public void mouseExited (MouseEvent event) {} 

}
