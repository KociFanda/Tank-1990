package com.example.tank_1990;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;

public class Tank2 extends Entita {
    public boolean isCollidingUp = false;
    public boolean isCollidingDown = false;
    public boolean isCollidingLeft = false;
    public boolean isCollidingRight = false;
    private int dx;
    private int dy;
    private List<Grenade2> grenades2;
    private String imageName;
    private String tank2Position;
    public int HP = 3;

    public Tank2(int x, int y, String tank2Position) {
        super(x, y);
        this.tank2Position = tank2Position;
        initTank2();
    }

    private void initTank2() {
        grenades2 = new ArrayList<>();


        loadImage("tank2Left.png");
        imageName = "tank2Left.png";
        getImageDimensions();
    }

    public void move() {
        x += dx;
        y += dy;
    }

    public List<Grenade2> getGrenades2() {
        return grenades2;
    }

    public void keyPressed(KeyEvent e, Tank tank, Tank2 tank2) {



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

            if (key == KeyCode.LEFT && isCollidingLeft == false) {
                dx = -3;
                dy = 0;
                loadImage("tank2Left.png");
                imageName = "tank2Left.png";
                getImageDimensions();
                isCollidingUp= false;
                isCollidingDown= false;
                isCollidingLeft= false;
                isCollidingRight= false;
            }

            if (key == KeyCode.RIGHT && isCollidingRight == false) {
                dx = 3;
                dy = 0;
                loadImage("tank2Right.png");
                imageName = "tank2Right.png";
                getImageDimensions();
                isCollidingUp= false;
                isCollidingDown= false;
                isCollidingLeft= false;
                isCollidingRight= false;
            }

            if (key == KeyCode.UP && isCollidingUp  == false)  {
                dy = -3;
                dx = 0;
                loadImage("tank2Up.png");
                imageName = "tank2Up.png";
                getImageDimensions();
                isCollidingUp= false;
                isCollidingDown= false;
                isCollidingLeft= false;
                isCollidingRight= false;
            }

            if (key == KeyCode.DOWN && isCollidingDown == false) {
                dy = 3;
                dx = 0;
                loadImage("tank2Down.png");
                imageName = "tank2Down.png";
                getImageDimensions();
                isCollidingUp= false;
                isCollidingDown= false;
                isCollidingLeft= false;
                isCollidingRight= false;
            }
        }


    public String getImageName() {
        return imageName;
    }

    public void fireRight() {
        grenades2.add(new Grenade2(x + width, y + height / 2, imageName));
    }

    public void fireLeft() {
        grenades2.add(new Grenade2(x - width / 2, y + height / 2, imageName));
    }

    public void fireUp() {
        grenades2.add(new Grenade2(x + width / 2, y - height / 2, imageName));
    }

    public void fireDown() {
        grenades2.add(new Grenade2(x + width / 2, y + height, imageName));
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

        if (key == KeyCode.ESCAPE) {
            System.exit(0);
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
