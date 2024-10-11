package com.example.stra.model;

import com.example.stra.view.GameBoard;

public enum PieceMoves implements PieceMove{
    MARSHAL((i, j, nextI, nextJ, board, b) -> {
        Piece thisP = board.get(i, j);
        Piece thatP = board.get(nextI, nextJ);
        if(board.isRiver(nextI, nextJ))return 0;
        if(thatP == null){
            board.change(i, j, nextI, nextJ);
            b.change(i, j, nextI, nextJ);
            return 0;
        }
        board.change(i, j, nextI, nextJ);
        b.change(i, j, nextI, nextJ);
        if(thisP.power() > thatP.power()){
            return 1;
        }
        return -1;

    }),
    GENERAL((i, j, nextI, nextJ, board, b) -> {
        Piece thisP = board.get(i, j);
        Piece thatP = board.get(nextI, nextJ);
        if(board.isRiver(nextI, nextJ))return 0;
        if(thatP == null){
            board.change(i, j, nextI, nextJ);
            b.change(i, j , nextI, nextJ);
            return 0;
        }
        board.change(i, j, nextI, nextJ);
        b.change(i, j, nextI, nextJ);
        if(thisP.power() > thatP.power()){
            return 1;
        }
        return -1;
    }),
    COLONEL((i, j, nextI, nextJ, board, b) -> {
        Piece thisP = board.get(i, j);
        Piece thatP = board.get(nextI, nextJ);
        if(board.isRiver(nextI, nextJ))return 0;
        if(thatP == null){
            board.change(i, j, nextI, nextJ);
            b.change(i, j, nextI, nextJ);
            return 0;
        }
        board.change(i, j, nextI, nextJ);
        b.change(i, j, nextI, nextJ);
        if(thisP.power() > thatP.power()){
            return 1;
        }
        return -1;
    }),
    MAJOR((i, j, nextI, nextJ, board, b) -> {
        Piece thisP = board.get(i, j);
        Piece thatP = board.get(nextI, nextJ);
        if(board.isRiver(nextI, nextJ))return 0;
        if(thatP == null){
            board.change(i, j, nextI, nextJ);
            b.change(i, j, nextI, nextJ);
            return 0;
        }
        board.change(i, j, nextI, nextJ);
        b.change(i, j, nextI, nextJ);
        if(thisP.power() > thatP.power()){
            return 1;
        }
        return -1;
    }),
    CAPITAN((i, j, nextI, nextJ, board, b) -> {
        Piece thisP = board.get(i, j);
        Piece thatP = board.get(nextI, nextJ);
        if(board.isRiver(nextI, nextJ))return 0;
        if(thatP == null){
            board.change(i, j, nextI, nextJ);
            b.change(i, j, nextI, nextJ);
            return 0;
        }
        board.change(i, j, nextI, nextJ);
        b.change(i, j, nextI, nextJ);
        if(thisP.power() > thatP.power()){
            return 1;
        }
        return -1;
    }),
    LIEUTENANT((i, j, nextI, nextJ, board, b) -> {
        Piece thisP = board.get(i, j);
        Piece thatP = board.get(nextI, nextJ);
        if(board.isRiver(nextI, nextJ))return 0;
        if(thatP == null){
            board.change(i, j, nextI, nextJ);
            b.change(i, j, nextI, nextJ);
            return 0;
        }
        board.change(i, j, nextI, nextJ);
        b.change(i, j, nextI, nextJ);
        if(thisP.power() > thatP.power()){
            return 1;
        }
        return -1;
    }),
    SERGEANT((i, j, nextI, nextJ, board, b) -> {
        Piece thisP = board.get(i, j);
        Piece thatP = board.get(nextI, nextJ);
        if(board.isRiver(nextI, nextJ))return 0;
        if(thatP == null){
            board.change(i, j, nextI, nextJ);
            b.change(i, j, nextI, nextJ);
            return 0;
        }
        board.change(i, j, nextI, nextJ);
        b.change(i, j, nextI, nextJ);
        if(thisP.power() > thatP.power()){
            return 1;
        }
        return -1;
    }),
    MINERS((i, j, nextI, nextJ, board, b) -> {
        Piece thisP = board.get(i, j);
        Piece thatP = board.get(nextI, nextJ);
        if(board.isRiver(nextI, nextJ))return 0;
        if(thatP == PlayerPiece.BOMB) {
            board.change(i, j, nextI, nextJ);
            b.change(i, j, nextI, nextJ);
            return 1;
        }
        if(thatP == null){
            board.change(i, j, nextI, nextJ);
            b.change(i, j, nextI, nextJ);
            return 0;
        }
        board.change(i, j, nextI, nextJ);
        b.change(i, j, nextI, nextJ);
        if(thisP.power() > thatP.power()){
            return 1;
        }
        return -1;
    }),
    SCOUT((i, j, nextI, nextJ, board, b) -> {
        Piece thisP = board.get(i, j);
        Piece thatP = board.get(nextI, nextJ);
        if(board.isRiver(nextI, nextJ))return 0;
        if(thatP == null){
            board.change(i, j, nextI, nextJ);
            b.change(i, j, nextI, nextJ);
            return 0;
        }
        board.change(i, j, nextI, nextJ);
        b.change(i, j, nextI, nextJ);
        if(thisP.power() > thatP.power()){
            return 1;
        }
        return -1;
    }),
    SPY((i, j, nextI, nextJ, board, b) -> {
        if(board.get(nextI, nextJ) == PlayerPiece.MARSHAL){
            board.change(i, j, nextI, nextJ);
            b.change(i, j, nextI, nextJ);
            return 1;
        }
        Piece thisP = board.get(i, j);
        Piece thatP = board.get(nextI, nextJ);
        if(board.isRiver(nextI, nextJ))return 0;
        if(thatP == null){
            board.change(i, j, nextI, nextJ);
            b.change(i, j, nextI, nextJ);
            return 0;
        }
        board.change(i, j, nextI, nextJ);
        b.change(i, j, nextI, nextJ);
        if(thisP.power() > thatP.power()){
            return 1;
        }
        return -1;
    }),
    BOMB((i, j, nextI, nextJ, board, b) -> {
        return 0;
    }),
    FLAG((i, j, nextI, nextJ, board, b) -> {
        return 0;
    });


    private PieceMoves(PieceMove pieceMove){
        this.pieceMove = pieceMove;
    }

    private PieceMove pieceMove;
    @Override
    public int move(int i, int j, int nextI, int nextJ, Gamee board, GameBoard b) {
        return pieceMove.move(i, j, nextI, nextJ, board, b);
    }
}
