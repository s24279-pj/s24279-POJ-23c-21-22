import java.awt.*;
import java.awt.geom.Rectangle2D;

public class AlienLaser {

    Player player = new Player();
    Fleet fleet = new Fleet();

    int x = 30;
    int shot_y = 30;

    // int shot_x = 0;
    public void position(int pos_x, int pos_y){
        x = pos_x;
        shot_y = pos_y;
    }

    public int current_x() {
        return x ;
    }

    public int current_y() {
        shot_y = player.y_axis;
        return shot_y;
    }

    public void drawAlienLaser(Graphics g) {
        Graphics2D laser = (Graphics2D) g;
        Rectangle2D.Double laser_alien = new Rectangle2D.Double(x, shot_y, 5, 10);
        laser.setColor(Color.white);
        laser.fill(laser_alien);
    }


    public void shotMove(int x, int y) {
        y += 5;

    }
}
