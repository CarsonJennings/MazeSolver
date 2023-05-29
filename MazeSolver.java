import java.io.FileWriter;
import java.util.*;

public class MazeSolver {
    static FilePrinter fileWriterDFS;
    static FilePrinter fileWriterBFS;
    
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("You must specify a maze file");
            System.err.println("Usage: java MazeSolver <mazefile>");
            return;
        }

        Maze maze0 = new Maze(args[0]);
        fileWriterDFS = new FilePrinter("DFS-Solution.txt");
        Maze maze1 = new Maze(args[0]);
        fileWriterBFS = new FilePrinter("BFS-Solution.txt");

        fileWriterDFS.println("Beginning DFS traversal on the following maze: \n" + maze0);
        dfsSolution(maze0, maze0.getStart(), maze0.getFinish());
        fileWriterBFS.println("Beginning BFS taversal on the following maze: \n" + maze1);
        bfsSolution(maze1, maze1.getStart(), maze1.getFinish());
        
        fileWriterBFS.close();
        fileWriterDFS.close();
    }

    public static void dfsSolution(Maze maze, MazeLocation startPos, MazeLocation endPos) {
        Stack<MazeLocation> path = new Stack<MazeLocation>();
        MazeLocation curLocation = startPos;
        int curRow = curLocation.getRow();
        int curCol = curLocation.getCol();
        path.push(curLocation);

        while (!path.isEmpty()) {
            curLocation = path.pop(); // Get next location
            curRow = curLocation.getRow();
            curCol = curLocation.getCol();
            maze.setChar(curRow, curCol, 'O');
            fileWriterDFS.println(curLocation.toString());
            fileWriterDFS.println(maze.toString());

            if (curLocation.equals(endPos)) {
                fileWriterDFS.println("Solution found!");
                return;
            }
            if (curRow + 1 < maze.getHeight() && maze.getChar(curRow + 1, curCol) == ' ') {
                path.push(new MazeLocation(curRow + 1, curCol));
            }
            if (curRow - 1 >= 0 && maze.getChar(curRow - 1, curCol) == ' ') {
                path.push(new MazeLocation(curRow - 1, curCol));
            }
            if (curCol + 1 < maze.getWidth() && maze.getChar(curRow, curCol + 1) == ' ') {
                path.push(new MazeLocation(curRow, curCol + 1));
            }
            if (curCol - 1 >= 0 && maze.getChar(curRow, curCol - 1) == ' ') {
                path.push(new MazeLocation(curRow, curCol - 1));
            }
        }
        fileWriterDFS.println("No Solution found");
    }

    public static void bfsSolution(Maze maze, MazeLocation startPos, MazeLocation endPos) {
        Queue<MazeLocation> path = new LinkedList<MazeLocation>();
        MazeLocation curLocation = startPos;
        int curRow = curLocation.getRow();
        int curCol = curLocation.getCol();
        path.add(curLocation);

        while (!path.isEmpty()) {
            curLocation = path.remove();
            curRow = curLocation.getRow();
            curCol = curLocation.getCol();
            maze.setChar(curRow, curCol, 'O');
            fileWriterBFS.println(curLocation.toString());
            fileWriterBFS.println(maze.toString());

            if (curLocation.equals(endPos)) {
                fileWriterBFS.println("Solution found!");
                return;
            }
            if (curRow + 1 < maze.getHeight() && maze.getChar(curRow + 1, curCol) == ' ') {
                path.add(new MazeLocation(curRow + 1, curCol));
            }
            if (curRow - 1 >= 0 && maze.getChar(curRow - 1, curCol) == ' ') {
                path.add(new MazeLocation(curRow - 1, curCol));
            }
            if (curCol + 1 < maze.getWidth() && maze.getChar(curRow, curCol + 1) == ' ') {
                path.add(new MazeLocation(curRow, curCol + 1));
            }
            if (curCol - 1 >= 0 && maze.getChar(curRow, curCol - 1) == ' ') {
                path.add(new MazeLocation(curRow, curCol - 1));
            }
        }
        fileWriterBFS.println("No Solution found");
    }

}