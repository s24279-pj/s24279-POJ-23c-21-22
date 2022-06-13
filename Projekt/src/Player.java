import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Player extends JFrame {

    boolean move;

    public int x_axis = 0;
    public int y_axis = 0;
    public int player_height = 30;
    public int player_width = 70;

    public void position(int pos_x, int pos_y){
        x_axis = pos_x;
        y_axis = pos_y;
    }

    public void drawPlayer(Graphics g) {
        int start_x = 400;
        int start_y = 650;
        Graphics2D player = (Graphics2D) g;
        Rectangle2D.Double player_ship = new Rectangle2D.Double(start_x, start_y, player_width, player_height);
        player.setColor(Color.yellow);
        player.fill(player_ship);
    }

    public void steering() {

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_RIGHT) {
                    position(x_axis+=10, y_axis);
                }else if (key == KeyEvent.VK_LEFT) {

                }else if (key == KeyEvent.VK_SPACE) {

                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D ship = (Graphics2D) g;
        Rectangle2D.Double player = new Rectangle2D.Double(200,200,50,50);
        ship.draw(player);
    }
}