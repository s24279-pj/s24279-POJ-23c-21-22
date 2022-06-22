import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Player extends JFrame {

    public int x_axis = 400;
    public int y_axis = 650;
    public int player_height = 30;
    public int player_width = 70;


    public void position(int pos_x, int pos_y){
        x_axis = pos_x;
        y_axis = pos_y;
    }

    public int current_x() {
        return x_axis;
    }

    public int current_y() {
        return y_axis;
    }

    public void drawPlayer(Graphics g) {
        Graphics2D player = (Graphics2D) g;
        Rectangle2D.Double player_ship = new Rectangle2D.Double(x_axis, y_axis, player_width, player_height);
        player.setColor(Color.yellow);
        player.fill(player_ship);
    }
}

