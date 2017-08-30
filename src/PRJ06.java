import javax.swing.*;
import java.awt.*;

/**
 * Created by Owner on 4/29/14.
 */
public class PRJ06 extends JFrame
{
    public static void main (String[] args)
    {
        PRJ06 frmApp = new PRJ06();
        PanelRace pnlRace = new PanelRace();

        frmApp.setLayout(new BorderLayout());
        frmApp.add(pnlRace, BorderLayout.CENTER);

        frmApp.setTitle("PRJ06 The Tortoise And The Hare");
        frmApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmApp.setSize(700,500);
        frmApp.setVisible(true);

        pnlRace.run();
    }
}
