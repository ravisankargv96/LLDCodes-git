package Refactoring;

public class GameResult {
    boolean isOver;
    Initial.Player winner;

    public GameResult(boolean isOver, Initial.Player winner) {
        this.isOver = isOver;
        this.winner = winner;
    }
}
