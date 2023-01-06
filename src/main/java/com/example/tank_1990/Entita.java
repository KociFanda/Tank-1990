package com.example.tank_1990;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class Entita {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected boolean visible;
    protected Image image;

    public Entita(int x, int y) {

        this.x = x;
        this.y = y;
        visible = true;
    }

    protected void loadImage(String imageName) {

        //ImageIcon ii = new ImageIcon(imageName);
        image = new Image(imageName);
    }

    protected void getImageDimensions() {

        width = (int) image.getWidth();
        height = (int) image.getHeight();
    }
     public Rectangle getRect(){
        return new Rectangle(x, y, width+2, height+2);
     }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
}