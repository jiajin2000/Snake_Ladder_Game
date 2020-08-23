package snake_ladder_game;

import adt.ArrList;
import entity.Player;
import java.util.regex.Pattern;
import static snake_ladder_game.Snake_ladder_game.scan;
import static snake_ladder_game.Snake_ladder_game.playerList;

public class Add_Player {

    public static void addPlayer() {

        String line = "================================";
        playerList = new ArrList<>();

        int option;

        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        String data = "1";

        do {
            System.out.print("How Many Player for this Game ?(Min 2, Max 4):");
            while (!scan.hasNextInt()) {
                System.out.println("Invalid Entry of Number of Player !");
                System.out.print("How Many Player for this Game ?(Min 2, Max 4):");
                scan.next(); // this is important!
            }
            option = scan.nextInt();
            data = Integer.toString(option);
        } while ((option < 2 || option > 4) || (pattern.matcher(data).matches() == false));

        String clear = scan.nextLine();
        for (int i = 1; i <= option; i++) {

            System.out.print("Please Enter Player " + i + "'s Name  :");
            String name = scan.nextLine();

            while (name.length() > 3) {
                System.out.println("\nMaximum Length of Player's Name is 3 !\n");
                System.out.print("Please Enter Player " + i + "'s Name  :");
                name = scan.nextLine();
                System.out.println("");
            }

            playerList.add(new Player(name));

        }

        System.out.println("");
        System.out.println("Player Successfully Registered !\n" + line);
        System.out.println(playerList.toString());

    }

}
