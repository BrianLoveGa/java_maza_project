package Maze;

import Maze.Maze;

import java.util.*;

/// use downloaded maze program
/// show map
/// code interface for player to move in map (up down left right)
/// allow user to jump 'pits'
/// keep track of moves ( 100 moves = dead if still in maze)


/// intro method
// Your map will look like all "." Characters and one "x" character.
// The "x" represents your current position and the "." Represents an unknown space.
// As you move through the map the "." Will turn into either walls ("-") or free spaces ("*").
// There might even be more surprises in store for you as well.


public class MazeMain {
    static Scanner scanner = new Scanner(System.in);
    static Maze maze = new Maze();
    static String options = "Escape the java maze \n move: (U)p, (D)own, (L)eft or (R)ight \n you are the X _-_ type (Q)uit to exit";
    static String info = "The dots (.) are unexplored .. The - & | are walls * is open and 0 is a pit ";

    public static void main(String[] args) {
        intro();
        int x = 0;
        while (x == 0) {
            if (maze.didIWin() == false) {
                userMove();
                maze.printMap();
                print(info);
                print(options);

            } else if (maze.didIWin() == true) {
                print("error or winner");
                x++;
            }
        }

    }

    public static void print(Object _o) {
        System.out.println(_o);
    }

    public static void intro() {
        //welcome the user and print new map
        print("Welcome to Java Maze Runner!");
        print("Here is your current position:");
        maze.printMap();
        print(options);

    }

    public static String userMove() {
        //take desired direction to move:

        String direction = scanner.nextLine().toUpperCase();

        //Guarantee that the user selection is only one of the given options,
        //and continue to reprompt the user until they enter a desired direction.
        //if you cannot move in that direction, notify the user there is wall in that direction and ask them to pick a new direction to move.

        if (direction.equals("R") || direction.equals("L") || direction.equals("U") || direction.equals("D") || direction.equals("Q")) {
            if (direction.equals("R") && (maze.canIMoveRight())) {
                maze.moveRight(); // Moves your position one to the right and prints out the new board
            } else if (direction.equals("L") && (maze.canIMoveLeft())) {
                maze.moveLeft(); // Moves your position one to the left and prints out the new board
            } else if (direction.equals("U") && (maze.canIMoveUp())) {
                maze.moveUp(); // Moves your position one above and prints out the new board
            } else if (direction.equals("D") && (maze.canIMoveDown())) {
                maze.moveDown(); // Moves your position one below and prints out the new board
            } else if (maze.isThereAPit(direction)) {
                navigatePit(direction);
            } else if (direction.equals("Q")){
                print("Thanks for playing ... Bye Bye now");
                System.exit(0);
            } else {
                print("Sorry, you’ve hit a wall.");
                maze.printMap();
                print(options);
                userMove();
            }

        } else {
            print(" Wrong input! ");
            print(info);
            print(options);
            userMove();
        }

        //return a string indicating which direction the user chooses to move in
        return direction;

    }

    public static void navigatePit(String direction) {

        print("Watch out! There's a pit ahead, jump it? (Y/N)");
        String jump = scanner.nextLine();

        if (jump.startsWith("Y")) {
            maze.jumpOverPit(direction);
        } else if (jump.startsWith("N")) {
            userMove();
        } else {
            print("Please type \"Y\" or \"N");
            navigatePit(direction);
        }

    }


}
