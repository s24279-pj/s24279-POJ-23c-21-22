import java.awt.*;
import java.util.Random;

public class Fleet {

    Alien ship = new Alien();
    AlienLaser alien_laser = new AlienLaser();

    Alien[] line1 = new Alien[10];
    Alien[] line2 = new Alien[10];
    Alien[] line3 = new Alien[10];

    public Fleet() {
        for (int i = 0; i < 10; i++) {
            line1[i] = new Alien();
            line2[i] = new Alien();
            line3[i] = new Alien();
        }
    }

    int start_x = 50;
    int start_y;
    boolean moveToRight = true;
    int window_width = 900;


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

    public void drawFleet(Graphics g) {
        for (int i = 0; i < 10; i++) {
            line1[i].drawAlien(g);
            line2[i].drawAlien(g);
            line3[i].drawAlien(g);

            if(line3[i].isShooting()) {
                alien_laser.drawAlienLaser(g);
            }
        }

    }

    public void moveFleet() {

        if (moveToRight) {
            //prawa krawedz, ruch w dół
            for (int i = 9; i >= 0; i--) {
                if (line1[i].isAlive() || line2[i].isAlive() || line3[i].isAlive()) {
                    if (line1[i].current_x() > window_width + line1[i].alien_width - 100) {
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
                if (line1[i].isAlive() || line2[i].isAlive() || line3[i].isAlive()) {
                    if (line1[i].current_x() == 50) {
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

    public void checkPlayerShot(int laser_x, int laser_y) {
        for (int i = 0; i < 10; i++) {

            if (laser_y < line3[i].current_y() + ship.alien_height && laser_y >= line3[i].current_y()) {
                if (laser_x >= line3[i].current_x() && laser_x <= (line3[i].current_x() + ship.alien_width)) {
                    if (line3[i].isAlive()) {
                        line3[i].alienStatus = false;
                        Game.laserShot = false;
                    }
                }
            }


            if (laser_y < line2[i].current_y() + ship.alien_height && laser_y >= line2[i].current_y()) {
                if (laser_x >= line2[i].current_x() && laser_x <= (line2[i].current_x() + ship.alien_width)) {
                    if (line2[i].isAlive()) {
                        line2[i].alienStatus = false;
                        Game.laserShot = false;
                    }
                }
            }

            if (laser_y < line1[i].current_y() + ship.alien_height && laser_y >= line1[i].current_y()) {
                if (laser_x >= line1[i].current_x() && laser_x <= (line1[i].current_x() + ship.alien_width)) {
                    if (line1[i].isAlive()) {
                        line1[i].alienStatus = false;
                        Game.laserShot = false;
                    }
                }
            }
        }
    }

    public void attack() {
        //dodac te randomy do tablicy wektorowej i stamtad puszczac
        Random random = new Random();
        int alien_nr = random.nextInt(10);
        alien_laser.position(line3[0].x_axis + (line3[0].alien_width / 2), line3[0].current_y() + line3[0].alien_height);
        if(line3[0].isAlive()) {
            line3[0].shotStatus = true;

        }
    }
}




