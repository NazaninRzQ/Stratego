package com.example.stra;

import com.example.stra.controller.StartController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage){
        var hi = new StartController(stage);
        Scene scene = new Scene(hi.getStat());
        stage.setMinHeight(200);
        stage.setMinWidth(200);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}