public class Main {
    public static void main(String[] args) {

        GameLogic gameLogic = new GameLogic(new GameDisplay());
        gameLogic.startGame(new GameFields());
    }
}
