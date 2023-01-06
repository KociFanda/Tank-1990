package com.example.tank_1990;

public class Grenade extends Entita{
    private final int BOARD_WIDTH = 1200;
    private final int BOARD_HEIGHT = 800;
    private final int GRENADE_SPEED = 9;
    private final String tankPosition;
    public Grenade(int x, int y, String tankPosition) {
        super(x, y);
        this.tankPosition = tankPosition;

        initGrenade(tankPosition);
    }
    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    private void initGrenade(String tankPosition) {
        if(tankPosition == "tankDown.png"){
            loadImage("grenadeDown.png");
        }
        else if(tankPosition == "tankUp.png"){

            loadImage("grenadeUp.png");
            getImageDimensions();
        }
       else if (tankPosition == "tankLeft.png"){
            loadImage("grenadeLeft.png");
            getImageDimensions();
        }
       else if (tankPosition == "tankRight.png"){
            loadImage("grenadeRight.png");
            getImageDimensions();
        }

    }

    public void moveDown() {

        System.out.println("funguju");
        y += GRENADE_SPEED;
        System.out.println(y);
        if (x > BOARD_HEIGHT) {
            visible = false;
        }
    }
    public void moveLeft() {
        System.out.println("funguju");
        x -= GRENADE_SPEED;
        if (x > BOARD_WIDTH) {
            visible = false;
        }
    }
    public void moveRight() {
        System.out.println("funguju");
        x += GRENADE_SPEED;
        if (x > BOARD_WIDTH) {
            visible = false;
        }
    }
    public void moveUp() {
        System.out.println("funguju");
        y -= GRENADE_SPEED;
        if (x > BOARD_HEIGHT) {
            visible = false;
        }

    }

    public void move() {
        if(tankPosition == "tankDown.png"){
            y += GRENADE_SPEED;
            if (x > BOARD_HEIGHT) {
                visible = false;
            }
        }
        else if(tankPosition == "tankUp.png"){
            y -= GRENADE_SPEED;
            if (x > BOARD_HEIGHT) {
                visible = false;
            }
        }
        else if (tankPosition == "tankLeft.png"){
            x -= GRENADE_SPEED;
            if (x > BOARD_WIDTH) {
                visible = false;
            }
        }
        else if (tankPosition == "tankRight.png"){
            x += GRENADE_SPEED;
            if (x > BOARD_WIDTH) {
                visible = false;
            }
        }

    }
}
