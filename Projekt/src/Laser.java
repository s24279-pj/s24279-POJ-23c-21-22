import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Laser {

    int x_axis = 0;
    int y_axis = 0;

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

    public void drawLaser(Graphics g) {
        Graphics2D laser = (Graphics2D) g;
        Rectangle2D.Double laser_blast = new Rectangle2D.Double(x_axis, y_axis, 10, 10);
        laser.setColor(Color.red);
        laser.fill(laser_blast);
    }

    public void shot() {

    }

}
