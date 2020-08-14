/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake_ladder_game;

import adt.ArrList;
import adt.DoublyLinkedList;
import entity.Leaderboard;
import entity.Player;
import java.util.Iterator;
import static snake_ladder_game.Snake_ladder_game.scan;
import static snake_ladder_game.Snake_ladder_game.leaderboardList;
import static snake_ladder_game.Snake_ladder_game.playerList;

/**
 *
 * @author kengboongoh
 */
public class Add_Player {
    

    public static void addPlayer() {
     //ArrListInterface<Player> playerList;
     //DoublyLinkedListInterface<Leaderboard> leaderboardList;
     
    String line = "================================";  
    playerList = new ArrList<>();
    leaderboardList = new DoublyLinkedList<>();
    Iterator<Leaderboard> display =leaderboardList.getIterator();
      
    // Hardcoded data for testing purposes only
    int option;
    System.out.print("How Many Player for this Game ?(Min 2, Max 4):");
    option = scan.nextInt();
    
     while(option < 2 || option > 4 ){
         
            System.out.println("Invalid Entry of Number of Player !");
            System.out.print("How Many Player for this Game ?(Min 2, Max 4):");
            option = scan.nextInt();
            System.out.println("");
        }
     
     
    String clear = scan.nextLine();
    for (int i = 1; i <= option; i++) {
         
         System.out.print("Please Enter Player " + i + "'s Name  :");
         String name = scan.nextLine();
         playerList.add(new Player(name));
         leaderboardList.add(new Leaderboard(name, 0));
        
    }
    //playerList.add(new Player("Jen Tat"));
    //playerList.add(new Player("Chia Ter"));
    
    
     System.out.println("");
     System.out.println("Player Successfully Registered !\n" + line);
     System.out.println(playerList.toString());
     //System.out.println(PlayerArrList.toString());
     //playerQueue = new CircularArrQueue<>();
     //queuePlayer();
    
     System.out.println(line + "\n\t  Leaderboard\n" + line);
     System.out.println(leaderboardList.toString());
     System.out.println(leaderboardList.getNth(0).getId() + "  is leading!!");
  }
    
}
