import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Game extends JFrame {

    Fleet fleet = new Fleet();
    Player player = new Player();
    Laser laser = new Laser();
    static boolean goRight = false;
    static boolean goLeft = false;
    static boolean laserShot = false;
    int window_width = 900;

    public Game() {
        setTitle("Space Invaders");
        setSize(900, 700);
        setVisible(true);
        setBackground(Color.DARK_GRAY);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        fleet.makeFleet();
        fleet.setlayout();
        addKeyListener(new Listener());
//delay 20
        Timer timerClock = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ruch player'a w prawo
                if (goRight){
                    if(player.current_x() != window_width - 100) {
                        player.position(player.x_axis += 10, player.y_axis);
                    }else {
                        player.position(player.x_axis, player.y_axis);
                    }
                }
                //ruch player'a w lewo
                if (goLeft){
                    if(player.current_x() != window_width - 850) {
                        player.position(player.x_axis -= 10, player.y_axis);
                    }else {
                        player.position(player.x_axis, player.y_axis);
                    }
                }
                //strzal player'a
                if (laserShot){

                }
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
    //    laser.drawLaser(g);

    /*  for (int i =0; i < 10; i++) {
          System.out.println("Ship nr :" + i + " pos_X: " + fleet.line1[i].current_x());
      }*/
    }

    public static void main(String[] args) {

        var game = new Game();

    }

    static class Listener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_RIGHT){
                goRight = true;
            }else if (key == KeyEvent.VK_LEFT) {
                goLeft = true;
            }else if (key == KeyEvent.VK_SPACE) {
                laserShot = true;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_RIGHT){
                goRight = false;
            }
            if (key == KeyEvent.VK_LEFT) {
                goLeft = false;
            }else if(key == KeyEvent.VK_SPACE) {
                laserShot = true;
            }
        }
    }
}
