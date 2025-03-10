public class GameDisplay {


    public void display(GameFields gameFields) {
        for(int i = 0; i < gameFields.getFields().length; i++) {
            for(int j = 0; j < gameFields.getFields()[0].length; j++) {
                System.out.print(gameFields.getFields()[i][j] + " ");
            }
            System.out.println();
        }
    }
}