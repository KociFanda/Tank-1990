package com.example.tank_1990;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;

public class Tank extends Entita {
    public boolean isCollidingUp = false;
    public boolean isCollidingDown = false;
    public boolean isCollidingLeft = false;
    public boolean isCollidingRight = false;
    private int dx;
    private int dy;
    private List<Grenade> grenades;
    private String imageName;
    public int HP = 3;

    public Tank(int x, int y) {
        super(x, y);

        initTank();
    }

    private void initTank() {
        grenades = new ArrayList<>();

        loadImage("tankLeft.png");
        imageName = "tankLeft.png";
        getImageDimensions();
    }

    public void move() {
        x += dx;
        y += dy;
    }

    public List<Grenade> getGrenades() {
        return grenades;
    }


    public void keyPressed(KeyEvent e, Tank tank, Tank2 tank2) {
            KeyCode key = e.getCode();
            if (key == KeyCode.SPACE) {
                if (imageName == "tankRight.png") {
                    fireRight();
                }
                if (imageName == "tankLeft.png") {
                    fireLeft();
                }
                if (imageName == "tankUp.png") {
                    fireUp();
                }
                if (imageName == "tankDown.png") {
                    fireDown();
                }
            }

            if (key == KeyCode.A && isCollidingLeft == false) {
                dx = -3;
                dy = 0;
                loadImage("tankLeft.png");
                imageName = "tankLeft.png";
                getImageDimensions();
                isCollidingRight= false;
                isCollidingUp= false;
                isCollidingDown= false;
                isCollidingLeft= false;
            }

            if (key == KeyCode.D && isCollidingRight == false) {
                dx = 3;
                dy = 0;
                loadImage("tankRight.png");
                imageName = "tankRight.png";
                getImageDimensions();
                isCollidingRight= false;
                isCollidingUp= false;
                isCollidingDown= false;
                isCollidingLeft= false;
            }

            if (key == KeyCode.W && isCollidingUp == false) {
                dy = -3;
                dx = 0;
                loadImage("tankUp.png");
                imageName = "tankUp.png";
                getImageDimensions();
                isCollidingRight= false;
                isCollidingUp= false;
                isCollidingDown= false;
                isCollidingLeft= false;
            }

            if (key == KeyCode.S && isCollidingDown == false) {
                dy = 3;
                dx = 0;
                loadImage("tankDown.png");
                imageName = "tankDown.png";
                getImageDimensions();
                isCollidingRight= false;
                isCollidingUp= false;
                isCollidingDown= false;
                isCollidingLeft= false;
            }
        if(tank.getX() <= 0){
            tank.setDx(0);
        }
        }


    public String getImageName() {
        return imageName;
    }

    public void fireRight() {
        grenades.add(new Grenade(x + width, y + height / 2, imageName));
    }

    public void fireLeft() {
        grenades.add(new Grenade(x - width / 2, y + height / 2, imageName));
    }

    public void fireUp() {
        grenades.add(new Grenade(x + width / 2, y - height / 2, imageName));
    }

    public void fireDown() {
        grenades.add(new Grenade(x + width / 2, y + height, imageName));
    }

    public void keyReleased(KeyEvent e) {
        KeyCode key = e.getCode();
        if (key == KeyCode.A) {
            dx = 0;
        }

        if (key == KeyCode.D) {
            dx = 0;
        }

        if (key == KeyCode.W) {
            dy = 0;
        }

        if (key == KeyCode.S) {
            dy = 0;
        }
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

}
