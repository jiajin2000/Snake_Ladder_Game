package snake_ladder_game;

import adt.LinkedStack;
import adt.LinkedStackInterface;
import entity.Dice;
import java.util.Scanner;
import static snake_ladder_game.Add_Snake_Ladder.checkSorL;
import static snake_ladder_game.Snake_ladder_game.TOTAL_BOARD_SQUARE;
import static snake_ladder_game.Snake_ladder_game.playerList;
import static snake_ladder_game.Snake_ladder_game.playerQueue;

public class Roll_Dice {

    private static LinkedStackInterface<Integer> dice = new LinkedStack<Integer>();
    static Dice diceNum = new Dice();
    static Scanner scan = new Scanner(System.in);
    static int countRollTime = 1;
    static String line = "=====================================";

    public static int rollDice() {

        int totalStep = 0;

        do {

            diceNum.roll();
            System.out.println(playerList.get(playerQueue.getFront().getNumber()).getPlayerName() + " rolled\t: " + diceNum.getDice());
            dice.push(diceNum.getDice());

            if (diceNum.getDice() == 6) {

                System.out.println("Congratulations !!! " + playerList.get(playerQueue.getFront().getNumber()).getPlayerName() + " rolled 6, so you have an extra chance to roll it again.");
                countRollTime++;
                System.out.print("Key in anything to roll the dice again: ");
                scan.next().charAt(0);
            }

            totalStep += diceNum.getDice();

        } while (diceNum.getDice() == 6);

        System.out.println(playerList.get(playerQueue.getFront().getNumber()).getPlayerName() + " total step is: " + totalStep);
        System.out.println(line);

        return totalStep;
    }

    public static void initiateDice() {
        char selection;

        System.out.println(line);

        System.out.print("Key in anything to roll the dice: ");
        scan.next().charAt(0);

        System.out.println(line);

        int steps = rollDice();

        do {

            System.out.print("Do you want reroll again ? * One Chance Only *  (Y = yes N = No): ");
            selection = scan.next().charAt(0);

            if (Character.toUpperCase(selection) != 'Y' && Character.toUpperCase(selection) != 'N') {

                System.out.println("Invalid choice! Please choose again.");
                System.out.println("");

            }

        } while (Character.toUpperCase(selection) != 'Y' && Character.toUpperCase(selection) != 'N');

        if (Character.toUpperCase(selection) != 'N') {
            System.out.println("");
            System.out.println("");
            System.out.println("Now still is " + playerList.get(playerQueue.getFront().getNumber()).getPlayerName() + " Turn ! Because " + playerList.get(playerQueue.getFront().getNumber()).getPlayerName() + " select reroll again.");
            System.out.println(line);

            System.out.print("Enter anything to roll again the dice: ");
            scan.next().charAt(0);

            System.out.println(line);
            for (int i = 0; i < countRollTime; i++) {
                dice.pop();
            }

            countRollTime = 1;
            System.out.println("");
            int totalStep = rollDice();
            setPosition(totalStep);

        } else {
            dice.push(diceNum.getDice());
            setPosition(steps);
        }

    }

    public static void setPosition(int totalStep) {

        int currentPosition = playerList.get(playerQueue.getFront().getNumber()).getCurrentPosition() + totalStep;

        if (currentPosition > TOTAL_BOARD_SQUARE) {

            currentPosition = TOTAL_BOARD_SQUARE - (currentPosition - TOTAL_BOARD_SQUARE);
        }

        playerList.get(playerQueue.getFront().getNumber()).setCurrentPosition(currentPosition);
        System.out.println(playerList.get(playerQueue.getFront().getNumber()).getPlayerName() + " Moved To " + currentPosition);
        System.out.println(line);
    }
}
