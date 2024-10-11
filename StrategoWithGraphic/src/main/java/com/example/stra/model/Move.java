/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.example.stra.model;

/**
 * This enum class is for moving pieces.
 * 
 * @author Nazanin Rezaee
 */
public enum Move {
    UP(-1 , 0),
    DOWN( 1 , 0),
    RIGHT(0 , 1),
    LEFT(0 , -1);
    
    
    final int i;
    final int j;
    
    Move(int i , int j){
        this.i = i;
        this.j = j;
    }
    
    /**
     * Select method includes a switch case.
     * @param s is a String type that uses for how to move pieces.
     * @return every case returns appropriate move depends on the enum features.
     */
    
    static Move select(String s){
        switch (s) {
            case "u" :
                return Move.UP;
            case "r" :
                return Move.RIGHT;
            case "b" :
                return Move.DOWN;
            case "l" :
                return Move.LEFT;
        }
        return null;
    }
}
