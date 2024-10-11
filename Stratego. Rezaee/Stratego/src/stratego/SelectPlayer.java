/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stratego;

import java.util.Scanner;

/**
 * This class is for selecting what color you want to be.
 * 
 * @author Nazanin Rezaee
 */
public class SelectPlayer {
    
    private RedPlayer red;
    private BluePlayer blue;

    
    public SelectPlayer(RedPlayer red, BluePlayer blue) {
        this.red = red;
        this.blue = blue;
    }
    
    /**
     * Select method that gets a String and a Scanner and select your color
     * as your choice.
     * @param s for printing a message
     * @param sc for getting an answer from user
     * @return 
     */
    public Player[] select(String s , Scanner sc){
        System.out.println(s);
        Player[] pl = new Player[2];
        int i = sc.nextInt();
        if(i == 1){
            pl[0] = red;
            pl[1] = blue;
        }else{
            pl[0] = blue;
            pl[1] = red;
        }
        
        return pl;
    }
    
    
}
