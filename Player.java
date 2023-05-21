
public class Player {
    private String name;
    private int score;

    public Player(String playerName) {
        this.name = playerName;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public boolean play(MineField mineField, int row, int col) {
        Cell cell = mineField.getCell(row, col);

        if (cell.isOpen()) {
            System.out.println("Cell already opened. Please choose another cell.");
            return false;
        }

        cell.open();
        if (cell.containsMine()) {
            score++;
            return true;
        }

        return false;
    }

    public void printStatus() {
        System.out.println("Player: " + name);
        System.out.println("Score: " + score);
    }
}