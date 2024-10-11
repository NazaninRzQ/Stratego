/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stratego;

import java.util.Random;
import java.util.Scanner;

/**
 * This class implements game rules and conditions of
 * moving pieces and printing board game.
 * 
 * @author Nazanin Rezaee
 */
public class Game {
    
    private Player computer;
    private Player gamer;
    private Player current;
    private Scanner sc;
    
    public Game(Scanner sc){
        this.sc = sc;
    }
    
    
    private Piece[][] board = new Piece[10][10];
    
    /**
     * For starting the game
     */
    public void run(){
        RedPlayer r = new RedPlayer();
        BluePlayer b = new BluePlayer();
        SelectPlayer s = new SelectPlayer(r, b);
        System.out.println("Choose your color: ");
        System.out.println("Red player starts.");
        Player[] p = s.select("1 for red , 2 for blue", new Scanner(System.in));
        gamer = p[0];
        computer = p[1];
        current = r;
        
        fillBoard();
        
        
        Scanner sc2 = new Scanner(System.in);
        
        while(true){
            if(current == gamer){
                System.out.println("Enter index of your piece and your move \n x is vertical and y is horizental: x,y,move \n (example : 1,2,u) : ");
                String in = sc2.nextLine();
                String[] str = in.split(",");
                int i = 10 - Integer.parseInt(str[0]);
                int j = Integer.parseInt(str[1]) - 1;
                Move m = Move.select(str[2]);
                
                
                int nextI = i + m.i;
                int nextJ = j + m.j;
                if(board[i][j].isMovable()){
                    if(move_gamer(i, j, nextI, nextJ)){
                        System.out.println("You win!!");
                        break;
                    }
                }else{
                    System.out.println("This piece can't move , try again...");
                }
            }else{
                    int i = 3;
                    Random ran = new Random();
                    int j = ran.nextInt(10);
                    int nextI = i + Move.DOWN.i;
                    int nextJ = j + Move.DOWN.j;
                    if(board[i][j] != null){
                        if(board[i][j].isMovable()){
                            if(move_computer(i, j, nextI, nextJ)){
                                System.out.println("You lose!!");
                                break;
                            }
                        }
                    }
                    
                }
        }
        
        
        
    }
    

    
    
    /**
     * Filling the board boxes by getting a data from file.
     */
    public void fillBoard(){
        
        System.out.println();
        System.out.println();
        
        for(int i=0 ; i<40 ; i++){
            
            String line = sc.nextLine();
            String[] str = line.split(",");
            String name = str[0];
            int x = Integer.parseInt(str[1]);
            int y = Integer.parseInt(str[2]);
            
            

            Piece pi = gamer.remove(name);
            if(pi != null){
                board[10-x][y-1] = pi;
            }else {
                --i;
                System.out.println("hi");
            }
            
        }
        
        for(int i=0 ; i<10 ; i++){
            for(int j=0 ; j<4 ; j++){
                Piece pi = computer.remove();
                board[j][i] = new EnemyPiece(pi);
            }
        }
        
        printBoard();
        
    }
    
    
    /**
     * Checking if the board box is a river or not
     * @param i is x of box
     * @param j is y of box
     * @return true and false for being river or not
     */
    private boolean isRiver(int i, int j){
        return i>=4 && i<=5  && j>=2 && j<=3 || i>=4 && i<=5 && j>=6 && j<=7;
    }
    
    
    /**
     * Changing turns.
     */
    private void changeTurn(){
        current = current == computer ? gamer : computer;
    }
    
    
    
    
    /**
     * for gamer move
     * @param i i is index of (x) last home
     * @param j j is index of (y) last home
     * @param nextI is index of (x) new home
     * @param nextJ is index of(y) new home
     * @return return boolean for finishing game, if true means game is finish
     */
    public boolean move_gamer(int i,int j,int nextI,int nextJ){
        if(board[nextI][nextJ] != null){
            Piece t2 = board[nextI][nextJ];
            if(t2.toString().equals("OP")){
                if(board[i][j].power()==10 && board[nextI][nextJ].power()==1){
                    board[nextI][nextJ]=board[i][j];
                    board[i][j]=null;
                }
                else {
                    if(board[i][j].power()<board[nextI][nextJ].power()){
                        Piece p = board[i][j];
                        Piece c = board[nextI][nextJ];
                        EnemyPiece ep = (EnemyPiece) c;
                        System.out.printf("Your %s attacked Computer %s -> %s is removed", p.toString(), ep.acName(), ep.acName());
                        board[nextI][nextJ]=board[i][j];
                        board[i][j]=null;
                        if(t2.power()==0)
                        {
                            printBoard();
                            System.out.println("you winnnnnnnnnnnn!!!!!!!");
                            return  true;
                        }
                        
                    }
                    else {
                        board[i][j]=null;
                    }

                }
//                printBoard();
                changeTurn();
            }
            else {
//                printBoard();
                System.out.println("**Error** can not move Here , try again.............");
                current=gamer;
            }
        }
        else{
            if(!isRiver(nextI, nextJ)){
                Piece t = board[i][j];
                board[nextI][nextJ] = t;
                board[i][j] = null;
                changeTurn();
//                printBoard();
            }
            else{
                System.out.println("**Error** Here is River, try again..........");
                current=gamer;
            }
        }

        return false;
    }
    
    
    
    /**
     * for computer move
     * @param i i is index of (x) last home
     * @param j j is index of (y) last home
     * @param nextI is index of (x) new home
     * @param nextJ is index of(y) new home
     * @return return boolean for finishing game, if true means game is finish
     */
    public boolean move_computer(int i,int j,int nextI,int nextJ){
        if(board[nextI][nextJ] != null){
            Piece t2 = board[nextI][nextJ];
            if(!t2.toString().equals("OP")){
                if(board[i][j].power()==10 & board[nextI][nextJ].power()==1){
                    board[nextI][nextJ]=board[i][j];
                    board[i][j]=null;
                }
                else {
                    if(board[i][j].power()>board[nextI][nextJ].power()){
                        Piece c = board[i][j];
                        Piece p = board[nextI][nextJ];
                        EnemyPiece ep = (EnemyPiece) c;
                        System.out.printf("Computer %s Attacked Your %s -> %s is removed",ep.acName(), p.toString() , p.toString());
                        board[nextI][nextJ]=board[i][j];
                        board[i][j]=null;
                        if(t2.power()==10)
                        {
                            return  true;
                        }
                    }
                    else {
                        board[i][j]=null;
                    }

                }

            }
            else {
                current=computer;
            }
//            printBoard();
            changeTurn();
        }
        else{
            if(!isRiver(nextI, nextJ)){
                Piece t = board[i][j];
                board[nextI][nextJ] = t;
                board[i][j] = null;
                changeTurn();
            }
            else{
                current=computer;
            }
        }
        printBoard();
        return false;
    }
    
    
    
    
    /**
     * Printing board game.
     */
    public void printBoard(){
        System.out.println();
        System.out.print("+");
        for(int k=0;k<10;k++)
            System.out.print("-------------+");
        for(int i=0;i<10;i++)
        {
            System.out.println();
            System.out.print("|");
            for(int j=0;j<10;j++){
                if(isRiver(i, j)){
                    System.out.print("     " + "**" + "      |");
                }else{
                    
                     if(board[i][j]!=null){
                        if(board[i][j].toString()=="OP"){
                            System.out.print("     "+board[i][j]+"      |");

                    }
                    else {
                        switch (board[i][j].power()){
                            case 1 :
                                System.out.print("   "+board[i][j]+"   |");
                                break;
                            case 2:
                                System.out.print("   "+board[i][j]+"   |");
                                break;
                            case 3:
                                System.out.print("   "+board[i][j]+"   |");
                                break;
                            case 4:
                                System.out.print("    "+board[i][j]+"    |");
                                break;
                            case 5:
                                System.out.print("   "+board[i][j]+"   |");
                                break;
                            case 6:
                                System.out.print(" "+board[i][j]+"  |");
                                break;
                            case 7:
                                System.out.print("  "+board[i][j]+"   |");
                                break;
                            case 8:
                                System.out.print("    "+board[i][j]+"   |");
                                break;
                            case 9:
                                System.out.print("    "+board[i][j]+"    |");
                                break;
                            case 10:
                                System.out.print("    "+board[i][j]+"      |");
                                break;
                            case  11:
                                System.out.print("     "+board[i][j]+"    |");
                                break;
                            case 0:
                                System.out.print("     "+board[i][j]+"    |");
                                break;
                        }
                    }
                }
                else {
                    System.out.print("             |");
                }
                    
                    
                }


            }
            System.out.println();
            System.out.print("+");
            for(int j=0;j<10;j++) {
                System.out.print("-------------+");
            }
        }
        System.out.println();
    }

}
