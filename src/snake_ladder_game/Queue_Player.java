/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake_ladder_game;

import entity.Player;
import static snake_ladder_game.Snake_ladder_game.playerList;
import static snake_ladder_game.Snake_ladder_game.playerQueue;

/**
 *
 * @author kengboongoh
 */
public class Queue_Player {
    
    public static void queuePlayer(){
        
     for(int i=0; i<playerList.size();i++){
        playerQueue.enqueue(playerList.get(i));
    }
     System.out.println(playerQueue.toString());
}
    public static void round(){
        //System.out.println(playerQueue.getFront().getPlayerName());
        //System.out.println("");
        
        int totalStep = Roll_Dice.rollDice();
        int currentPosition =  playerList.get(playerQueue.getFront().getNumber()).getCurrentPosition();
        //playerQueue.getFront().getNumber();
        //System.out.println(playerList.get(playerQueue.getFront().getNumber()));
        playerList.get(playerQueue.getFront().getNumber()).setCurrentPosition(totalStep+currentPosition);
        
 
        
        //System.out.println("current position "+playerList.get(playerQueue.getFront().getNumber()).getCurrentPosition());

        
    }
    
    public static void turnRound(){
    
     
        int num =  playerQueue.getFront().getNumber();
        //System.out.println(playerList.get(num));
        playerQueue.dequeue();
        playerQueue.enqueue(playerList.get(num));
        
 
        System.out.println(playerQueue.toString());
        
        
        
    }
    
}
