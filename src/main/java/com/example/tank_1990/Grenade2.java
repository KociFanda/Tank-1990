package com.example.tank_1990;

public class Grenade2 extends Entita{
    private final int BOARD_WIDTH = 1200;
    private final int BOARD_HEIGHT = 1000;
    private final int GRENADE_SPEED = 9;
    private final String tank2Position;
    public Grenade2(int x, int y, String tank2Position) {
        super(x, y);
        this.tank2Position = tank2Position;

        initGrenade2(tank2Position);
    }
    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    private void initGrenade2(String tank2Position) {
        if(tank2Position == "tank2Down.png"){
            loadImage("grenadeDown.png");
        }
        else if(tank2Position == "tank2Up.png"){

            loadImage("grenadeUp.png");
            getImageDimensions();
        }
        else if (tank2Position == "tank2Left.png"){
            loadImage("grenadeLeft.png");
            getImageDimensions();
        }
        else if (tank2Position == "tank2Right.png"){
            loadImage("grenadeRight.png");
            getImageDimensions();
        }

    }

    public void
    move() {
        if(tank2Position == "tank2Down.png"){
            y += GRENADE_SPEED;
            if (y > BOARD_HEIGHT) {
                visible = false;
            }
        }
        else if(tank2Position == "tank2Up.png"){
            y -= GRENADE_SPEED;
            if (y + height < 0) {
                visible = false;
            }
        }
        else if (tank2Position == "tank2Left.png"){
            x -= GRENADE_SPEED;
            if (x + width  < 0) {
                visible = false;
            }
        }
        else if (tank2Position == "tank2Right.png"){
            x += GRENADE_SPEED;
            if (x > BOARD_WIDTH) {
                visible = false;
            }
        }

    }
}
