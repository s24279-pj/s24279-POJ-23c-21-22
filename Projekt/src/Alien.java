import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Alien {

    private int x_axis = 0;
    private int y_axis = 0;
    public int alien_height = 40;
    public int alien_width = 40;
    boolean alienStatus = true;

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

    public void drawAlien(Graphics g) {
            Graphics2D alien = (Graphics2D) g;
            Rectangle2D.Double alien_ship = new Rectangle2D.Double(x_axis, y_axis, alien_width, alien_height);
            alien.setColor(Color.red);
            alien.fill(alien_ship);
    }

    public boolean isAlive() {
        return alienStatus;
    }

    //kiedy jest trafiony?? - musi tez byc tutaj isAlive na false jesli trafiony
/*    public boolean isHit(int x, int y) {
        //x = line1[i].current_x(), y = line1[i].current_y()
        if(x >= x_axis && x <= x_axis + alien_width){
            if(y >= y_axis && y <= y_axis + alien_height){
                alienStatus = false;
                return true;
            }
        }
        return false;
    }*/

}