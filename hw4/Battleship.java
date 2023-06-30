import java.awt.*;

public class Battleship extends Ship{

    public Battleship() {
        super();
    }

    public Battleship (int x, int y, int width, int length) {
        super();
        this.x = x;
        this.y = y;
        this.width = width;
        this.length = length;
    }

    public void paintComponent(Graphics g) {
        
        g.drawRect(x,y,width,length);
    }
}
