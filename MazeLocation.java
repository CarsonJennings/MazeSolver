public class MazeLocation {
    private int row;
    private int col;

    public MazeLocation(int row, int col) {
        this.row = row;
        this.col = col;
    }
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}

    public String toString() {
        return "(" + this.row + ", " + this.col + ")";
    }

    public boolean equals(MazeLocation location) {
        return (this.row == location.row && this.col == location.col);
    }
}