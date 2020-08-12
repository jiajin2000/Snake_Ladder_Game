package snake_ladder_game;
import entity.Player;
import adt.ArrList;
import adt.CircularArrQueue;
import adt.ArrListInterface;
import adt.BinarySearchTree;
import adt.DoublyLinkedList;
import adt.DoublyLinkedListInterface;
import entity.Leaderboard;
import adt.CircularArrQueueInterface;
import java.util.*;
import java.util.Random;
/**
 *
 * @author kengboongoh
 */
public class Snake_ladder_game {

    /**
     * @param args the command line arguments
     */
  static Scanner scan = new Scanner(System.in);
  public static ArrListInterface<Player> playerList;
  public static DoublyLinkedListInterface<Leaderboard> leaderboardList;
  public static CircularArrQueueInterface<String> playerQueue;
  public static BinarySearchTree startTree = new BinarySearchTree();
  public static BinarySearchTree endTree = new BinarySearchTree();
   
  public Snake_ladder_game(){
    String line = "================================";  
    playerList = new ArrList<>();
    leaderboardList = new DoublyLinkedList<>();
    Iterator<Leaderboard> display = leaderboardList.getIterator();
    Add_Player.addPlayer();
    
    Add_Snake_Ladder.SorLTree();
    Add_Snake_Ladder.checkSorL();
    
    //Sort_Ranking.ranking();
   // Queue_Player.queuePlayer();
   
  }
  
  public static void ranking(){
      for(int i = 0; i < playerList.size();i++){
        int count = 1;
        String id = playerList.get(i).getPlayerName();
        int score = playerList.get(i).getCurrentPosition();
        
       // leaderboardList.add(new Leaderboard(id, score));
        
        System.out.print("No"+ count + "\t");
        count++;
        //String haha = leaderboardList.getNth(i).getId();
        //int ok = leaderboardList.getNth(i).getScore();    
        //System.out.println(haha);
    }
      System.out.println(leaderboardList.toString());
  }
  
  public static void queuePlayer(){
     for(int i=0; i<playerList.size();i++){
        playerQueue.enqueue(playerList.get(i).getPlayerName());
    }
     System.out.println(playerQueue.toString());
}
  
    public static void main(String[] args) {
        // TODO code application logic here
         new Snake_ladder_game();
       //System.out.println("HI");  `
        
    }


public class dice {
    public static int getRandomNumber(int seed) { 
	   Random randomGenerator; 
	   randomGenerator = new Random(); 
	   return randomGenerator.nextInt(seed) + 1; 
   } 
}
}
