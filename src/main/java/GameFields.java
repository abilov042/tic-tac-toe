public class GameFields {


    private boolean isFirstPlayer = true;
    private int moveCounter = 0;
    public static char X = 'X';
    public static char O = 'O';

    private final char[][] fields = new char[][]{
                                                    {'1', '2', '3'},
                                                    {'4', '5', '6'},
                                                    {'7', '8', '9'}};


    private final boolean[][] payedFields = new boolean[][]{
                                                    {false, false, false},
                                                    {false, false, false},
                                                    {false, false, false}};

    public boolean[][] getPayedFields() {
        return payedFields;
    }

    public char[][] getFields() {
        return fields;
    }

    public boolean isFirstPlayer() {
        return isFirstPlayer;
    }

    public void setFirstPlayer(boolean firstPlayer) {
        isFirstPlayer = firstPlayer;
    }

    public int getMoveCounter() {
        return moveCounter;
    }
    public void incrementMove(){
        moveCounter++;
    }
}
