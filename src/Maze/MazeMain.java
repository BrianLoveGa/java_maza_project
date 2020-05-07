package Maze;
import Maze.Maze;

import java.util.*;


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
