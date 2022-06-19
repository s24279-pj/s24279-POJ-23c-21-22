import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Laser {

    Player player = new Player();
    Fleet fleet = new Fleet();

    int x_axis = 0;
    int y_axis = 0;
    int shot_y = player.y_axis;
    int shot_x = 400 + (player.player_width / 2);
   // int shot_x = 0;
    public void position(int pos_x, int pos_y){
        pos_x = shot_x;
        shot_y = pos_y;
    }

    public int current_x() {
        return shot_x ;
    }

    public int current_y() {
        y_axis = player.y_axis;
        return y_axis;
    }

    public void drawLaser(Graphics g) {
        Graphics2D laser = (Graphics2D) g;
        Rectangle2D.Double laser_blast = new Rectangle2D.Double(shot_x, shot_y, 5, 10);
        laser.setColor(Color.green);
        laser.fill(laser_blast);
    }

    //tutaj trzeba poprawic restart pozycji, po osiagnieciu krawedzi
    public void shotMove() {
        shot_y -= 10;
        if (shot_y < 0) {
            position(shot_x, shot_y);
            Game.laserShot = false;
        }
    }
}
