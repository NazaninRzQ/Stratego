package com.example.stra.controller;

import com.example.stra.model.Gamee;
import com.example.stra.view.GameBoard;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.Random;

public class Action2 implements EventHandler<ActionEvent> {
    private GameBoard board;
    private Gamee gamee;
    private int i;
    private int j;
    private int nextI;
    private int nextJ;

    public void change(int i, int j, int nextI, int nextJ){
        this.i = i;
        this.j = j;
        this.nextI = nextI;
        this.nextJ = nextJ;
    }


    public Action2(GameBoard board, Gamee gamee){
        this.board = board;
        this.gamee = gamee;
    }

    @Override
    public void handle(ActionEvent event) {
        gamee.move(i, j, nextI, nextJ, board);
        Random random = new Random();
        int j = random.nextInt(10);
        while(j == 2 || j == 6|| j ==7){
            j = random.nextInt(10);
        }
        int i = 3;
        board.change(i, j, i+1, j);
    }
}
