package com.example.tank_1990;

public class Grenade extends Entita{
    private final int BOARD_WIDTH = 390;
    private final int GRENADE_SPEED = 2;

    public Grenade(int x, int y) {
        super(x, y);

        initGrenade();
    }

    private void initGrenade() {

        loadImage("grenade.png");
        getImageDimensions();
    }

    public void move() {

        x += GRENADE_SPEED;

        if (x > BOARD_WIDTH) {
            visible = false;
        }
    }
}
