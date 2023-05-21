
import java.util.Random;

public class MineField {
    private int size;
    private int numMines;
    private Cell[][] grid;

    public MineField(int size, int numMines) {
        this.size = size;
        this.numMines = numMines;
        this.grid = new Cell[size][size];
        initializeCells();
        initializeMines();
    }

    private void initializeCells() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                grid[row][col] = new Cell(row, col);
            }
        }
    }

    private void initializeMines() {
        Random random = new Random();
        random.setSeed(2023);

        int minesPlaced = 0;
        while (minesPlaced < numMines) {
            int row = random.nextInt(size);
            int col = random.nextInt(size);

            Cell cell = grid[row][col];
            if (!cell.containsMine()) {
                cell.addMine();
                minesPlaced++;
            }
        }
    }

    public Cell getCell(int row, int col) {
        return grid[row][col];
    }
    public int getNumMines(){
        return numMines;

    }
    public void print() {
        System.out.print(" ");
        for (int i=0; i<size; i++) {
            System.out.print(" " + i);
        }
        System.out.println("");
        for (int i=0; i<size; i++) {
            System.out.print(i + " ");
            for (int j=0; j<size; j++) {
                System.out.print(grid[i][j]+ " ");
            }
            System.out.println("");
        }
    }
}