import java.awt.*;

public class Fleet {

    Alien ship = new Alien();

    Alien[] line1 = new Alien[10];
    Alien[] line2 = new Alien[10];
    Alien[] line3 = new Alien[10];

    int start_x = 50;
    int start_y;
    boolean moveToRight = true;
    int window_width = 900;

    public void makeFleet(){

       for (int i = 0; i < 10; i++) {
           line1[i] = new Alien();
           line2[i] = new Alien();
           line3[i] = new Alien();
       }
    }

    public void drawFleet(Graphics g) {
        for(int i = 0; i < 10; i++) {
            line1[i].drawAlien(g);
            line2[i].drawAlien(g);
            line3[i].drawAlien(g);
        }
    }

    public void setlayout() {
        start_x = 50;
        start_y = 70;
        for (int i = 0; i < 10; i++) {
            line1[i].position(start_x, start_y);
            start_x += ship.alien_width + 15;
        }

        start_x = 50;
        start_y += 70;
        for (int i = 0; i < 10; i++) {
            line2[i].position(start_x, start_y);
            start_x += ship.alien_width + 15;
        }

        start_x = 50;
        start_y += 70;
        for (int i = 0; i < 10; i++) {
            line3[i].position(start_x, start_y);
            start_x += ship.alien_width + 15;
        }
    }


    public void moveFleet() {

        if(moveToRight) {
            //prawa krawedz, ruch w dół
            for (int i = 9; i >= 0; i--) {
                if(!line1[i].isAlive() || !line2[i].isAlive() || !line3[i].isAlive()) {
                    if(line1[i].current_x() > window_width + line1[i].alien_width - 100) {
                        moveToRight = false;
                        moveDown();
                    }
                }
            }
            //ruch w prawo
            for (int i = 0; i < 10; i++) {
                line1[i].position(line1[i].current_x() + 1, line1[i].current_y());
                line2[i].position(line2[i].current_x() + 1, line2[i].current_y());
                line3[i].position(line3[i].current_x() + 1, line3[i].current_y());
            }
        } else {

            //lewa krawedz, ruch w dół
            for (int i = 0; i < 10; i++) {
                if(!line1[i].isAlive() || !line2[i].isAlive() || !line3[i].isAlive()) {
                    if(line1[i].current_x() == 50) {
                        moveToRight = true;
                        moveDown();
                    }
                }
            }
            //ruch w lewo
            for (int i = 0; i < 10; i++) {
                line1[i].position(line1[i].current_x() - 1, line1[i].current_y());
                line2[i].position(line2[i].current_x() - 1, line2[i].current_y());
                line3[i].position(line3[i].current_x() - 1, line3[i].current_y());
            }
        }
    }

    private void moveDown() {
        for (int j = 0; j < 10; j++) {
            line1[j].position(line1[j].current_x(), line1[j].current_y() + 50);
            line2[j].position(line2[j].current_x(), line2[j].current_y() + 50);
            line3[j].position(line3[j].current_x(), line3[j].current_y() + 50);
        }
    }
}
