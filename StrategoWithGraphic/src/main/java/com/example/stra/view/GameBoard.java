package com.example.stra.view;

import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class
GameBoard extends GridPane {
    private static final int WIDTH = 800;
    private static final int HEIGHT = WIDTH;

    private static final int ROWS = 10;
    private static final int COLUMNS =  10;

    private static final int SQUARE_SIZE = WIDTH/ROWS;
    private Button[][] board = new Button[10][10];



    public Button get(int i, int j){
        return board[i][j];
    }


    public GameBoard(){
        super();
        this.setHgap(10);
        this.setVgap(10);
        for(int i=0; i<10; ++i){
            for(int j=0; j<10; ++j){
                Button b = new Button();
                board[i][j] = b;
                b.setPrefSize(SQUARE_SIZE, SQUARE_SIZE);
                this.add(b, j, i);
            }
        }

        for(int i=4; i<=5; ++i){
            for(int j=2; j<=7; ++j){
                if(j >= 4 && j<= 5) continue;
                board[i][j].setBackground(new Background(new BackgroundFill(Color.CYAN, null, null)));
            }
        }
    }
    public void boardColor(Color color){
        if (Color.BLUE.equals(color)) {
            blue();
        } else if (Color.RED.equals(color)) {
            red();
        }
    }

    public void blue(){
        for(int i=0; i<4; ++i){
            for(int j=0; j<10; ++j){
                board[i][j].setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
            }
        }

        for(int i=6; i<10; ++i){
            for(int j=0; j<10; ++j){
                board[i][j].setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
            }
        }
    }
    public void red(){
        for(int i=0; i<4; ++i){
            for(int j=0; j<10; ++j){
                board[i][j].setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
            }
        }

        for(int i=6; i<10; ++i){
            for(int j=0; j<10; ++j){
                board[i][j].setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
            }
        }
    }





    public void setText(int i, int j, String name){
        Button tmp = board[i][j];
        tmp.setText(name);
    }
    public void change(int i, int j, int nextI, int nextJ){
        System.out.println("hi");
        Button b = board[i][j];
        this.getChildren().remove(board[i][j]);
        board[nextI][nextJ] = b;
        board[i][j] = new Button();
        board[i][j].setPrefSize(80, 80);
        this.add(board[i][j], j, i);
        this.add(board[nextI][nextJ], nextJ, nextI);
    }

}
