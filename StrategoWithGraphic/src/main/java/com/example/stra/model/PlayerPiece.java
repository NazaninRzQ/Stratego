/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.example.stra.model;

import com.example.stra.view.GameBoard;

/**
 *This enum class implements the Piece interface and
 * includes game's pieces with their features as power, 
 * count and being movable.
 * 
 * @author Nazanin Rezaee
 */
public enum PlayerPiece implements Piece{



    MARSHAL("marshal" , 1 , 1 , true, PieceMoves.MARSHAL),
    GENERAL("general" , 1 , 2 , true, PieceMoves.GENERAL),
    COLONEL("colonel" , 2 , 3 , true, PieceMoves.COLONEL),
    MAJOR("major" , 3 , 4 , true, PieceMoves.MAJOR),
    CAPITAN("capitan" , 4 , 5 , true, PieceMoves.CAPITAN),
    LIEUTENANT("lieutenant" , 4 , 6 , true, PieceMoves.LIEUTENANT),
    SERGEANT("sergeant" , 4 , 7 , true, PieceMoves.SERGEANT),
    MINERS("miners" , 5 , 8 , true, PieceMoves.MINERS),
    SCOUT("scout" , 8 , 9 , true, PieceMoves.SCOUT),
    SPY("spy" , 1 , 10 , true, PieceMoves.SPY),
    BOMB("bomb" , 6 , 11 , false, PieceMoves.BOMB),
    FLAG("flag" , 1 , 0 , false, PieceMoves.FLAG);
    


    private int power;
    private int count;
    
    private String name;
    private boolean isMovable;
    private PieceMove pm;
    
    private PlayerPiece(String name, int count, int power, boolean isMovable, PieceMove pm){
        this.isMovable = isMovable;
        this.name = name;
        this.power = power;
        this.count = count;
        this.pm=pm;
    }

    @Override
    public int power() {
        return this.power;
    }

    @Override
    public int count() {
        return this.count;
    }

    @Override
    public boolean isMovable() {
        return this.isMovable;
    }

    @Override
    public int move(int i, int j, int nextI, int nextJ, Gamee board, GameBoard b) {
        return this.pm.move(i, j, nextI, nextJ, board, b);
    }


    @Override
    public String toString(){
        return this.name;
    }
    
    
}
