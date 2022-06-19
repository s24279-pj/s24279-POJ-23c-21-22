import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Game extends JFrame {

    Fleet fleet = new Fleet();
    Player player = new Player();
    Laser laser = new Laser();
  //  AlienLaser alienLaser = new AlienLaser();

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
        fleet.setlayout();
        addKeyListener(new Listener());
        Timer timerClock = new Timer(10, e -> {
            //ruch player'a w prawo

            if (goRight){
                if(player.current_x() != window_width - 100) {
                    player.position(player.x_axis += 10, player.y_axis);
                    if(!laserShot) {
                        laser.position(laser.shot_x += 10, player.y_axis);
                    }else {
                        laser.position(laser.shot_x += 10, player.y_axis);
                        laser.shotMove();
                    }
                }else {
                    player.position(player.x_axis, player.y_axis);
                }
            }
            //ruch player'a w lewo
            if (goLeft){
                if(player.current_x() != window_width - 850) {
                    player.position(player.x_axis -= 10, player.y_axis);
                    if(!laserShot) {
                        laser.position(laser.shot_x -= 10, player.y_axis);
                    }else {
                        laser.position(laser.shot_x -= 10, player.y_axis);
                        laser.shotMove();
                    }
                }else {
                    player.position(player.x_axis, player.y_axis);
                }
            }
            //strzal player'a
      /*      if (laserShot) {
                    laser.shotMove();
            }*/
            fleet.moveFleet();
            repaint();
        });
        timerClock.start();
    }

    public void paint(Graphics g) {
        g.clearRect(0,0,900,700);
        fleet.drawFleet(g);
        player.drawPlayer(g);
    //    alienLaser.drawAlienLaser(g);
        laser.drawLaser(g);
    }

    static class Listener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {}

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
            }
            if (key == KeyEvent.VK_SPACE) {

            }
        }
    }

    public static void main(String[] args) {

        var game = new Game();
    }


}
