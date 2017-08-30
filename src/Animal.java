import java.awt.*;

/**
 * Created by Owner on 4/29/14.
 */
public class Animal {
    protected int topSpeed;

    public Animal() {
        this.topSpeed = 0;
    }

    public Animal(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public void erase(Graphics g, int x, int y)
    {
        g.drawLine(x-1, y, x+1, y);
        g.drawLine(x, y-1, x, y+1);
    }

    public void paint(Graphics g, int x, int y)
    {
        g.drawLine(x-1, y, x+1, y);
        g.drawLine(x, y-1, x, y+1);
    }

    public int run() {return 0;}
}
