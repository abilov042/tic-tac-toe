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
                gameFields.getFields()[(choice - 1) / 3][(choice - 1) % 3] = 'X';
                gameFields.getPayedFields()[(choice - 1) / 3][(choice - 1) % 3] = true;
                gameFields.setFirstPlayer(false);

                if(checkPlayerXWon(gameFields)){
                    System.out.println("Player X Won");
                    gameDisplay.display(gameFields);
                    break;
                }
            }
            else {
                gameFields.getFields()[(choice - 1) / 3][(choice - 1) % 3] = 'O';
                gameFields.getPayedFields()[(choice - 1) / 3][(choice - 1) % 3] = true;
                gameFields.setFirstPlayer(true);
                if(checkPlayerOWon(gameFields)){
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


    private boolean checkPlayerXWon(GameFields gameFields){
        if(gameFields.getFields()[0][0] == 'X' && gameFields.getFields()[0][1] == 'X' && gameFields.getFields()[0][2] == 'X'){
            return true;
        }
        else if(gameFields.getFields()[1][0] == 'X' && gameFields.getFields()[1][1] == 'X' && gameFields.getFields()[1][2] == 'X'){
            return true;
        }
        else if(gameFields.getFields()[2][0] == 'X' && gameFields.getFields()[2][1] == 'X' && gameFields.getFields()[2][2] == 'X'){
            return true;
        }
        else if (gameFields.getFields()[0][0] == 'X' && gameFields.getFields()[1][0] == 'X' && gameFields.getFields()[2][0] == 'X'){
            return true;
        }
        else if(gameFields.getFields()[0][2] == 'X' && gameFields.getFields()[1][2] == 'X' && gameFields.getFields()[2][2] == 'X'){
            return true;
        }
        else if(gameFields.getFields()[0][1] == 'X' && gameFields.getFields()[1][1] == 'X' && gameFields.getFields()[2][1] == 'X'){
            return true;
        }
        else if(gameFields.getFields()[0][0] == 'X' && gameFields.getFields()[1][1] == 'X' && gameFields.getFields()[2][2] == 'X'){
            return true;
        }
        else return gameFields.getFields()[0][2] == 'X' && gameFields.getFields()[1][1] == 'X' && gameFields.getFields()[2][0] == 'X';
    }

    private boolean checkPlayerOWon(GameFields gameFields){
        if(gameFields.getFields()[0][0] == 'O' && gameFields.getFields()[0][1] == 'O' && gameFields.getFields()[0][2] == 'O'){
            return true;
        }
        else if(gameFields.getFields()[1][0] == 'O' && gameFields.getFields()[1][1] == 'O' && gameFields.getFields()[1][2] == 'O'){
            return true;
        }
        else if(gameFields.getFields()[2][0] == 'O' && gameFields.getFields()[2][1] == 'O' && gameFields.getFields()[2][2] == 'O'){
            return true;
        }
        else if (gameFields.getFields()[0][0] == 'O' && gameFields.getFields()[1][0] == 'O' && gameFields.getFields()[2][0] == 'O'){
            return true;
        }
        else if(gameFields.getFields()[0][2] == 'O' && gameFields.getFields()[1][2] == 'O' && gameFields.getFields()[2][2] == 'O'){
            return true;
        }
        else if(gameFields.getFields()[0][1] == 'O' && gameFields.getFields()[1][1] == 'O' && gameFields.getFields()[2][1] == 'O'){
            return true;
        }
        else if(gameFields.getFields()[0][0] == 'O' && gameFields.getFields()[1][1] == 'O' && gameFields.getFields()[2][2] == 'O'){
            return true;
        }
        else return gameFields.getFields()[0][2] == 'O' && gameFields.getFields()[1][1] == 'O' && gameFields.getFields()[2][0] == 'O';
    }

}
