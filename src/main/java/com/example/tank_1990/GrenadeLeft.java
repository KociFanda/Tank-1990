package com.example.tank_1990;

public class GrenadeLeft extends Entita {

    private final int BOARD_WIDTH = 1200;
    private final int BOARD_HEIGHT = 800;
    private final int GRENADE_SPEED = 5;


    public GrenadeLeft(int x, int y) {
        super(x, y);

        initGrenadeLeft();
    }

    private void initGrenadeLeft() {

        loadImage("grenadeLeft.png");
        getImageDimensions();
    }


    public void moveLeft() {
        x -= GRENADE_SPEED;
        if (x > BOARD_WIDTH) {
            visible = false;
        }
    }

}

