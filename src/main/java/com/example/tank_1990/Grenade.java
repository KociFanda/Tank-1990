package com.example.tank_1990;

public class Grenade extends Entita{

    private final int BOARD_WIDTH = 1200;
    private final int BOARD_HEIGHT = 800;
    private final int GRENADE_SPEED = 2;
    String tankPosition;

    public Grenade(int x, int y) {
        super(x, y);

        initGrenade();
    }

    private void initGrenade() {

        loadImage("grenade.png");
        getImageDimensions();
    }

    public void move(Tank tank) {
       tankPosition = tank.getImageName();

       if(tankPosition == "tankRight.png"){
               x += GRENADE_SPEED;
               if (x > BOARD_WIDTH) {visible = false;}
       }
        if(tankPosition == "tankLeft.png"){
            x -= GRENADE_SPEED;
            if (x > BOARD_WIDTH) {visible = false;}
        }
        if(tankPosition == "tankUp.png"){
            y -= GRENADE_SPEED;
            if (x > BOARD_HEIGHT) {visible = false;}
        }
        if(tankPosition == "tankDown.png"){
            y += GRENADE_SPEED;
            if (x > BOARD_HEIGHT) {visible = false;}
        }




        }



    }

