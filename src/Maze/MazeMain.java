package Maze;
import java.util.*;

//   !!!*** WARNING - the maze has a bug and you can not jump over the pit in the corner on the way to the exit
//        - MUST MODIFY MAZE FILE TO WIN ! - currently un-changed

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
    static int limit = 10; // - I give an extra move

    public static void main(String[] args) {
        intro(); // play intro once
        // int x = 0;
        int moves = 0;

        // start game loop - change x value to end
        while (moves <= (limit +1)) {
            if (!maze.didIWin() && moves < limit + 2) { // love intelli j auto refactor
                userMove();
                moves++;
                maze.printMap();
                print(info);
                print(options);
                moveAlert(moves);
                // print(moves + " moves used so far");  // testing

            } else if (maze.didIWin() && moves < limit + 2) { // love intelli j auto refactor
                print("Winner Winner you escaped ! Congrats Maze Runner !");
                print(" you won the game in only " + moves + " moves");
                // x = x+1;
                // System.exit(0);
                // break;


            } else if (moves == limit) {
                print("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[");
                print("Sorry, but you didn't escape in time - YOU LOSE! ");
                // x = x+1;
                // System.exit(0);
                // break;

            }
        }

    }

    public static void print(Object _o) {
        System.out.println(_o);
    }

    public static void intro() {
        //welcome the user and print new map

        print(" * _ +*_ +*_ +*_ +*_ +*_ +*_ +*_ +* _ +*_ +*_ +*_ +*_ +*_ +*_ +*_ +* _ +*_ +*_ +*_ +*_ +*_ +*_ +*_ +* _ +*_ +*_ ");
        print("          JJJJJJJJJJJ          AAA   VVVVVVVV           VVVVVVVV   AAA ");
        print("          J:::::::::J         A:::A  V::::::V           V::::::V  A:::A  ");
        print("          J:::::::::J        A:::::A V::::::V           V::::::V A:::::A  ");
        print("          JJ:::::::JJ       A:::::::AV::::::V           V::::::VA:::::::A  ");
        print("            J:::::J        A:::::::::AV:::::V           V:::::VA:::::::::A  ");
        print("            J:::::J       A:::::A:::::AV:::::V         V:::::VA:::::A:::::A  ");
        print("            J:::::J      A:::::A A:::::AV:::::V       V:::::VA:::::A A:::::A  ");
        print("            J:::::j     A:::::A   A:::::AV:::::V     V:::::VA:::::A   A:::::A  ");
        print("            J:::::J    A:::::A     A:::::AV:::::V   V:::::VA:::::A     A:::::A  ");
        print("JJJJJJJ     J:::::J   A:::::AAAAAAAAA:::::AV:::::V V:::::VA:::::AAAAAAAAA:::::A  ");
        print("J:::::J     J:::::J  A:::::::::::::::::::::AV:::::V:::::VA:::::::::::::::::::::A  ");
        print("J::::::J   J::::::J A:::::AAAAAAAAAAAAA:::::AV:::::::::VA:::::AAAAAAAAAAAAA:::::A  ");
        print("J:::::::JJJ:::::::JA:::::A             A:::::AV:::::::VA:::::A             A:::::A  ");
        print(" JJ:::::::::::::JJA:::::A               A:::::AV:::::VA:::::A               A:::::A  ");
        print("   JJ:::::::::JJ A:::::A                 A:::::AV:::VA:::::A                 A:::::A  ");
        print("     JJJJJJJJJ  AAAAAAA                   AAAAAAAVVVAAAAAAA                   AAAAAAA  ");
        print("MMMMMMMM               MMMMMMMM               AAA               ZZZZZZZZZZZZZZZZZZZEEEEEEEEEEEEEEEEEEEEEE  ");
        print("M:::::::M             M:::::::M              A:::A              Z:::::::::::::::::ZE::::::::::::::::::::E  ");
        print("M::::::::M           M::::::::M             A:::::A             Z:::::::::::::::::ZE::::::::::::::::::::E  ");
        print("M:::::::::M         M:::::::::M            A:::::::A            Z:::ZZZZZZZZ:::::Z EE::::::EEEEEEEEE::::E  ");
        print("M::::::::::M       M::::::::::M           A:::::::::A           ZZZZZ     Z:::::Z    E:::::E       EEEEEE  ");
        print("M:::::::::::M     M:::::::::::M          A:::::A:::::A                  Z:::::Z      E:::::E  ");
        print("M:::::::M::::M   M::::M:::::::M         A:::::A A:::::A                Z:::::Z       E::::::EEEEEEEEEE  ");
        print("M::::::M M::::M M::::M M::::::M        A:::::A   A:::::A              Z:::::Z        E:::::::::::::::E  ");
        print("M::::::M  M::::M::::M  M::::::M       A:::::A     A:::::A            Z:::::Z         E:::::::::::::::E  ");
        print("M::::::M   M:::::::M   M::::::M      A:::::AAAAAAAAA:::::A          Z:::::Z          E::::::EEEEEEEEEE  ");
        print("M::::::M    M:::::M    M::::::M     A:::::::::::::::::::::A        Z:::::Z           E:::::E  ");
        print("M::::::M     MMMMM     M::::::M    A:::::AAAAAAAAAAAAA:::::A    ZZZ:::::Z     ZZZZZ  E:::::E       EEEEEE  ");
        print("M::::::M               M::::::M   A:::::A             A:::::A   Z::::::ZZZZZZZZ:::ZEE::::::EEEEEEEE:::::E  ");
        print("M::::::M               M::::::M  A:::::A               A:::::A  Z:::::::::::::::::ZE::::::::::::::::::::E  ");
        print("M::::::M               M::::::M A:::::A                 A:::::A Z:::::::::::::::::ZE::::::::::::::::::::E   ");
        print("MMMMMMMM               MMMMMMMMAAAAAAA                   AAAAAAAZZZZZZZZZZZZZZZZZZZEEEEEEEEEEEEEEEEEEEEEE   ");
        print(" * _ +*_ +*_ +*_ +*_ +*_ +*_ +*_ +* _ +*_ +*_ +*_ +*_ +*_ +*_ +*_ +* _ +*_ +*_ +*_ +*_ +*_ +*_ +*_ +* _ +*_ +*_  ");
        print("Welcome to Java Maze Runner!");
        print("Here is your current position:");
        maze.printMap();
        print(options);

    }

    public static void userMove() {
        //take desired direction to move:

        String direction = scanner.nextLine().toUpperCase().trim();


        if (direction.equals("R") || direction.equals("L") || direction.equals("U") || direction.equals("D") || direction.equals("Q")) {
            // change this to switch ?
            if (direction.equals("Q")) {
                print("Thanks for playing ... Bye Bye now");
                System.exit(0);
            } else if (direction.equals("L") && (maze.canIMoveLeft())) {
                maze.moveLeft();
            } else if (direction.equals("U") && (maze.canIMoveUp())) {
                maze.moveUp();
            } else if (direction.equals("D") && (maze.canIMoveDown())) {
                maze.moveDown();
            } else if (direction.equals("R") && (maze.canIMoveRight())) {
                maze.moveRight();
            } else if (maze.isThereAPit(direction)) {
                navigatePit(direction);
            } else {
                print("Sorry, you’ve hit a wall.");
                maze.printMap();
                print("Sorry, you’ve hit a wall."); /// have to scroll to top to see so duplicate here for better UX
                print(options);
                userMove();
            }

        } else {
            print(" Wrong input! ");
            print(info);
            print(options);
            userMove();
        }


    }

    public static void navigatePit(String direction) {

        print("Watch out! There's a pit ahead, jump it? (Y/N)");
        String jump = scanner.nextLine().toUpperCase().trim();

        if (jump.startsWith("Y")) {
            maze.jumpOverPit(direction);
        } else if (jump.startsWith("N")) {
            userMove();
        } else {
            print("Please type \"Y\" or \"N");
            navigatePit(direction);
        }

    }

    public static void moveAlert(int moves) {

        //
        //add these in
        //         50	Warning: You have made 50 moves, you have 50 remaining before the maze exit closes
        //         75	Alert! You have made 75 moves, you only have 25 moves left to escape.
         //        90	DANGER! You have made 90 moves, you only have 10 moves left to escape!!


        if (moves == limit / 2) {
            print("Warning: You have used half of your moves, you have " + (limit / 2) + " remaining before the maze exit closes");
        } else if (moves == limit - 25) {
            print("Alert! You have made " + (limit - 25) + " moves, you only have 25 moves left to escape.");
        } else if (moves == limit - 10) {
            print("DANGER! You have made " + (limit - 10) + " moves, you only have 10 moves left to escape!!");
        } else if (moves == limit - 2) {
            print("HURRY UP THE DOOR IS ALMOST CLOSED ... ONLY 2 moves left !! Make them count !");
        }
    }


}
