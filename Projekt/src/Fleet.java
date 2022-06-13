import java.awt.*;

public class Fleet {

    Alien ship = new Alien();

    Alien[] line1 = new Alien[10];
    Alien[] line2 = new Alien[10];
    Alien[] line3 = new Alien[10];

    int start_x;
    int start_y;

    public void makeFleet(){

       for (int i = 0; i < 10; i++) {
           line1[i] = ship;
           line2[i] = ship;
           line3[i] = ship;
       }
    }

    public void drawFleet(Graphics g) {
        start_x = 50;
        start_y = 70;
        for(int i = 0; i < 10; i++) {
            line1[i].position(start_x, start_y);
            start_x = start_x + ship.alien_width + 20;
            line1[i].drawAlien(g);
        }

        start_x = 50;
        start_y = start_y + ship.alien_height + 20;
        for(int i = 0; i < 10; i++) {
            line2[i].position(start_x, start_y);
            start_x = start_x + ship.alien_width + 20;
            line2[i].drawAlien(g);
        }

        start_x = 50;
        start_y = start_y + ship.alien_height + 20;
        for(int i = 0; i < 10; i++) {
            line3[i].position(start_x, start_y);
            start_x = start_x + ship.alien_width + 20;
            line3[i].drawAlien(g);
        }
    }

    public void moveFleet() {
        for (int i = 0; i < 10; i++) {
            line1[i].position(line1[i].current_x() + 10, line1[i].current_y());
            line2[i].position(line2[i].current_x() + 10, line2[i].current_y());
            line3[i].position(line3[i].current_x() + 10, line3[i].current_y());
        }
    }

/*    public void drawFleet(Graphics g) {
        for(int i = 0; i < 10; i++) {
            line1[i].drawAlien(g);
        }
    }

    public void setlayout() {
        int start_x = 10;
        int start_y = 50;
        for (int i = 0; i < 10; i++) {
            line1[i].position(start_x, start_y);
            start_x = ship.alien_width + 15;
        }
    }*/
}
