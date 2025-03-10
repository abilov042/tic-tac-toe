import java.util.InputMismatchException;
import java.util.Scanner;

public class GameLogic {

    private final GameDisplay gameDisplay;

    public GameLogic(GameDisplay gameDisplay) {
        this.gameDisplay = gameDisplay;
    }


    public void startGame(GameFields gameFields){

        Scanner scanner = new Scanner(System.in);

        while(true){
            gameDisplay.display(gameFields);

            int choice;
            try {
                choice = scanner.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("Invalid input");
                scanner.nextLine();
                continue;
            }


            if(gameFields.getPayedFields()[(choice - 1) / 3][(choice - 1) % 3]){
                System.out.println("Invalid choice");
                continue;
            }
            else if(gameFields.isFirstPlayer()){
                gameFields.getFields()[(choice - 1) / 3][(choice - 1) % 3] = GameFields.X;
                gameFields.getPayedFields()[(choice - 1) / 3][(choice - 1) % 3] = true;
                gameFields.setFirstPlayer(false);

                if(checkPlayerWon(gameFields, GameFields.X)){
                    System.out.println("Player X Won");
                    gameDisplay.display(gameFields);
                    break;
                }
            }
            else {
                gameFields.getFields()[(choice - 1) / 3][(choice - 1) % 3] = GameFields.O;
                gameFields.getPayedFields()[(choice - 1) / 3][(choice - 1) % 3] = true;
                gameFields.setFirstPlayer(true);
                if(checkPlayerWon(gameFields, GameFields.O)){
                    System.out.println("Player O Won");
                    gameDisplay.display(gameFields);
                    break;
                }
            }
            gameFields.incrementMove();
            if (gameFields.getMoveCounter() == 9){
                System.out.println("Tie game");
                gameDisplay.display(gameFields);
                break;
            }
        }
    }


    private boolean checkPlayerWon(GameFields gameFields, char player){
        if(gameFields.getFields()[0][0] == player && gameFields.getFields()[0][1] == player && gameFields.getFields()[0][2] == player){
            return true;
        }
        else if(gameFields.getFields()[1][0] == player && gameFields.getFields()[1][1] == player && gameFields.getFields()[1][2] == player){
            return true;
        }
        else if(gameFields.getFields()[2][0] == player && gameFields.getFields()[2][1] == player && gameFields.getFields()[2][2] == player){
            return true;
        }
        else if (gameFields.getFields()[0][0] == player && gameFields.getFields()[1][0] == player && gameFields.getFields()[2][0] == player){
            return true;
        }
        else if(gameFields.getFields()[0][2] == player && gameFields.getFields()[1][2] == player && gameFields.getFields()[2][2] == player){
            return true;
        }
        else if(gameFields.getFields()[0][1] == player && gameFields.getFields()[1][1] == player && gameFields.getFields()[2][1] == player){
            return true;
        }
        else if(gameFields.getFields()[0][0] == player && gameFields.getFields()[1][1] == player && gameFields.getFields()[2][2] == player){
            return true;
        }
        else return gameFields.getFields()[0][2] == player && gameFields.getFields()[1][1] == player && gameFields.getFields()[2][0] == player;
    }

}
