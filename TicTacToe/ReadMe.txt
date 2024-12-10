This is project is building TicTacToe from scratch by grabbing lots of design level conclusions.

01.Low Level Design:
    Assignment: Create a turn-based Game AI Engine
        Chess
        TicTacToe
        Sudoku
        Go
        ChainReaction

    Readability, Extensiablity & Correctness

    Let's stick to TicTacToe

    If you are writing some standarized ways, It's always good to not have access to user. Use methods like get to
    return the expected result.

    i.e. board.cells[i][j]  <=> board.cells.get(i,j), this type avoid user manipulation.
    In short, all the state representation in the game are sensitive data that cannot be manipulated by user.