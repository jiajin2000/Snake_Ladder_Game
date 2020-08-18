/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake_ladder_game;

import adt.ArrList;
import adt.ArrListInterface;
import adt.BinarySearchTree;
import adt.BinarySearchTreeInterface;
import adt.CircularArrQueueInterface;
import adt.DoublyLinkedListInterface;
import entity.Leaderboard;
import entity.Player;
import entity.SorLSquare;
import java.util.Iterator;
import snake_ladder_game.Add_Player;
import static snake_ladder_game.Snake_ladder_game.playerList;
import static snake_ladder_game.Snake_ladder_game.playerQueue;
/**
 *
 * @author kengboongoh
 */
public class Add_Snake_Ladder {
    
     public static ArrListInterface<SorLSquare> SorLSquareList;
     public static BinarySearchTree startTree = new BinarySearchTree();
     public static BinarySearchTree endTree = new BinarySearchTree();
     static String line = "================================";  
    
    public static void SorLTree() {
      
       SorLSquareList = new ArrList<>(10);
       addSnakeorLadder();
     
      Object[] sol = {"Snake",28,30};
      
      for (int i = 0; i < SorLSquareList.size(); i++) {
          
      startTree.add(SorLSquareList.get(i).getStartSquare());
    
      endTree.add(SorLSquareList.get(i).getEndSquare());
     
    }

    //System.out.println("\nStartTree contains: ");
    //Add_Snake_Ladder.display(startTree);
    
    //System.out.println("\nEndTree contains: ");
    //display(endTree);
     System.out.println("========Snakes & Ladders========\n");
     System.out.print(SorLSquareList.toString());
     System.out.println(line);
    
          
    }
    
    public static void addSnakeorLadder() {
         
         
         SorLSquareList.add(new SorLSquare("Ladder",20,31));
         SorLSquareList.add(new SorLSquare("Ladder",6,25));
         SorLSquareList.add(new SorLSquare("Ladder",41,60));
         SorLSquareList.add(new SorLSquare("Ladder",30,80));
         
         SorLSquareList.add(new SorLSquare("Snake",50,7));
         SorLSquareList.add(new SorLSquare("Snake",31,20));
         SorLSquareList.add(new SorLSquare("Snake",78,50));
         SorLSquareList.add(new SorLSquare("Snake",90,61));
     
         
    }
   
     public static void checkSorL(){
     
         int currentPosition =  playerList.get(playerQueue.getFront().getNumber()).getCurrentPosition();

         String name =  playerList.get(playerQueue.getFront().getNumber()).getPlayerName();
         
         //for (int i = 0; i < currentPosition.length; i++)
         //{
          if(startTree.contains(currentPosition)){
              
              for (int t = 0; t < SorLSquareList.size(); t++) {
                  
                  int position=currentPosition;
                  int startSquare=SorLSquareList.get(t).getStartSquare();
                  int endSquare=SorLSquareList.get(t).getEndSquare();
                  String type =SorLSquareList.get(t).getType();
                  
                  if(position == startSquare && type == "Ladder")
                  {
                    currentPosition = endSquare;
                    playerList.get(playerQueue.getFront().getNumber()).setCurrentPosition(currentPosition);
                    System.out.println("\n** Woo Hoo ! "+ name+ " taking the Shortcut with the Ladder from Position "+ startSquare + " to " + endSquare+" **\n");
                  
                  }
                 
              }
              
          }
          
          if(endTree.contains(currentPosition)){
              
              
              for (int q = 0; q < SorLSquareList.size(); q++) {
                  
                  int position=currentPosition;
                  int startSquare=SorLSquareList.get(q).getStartSquare();
                  int endSquare=SorLSquareList.get(q).getEndSquare();
                  String type =SorLSquareList.get(q).getType();
                  
                  if(position == endSquare && type == "Snake")
                  {
                    currentPosition = endSquare - 1;
                     playerList.get(playerQueue.getFront().getNumber()).setCurrentPosition(currentPosition);
                    System.out.println("\n** Oh No ! The Snake is too Slippery, "+ name+ " slide from Position "+ startSquare + " to " + endSquare+" **\n");
                  
                  }
            
              }
              
          }
             
         //}
  
         
     }
     
    public static void display(BinarySearchTreeInterface tree) {
        
      Iterator it = tree.getInorderIterator();
       while (it.hasNext()) {
         System.out.print(it.next() + " ");
          }
       System.out.println("\n");
     }
}
