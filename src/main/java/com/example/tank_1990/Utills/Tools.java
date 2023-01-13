package com.example.tank_1990.Utills;

import com.example.tank_1990.Tank;
import com.example.tank_1990.Tank2;
import javafx.scene.shape.Rectangle;

public class Tools {


    public static void checkCollisionTank(Tank tank, Tank2 tank2, String tankPosition, Rectangle barak) {
        if(tank.getX() <= 0 ) {tank.setX(0);}
        if(tank.getX() >= 1125 ) {tank.setX(1125);}
        if(tank.getY() <= 0 ) {tank.setY(0);}
        if(tank.getY() >= 930 ) {tank.setY(930);}

        if (tank.getRect().intersects(barak.getBoundsInParent())) {
            //Prava
            if(tank.getX() <= 70 && tank.getY() >258 -60 && tank.getY() < 330 + 60) {
                tank.setX(70);}
            //Horni
            else if(tank.getY() <= 258 && tank.getX() <=70  - 5) {
                tank.setY(258 - 84 );}
            //Dolni
            else if(tank.getY() <=  421 && tank.getY() >=340 && tank.getX() < 70 -15) {
                tank.setY(421);}}

        if (tank.getRect().getBoundsInParent().intersects(tank2.getRect().getBoundsInParent())) {
            tank.setDx(0);
            tank.setDy(0);

            if (tankPosition.equals("tankUp.png")) {
                tank.isCollidingUp = true;
                tank.isCollidingDown = false;tank.isCollidingLeft = false;tank.isCollidingRight = false;
            }
            if (tankPosition.equals("tankDown.png")) {
                tank.isCollidingDown = true;
                tank.isCollidingLeft = false;tank.isCollidingRight = false;tank.isCollidingUp = false;
            }
            if (tankPosition.equals("tankLeft.png")) {
                tank.isCollidingLeft = true;
                tank.isCollidingRight = false;tank.isCollidingUp = false;tank.isCollidingDown = false;
            }
            if (tankPosition.equals("tankRight.png")) {
                tank.isCollidingRight = true;
                tank.isCollidingUp = false;tank.isCollidingDown = false;tank.isCollidingLeft = false;
            }
        }
    }
    public static void checkCollisionTank2(Tank2 tank2, Tank tank, String tank2Position, Rectangle barak) {
        if(tank2.getX() <= 0 ) {tank2.setX(0);}
        if(tank2.getX() >= 1125 ) {tank2.setX(1125);}
        if(tank2.getY() <= 0 ) {tank2.setY(0);}
        if(tank2.getY() >= 930 ) {tank2.setY(930);}

        if (tank2.getRect().intersects(barak.getBoundsInParent())) {
            //Prava
            if(tank2.getX() <= 70 && tank2.getY() >258 -60 && tank2.getY() < 330 + 60) {
                tank2.setX(70);}
            //Horni
            else if(tank2.getY() <= 258 && tank2.getX() <=70  - 5) {
                tank2.setY(258 - 84 );}
            //Dolni
            else if(tank2.getY() <=  421 && tank2.getY() >=340 && tank2.getX() < 70 -15) {
                tank2.setY(421);}}
        if (tank2.getRect().getBoundsInParent().intersects(tank.getRect().getBoundsInParent())) {

            tank2.setDx(0);
            tank2.setDy(0);
            if (tank2Position.equals("tank2Up.png")) {
                tank2.isCollidingUp = true;
                tank2.isCollidingDown = false;tank2.isCollidingLeft = false;tank2.isCollidingRight = false;
            }
            if (tank2Position.equals("tank2Down.png")) {
                tank2.isCollidingDown = true;
                tank2.isCollidingLeft = false;tank2.isCollidingRight = false;tank2.isCollidingUp = false;
            }
            if (tank2Position.equals("tank2Left.png")) {
                tank2.isCollidingLeft = true;
                tank2.isCollidingRight = false;tank2.isCollidingUp = false;tank2.isCollidingDown = false;
            }
            if (tank2Position.equals("tank2Right.png")) {
                tank2.isCollidingRight = true;
                tank2.isCollidingUp = false;tank2.isCollidingDown = false;tank2.isCollidingLeft = false;
            }
        }
    }


}
