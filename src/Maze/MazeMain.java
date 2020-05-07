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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Maze maze = new Maze();
        maze.printMap();
        String options = "Escape the java maze move: (u)p, (d)own, (l)eft or (r)ight \n you are the X _-_ type stop to exit";
        System.out.println(options);

        String move;
        for(move = scanner.nextLine();
            !move.equals("stop");
            move = scanner.nextLine()){
            switch(move){
                case "u":{
                    if (maze.canIMoveUp()){
                        maze.moveUp();
                    }
                    break;
                }
                case "d":{
                    if (maze.canIMoveDown()){
                        maze.moveDown();
                    }
                    break;
                }
                case "l":{
                    if (maze.canIMoveLeft()){
                        maze.moveLeft();
                    }
                    break;
                }
                case "r":{
                    if (maze.canIMoveRight()){
                        maze.moveRight();
                    }
                    break;
                }
            }
            maze.printMap();
            System.out.println(options);
        }

    }
}
