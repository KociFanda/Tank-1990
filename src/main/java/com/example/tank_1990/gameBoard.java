package com.example.tank_1990;

import javafx.animation.AnimationTimer;
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

public class gameBoard  {

    private final int ITANK_X = 40;
    private final int ITANK_Y = 60;
    private Tank tank;
    private Canvas canvas;
    Image nejakyImage;
    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), e-> step()));

    public gameBoard() {
        this.canvas = new Canvas(1200,800);
        GraphicsContext gc = this.canvas.getGraphicsContext2D();
        gc.setFill(Color.BEIGE);
        gc.fillRect(0,0, canvas.getWidth(), canvas.getHeight());
        initBoard();
    }

    private void handle() {
    timeline.setCycleCount(Timeline.INDEFINITE);
    GraphicsContext gc = this.canvas.getGraphicsContext2D();
    gc.setFill(Color.BEIGE);
    gc.fillRect(0,0, canvas.getWidth(), canvas.getHeight());
    timeline.play();
    }



    private void initBoard() {

        canvas.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                tank.keyPressed(keyEvent);
            }
        });
        canvas.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                tank.keyReleased(keyEvent);
            }
        });

        tank = new Tank(ITANK_X,ITANK_Y);
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
        gc.fillRect(0,0, canvas.getWidth(), canvas.getHeight());

        gc.setStroke(Color.BEIGE);
        gc.setLineWidth(20);
       gc.strokeRect(tank.getX()-15, tank.getY()-15, tank.getImage().getWidth()+4, tank.getImage().getHeight()+6);
        gc.drawImage(tank.getImage(), tank.getX(), tank.getY());

        List<Grenade> grenades = tank.getGrenades();

        for (int i = 0; i < grenades.size(); i++) {
            Grenade grenade = grenades.get(i);
            gc.setStroke(Color.BEIGE);
            gc.setLineWidth(3);
            gc.strokeLine(grenade.getX() - 3, grenade.getY(), grenade.getX() - 3, grenade.getY() + grenade.height);
            gc.drawImage(grenade.getImage(), grenade.getX(), grenade.getY());
        }
    }

    private void updateGrenade() {

        List<Grenade> grenades = tank.getGrenades();
        for (int i = 0; i < grenades.size(); i++) {
            Grenade grenade = grenades.get(i);
            if (grenade.isVisible()) {
                grenade.move(tank);
            } else {
                grenades.remove(i);
            }
        }
    }

    private void updateTank() {

        tank.move();

    }

}
