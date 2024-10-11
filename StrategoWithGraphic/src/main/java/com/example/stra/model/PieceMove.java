package com.example.stra.model;

import com.example.stra.view.GameBoard;

public interface PieceMove {

    int move(int i, int j, int nextI, int nextJ, Gamee board, GameBoard b);
}
