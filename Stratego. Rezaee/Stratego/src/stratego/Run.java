package stratego;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * This class has a main method and the program
 * runs here.
 *
 * @author Nazanin Rezaee
 */
public class Run {

    public static void main(String[] args) throws FileNotFoundException {
        InputStream is = new FileInputStream("input.txt");
        Scanner sc = new Scanner(is);
        Game g = new Game(sc);
        g.run();



    }
}
