package Refactoring;

//Requirement: Taking a game & having the ability to play it through AI
/*
* Engineer:
*   1. What are the APIs to be exposed in the backend.
*       Note: At Code level API call <=> method call
*             So starting method is the API call
* */
public class GameEngine {

    public static void main(String[] args) {

    }

    // returns the state of the board, entry point to play the game
    public Initial.Board start(){
        return new Initial.Board();
    }

    // Playing the game: making move on turn based.
    public void move(Initial.Board board, Initial.Player player, Initial.Move move){

    }

    // Check if the game is complete? Outcome: ["true", "Winner"] Result = win, lose, draw
    public Initial.GameResult isComplete(Initial.Board board){

        // Checking the state of TicTacToe board, whether it's completed or not.
        // This logic can be written in any best ways.

        if(board instanceof Initial.TicTacToeBoard){
            Initial.TicTacToeBoard board1 = (Initial.TicTacToeBoard) board;

            boolean rowComplete = true, colComplete = true, diagComplete = true, revDiagComplete = true;
            for (int i = 0; i < 3; i++){
                rowComplete = false;

                String firstCharacter = ((Initial.TicTacToeBoard) board1).cells[i][0];
                for (int j = 0; j < 3; j++){

                    if(!board1.cells[i][j].equals(firstCharacter)){
                        rowComplete = false;
                        break;
                    }
                    /*
                    if (board1.cells[i][j].equals(firstCharacter)){

                    } else{
                        rowComplete = false;
                    }
                     */
                }

                if (rowComplete){
                    break;
                }
            }

            for (int i = 0; i < 3; i++){
                colComplete = true;

                String firstCharacter = ((Initial.TicTacToeBoard) board1).cells[i][0];
                for (int j = 1; j < 3; j++){

                    if(!board1.cells[j][i].equals(firstCharacter)){
                        colComplete = false;
                        break;
                    }
                }

                if (colComplete){
                    break;
                }
            }

            // diagonals are 2 types: i = j & i + j = c; c can be either m or n for rectangular matrix
            for(int i = 0; i < 3; i++){
                diagComplete = true;
                String firstCharacter = board1.cells[0][0];
                if(!board1.cells[i][i].equals(firstCharacter)){
                    diagComplete = false;
                    break;
                }
            }

            for(int i = 0; i < 3; i++){
                revDiagComplete = true;
                String firstCharacter = board1.cells[i][2-i];
                if(!board1.cells[0 + i][2-i].equals(firstCharacter)){
                    revDiagComplete = false;
                }
            }

            if(rowComplete || colComplete || diagComplete || revDiagComplete){
                return new Initial.GameResult();
            }

            String firstCharacter;
            int countOfFilledCells = 0;
            for(int i = 0; i < 3; i++){
                for(int j = 1; j < 3; j++){
                    if(!board1.cells[j][i] != null){
                        countOfFilledCells++;
                    }
                }
            }

            if (countOfFilledCells == 9){
                return new Initial.GameResult(true, "-");
            } else {
                return new Initial.GameResult(false, "-")
            }

        }

    }
}

/**
 * Conclusions:
 *      All the objects are in the same files. Very Scary to change any piece of logic.
 *          1. Separation of Classes into multiple files.
 * */
