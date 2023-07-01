import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class ShipBattleShip extends Ship{

    public ShipBattleShip() {
        super();
    }

    public ShipBattleShip (int x, int y, int width, int length) {
        super();
        this.x = x;
        this.y = y;
        this.width = width;
        this.length = length;
    }

    public void drawShip(Graphics g) {
        g.drawRect(x,y,width,length);
    }

    public void drawShip(Graphics g, int frameNumber) {
        if (filled) {
            g.fillRect(frameNumber + x,y,width,length);
        }
        else {
            g.drawRect(frameNumber + x,y,width,length);
        }
    }

    public void drawShip(Graphics g, int frameNumber, int zoomMagnitude) {
        Rectangle loc = new Rectangle(x,y,width,length);
        
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
            g.fillRect(loc.x,loc.y,loc.width,loc.height);
        }
        else {
            g.drawRect(loc.x,loc.y,loc.width,loc.height);
        }
    }

    public boolean isClicked(MouseEvent e, int frameNumber) {
        Point2D point = e.getPoint();
        Rectangle bounds = new Rectangle(frameNumber + x,y,width,length);
        if (bounds.contains(point)) {
            System.out.println ("Ship selected!");
            filled = !filled;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean intersects(Ship ship, int frameNumber) {
        Rectangle shape1 = new Rectangle(this.getX()+ frameNumber,this.getY(),this.getWidth(),this.getLength());
        Ellipse2D.Double shape2 = new Ellipse2D.Double(ship.getX() + frameNumber,ship.getY(),ship.getWidth(),ship.getLength());
        return testIntersection(shape1, shape2);
    }

    public void applyMovement(Rectangle loc, int frameNumber) {
        if (direction == 0) {
            loc.x = (x + frameNumber);
            x = loc.x;
        }
        else if (direction == 1) {
            loc.x = x - frameNumber;
            x = loc.x;
        }
        else if (direction == 2) {
            loc.y = y + frameNumber;
            y = loc.y;
        }
        else if (direction == 3) {
            loc.y = y - frameNumber;
            y = loc.y;
        }
    }
}
