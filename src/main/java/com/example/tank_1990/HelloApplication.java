package com.example.tank_1990;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 820, 640);
        Canvas canvas = new Canvas(820,640);
        Scene scene = new Scene(new Pane(canvas));
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BEIGE);
        gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
        stage.setScene(scene);
        stage.setTitle("Tank1990");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}