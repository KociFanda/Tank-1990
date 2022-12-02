package com.example.tank_1990;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;

public class Tank extends Entita {
    private int dx;
    private int dy;
    private List<Grenade> grenades;

    public Tank(int x, int y) {
        super(x, y);

        initTank();
    }

    private void initTank() {

        grenades = new ArrayList<>();

        loadImage("tank.jpg");
        getImageDimensions();
    }

    public void move() {
        x += dx;
        y += dy;
    }

    public List<Grenade> getGrenades() {
        return grenades;
    }

    public void keyPressed(KeyEvent e) {

        KeyCode key = e.getCode();

        if (key == KeyCode.SPACE) {
            fire();
        }

        if (key == KeyCode.LEFT) {
            dx = -2;
        }

        if (key == KeyCode.RIGHT) {
            dx = 2;
        }

        if (key == KeyCode.UP) {
            dy = -2;
        }

        if (key == KeyCode.DOWN) {
            dy = 2;
        }
    }

    public void fire() {
        grenades.add(new Grenade(x + width, y + height / 2));
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
