/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake_ladder_game;

import adt.LinkedStack;
import adt.LinkedStackInterface;
import entity.Dice;
import java.util.Scanner;
import static snake_ladder_game.Snake_ladder_game.playerList;
import static snake_ladder_game.Snake_ladder_game.playerQueue;

/**
 *
 * @author User
 */
public class Roll_Dice {
    
      private static LinkedStackInterface<Integer> dice = new LinkedStack<Integer>();
      static Dice diceNum = new Dice();
      static Scanner scan = new Scanner(System.in);
      static int countRollTime=1;
      
      
      
    public static int rollDice(){
        int totalStep =0;
        
        do{
          
          diceNum.roll();
          System.out.println( playerList.get(playerQueue.getFront().getNumber()).getPlayerName() + " rolled : "+diceNum.getDice());
          dice.push(diceNum.getDice());
           if(diceNum.getDice()==6){
              
               System.out.println("Congratulations!"+ playerList.get(playerQueue.getFront().getNumber()).getPlayerName()+" rolled 6, so you have an extra chance to roll it again.");
               countRollTime++;
           }
           totalStep+=diceNum.getDice();
           
      }while (diceNum.getDice()==6);
      System.out.println(playerList.get(playerQueue.getFront().getNumber()).getPlayerName()+" total step is: "+totalStep);
      
      return totalStep;
    }
    
    public static void initiateDice() {
      char selection;
      char opinion;
      do{
      System.out.println("Do you want roll the dice?(Y = yes): ");
      opinion = scan.next().charAt(0);
      if(Character.toUpperCase(opinion)!='Y'){
         System.out.println("Invalid ! Please try again.");
         System.out.println("");
     }
      }while(Character.toUpperCase(opinion)!='Y');
       rollDice();
      do{
         
    System.out.print("Do you want reroll again? (Y = yes N = No): ");
    selection = scan.next().charAt(0);
     if(Character.toUpperCase(selection)!='Y'&& Character.toUpperCase(selection)!='N'){
         System.out.println("Invalid choice! Please choose again.");
         System.out.println("");
     }
      }while(Character.toUpperCase(selection)!='Y'&& Character.toUpperCase(selection)!='N');
    
        if(Character.toUpperCase(selection)!='N'){
            for(int i=0;i<countRollTime;i++){
            dice.pop();
            }
            countRollTime=1;
            System.out.println("");
             rollDice();
        }
        else{
            dice.push(diceNum.getDice());
        }
}
}
