/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.stra.model;

import com.example.stra.view.GameBoard;

/**
 *This interface implements common features that all the pieces have.
 * and other classes should implement this interface and override methods.
 * 
 * @author Nazanin Rezaee
 */


public interface Piece {
    int power();
    int count();
    boolean isMovable();
    int move(int i, int j, int nextI, int nextJ, Gamee board, GameBoard b);
}
