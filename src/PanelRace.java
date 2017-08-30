import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Vector;

/**
 * Created by S1329044 on 4/21/14.
 */
public class PanelRace extends JPanel
{
    Animal animal;

    private Graphics g;
    private Vector<Animal> vAnimal = new Vector<Animal>();
    private int totalHares = 0;
    private int totalTortoises = 0;
    private int totalAnimals = 0;
    private int winningDistance = 0;
    private int[] distanceArray = new int[20];
    private String temp = "";
    private Random rand;


    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        this.g = g;
        paintAnimals();
    }

    protected void drawFinishLine(Graphics g)
    {
        if (g != null)
        {
            g.drawLine(winningDistance, 0, winningDistance, getHeight());
        }
    }

    protected void promptForAnimals()
    {
        do
        {
            do
            {
                temp = JOptionPane.showInputDialog(null, "Enter number of tortoises: ");
                totalTortoises = Integer.parseInt(temp);
            }
            while(totalTortoises > 20);
            temp = JOptionPane.showInputDialog(null, "Enter number of hares: ");
            totalHares = Integer.parseInt(temp);
            totalAnimals = totalTortoises + totalHares;
        }
        while(totalAnimals > 20);

        for (int i=0; i<totalTortoises;i++)
        {
            Tortoise animal = new Tortoise(rand.nextInt(3)+1);
            vAnimal.add(i, animal);
        }
        for (int i=totalTortoises; i<totalAnimals;i++)
        {
            Hare animal = new Hare(rand.nextInt(8) + 2);
            vAnimal.add(i, animal);
        }
    }

    // CONTRUCTOR
    public PanelRace()
    {
        rand = new Random(System.currentTimeMillis());

        promptForAnimals();


    }
    protected void paintAnimals()
    {
        drawFinishLine(g);  // move this before loop in main()

        for (int i=0; i<totalAnimals; i++)
        {vAnimal.get(i).erase(g, distanceArray[i], i*20+10);}

        for (int i=0; i<totalAnimals; i++)
        {distanceArray[i] += vAnimal.get(i).run();}

        for (int i=0; i<totalAnimals; i++)
        {vAnimal.get(i).paint(g, distanceArray[i], i*20+10);}

    }
    protected boolean checkWinner()
    {
        for (int i=0; i<totalAnimals; i++)
        {
            if (distanceArray[i] > winningDistance)
            {
                return true;
            }
        }
        return false;
    }
    public void run()
    {
        winningDistance = getWidth() - 40;

        for (int i=0; i<totalTortoises;i++)
        {
            vAnimal.get(i).setTopSpeed(rand.nextInt(3)+1);
        }
        for (int i=totalTortoises; i<totalAnimals;i++)
        {
            vAnimal.get(i).setTopSpeed(rand.nextInt(8) + 2);
        }

        for (int i=0; i<totalAnimals; i++)
        {
            distanceArray[i] = 0;
        }

        do
        {
            if (g != null)
            {
                paintAnimals();
            }
            repaint();

            try
            {
                Thread.sleep(400L);
            }
            catch(InterruptedException ex) {};

            checkWinner();

        }while(!checkWinner());
    }
}