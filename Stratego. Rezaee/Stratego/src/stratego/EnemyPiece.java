/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stratego;

/**
 *This class implements the Piece interface and
 * includes game's pieces for the enemy.
 * It overrides the methods and prints OP for
 * the pieces because we should not see the enemy's
 * pieces.
 * 
 * @author Nazanin Rezaee
 */
public class EnemyPiece implements Piece{
    
    private Piece p;

    public EnemyPiece(Piece p) {
        this.p = p;
    }
    

    @Override
    public int power() {
        return p.power();
    }

    @Override
    public int count() {
        return p.count();
    }

    @Override
    public boolean isMovable() {
        return p.isMovable();
    }
    
    @Override
    public String toString(){
        return "OP";
    }
    
    public String acName(){
        return this.p.toString();
    }
    
}
