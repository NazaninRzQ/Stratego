package com.example.stra.controller;


import com.example.stra.model.Gamee;
import com.example.stra.model.Piece;
import com.example.stra.view.GameBoard;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class GameBoardController {
    private GameBoard board = new GameBoard();
    private Gamee gamee;
    private Color color;

    public GameBoardController(Color color){
        this.color = color;
        board.boardColor(color);
        gamee = new Gamee(color == Color.RED);


        for(int i=0; i<10; ++i){
            for(int j=0; j<10; ++j){
                Piece p = gamee.get(i, j);

                board.setText(i, j, p == null ? "" : gamee.get(i, j).toString());
            }
        }

        for(int i=0; i<10; ++i){
            for(int j=0; j<10; ++j){
                Button btn = board.get(i, j);
                Background b = btn.getBackground();
                if(b == null) continue;
                for(BackgroundFill f : b.getFills()){
                    if(f.getFill() == color){
                        Action action = new Action(board, gamee);
                        action.chan(i, j, i-1, j);
                        btn.addEventFilter(ActionEvent.ACTION, action);
                    }
                }

            }
        }
    }






    public GameBoard getBoard(){
        return this.board;
    }
}
