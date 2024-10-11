package com.example.stra.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Start extends VBox {
    private Label lbl = new Label("Welcome to my game");
    private RadioButton redBtn = new RadioButton("red");
    private RadioButton blueBtn = new RadioButton("blue");
    private Button startBtn = new Button("start");
    private ToggleGroup group = new ToggleGroup();



    public Start(){
        HBox box = new HBox(20);
        box.getChildren().addAll(redBtn, blueBtn);
        box.setAlignment(Pos.CENTER);
        group.getToggles().addAll(this.redBtn, this.blueBtn);
        this.redBtn.setUserData(Color.RED);
        this.blueBtn.setUserData(Color.BLUE);
        this.setSpacing(20);
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(this.lbl, box, startBtn);
    }


    public Label getLbl() {
        return lbl;
    }

    public RadioButton getRedBtn() {
        return redBtn;
    }

    public RadioButton getBlueBtn() {
        return blueBtn;
    }

    public Button getStartBtn() {
        return startBtn;
    }
    public ToggleGroup getGroup(){
        return this.group;
    }
}
