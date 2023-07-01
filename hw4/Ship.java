import java.awt.*;

public class Ship {
    protected int x,y,width,length;
    protected String name;

    public Ship () {
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

    public void rotateShip() {
        int temp = this.width;
        this.width = this.length;
        this.length = temp;
    }
    public void paintComponent(Graphics g) {
        System.out.println("test");
    }
}