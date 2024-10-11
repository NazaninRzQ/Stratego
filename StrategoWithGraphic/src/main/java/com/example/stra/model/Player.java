/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.stra.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Nazanin Rezaee
 */
public abstract class Player {
    private List<Piece> piecesList = new ArrayList<>();
    
    protected Player(){
        fillList();
    }
    
    private void fillList(){
        Piece[] ps = PlayerPiece.values();
        for(Piece p : ps){
            for(int i=0 ; i<p.count() ; i++){
                piecesList.add(p);
            }
        }
    }
    
    public Piece remove(String name){
        for(Piece p : piecesList){
            if(p.toString().equals(name)){
                piecesList.remove(p);
                return p;
            }
        }
        return null;
    }
    
    public Piece remove(){
        return piecesList.remove(0);
    }
    
    public abstract String type();
    
}
