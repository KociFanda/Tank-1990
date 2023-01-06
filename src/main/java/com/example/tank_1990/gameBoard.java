package com.example.tank_1990;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.List;

public class gameBoard {

    private final int ITANK_X = 40;
    private final int ITANK_Y = 60;
    public Tank tank;
    public Tank2 tank2;
    private Canvas canvas;
    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), e -> step()));
    String tankPosition;
    String tank2Position;

    public gameBoard() {
        this.canvas = new Canvas(1200, 800);
        GraphicsContext gc = this.canvas.getGraphicsContext2D();
        gc.setFill(Color.BEIGE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        initBoard();
    }

    private void handle() {
        timeline.setCycleCount(Timeline.INDEFINITE);
        GraphicsContext gc = this.canvas.getGraphicsContext2D();
        gc.setFill(Color.BEIGE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        timeline.play();
    }


    private void initBoard() {
        canvas.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                tank.keyPressed(keyEvent, tank, tank2);

                tank2.keyPressed(keyEvent, tank, tank2);
            }});
        canvas.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                tank.keyReleased(keyEvent);
                tank2.keyReleased(keyEvent);
            }});

        tank = new Tank(ITANK_X, ITANK_Y);
        tank2 = new Tank2(500,600, tank2Position);
        this.handle();
    }

    public Canvas getCanvas() {
        return canvas;
    }


    private void step() {
        tankPosition = tank.getImageName();
        tank2Position = tank2.getImageName();
        this.updateGrenade();
        this.updateTank();
        this.updateTank2();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BEIGE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setStroke(Color.BEIGE);
        gc.setLineWidth(3);

        gc.strokeRect(tank.getX(), tank.getY(), tank.getImage().getWidth() + 4, tank.getImage().getHeight() + 6);
        gc.drawImage(tank.getImage(), tank.getX(), tank.getY());

        gc.strokeRect(tank2.getX(), tank2.getY(), tank2.getImage().getWidth() + 4, tank2.getImage().getHeight() + 6);
        gc.drawImage(tank2.getImage(), tank2.getX(), tank2.getY());

        List<Grenade> grenadeR = tank.getGrenades();
        for (int i = 0; i < grenadeR.size(); i++) {
            Grenade grenade1 = grenadeR.get(i);
            gc.drawImage(grenade1.getImage(), grenade1.getX(), grenade1.getY());
        }

        List<Grenade> grenadeL = tank.getGrenades();
        for (int i = 0; i < grenadeL.size(); i++) {
            Grenade grenade2 = grenadeL.get(i);
            gc.drawImage(grenade2.getImage(), grenade2.getX(), grenade2.getY());
        }

        List<Grenade> grenadeU = tank.getGrenades();
        for (int i = 0; i < grenadeU.size(); i++) {
            Grenade grenade3 = grenadeU.get(i);
            gc.drawImage(grenade3.getImage(), grenade3.getX(), grenade3.getY());
        }

        List<Grenade> grenadeD = tank.getGrenades();
        for (int i = 0; i < grenadeD.size(); i++) {
            Grenade grenade4 = grenadeD.get(i);
            gc.drawImage(grenade4.getImage(), grenade4.getX(), grenade4.getY());
        }

        List<Grenade2> grenade2R = tank2.getGrenades2();
        for (int i = 0; i < grenade2R.size(); i++) {
            Grenade2 grenadeDruhéhotanku1 = grenade2R.get(i);
            gc.drawImage(grenadeDruhéhotanku1.getImage(), grenadeDruhéhotanku1.getX(), grenadeDruhéhotanku1.getY());
        }

        List<Grenade2> grenade2L = tank2.getGrenades2();
        for (int i = 0; i < grenade2L.size(); i++) {
            Grenade2 grenadeDruhéhotanku2 = grenade2L.get(i);
            gc.drawImage(grenadeDruhéhotanku2.getImage(), grenadeDruhéhotanku2.getX(), grenadeDruhéhotanku2.getY());
        }

        List<Grenade2> grenade2U = tank2.getGrenades2();
        for (int i = 0; i < grenade2U.size(); i++) {
            Grenade2 grenadeDruhéhotanku3 = grenade2U.get(i);
            gc.drawImage(grenadeDruhéhotanku3.getImage(), grenadeDruhéhotanku3.getX(), grenadeDruhéhotanku3.getY());
        }

        List<Grenade2> grenade2D = tank2.getGrenades2();
        for (int i = 0; i < grenade2D.size(); i++) {
            Grenade2 grenadeDruhéhotanku4 = grenade2D.get(i);
            gc.drawImage(grenadeDruhéhotanku4.getImage(), grenadeDruhéhotanku4.getX(), grenadeDruhéhotanku4.getY());
        }
    }
    private void updateGrenade() {

        tankPosition = tank.getImageName();
        tank2Position = tank2.getImageName();

        List<Grenade> grenade = tank.getGrenades();
        List<Grenade2> grenade2 = tank2.getGrenades2();

        for (int i = 0; i < grenade.size(); i++) {
            Grenade grenade11 = grenade.get(i);
            if (grenade11.isVisible()) {

                grenade11.move();
            } else {
                grenade.remove(i);
            }
            if (grenade.get(i).getRect().intersects(tank2.getRect().getBoundsInParent())) {
                grenade.remove(grenade.get(i));
                System.out.println("hit 2");
            }
        }

        for (int i = grenade2.size() - 1; i >= 0; i--) {
            Grenade2 grenade22 = grenade2.get(i);
            if (grenade22.isVisible()) {

                grenade22.move();
            } else {
                grenade2.remove(grenade2.get(i));
            }
            if (grenade2.get(i).getRect().intersects(tank.getRect().getBoundsInParent())) {
                grenade2.remove(grenade2.get(i));
                System.out.println("hit 1");
            }
        }
    }


    private void updateTank() {
        tank.move();
        checkCollisionTank();
    }
    private void updateTank2() {
        tank2.move();
        checkCollisionTank2();
    }
    public void checkCollisionTank() {
        if (tank.getRect().getBoundsInParent().intersects(tank2.getRect().getBoundsInParent())) {
            tank.setDx(0);
            tank.setDy(0);

            if (tankPosition.equals("tankUp.png")) {
                tank.isCollidingUp = true;
                tank.isCollidingDown = false;
                tank.isCollidingLeft = false;
                tank.isCollidingRight = false;
            }
            if (tankPosition.equals("tankDown.png")) {
                tank.isCollidingDown = true;
                tank.isCollidingLeft = false;
                tank.isCollidingRight = false;
                tank.isCollidingUp = false;
            }
            if (tankPosition.equals("tankLeft.png")) {
                tank.isCollidingLeft = true;
                tank.isCollidingRight = false;
                tank.isCollidingUp = false;
                tank.isCollidingDown = false;
            }
            if (tankPosition.equals("tankRight.png")) {
                tank.isCollidingRight = true;
                tank.isCollidingUp = false;
                tank.isCollidingDown = false;
                tank.isCollidingLeft = false;
            }
        }
    }
        public void checkCollisionTank2() {
      if (tank2.getRect().getBoundsInParent().intersects(tank.getRect().getBoundsInParent()) ) {

            tank2.setDx(0);
            tank2.setDy(0);
        if (tank2Position.equals("tank2Up.png")) {
            tank2.isCollidingUp= true;
            tank2.isCollidingDown= false;
            tank2.isCollidingLeft= false;
            tank2.isCollidingRight= false;
        }
        if (tank2Position.equals("tank2Down.png")) {
            tank2.isCollidingDown= true;
            tank2.isCollidingLeft= false;
            tank2.isCollidingRight= false;
            tank2.isCollidingUp= false;
        }
        if (tank2Position.equals("tank2Left.png")) {
            tank2.isCollidingLeft= true;
            tank2.isCollidingRight= false;
            tank2.isCollidingUp= false;
            tank2.isCollidingDown= false;
        }
        if (tank2Position.equals("tank2Right.png")) {
            tank2.isCollidingRight= true;
            tank2.isCollidingUp= false;
            tank2.isCollidingDown= false;
            tank2.isCollidingLeft= false;}
      }
        }

    }

