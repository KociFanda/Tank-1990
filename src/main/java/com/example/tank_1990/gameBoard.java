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
    private Tank tank;
    private Canvas canvas;
    Image nejakyImage;
    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), e -> step()));
    String tankPosition;

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
                tank.keyPressed(keyEvent, tankPosition);
            }
        });
        canvas.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                tank.keyReleased(keyEvent);
            }
        });

        tank = new Tank(ITANK_X, ITANK_Y);
        this.handle();
    }

    public Canvas getCanvas() {
        return canvas;
    }


    private void step() {
        this.updateGrenade();
        this.updateTank();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BEIGE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setStroke(Color.BEIGE);
        gc.setLineWidth(20);
        gc.strokeRect(tank.getX() - 15, tank.getY() - 15, tank.getImage().getWidth() + 4, tank.getImage().getHeight() + 6);
        gc.drawImage(tank.getImage(), tank.getX(), tank.getY());

        List<GrenadeRight> grenadeR = tank.getGrenadesR();
        for (int i = 0; i < grenadeR.size(); i++) {
            GrenadeRight grenade1 = grenadeR.get(i);
            gc.setStroke(Color.BEIGE);
            gc.setLineWidth(1);
            gc.strokeLine(grenade1.getX() - 3, grenade1.getY(), grenade1.getX() - 3, grenade1.getY() + grenade1.height);
            gc.drawImage(grenade1.getImage(), grenade1.getX(), grenade1.getY());
        }

        List<GrenadeLeft> grenadeL = tank.getGrenadesL();
        for (int i = 0; i < grenadeL.size(); i++) {
            GrenadeLeft grenade2 = grenadeL.get(i);
            gc.setStroke(Color.BEIGE);
            gc.setLineWidth(1);
            gc.strokeLine(grenade2.getX() - 3, grenade2.getY(), grenade2.getX() - 3, grenade2.getY() + grenade2.height);
            gc.drawImage(grenade2.getImage(), grenade2.getX(), grenade2.getY());
        }

        List<GrenadeUp> grenadeU = tank.getGrenadesU();
        for (int i = 0; i < grenadeU.size(); i++) {
            GrenadeUp grenade3 = grenadeU.get(i);
            gc.setStroke(Color.BEIGE);
            gc.setLineWidth(1);
            gc.strokeLine(grenade3.getX() - 3, grenade3.getY(), grenade3.getX() - 3, grenade3.getY() + grenade3.height);
            gc.drawImage(grenade3.getImage(), grenade3.getX(), grenade3.getY());
        }

        List<GrenadeDown> grenadeD = tank.getGrenadesD();
        for (int i = 0; i < grenadeD.size(); i++) {
            GrenadeDown grenade4 = grenadeD.get(i);
            gc.setStroke(Color.BEIGE);
            gc.setLineWidth(1);
            gc.strokeLine(grenade4.getX() - 3, grenade4.getY(), grenade4.getX() - 3, grenade4.getY() + grenade4.height);
            gc.drawImage(grenade4.getImage(), grenade4.getX(), grenade4.getY());
        }

    }

    private void updateGrenade() {

        tankPosition = tank.getImageName();

        List<GrenadeRight> grenadeRight = tank.getGrenadesR();
        List<GrenadeLeft> grenadeLeft = tank.getGrenadesL();
        List<GrenadeUp> grenadeUp = tank.getGrenadesU();
        List<GrenadeDown> grenadeDown = tank.getGrenadesD();


            for (int i = 0; i < grenadeRight.size(); i++) {
                GrenadeRight grenade11 = grenadeRight.get(i);
                if (grenade11.isVisible()) {
                    grenade11.moveRight();
                } else {
                    grenadeRight.remove(i);
                }
            }
            for (int i = 0; i < grenadeLeft.size(); i++) {
                GrenadeLeft grenade22 = grenadeLeft.get(i);
                if (grenade22.isVisible()) {
                    grenade22.moveLeft();
                } else {
                    grenadeLeft.remove(i);
                }
            }
            for (int i = 0; i < grenadeUp.size(); i++) {
                GrenadeUp grenade33 = grenadeUp.get(i);
                if (grenade33.isVisible()) {
                    grenade33.moveUp();
                } else {
                    grenadeUp.remove(i);
                }
            }
            for (int i = 0; i < grenadeDown.size(); i++) {
                GrenadeDown grenade44 = grenadeDown.get(i);
                if (grenade44.isVisible()) {
                    grenade44.moveDown();
                } else {
                    grenadeDown.remove(i);
                }
            }

    }


    private void updateTank() {

        tank.move();

    }

}
