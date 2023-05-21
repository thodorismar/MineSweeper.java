
import java.util.ArrayList;

public class Cell {
    private int row, column, mineCount;
    private boolean hasMine, isOpen;
    private ArrayList<Cell> neighbors = new ArrayList<Cell>();

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        this.hasMine = false;
        this.isOpen = false;
        this.mineCount = 0;
    }

    public void addNeighbor(Cell cell) {
        this.neighbors.add(cell);
    }

    public void open() {
        this.isOpen = true;
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public boolean containsMine() {
        return this.hasMine;
    }

    public String toString() {
        if (!isOpen) {
            return "-";
        } else if (hasMine) {
            return "*";
        } else {
            return Integer.toString(mineCount);
        }
    }

    public void addMine() {
        hasMine = true;
    }

}