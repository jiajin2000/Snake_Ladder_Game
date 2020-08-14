/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake_ladder_game;

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
        System.out.println(playerQueue.getFront().getPlayerName());
        System.out.println("");
    }
    
}
