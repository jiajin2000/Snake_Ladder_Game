package snake_ladder_game;
import entity.Player;
import adt.ArrList;
import adt.CircularArrQueue;
import adt.ArrListInterface;
import adt.DoublyLinkedList;
import adt.DoublyLinkedListInterface;
import entity.Leaderboard;
import adt.CircularArrQueueInterface;
import java.util.*;
/**
 *
 * @author kengboongoh
 */
public class Snake_ladder_game {

    /**
     * @param args the command line arguments
     */
  static Scanner scan = new Scanner(System.in);
  private ArrListInterface<Player> playerList;
  private DoublyLinkedListInterface<Leaderboard> leaderboardList;
  private CircularArrQueueInterface<String> playerQueue;
   
  public Snake_ladder_game(){
    String line = "================================";  
    playerList = new ArrList<>();
    leaderboardList = new DoublyLinkedList<>();
    Iterator<Leaderboard> display = leaderboardList.getIterator();
    addPlayer();
    
    System.out.println("");
    System.out.println("Player Successfully Registered !\n" + line);
    System.out.println(playerList.toString());
    //System.out.println(PlayerArrList.toString());
    playerQueue = new CircularArrQueue<>();
    queuePlayer();
    
    System.out.println(line + "\n\t  Leaderboard\n" + line);
    System.out.println(leaderboardList.toString());
    System.out.println(leaderboardList.getNth(0).getId() + "  is leading!!");
    
    
    //leaderboardList.remove(new Leaderboard("p1"));
    //System.out.println(leaderboardList.toString());
  }
  
  
  private void addPlayer() {
      
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
    
  }
  
  private void ranking(){
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
  
  private void queuePlayer(){
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
    
}
