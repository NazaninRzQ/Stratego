package com.example.stra.controller;

import com.example.stra.view.Start;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class StartController {
    private Start start = new Start();

    public StartController(Stage stage){
        start.getStartBtn().setOnAction(eve -> {
            Stage newStage = new Stage();
            stage.hide();
            GameBoardController boardController = new GameBoardController((Color)getStat().getGroup().getSelectedToggle().getUserData());
            Scene scene = new Scene(boardController.getBoard());
            newStage.setScene(scene);
            newStage.show();
        });
    }




    public Start getStat(){
        return this.start;
    }


}
