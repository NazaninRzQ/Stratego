/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package stratego;

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
    
}
