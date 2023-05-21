
import java.util.Scanner;

public class MineSweeper {
    private Player player1;
    private Player player2;
    private MineField mineField;

    public MineSweeper(String player1Name, String player2Name, int size, int numMines) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
        this.mineField = new MineField(size, numMines);
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        Player currentPlayer = player1;

        while (true) {
            System.out.println("\nCurrent Player: " + currentPlayer.getName());
            System.out.println("Select a cell to open (row column): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            boolean isMineFound = currentPlayer.play(mineField, row, col);
            mineField.print();

            if (isMineFound) {
                System.out.println("Mine found! Player " + currentPlayer.getName() );
                if (player1.getScore() + player2.getScore()== mineField.getNumMines()) {
                    System.out.println("Game has ended");
                    break;
                }
            }

            if (currentPlayer == player1) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }
        }

        System.out.println("Game over!");
        player1.printStatus();
        player2.printStatus();
    }

    public static void main(String[] args) {
        MineSweeper game = new MineSweeper("Player1", "Player2", 8, 10);
        game.play();
    }
}