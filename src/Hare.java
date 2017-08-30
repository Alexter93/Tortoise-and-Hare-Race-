import java.awt.*;
import java.util.Random;
import java.util.Vector;

/**
 * Created by S1329044 on 4/21/14.
 */
public class Hare extends Animal {

    public Hare() {
        this.topSpeed = 0;
    }

    public Hare(int topSpeed) {
        super(topSpeed);
    }

    public void erase(Graphics g, int x, int y)
    {
        if (g != null)
        {
            g.setColor(Color.WHITE);
            g.drawOval(x, y, 10, 10);
            g.drawOval(x+5, y, 5, 5);
            g.drawOval(x+4, y-5, 3, 8);
            g.drawOval(x+7, y-5, 3, 8);
        }
    }
    public void paint(Graphics g, int x, int y)
    {
        if (g != null)
        {
            g.setColor(Color.BLUE);
            g.drawOval(x, y, 10, 10);
            g.drawOval(x+5, y, 5, 5);
            g.drawOval(x+4, y-5, 3, 8);
            g.drawOval(x+7, y-5, 3, 8);
        }
    }

    public int run()
    {
        Random rand = new Random(System.currentTimeMillis()); //"System.currentTimeMillis()" seeds
        int distance = 0;
        int sleep = rand.nextInt(100);
        if (sleep > 70)
        {
            distance = rand.nextInt(topSpeed)+1;
        }
        return distance;
    }
}
