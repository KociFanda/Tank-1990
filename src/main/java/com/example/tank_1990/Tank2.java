package com.example.tank_1990;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;

public class Tank2 extends Entita {
    public boolean isColliding = false;
    private int dx;
    private int dy;
    private List<GrenadeRight> grenadesR;
    private List<GrenadeLeft> grenadesL;
    private List<GrenadeUp> grenadesU;
    private List<GrenadeDown> grenadesD;
    private String imageName;

    public Tank2(int x, int y) {
        super(x, y);

        initTank2();
    }

    private void initTank2() {
        grenadesR = new ArrayList<>();
        grenadesL = new ArrayList<>();
        grenadesU = new ArrayList<>();
        grenadesD = new ArrayList<>();

        loadImage("tank2Left.png");
        imageName = "tank2Left.png";
        getImageDimensions();
    }

    public void move() {
        x += dx;
        y += dy;
    }

    public List<GrenadeRight> getGrenadesR() {
        return grenadesR;
    }

    public List<GrenadeLeft> getGrenadesL() {
        return grenadesL;
    }

    public List<GrenadeUp> getGrenadesU() {
        return grenadesU;
    }

    public List<GrenadeDown> getGrenadesD() {
        return grenadesD;
    }

    public void keyPressed(KeyEvent e, String tankPosition) {

        if (!isColliding) {

            KeyCode key = e.getCode();

            if (key == KeyCode.SHIFT) {
                if (imageName == "tank2Right.png") {
                    fireRight();
                }
                if (imageName == "tank2Left.png") {
                    fireLeft();
                }
                if (imageName == "tank2Up.png") {
                    fireUp();
                }
                if (imageName == "tank2Down.png") {
                    fireDown();
                }
            }

            if (key == KeyCode.A) {
                dx = -2;
                dy = 0;
                loadImage("tank2Left.png");
                imageName = "tankLeft.png";
                getImageDimensions();
            }

            if (key == KeyCode.D) {
                dx = 2;
                dy = 0;
                loadImage("tank2Right.png");
                imageName = "tankRight.png";
                getImageDimensions();
            }

            if (key == KeyCode.W) {
                dy = -2;
                dx = 0;
                loadImage("tank2Up.png");
                imageName = "tankUp.png";
                getImageDimensions();
            }

            if (key == KeyCode.S) {
                dy = 2;
                dx = 0;
                loadImage("tank2Down.png");
                imageName = "tankDown.png";
                getImageDimensions();
            }
        }
    }

    public String getImageName() {
        return imageName;
    }

    public void fireRight() {
        grenadesR.add(new GrenadeRight(x + width, y + height / 2));
    }

    public void fireLeft() {
        grenadesL.add(new GrenadeLeft(x - width / 2, y + height / 2));
    }

    public void fireUp() {
        grenadesU.add(new GrenadeUp(x + width / 2, y - height / 2));
    }

    public void fireDown() {
        grenadesD.add(new GrenadeDown(x + width / 2, y + height));
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
