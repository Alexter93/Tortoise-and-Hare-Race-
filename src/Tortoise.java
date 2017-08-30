import java.awt.*;
import java.util.Random;
import java.util.Vector;

/**
 * Created by S1329044 on 4/21/14.
 */
public class Tortoise extends Animal {
    public Tortoise() {
    }

    public Tortoise(int topSpeed) {
        super(topSpeed);
    }

    public void erase(Graphics g, int x, int y)
    {
        if (g != null)
        {
            g.setColor(Color.WHITE);
            g.fillArc(x, y, 20, 10, 0, 180);
            g.drawOval(x+20, y, 5, 5);
        }
    }
    public void paint(Graphics g, int x, int y)
    {
        if (g != null)
        {
            g.setColor(Color.BLUE);
            g.fillArc(x, y, 20, 10, 0, 180);
            g.drawOval(x+20, y, 5, 5);
        }
    }

    public int run()
    {
        Random rand = new Random(System.currentTimeMillis());
        int distance = 0;
        int sleep = rand.nextInt(100);
        if (sleep > 15)
        {
            distance = rand.nextInt(topSpeed)+1;
        }
        return distance;
    }
}
