package com.example.tank_1990;

public class GrenadeRight extends Entita {

    private final int BOARD_WIDTH = 1200;
    private final int BOARD_HEIGHT = 800;
    private final int GRENADE_SPEED = 5;

    public GrenadeRight(int x, int y) {
        super(x, y);

        initGrenadeRight();
    }

    private void initGrenadeRight() {

        loadImage("grenadeRight.png");
        getImageDimensions();
    }

    public void moveRight() {
        x += GRENADE_SPEED;
        if (x > BOARD_WIDTH) {
            visible = false;
        }
    }
}

