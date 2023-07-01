import java.awt.*;

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

    public void paintComponent(Graphics g, int frameNumber) {
        g.drawOval(frameNumber + x,y,width,length);
    }
}
