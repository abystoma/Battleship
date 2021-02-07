package battleship;

public class Main {
    public static void main(String[] args) {
        GameField gameField = new GameField();

        gameField.generateBoard();

        gameField.play();
    }
}