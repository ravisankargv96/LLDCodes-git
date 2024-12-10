package ATicTacToe;

public class Game {

    public static void main(String[] args) {
        /**
        * Initialize the board.
        * 1. Board Can be any size (nXn), currently we are initializing 3 X 3 board
        * 2. Print the first state of the board.
        * */
        TicTacToe game = new TicTacToe(3);
        game.printBoard();

        /**
        * Assuming fixed set of moves:
        * 1. Starting with player1 then player2
        * */

        int[][] moves = {
                {0, 0, 1}, {0, 1, 2},
                {1, 1, 1}, {0, 2, 2},
                {2, 2, 1}
        };

        /**
        * Logic:
        * At every state of the board (i.e. each move) check if gameOver or to be played.
        * 1. Declare the winner.
        * */

        for (int[] move : moves) {
            int row = move[0];
            int col = move[1];
            int player = move[2];

            try{
                int winner = game.makeMove(row, col, player);
                game.printBoard();
                if (winner != 0){
                    System.out.println("Player " + winner + " wins!");
                    break;
                }
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                break;
            }
        }

    }
}
