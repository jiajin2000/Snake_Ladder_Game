package snake_ladder_game;

import entity.Player;
import static snake_ladder_game.Add_Snake_Ladder.checkSorL;
import static snake_ladder_game.Snake_ladder_game.playerList;
import static snake_ladder_game.Snake_ladder_game.playerQueue;

public class Queue_Player {

    public static void queuePlayer() {

        for (int i = 0; i < playerList.size(); i++) {
            playerQueue.enqueue(playerList.get(i));
        }

    }

    public static void round() {

        System.out.println("Now is " + playerList.get(playerQueue.getFront().getNumber()).getPlayerName() + " Turn !");
        Roll_Dice.initiateDice();
        checkSorL();

    }

    public static void turnRound() {

        int num = playerQueue.getFront().getNumber();

        playerQueue.dequeue();
        playerQueue.enqueue(playerList.get(num));

    }

}
