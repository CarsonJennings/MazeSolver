import java.util.*;
import java.io.*;

public class Maze {
    private char[][] mazeData;
    private MazeLocation start;
    private MazeLocation finish;

    public Maze(String data) {
        try {
            Scanner scan = new Scanner(new File(data));

            int rows = scan.nextInt();
			int columns = scan.nextInt();
			int startRow = scan.nextInt();
			int startColumn = scan.nextInt();
			int finishRow = scan.nextInt();
			int finishColumn = scan.nextInt();
			scan.nextLine();

            this.start = new MazeLocation(startRow, startColumn);
            this.finish = new MazeLocation(finishRow, finishColumn);
            this.mazeData = new char[rows][columns];

            for (int row = 0; row < rows; row++) {
				String line = scan.nextLine();
				for (int col = 0; col < columns; col++) {
					this.mazeData[row][col] = line.charAt(col);
				}
			}
        } catch (FileNotFoundException ex) {
			System.out.println("Error scanning file "+data);
			System.exit(2);
		} catch(NoSuchElementException ex) {
			System.out.println("Maze data file is not formatted correctly, should be:");
			System.out.println("<num rows> <num columns>");
			System.out.println("<start row> <start column>");
			System.out.println("<finish row> <finish column>");
			System.out.println("<Maze data>");
			System.out.println("Example:");
			System.out.println("7 8");
			System.out.println("0 1");
			System.out.println("6 6");
			System.out.println("H HHHHHH");
			System.out.println("H    H H");
			System.out.println("HHHH H H");
			System.out.println("H      H");
			System.out.println("H HHHHHH");
			System.out.println("H      H");
			System.out.println("HHHHHH H");
			System.exit(3);
		}
    }

    public MazeLocation getStart() {
        return start;
    }

    public MazeLocation getFinish() {
        return finish;
    }

	public int getHeight() {
		return mazeData.length;
	}

	public int getWidth() {
		if (mazeData.length > 0) {
			return mazeData[0].length;	
		}
		return 0;
	}

    public char getChar(int row, int col) {
        return mazeData[row][col];
    }

    public void setChar(int row, int col, char val) {
        mazeData[row][col] = val;
    }

    public String toString() {
		String details = " ";
		for (int i = 0; i < mazeData[0].length; i++) {
			details += i%10;	
		}
		details += "\n";
		for (int i = 0; i < mazeData.length; i++) {
			details += i%10;
			for (int j = 0; j < mazeData[i].length; j++) {
					details += mazeData[i][j];	
			}
			details +="\n";
		}
		return details;
	}
}