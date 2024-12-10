package ATicTacToe;

/**
 * Initialize the board.
 * 1. Board Can be any size (nXn), currently we are initializing 3 X 3 board
 * 2. Print the first state of the board.
 * */
public class TicTacToe {

    private int n;

    // board Size
    private int[][] board;

    // Other calculations
    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;


    public TicTacToe(int n) {
        this.n = n;
        this.board = new int[n][n];

        //other calculations
        this.rows = new int[n];
        this.cols = new int[n];
        this.diagonal = 0;
        this.antiDiagonal = 0;

    }

    /**
     * Make a move on the board.
     * @param row index of the move.
     * @param col index of the move.
     * @param player The player making the move (1 or 2).
     * @return 0 if no winner, 1 if player 1 wins, 2 if player 2 wins.
     * @throws IllegalArgumentException If the cell is already occupied.
     * */

    public int makeMove(int row, int col, int player){

        // Don't make move in already marked places
        if (board[row][col] != 0){
            throw new IllegalArgumentException("Cell is already occupied!");
        }

        board[row][col] = player;

        //Note: Can write below logic as isGameOver()
        // Calculation i.e. boardStatus

        int score = (player == 1) ? 1 : -1;

        rows[row] += score;
        cols[col] += score;
        diagonal += (row == col) ? score: 0;
        antiDiagonal += (row + col == n-1) ? score: 0;

        // Check if the player wins
        if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n ||
        Math.abs(diagonal) == n || Math.abs(antiDiagonal) == n){
            return player; //winner
        }

        return 0; //Continue

    }



    /**
    * Print the current state of the board.
    * */
    public void printBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char cell = board[i][j] == 0 ? ' ' : (board[i][j] == 1 ? 'X' : 'O');
                System.out.print(cell);
                if (j < n - 1) System.out.print("|");
            }
            System.out.print("\n");
            if (i < n - 1) {
                System.out.print("-".repeat(n * 4 - 1));
            }
        }
    }
}
