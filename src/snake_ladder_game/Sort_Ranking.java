package snake_ladder_game;

import adt.DoublyLinkedList;
import adt.DoublyLinkedListInterface;
import entity.Leaderboard;
import java.util.Iterator;
import static snake_ladder_game.Snake_ladder_game.leaderboardList;
import static snake_ladder_game.Snake_ladder_game.playerList;
import static snake_ladder_game.Snake_ladder_game.playerQueue;

public class Sort_Ranking {

    static String line = "================================";
    static String line2 = "--------------------------------";
    static String layout = String.format("%-5s %-20s %-5s", "Rank", "Player", "Score");

    public static void updateRanking() {

        String name = playerList.get(playerQueue.getFront().getNumber()).getPlayerName();
        int newPosition = playerList.get(playerQueue.getFront().getNumber()).getCurrentPosition();
        leaderboardList.remove(new Leaderboard(name));
        leaderboardList.add(new Leaderboard(name, newPosition));

        System.out.println(line + "\n\t  Leaderboard\n" + line);
        System.out.println(layout);
        System.out.println(line2);
        System.out.println(leaderboardList.toString());

    }

    public static void createLeaderBoard() {

        for (int i = 0; i < playerList.size(); i++) {
            String id = playerList.get(i).getPlayerName();
            Snake_ladder_game.leaderboardList.add(new Leaderboard(id));
        }

        System.out.println(line + "\n\t  Leaderboard\n" + line);
        System.out.println(layout);
        System.out.println(line2);
        System.out.println(leaderboardList.toString());
    }

}
