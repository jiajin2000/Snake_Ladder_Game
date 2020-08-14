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

/**
 *
 * @author User
 */
public class Roll_Dice {
    
      private static LinkedStackInterface<Integer> dice = new LinkedStack<Integer>();
      static Dice diceNum = new Dice();
      static Scanner scan = new Scanner(System.in);
      static int countRollTime=1;
      
    public static void rollDice(){
        int totalStep =0;
        
        do{
          
          diceNum.roll();
          System.out.println("You rolled :"+diceNum.getDice());
          dice.push(diceNum.getDice());
           if(diceNum.getDice()==6){
              
               System.out.println("Congratulations! You rolled 6, so you have an extra chance to roll it again.");
               countRollTime++;
           }
           totalStep+=diceNum.getDice();
           
      }while (diceNum.getDice()==6);
      System.out.println("Your total step is:"+totalStep);
    }
    
    public static void main(String[] args) {
      char selection;
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
