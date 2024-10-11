package com.example.stra.controller;

import com.example.stra.model.Gamee;
import com.example.stra.view.GameBoard;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Action implements EventHandler<ActionEvent> {
    private int i, j, nextI, nextJ;
    private GameBoard board;
    private  Gamee gamee;
    private Action2 action2;
    public Action(GameBoard board, Gamee gamee){
        this.board = board;
        this.gamee = gamee;
        this.action2 = new Action2(board, gamee);
    }


    public void chan(int i, int j, int nextI, int nextJ){
        this.i = i;
        this.j = j;
        this.nextI = nextI;
        this.nextJ = nextJ;
    }


    @Override
    public void handle(ActionEvent event) {
        for(int ii=0; ii<10; ++ii){
            for(int jj=0; jj<10; ++jj){
                board.get(ii, jj).removeEventHandler(ActionEvent.ACTION, this);
                board.get(ii, jj).removeEventHandler(ActionEvent.ACTION, action2);

            }
        }
        action2.change(i,j ,nextI, nextJ);
        board.get(i-1, j).addEventHandler(ActionEvent.ACTION, action2);

    }
}
