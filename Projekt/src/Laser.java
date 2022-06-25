import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Laser {

    Player player = new Player();

    int shot_y = player.y_axis;
    int shot_x = 400 + (player.player_width / 2);

    public void position(int pos_x, int pos_y){
        shot_x = pos_x;
        shot_y = pos_y;
    }

    public int current_x() {
        return shot_x ;
    }

    public int current_y() {

        shot_y = player.y_axis;
        return shot_y;
    }

    public void drawLaser(Graphics g) {
        Graphics2D laser = (Graphics2D) g;
        Rectangle2D.Double laser_blast = new Rectangle2D.Double(shot_x, shot_y, 5, 10);
        if(Game.laserShot) {
            laser.setColor(Color.green);
            laser_blast.height = 10;
            laser_blast.width = 5;
        }else {
            laser_blast.height = 0;
            laser_blast.width = 0;
        }
        laser.fill(laser_blast);
    }

    public void shotMove(int x) {
        shot_y -= 10;
        if (shot_y <= 0 || !Game.laserShot) {
            Game.laserShot = false;
            position(x + (player.player_width/2), shot_y);
        }

    }
}
