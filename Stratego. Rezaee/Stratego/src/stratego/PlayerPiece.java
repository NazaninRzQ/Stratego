/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package stratego;

/**
 *This enum class implements the Piece interface and
 * includes game's pieces with their features as power, 
 * count and being movable.
 * 
 * @author Nazanin Rezaee
 */
public enum PlayerPiece implements Piece{

    MARSHAL("marshal" , 1 , 1 , true),
    GENERAL("general" , 1 , 2 , true),
    COLONEL("colonel" , 2 , 3 , true),
    MAJOR("major" , 3 , 4 , true),
    CAPITAN("capitan" , 4 , 5 , true),
    LIEUTENANT("lieutenant" , 4 , 6 , true),
    SERGEANT("sergeant" , 4 , 7 , true),
    MINERS("miners" , 5 , 8 , true),
    SCOUT("scout" , 8 , 9 , true),
    SPY("spy" , 1 , 10 , true),
    BOMB("bomb" , 6 , 11 , false),
    FLAG("flag" , 1 , 0 , false);
    
    
    private int power;
    private int count;
    
    private String name;
    private boolean isMovable;
    
    
    private PlayerPiece(String name, int count, int power, boolean isMovable){
        this.isMovable = isMovable;
        this.name = name;
        this.power = power;
        this.count = count;
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
    public String toString(){
        return this.name;
    }
    
    
}
