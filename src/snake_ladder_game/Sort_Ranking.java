/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake_ladder_game;
import static snake_ladder_game.Snake_ladder_game.leaderboardList;
import static snake_ladder_game.Snake_ladder_game.playerList;

/**
 *
 * @author kengboongoh
 */
public class Sort_Ranking {
    
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
    
}
