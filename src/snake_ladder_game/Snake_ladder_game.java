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
  public static CircularArrQueueInterface<Player> playerQueue;
  public static BinarySearchTree startTree = new BinarySearchTree();
  public static BinarySearchTree endTree = new BinarySearchTree();
   

  
    public static void main(String[] args) {
       
        String line = "================================";  
        leaderboardList = new DoublyLinkedList<>();
        Iterator<Leaderboard> display = leaderboardList.getIterator();
        playerList = new ArrList<>();
        playerQueue = new CircularArrQueue<>();
        Add_Player.addPlayer();

        Add_Snake_Ladder.SorLTree();
        //Add_Snake_Ladder.checkSorL();
        //playerList.get(1).setCurrentPosition(4);
        Board_Layout.Board_Layout();
        //Sort_Ranking.ranking();
        //Queue_Player.queuePlayer();
        
        Sort_Ranking.createLeaderBoard();
        
        Queue_Player.queuePlayer();
       
        while(!leaderboardList.getNth(0).isIsWinner()){
        

            Queue_Player.round();
           
            
            Board_Layout.Board_Layout();
            
            Sort_Ranking.ranking();
 
            Queue_Player.turnRound();
        
        }
      
        
        //Board_Layout.displayBoard100();

    }

}
