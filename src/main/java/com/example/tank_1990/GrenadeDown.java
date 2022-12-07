package com.example.tank_1990;

public class GrenadeDown extends Entita {

    private final int BOARD_WIDTH = 1200;
    private final int BOARD_HEIGHT = 800;
    private final int GRENADE_SPEED = 5;

    public GrenadeDown(int x, int y) {
        super(x, y);

        initGrenadeDown();
    }

    private void initGrenadeDown() {

        loadImage("grenadeDown.png");
        getImageDimensions();
    }

    public void moveDown() {
        y += GRENADE_SPEED;

        if (x > BOARD_HEIGHT) {
            visible = false;
        }
    }
}

