package gamers;

import main.*;

import java.lang.Math;
import java.util.concurrent.TimeUnit;

public class s24279 extends Unit {

    public s24279(String id, Pair<Double, Double> position, double rotate, CollisionModel model) {
        super(id, position, rotate, model);
    }

    public void sleep(int x) {
        try {
            TimeUnit.MILLISECONDS.sleep(x);
        } catch (final InterruptedException e) {
            e.notify();
        }
    }

    public void seek(int x) {
        int steps = 0;
        int randAngle = (int) ((Math.random() * 180) - 90);
       while (nearestCollision() >= 2) {
            if (steps % 3 == 0 && nearestCollision() >= 1) {
                rotateBy(randAngle);
                this.sleep(200);
            } else if (steps % 4 == 0 && nearestCollision() >= 1) {
                rotateBy(-randAngle);
                this.sleep(200);
           }
            rotateBy(-x);
            this.sleep(100);
            rotateBy(x);
            this.sleep(100);
            steps++;
            resetTachoCounter();
            resetRotateTachoCounter();
        }
    }

    @Override
    public void run() {
      //  this.enableStopOnWall();
        this.enableMovement();
        this.forward();
        int randAngle = (int) ((Math.random() * 180) - 90);

        for (; ; ) {

            if(this.nearestCollision() < 2 && nearestCollision() >= 0) {
                if (this.whatIsInRange() == 3) {
                    do {
                        this.attackInNextMove();
                    } while(this.whatIsInRange() == 3);
                    this.forward();
                } else if (this.whatIsInRange() == 1 || whatIsInRange() == 2) {
                    if(this.nearestCollision() >= 0 && nearestCollision() <= 1 ) {
                        this.setSpeed(80);
                        resetTachoCounter();
                        resetRotateTachoCounter();
                    }
                    this.backward();
                   // sleep(200);
                    rotateBy(160);
                    this.forward();
                }this.setSpeed(100);
            }seek(25);
        }
    }
}




//backup
//            if(this.nearestCollision() <= 2 && nearestCollision() >= 0) {
//                    if (this.whatIsInRange() == 3) {
//                    do {
//                    this.attackInNextMove();
//                    } while(this.whatIsInRange() == 3);
//                    this.forward();
//                    } else if (this.whatIsInRange() == 1 || whatIsInRange() == 2) {
//                    if(this.nearestCollision() >= 0 && nearestCollision() <= 1) {
//                    this.setSpeed(70);
//                    }
//                    this.backward();
//                    rotateBy(160);
//                    sleep(400);
//                    this.forward();
//                    }this.setSpeed(100);
//                    }seek(25);