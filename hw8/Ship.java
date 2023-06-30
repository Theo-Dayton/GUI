import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;

abstract public class Ship {
    protected int x,y,width,length;
    protected String name;
    protected int direction;
    protected boolean filled;

    protected static final int ZOOMCENTER = 300;

    public Ship () {
        filled = false;
        Random rand = new Random();
        direction = rand.nextInt(4);
    }

    public void drawShip(Graphics g) {

    }

    public void drawShip(Graphics g, int frameNumber) {
    }

    public void drawShip(Graphics g, int frameNumber, int zoomMagnitude) {
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getWidth() {
        return this.width;
    }

    public int getLength() {
        return this.length;
    }

    public void changeX(int value) {
        this.x += value;
    }

    public void changeY(int value) {
        this.y += value;
    }

    public void setValues(int x,int y, int width, int length) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.length = length;
    }

    public boolean isClicked(MouseEvent e, int frameNumber) {
        return false;
    }

    public boolean isSelected() {
        return filled;
    }

    public void setSelected(boolean input) {
        filled = input;
    }

    public boolean intersects(Ship ship, int frameNumber) {
        return false;
    }

    public static boolean testIntersection(Shape shapeA, Shape shapeB) {
        Area areaA = new Area(shapeA);
        areaA.intersect(new Area(shapeB));
        return !areaA.isEmpty();
     }

     public boolean outOfBounds(Dimension size) {
        if (direction == 0 && ((x+width) > (size.getWidth()-200))) {
            return true;
        }
        else if (direction == 1 && (x < 0)) {
            return true;
        }
        else if (direction == 2 && ((y+length) > (size.getHeight()-75))) {
            return true;
        }
        else if (direction == 3 && (y < 0)) {
            return true;
        }
        return false;
     }

}