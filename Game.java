import java.util.Scanner;

class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the grid: ");
        int gridSize = scanner.nextInt();

        System.out.print("Enter the number of mines: ");
        int numMines = scanner.nextInt();

        System.out.print("Enter the name of player 1: ");
        String player1Name = scanner.next();

        System.out.print("Enter the name of player 2: ");
        String player2Name = scanner.next();

        MineSweeper game = new MineSweeper(player1Name, player2Name, gridSize, numMines);
        game.play();

    }
}