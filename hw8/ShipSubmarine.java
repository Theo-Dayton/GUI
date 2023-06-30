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
        Ellipse2D.Double loc = new Ellipse2D.Double(x,y,width,length);
        
        applyMovement(loc, frameNumber);

        if (loc.x > ZOOMCENTER) {
            loc.x = loc.x-zoomMagnitude;
        }
        else {
            loc.x = loc.x+zoomMagnitude;
        }

        if (loc.y > ZOOMCENTER) {
            loc.y = loc.y-zoomMagnitude;
        }
        else {
            loc.y = loc.y+zoomMagnitude;
        }

        if (filled) {
            g.fillOval((int)loc.x,(int)loc.y,(int)loc.width,(int)loc.height);
        }
        else {
            g.drawOval((int)loc.x,(int)loc.y,(int)loc.width,(int)loc.height);
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

    public void applyMovement(Ellipse2D.Double loc, int frameNumber) {
        if (direction == 0) {
            loc.x = (x + frameNumber);
            x = (int)loc.x;
        }
        else if (direction == 1) {
            loc.x = x - frameNumber;
            x = (int)loc.x;
        }
        else if (direction == 2) {
            loc.y = y + frameNumber;
            y = (int)loc.y;
        }
        else if (direction == 3) {
            loc.y = y - frameNumber;
            y = (int)loc.y;
        }
    }

}
