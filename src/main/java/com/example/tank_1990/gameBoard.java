package com.example.tank_1990;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.util.Duration;
import java.util.List;

public class gameBoard {
    private final int ITANK_X = 40;
    private final int ITANK_Y = 60;
    private final int ITANK2_Y = 800;
    private final int ITANK2_X =600;
    public Tank tank;
    public Tank2 tank2;
    private final Canvas canvas;
    private int zivoty1= 3;
    private int zivoty2= 3;
    private int respawnTimer=1000;
    Image background = new Image("background.png");
    Font Mujfont = new Font("Arial", 20);
    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), e -> step()));
    String tankPosition, tank2Position;
    Rectangle barak = new Rectangle(0, 258, 70, 163);
    //Random rnd


    public gameBoard() {
        this.canvas = new Canvas(1200, 600);
        GraphicsContext gc = this.canvas.getGraphicsContext2D();
        gc.drawImage(background, 0, 0);
        initBoard();
    }

    private void handle() {
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void initBoard() {
        canvas.setOnKeyPressed(keyEvent -> {
            tank.keyPressed(keyEvent);
            tank2.keyPressed(keyEvent);
        });
        canvas.setOnKeyReleased(keyEvent -> {
            tank.keyReleased(keyEvent);
            tank2.keyReleased(keyEvent);
        });

        tank = new Tank(ITANK_X, ITANK_Y);
        tank2 = new Tank2(ITANK2_X, ITANK2_Y);
        this.handle();
    }

    public Canvas getCanvas() {return canvas;}

    private void step() {
        tankPosition = tank.getImageName();
        tank2Position = tank2.getImageName();
        this.updateGrenade();
        if (isTankDead()){this.updateTank();}
        else{
            respawnTimer--;
        if (respawnTimer<=0){
            tank.HP = 3;
            respawnTimer=600;
            zivoty1=3;
            tank.setX(800);
            tank.setY(800);
        }}
        if (isTank2Dead()){this.updateTank2();}  else{
            respawnTimer--;
            if (respawnTimer<=0){
                tank2.HP = 3;
                respawnTimer=600;
                zivoty2=3;
                tank.setX(500);
                tank.setY(500);
            }}

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFont(Mujfont);
        gc.drawImage(background, 0, 0);


        if (isTankDead()) {
            gc.setStroke(Color.BEIGE);
            gc.drawImage(tank.getImage(), tank.getX(), tank.getY());
            gc.setStroke(Color.WHITE);
            gc.strokeText("Player 1\nŽivoty " + zivoty1, tank.getX(), tank.getY() - 28);

            List<Grenade> grenadeR = tank.getGrenades();
            for (Grenade grenade1 : grenadeR) {
                gc.drawImage(grenade1.getImage(), grenade1.getX(), grenade1.getY());
            }

            List<Grenade> grenadeL = tank.getGrenades();
            for (Grenade grenade2 : grenadeL) {
                gc.drawImage(grenade2.getImage(), grenade2.getX(), grenade2.getY());
            }

            List<Grenade> grenadeU = tank.getGrenades();
            for (Grenade grenade3 : grenadeU) {
                gc.drawImage(grenade3.getImage(), grenade3.getX(), grenade3.getY());
            }

            List<Grenade> grenadeD = tank.getGrenades();
            for (Grenade grenade4 : grenadeD) {
                gc.drawImage(grenade4.getImage(), grenade4.getX(), grenade4.getY());
            }
        }
        if (isTank2Dead()) {
            gc.setStroke(Color.BEIGE);

            gc.drawImage(tank2.getImage(), tank2.getX(), tank2.getY());
            gc.setStroke(Color.WHITE);
            gc.strokeText("Player 2 \nŽivoty " + zivoty2, tank2.getX(), tank2.getY() -28);

            List<Grenade2> grenade2R = tank2.getGrenades2();
            for (Grenade2 grenadeDruhehotanku1 : grenade2R) {
                gc.drawImage(grenadeDruhehotanku1.getImage(), grenadeDruhehotanku1.getX(), grenadeDruhehotanku1.getY());
            }

            List<Grenade2> grenade2L = tank2.getGrenades2();
            for (Grenade2 grenadeDruhehotanku2 : grenade2L) {
                gc.drawImage(grenadeDruhehotanku2.getImage(), grenadeDruhehotanku2.getX(), grenadeDruhehotanku2.getY());
            }

            List<Grenade2> grenade2U = tank2.getGrenades2();
            for (Grenade2 grenadeDruhéhotanku3 : grenade2U) {
                gc.drawImage(grenadeDruhéhotanku3.getImage(), grenadeDruhéhotanku3.getX(), grenadeDruhéhotanku3.getY());
            }

            List<Grenade2> grenade2D = tank2.getGrenades2();
            for (Grenade2 grenadeDruhéhotanku4 : grenade2D) {
                gc.drawImage(grenadeDruhéhotanku4.getImage(), grenadeDruhéhotanku4.getX(), grenadeDruhéhotanku4.getY());
            }
        }

    }

    private void updateGrenade() {
        tankPosition = tank.getImageName();
        tank2Position = tank2.getImageName();
        List<Grenade> grenade = tank.getGrenades();
        List<Grenade2> grenade2 = tank2.getGrenades2();
            if(isTankDead()) {
                for (int i = 0; i < grenade.size(); i++) {
                    Grenade grenade11 = grenade.get(i);
                    if (grenade11.isVisible()) {
                        grenade11.move();
                    } else {grenade.remove(i);}

                    if (grenade.get(i).getRect().intersects(tank2.getRect().getBoundsInParent()) && isTank2Dead()) {
                        grenade.remove(grenade.get(i));
                        System.out.println("Tank 1 trefil tank 2");
                        tank2.HP = tank2.HP - 1;

                        zivoty2--;
                    }
                }
            }
        if (isTank2Dead()) {
            for (int i = grenade2.size() - 1; i >= 0; i--) {
                Grenade2 grenade22 = grenade2.get(i);
                if (grenade22.isVisible()) {grenade22.move();}

                else {grenade2.remove(grenade2.get(i));}

                if (grenade2.get(i).getRect().intersects(tank.getRect().getBoundsInParent()) && isTankDead()) {
                    grenade2.remove(grenade2.get(i));
                    System.out.println("Tank 2 trefil tank 1");
                    tank.HP = tank.HP - 1;
                    zivoty1--;
                }
            }
        }
    }

    private void updateTank() {
        tank.move();

       com.example.tank_1990.Utills.Tools.checkCollisionTank(tank, tank2,tankPosition, barak);

    }

    private void updateTank2() {
        tank2.move();
        if (isTankDead()){
            com.example.tank_1990.Utills.Tools.checkCollisionTank2(tank2, tank,tank2Position, barak);}
    }

    public boolean isTankDead() {
        return tank.HP > 0;
    }
    public boolean isTank2Dead() {
        return tank2.HP > 0;
    }
}

