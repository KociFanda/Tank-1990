package com.example.tank_1990;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class StartGame extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Tank1990");

        gameBoard board = new gameBoard();
        Scene scene = new Scene(new Pane(board.getCanvas()));
        board.getCanvas().requestFocus();
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}