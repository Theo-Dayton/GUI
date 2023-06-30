import java.awt.*;

public class Submarine extends Ship{

    public Submarine() {
        super();
    }

    public Submarine (int x, int y, int width, int length) {
        super();
        this.x = x;
        this.y = y;
        this.width = width;
        this.length = length;
    }

    public void paintComponent(Graphics g) {
        g.drawOval(x,y,width,length);
    }
}
