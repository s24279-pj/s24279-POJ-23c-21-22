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
       Timer timerClock = new Timer(1000, new ActionListener() {
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
        fleet.makeFleet();
      //  fleet.setlayout();
      //  fleet.moveFleet();
        fleet.drawFleet(g);

        player.drawPlayer(g);

        System.out.println(fleet.line1[0].current_x());
    }

    public static void main(String[] args) {

        var game = new Game();
    }
}
