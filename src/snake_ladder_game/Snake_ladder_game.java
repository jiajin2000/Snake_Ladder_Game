package snake_ladder_game;
import entity.Player;
import adt.ArrList;
import adt.CircularArrQueue;
import adt.ArrListInterface;
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
  
   
  public Snake_ladder_game(){
      
    playerList = new ArrList<>();
    addPlayer();
    System.out.println("");
    System.out.println("Player Successfully Registered !");
    System.out.println("================================");
    System.out.println(playerList.toString());
    
    for(int i=0; i<playerList.size();i++){
        System.out.println(playerList.get(i).getPlayerName());
    }
    //System.out.println(PlayerArrList.toString());
    
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
        
    }
    //playerList.add(new Player("Jen Tat"));
    //playerList.add(new Player("Chia Ter"));
    
  }
  
    public static void main(String[] args) {
        // TODO code application logic here
         new Snake_ladder_game();
       //System.out.println("HI");  `
        
    }
    
}
