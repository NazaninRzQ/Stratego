package com.example.stra.model;

import com.example.stra.view.GameBoard;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Gamee {
    private Piece[][] board = new Piece[10][10];
    private Player gamer;
    private Player computer;



    // true for red
    public Gamee(boolean flag){
        RedPlayer r = new RedPlayer();
        BluePlayer b = new BluePlayer();
        if(flag){
            gamer = r;
            computer = b;
        }else {
            gamer = b;
            computer = r;
        }


        try {
            fillBoard();
        }catch (FileNotFoundException e){

        }




    }

    public Piece get(int i, int j){
        return board[i][j];
    }

    public void fillBoard() throws FileNotFoundException {


        Scanner sc = new Scanner(new FileInputStream("input.txt"));

        for(int i=0 ; i<40 ; i++){

            String line = sc.nextLine();
            String[] str = line.split(",");
//            System.out.println(line);
            String name = str[0];
            int x = Integer.parseInt(str[1]);
            int y = Integer.parseInt(str[2]);




            Piece pi = gamer.remove(name);
            if(pi != null){
                board[10-x][y-1] = pi;
            }else {
                --i;
                System.out.println("hi");
            }

        }

        for(int i=0 ; i<10 ; i++){
            for(int j=0 ; j<4 ; j++){
                Piece pi = computer.remove();
                board[j][i] = new EnemyPiece(pi);
            }
        }


    }

    public boolean isRiver(int i, int j){
        return i>=4 && i<=5  && j>=2 && j<=3 || i>=4 && i<=5 && j>=6 && j<=7;
    }


    public void change(int i, int j, int nextI, int nextJ){
        Piece p = board[i][j];
        board[i][j] = null;
        board[nextI][nextJ] = p;
    }

    public int move(int i, int j, int nextI, int nextJ, GameBoard b){
        return board[i][j].move(i, j, nextI, nextJ, this, b);
    }
}
