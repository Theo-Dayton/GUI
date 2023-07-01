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
}
