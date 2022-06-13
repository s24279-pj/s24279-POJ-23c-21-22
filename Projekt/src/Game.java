import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

public class Game extends JFrame {

    Alien alien = new Alien();
    Fleet fleet = new Fleet();
    Player player = new Player();

    public Game() {
        setTitle("Space Invaders");
        setSize(900, 700);
        setVisible(true);
        setBackground(Color.DARK_GRAY);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        fleet.makeFleet();
        fleet.setlayout();
//delay 20
        Timer timerClock = new Timer(5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fleet.moveFleet();
                repaint();
            }
        });
        timerClock.start();
    }

    public void paint(Graphics g) {
        g.clearRect(0,0,900,700);
        fleet.drawFleet(g);
        player.drawPlayer(g);

    /*  for (int i =0; i < 10; i++) {
          System.out.println("Ship nr :" + i + " pos_X: " + fleet.line1[i].current_x());
      }*/
    }

    public static void main(String[] args) {

        var game = new Game();

    }


}
