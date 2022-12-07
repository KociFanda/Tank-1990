package com.example.tank_1990;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;

public class Tank extends Entita {
    private int dx;
    private int dy;
    private List<GrenadeRight> grenadesR;
    private List<GrenadeLeft> grenadesL;
    private List<GrenadeUp> grenadesU;
    private List<GrenadeDown> grenadesD;
    private String imageName;

    public Tank(int x, int y) {
        super(x, y);

        initTank();
    }

    private void initTank() {
        grenadesR = new ArrayList<>();
        grenadesL = new ArrayList<>();
        grenadesU = new ArrayList<>();
        grenadesD = new ArrayList<>();

        loadImage("tankLeft.png");
        imageName = "tankLeft.png";
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

        if (key == KeyCode.LEFT) {
            dx = -2;
            dy = 0;
            loadImage("tankLeft.png");
            imageName = "tankLeft.png";
            getImageDimensions();
        }

        if (key == KeyCode.RIGHT) {
            dx = 2;
            dy = 0;
            loadImage("tankRight.png");
            imageName = "tankRight.png";
            getImageDimensions();
        }

        if (key == KeyCode.UP) {
            dy = -2;
            dx = 0;
            loadImage("tankUp.png");
            imageName = "tankUp.png";
            getImageDimensions();
        }

        if (key == KeyCode.DOWN) {
            dy = 2;
            dx = 0;
            loadImage("tankDown.png");
            imageName = "tankDown.png";
            getImageDimensions();
        }
    }

    public String getImageName() {
        return imageName;
    }

    public void fireRight() {
        grenadesR.add(new GrenadeRight(x + width, y + height / 2));
    }

    public void fireLeft() {
        grenadesL.add(new GrenadeLeft(x - width / 2, y + height / 2 ));
    }

    public void fireUp() {
        grenadesU.add(new GrenadeUp(x + width / 2, y - height / 2));
    }

    public void fireDown() {
        grenadesD.add(new GrenadeDown(x + width / 2, y + height ));
    }

    public void keyReleased(KeyEvent e) {
        KeyCode key = e.getCode();
        if (key == KeyCode.LEFT) {
            dx = 0;
        }

        if (key == KeyCode.RIGHT) {
            dx = 0;
        }

        if (key == KeyCode.UP) {
            dy = 0;
        }

        if (key == KeyCode.DOWN) {
            dy = 0;
        }
    }
}
