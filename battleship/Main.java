package battleship;
import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        GameField game1 = new GameField(1);
        System.out.println(game1.callPlayer());
        game1.generateBoard();
        game1.play();

        promptEnterKey();

        GameField game2 = new GameField(2);
        System.out.println(game2.callPlayer());
        game2.generateBoard();
        game2.play();

        
        GameField attack_1 = new Attack(game1.boardField, 2);
        GameField attack_2 = new Attack(game2.boardField, 1);


        Attack launch1 = (Attack) attack_1; // it's ok
        Attack launch2 = (Attack) attack_2; // it's ok



        while (true) {

            boolean isGameFinished = launch1.gameOver() && launch2.gameOver();

            if (isGameFinished) {
                break;
            }
            promptEnterKey();
            attack_2.fogOfWar();
            System.out.println("---------------------");
            attack_1.printField();
            attack_2.launchAttack();

            promptEnterKey();

            attack_1.fogOfWar();
            System.out.println("---------------------");
            attack_2.printField();

            attack_1.launchAttack();
        }          
        
    }

    public static void promptEnterKey() {
        System.out.println("Press Enter and pass the move to another player");
        sc.nextLine();

    }
}

