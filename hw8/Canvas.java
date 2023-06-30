/*
 * Canvas class, canvas page to draw on
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.concurrent.*;
import java.util.*;

public class Canvas extends JPanel implements MouseListener {
    protected Model model;
    protected Main parent;

    public Canvas (Main parent, Model model) {
        this.model = model;
        this.parent = parent;
        addMouseListener (this);
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    executor.scheduleAtFixedRate(shipAdding, 0, 2, TimeUnit.SECONDS);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        model.drawAll(g,parent.getFrameNumber(),parent.getMainSize());
        updateScore();
    }
    
    public void resetCanvas() {
        model.clearList();
        repaint();
        
    }
    public void addShip(String name, int length) {
        model.addShip(name, length, parent.getFrameNumber());
        repaint();
    }

    Runnable shipAdding = new Runnable() {
        public void run() {
            Random rand = new Random();
            int randomized = rand.nextInt(2);
            if (randomized == 0) {
            model.addShip("Battleship", 50, parent.getFrameNumber());
            }
            else {
                model.addShip("Submarine", 50, parent.getFrameNumber());
            }
            repaint();
        }
    };

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

    public void play() {
        parent.play();
        model.resetPoints();
    }

        // MouseListener defines all of these, so we must supply them 
        public void mouseReleased (MouseEvent event) {} 
        public void mouseClicked (MouseEvent event) {} 
        public void mouseEntered (MouseEvent event) {} 
        public void mouseExited (MouseEvent event) {} 

}
