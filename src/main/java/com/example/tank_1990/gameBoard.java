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
    private final int ITANK2_Y = 1000;
    private final int ITANK2_X =1000;
    public Tank tank;
    public Tank2 tank2;
    private final Canvas canvas;
    private int zivoty1= 3;
    private int zivoty2= 3;
    private int respawnTimer=1000;
    Image background = new Image("background.png");
    Image exploze1 = new Image("exploze1.png");
    Image exploze2 = new Image("exploze2.png");
    Image exploze3= new Image("exploze3.png");
    Image exploze4 = new Image("exploze4.png");

    Font Mujfont = new Font("Arial", 20);
    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(7), e -> step()));
    String tankPosition, tank2Position;
    Rectangle barak = new Rectangle(0, 258, 70, 163);
    public int fireCooldown =10;
    public int fireCooldown2 =10;
    private int trvaniExploze1Tank1 = 0;
    private int trvaniExploze1Tank2 = 0;
    private int trvaniExploze4Tank1 = 0;
    private int trvaniExploze4Tank2 = 0;

    public gameBoard() {
        this.canvas = new Canvas(1200, 1000);
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
            tank.keyPressed(keyEvent, fireCooldown);
            tank2.keyPressed(keyEvent, fireCooldown2);
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
        fireCooldown--;
        fireCooldown2--;

        if (isTankDead()){this.updateTank();}
        else{
            respawnTimer--;
        if (respawnTimer<=0){
            tank.HP = 3;
            respawnTimer=600;
            zivoty1=3;
            tank.setX(800);
            tank.setY(800);
            trvaniExploze1Tank1 = 0;
        }}
        if (isTank2Dead()){this.updateTank2();}
        else{
            respawnTimer--;
            if (respawnTimer<=0){
                tank2.HP = 3;
                respawnTimer=600;
                zivoty2=3;
                tank2.setX(1000);
                tank2.setY(1000);
                trvaniExploze1Tank2 = 0;
            }}

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFont(Mujfont);
        gc.drawImage(background, 0, 0);

        gc.setStroke(Color.WHITE);
        gc.strokeText("Player 1\nŽivoty " + zivoty1, 500, 30);

        if (isTankDead()) {
            gc.setStroke(Color.BEIGE);
            gc.drawImage(tank.getImage(), tank.getX(), tank.getY());
            gc.setStroke(Color.WHITE);
            gc.strokeText("Player 1\nŽivoty " + zivoty1, tank.getX(), tank.getY() - 28);

            if(trvaniExploze1Tank1 > 0){
                gc.drawImage(exploze1, tank.x, tank.y );
                trvaniExploze1Tank1--;}

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
        else{
            if(trvaniExploze4Tank2 > 0){
                gc.drawImage(exploze4, tank.x  -50, tank.y  -50);
                trvaniExploze4Tank2--;}
        }
        if (isTank2Dead()) {
            gc.setStroke(Color.BEIGE);
            gc.drawImage(tank2.getImage(), tank2.getX(), tank2.getY());
            gc.setStroke(Color.WHITE);
            gc.strokeText("Player 2 \nŽivoty " + zivoty2, tank2.getX(), tank2.getY() -28);
            if(trvaniExploze1Tank2 > 0){
                gc.drawImage(exploze1, tank2.x, tank2.y );
                trvaniExploze1Tank2--;}

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
        else{
            if(trvaniExploze4Tank1 > 0){
                gc.drawImage(exploze4, tank2.x -50, tank2.y -50);
                trvaniExploze4Tank1--;}
        }

    }

    private void updateGrenade() {
        tankPosition = tank.getImageName();
        tank2Position = tank2.getImageName();
        List<Grenade> grenade = tank.getGrenades();
        List<Grenade2> grenade2 = tank2.getGrenades2();


            if(isTankDead()) {
                for (int i = 0; i < grenade.size() ; i++) {
                    Grenade grenade11 = grenade.get(i);
                    if (grenade11.isVisible()) {
                        grenade11.move();
                        fireCooldown =10;}

                    if (grenade.get(i).getRect().intersects(tank2.getRect().getBoundsInParent()) && isTank2Dead()) {
                        System.out.println("Já píšu písmena :)" + grenade.get(i));
                        grenade.remove(grenade.get(i));
                        System.out.println("Tank 1 trefil tank 2");
                        tank2.HP = tank2.HP - 1;
                        zivoty2--;
                        trvaniExploze1Tank2 = 50;
                    }
                    if (grenade.get(i).getRect().intersects(barak.getBoundsInParent())) {
                        grenade.remove(grenade.get(i));}}}

            if (isTank2Dead()) {
            for (int i = grenade2.size() - 1; i >= 0; i--) {
                Grenade2 grenade22 = grenade2.get(i);
                if (grenade22.isVisible()) {
                    grenade22.move();
                    fireCooldown2 =10;}

                if (grenade2.get(i).getRect().intersects(tank.getRect().getBoundsInParent()) && isTankDead()){
                    grenade2.remove(grenade2.get(i));
                    System.out.println("Tank 2 trefil tank 1");
                    tank.HP = tank.HP - 1;
                    zivoty1--;
                    trvaniExploze1Tank1 = 50;
                }
                if (grenade2.get(i).getRect().intersects(barak.getBoundsInParent())) {
                    grenade2.remove(grenade2.get(i));}}}

    }

    private void updateTank() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        tank.move();
        if (isTank2Dead()) {
            com.example.tank_1990.Utills.Tools.checkCollisionTank(tank, tank2, tankPosition, barak);
        }
    }

    private void updateTank2() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        tank2.move();
        if (isTankDead()){
            com.example.tank_1990.Utills.Tools.checkCollisionTank2(tank2, tank,tank2Position, barak);}


    }

    public boolean isTankDead() {
        if (zivoty1 <= 0){
            trvaniExploze4Tank2 = 50;
            return false;
        }
        else {

            return true;}
    }
    public boolean isTank2Dead() {
        if (zivoty2 <= 0){
            trvaniExploze4Tank1 = 50;
            return false;
        }
        else {
            return true;}
    }
}

