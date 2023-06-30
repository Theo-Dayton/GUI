import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class ShipSubmarine extends Ship{

    public ShipSubmarine() {
        super();
    }

    public ShipSubmarine (int x, int y, int width, int length) {
        super();
        this.x = x;
        this.y = y;
        this.width = width;
        this.length = length;
    }

    public void drawShip(Graphics g, int frameNumber) {
        if (filled) {
            g.fillOval(frameNumber + x,y,width,length);
        }
        else {
            g.drawOval(frameNumber + x,y,width,length);
        }
    }

    public void drawShip(Graphics g, int frameNumber, int zoomMagnitude) {
        int shipX,shipY = 0;
        if ((frameNumber + x) > ZOOMCENTER) {
            shipX = (frameNumber + x)-zoomMagnitude;
        }
        else {
            shipX = (frameNumber + x)+zoomMagnitude;
        }

        if ((y) > ZOOMCENTER) {
            shipY = y-zoomMagnitude;
        }
        else {
            shipY = y+zoomMagnitude;
        }

        if (filled) {
            g.fillOval(shipX,shipY,width,length);
        }
        else {
            g.drawOval(shipX,shipY,width,length);
        }
    }

    public boolean isClicked(MouseEvent e, int frameNumber) {
        int mousex = e.getPoint().x;
        int mousey = e.getPoint().y;
        Ellipse2D.Double bounds = new Ellipse2D.Double(frameNumber + x,y,width,length);
        if (bounds.contains(mousex,mousey)) {
            System.out.println ("Ship selected!");
            filled = !filled;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean intersects(Ship ship, int frameNumber) {
        Ellipse2D.Double shape1 = new Ellipse2D.Double(this.getX()+ frameNumber,this.getY(),this.getWidth(),this.getLength());
        Ellipse2D.Double shape2 = new Ellipse2D.Double(ship.getX() + frameNumber,ship.getY(),ship.getWidth(),ship.getLength());
        return testIntersection(shape1, shape2);
    }

}
