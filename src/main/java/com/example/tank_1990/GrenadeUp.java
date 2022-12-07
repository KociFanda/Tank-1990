package com.example.tank_1990;

public class GrenadeUp extends Entita {

    private final int BOARD_WIDTH = 1200;
    private final int BOARD_HEIGHT = 800;
    private final int GRENADE_SPEED = 5;


    public GrenadeUp(int x, int y) {
        super(x, y);

        initGrenadeUp();
    }

    private void initGrenadeUp() {
        loadImage("grenadeUp.png");
        getImageDimensions();
    }


    public void moveUp() {
        y -= GRENADE_SPEED;
        if (x > BOARD_HEIGHT) {
            visible = false;
        }

    }
}

