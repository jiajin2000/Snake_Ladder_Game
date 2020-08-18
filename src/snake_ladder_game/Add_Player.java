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
import java.util.regex.Pattern;
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
   
    // Hardcoded data for testing purposes only
    int option;
    //System.out.print("How Many Player for this Game ?(Min 2, Max 4):");
    //option = scan.nextInt();
    
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
    } while ((option < 2 || option > 4) || (pattern.matcher(data).matches()== false));
    
    //String regex = "\\d+";
    //Pattern pattern = Pattern.compile(regex);
    //String data = Integer.toString(option);
    //System.out.print(pattern.matcher(data).matches());
    
    // while((option < 2 || option > 4) || (pattern.matcher(data).matches()== false) ){
         
     //       System.out.println("Invalid Entry of Number of Player !");
     //       System.out.print("How Many Player for this Game ?(Min 2, Max 4):");
     //       option = scan.nextInt();
     //       System.out.println("");
     //   }
     
     
    String clear = scan.nextLine();
    for (int i = 1; i <= option; i++) {
         
         System.out.print("Please Enter Player " + i + "'s Name  :");
         String name = scan.nextLine();
         
         while(name.length()>3){
            System.out.println("\nMaximum Length of Player's Name is 3 !\n");
            System.out.print("Please Enter Player " + i + "'s Name  :");
            name = scan.nextLine();
            System.out.println("");
        }
         
         playerList.add(new Player(name));
      
        
    }
    //playerList.add(new Player("Jen Tat"));
    //playerList.add(new Player("Chia Ter"));
    
    
     System.out.println("");
     System.out.println("Player Successfully Registered !\n" + line);
     System.out.println(playerList.toString());
     //System.out.println(PlayerArrList.toString());
     //playerQueue = new CircularArrQueue<>();
     //queuePlayer();
    
     //System.out.println(line + "\n\t  Leaderboard\n" + line);
     //System.out.println(leaderboardList.toString());
     //System.out.println(leaderboardList.getNth(0).getId() + "  is leading!!");
  }
    
}
