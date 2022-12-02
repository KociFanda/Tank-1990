package com.example.tank_1990;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import java.util.List;

public class gameBoard extends AnimationTimer {

    private final int ITANK_X = 40;
    private final int ITANK_Y = 60;
    private Tank tank;
    private Canvas canvas;
    //private final int DELAY = 10;

    public gameBoard() {
        this.canvas = new Canvas(820,640);
        // Canvas je transparentní. Tj. pokud chceme pozadí nějaké barvy, vykreslíme obdelník
        GraphicsContext gc = this.canvas.getGraphicsContext2D();
        gc.setFill(Color.BEIGE);
        gc.fillRect(0,0, canvas.getWidth(), canvas.getHeight());
        initBoard();
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
        //addKeyListener(new TAdapter());
        //setBackground(Color.black);
        //setFocusable(true);

        tank = new Tank(ITANK_X,ITANK_Y);

        //timer = new Timer(DELAY, this);
        this.start();
    }

    public Canvas getCanvas() {
        return canvas;
    }
    @Override
    public void handle(long l) {
        step();
    }

    private void step() {
        this.updateGrenade();
        this.updateTank();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.BEIGE);
        gc.setLineWidth(6);
        gc.strokeRect(tank.getX()-3, tank.getY()-3, tank.getImage().getWidth()+6, tank.getImage().getHeight()+6);
        gc.drawImage(tank.getImage(), tank.getX(), tank.getY());

        List<Grenade> grenades = tank.getGrenades();

        for (Grenade grenade : grenades) {
            gc.setStroke(Color.BEIGE);
            gc.setLineWidth(3);
            gc.strokeLine(missile.getX()-3, missile.getY(), missile.getX()-3, missile.getY()+missile.height);
            gc.drawImage(missile.getImage(), missile.getX(),
                    missile.getY());
        }
        //repaint(spaceShip.getX()-1, spaceShip.getY()-1,
        //        spaceShip.getWidth()+2, spaceShip.getHeight()+2);
    }

    private void updateGrenade() {
        List<Grenade> missiles = tank.getGrenades();
        for (int i = 0; i < missiles.size(); i++) {
            Missile missile = missiles.get(i);
            if (missile.isVisible()) {
                missile.move();
            } else {
                missiles.remove(i);
            }
        }
    }

    private void updateSpaceShip() {
        spaceShip.move();
    }
}
