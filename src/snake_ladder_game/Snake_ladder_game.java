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

import java.io.File;
import java.util.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Snake_ladder_game {

    static Scanner scan = new Scanner(System.in);
    public static ArrListInterface<Player> playerList;
    public static DoublyLinkedListInterface<Leaderboard> leaderboardList;
    public static CircularArrQueueInterface<Player> playerQueue;
    public static BinarySearchTree startTree = new BinarySearchTree();
    public static BinarySearchTree endTree = new BinarySearchTree();

    public static void main(String[] args) {
        
        
        String filepath = "src/music/BGM.wav";
        playBGM(filepath);

        
        logo();
        leaderboardList = new DoublyLinkedList<>();
        Iterator<Leaderboard> display = leaderboardList.getIterator();
        playerList = new ArrList<>();
        playerQueue = new CircularArrQueue<>();
        Add_Player.addPlayer();

        Add_Snake_Ladder.SorLTree();
        Board_Layout.Board_Layout();
        Sort_Ranking.createLeaderBoard();

        Queue_Player.queuePlayer();
       
        
        while (!leaderboardList.getNth(0).checkWinner()) {
             
             
            Queue_Player.round();

            Board_Layout.board100();

            Sort_Ranking.updateRanking();

            Queue_Player.turnRound();

        }
        
    
        
        String winner = leaderboardList.getNth(0).getId();

        System.out.println("Congratulation !!!  " + winner + " WIN THE GAME !!!");
        
        filepath = "src/music/Kid_Cheers.wav";
        
        playWinnerBGM(filepath); 
        
        enterExit();
        
    }
    
    private static void enterExit(){
    
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.println("\nPress Enter Key to Exit Game ...");
            String s = null;
            try {
                s = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if((s == null)||(s.length() == 0)||(s.trim().equals(""))) //Press Enter to Exit...
            {
                //System.out.println("See You Again");
                System.exit(0);
            }else{
                 //Prevent User key in any other key and exit 
                 System.exit(0);
            }
        }
    }

    private static void logo() {

        System.out.println("      ___           ___           ___           ___           ___ ");
        System.out.println("     /  /\\         /__/\\         /  /\\         /__/|         /  /\\");
        System.out.println("    /  /:/_        \\  \\:\\       /  /::\\       |  |:|        /  /:/");
        System.out.println("   /  /:/ /\\        \\  \\:\\     /  /:/\\:\\      |  |:|       /  /:/ /\\");
        System.out.println("  /  /:/ /::\\   _____\\__\\:\\   /  /:/~/::\\   __|  |:|      /  /:/ /:/");
        System.out.println(" /__/:/ /:/\\:\\ /__/::::::::\\ /__/:/ /:/\\:\\ /__/\\_|:|____ /__/:/ /:/ /\\");
        System.out.println(" \\  \\:\\/:/~/:/ \\  \\:\\~~\\~~\\/ \\  \\:\\/:/__\\/ \\  \\:\\/:::::/ \\  \\:\\/:/ /:/");
        System.out.println("  \\  \\::/ /:/   \\  \\:\\  ~~~   \\  \\::/       \\  \\::/~~~~   \\  \\::/ /:/");
        System.out.println("   \\__\\/ /:/     \\  \\:\\        \\  \\:\\        \\  \\:\\        \\  \\:\\/:/");
        System.out.println("     /__/:/       \\  \\:\\        \\  \\:\\        \\  \\:\\        \\  \\::/ ");
        System.out.println("     \\__\\/         \\__\\/         \\__\\/         \\__\\/         \\__\\/ \n");

        System.out.println("      ___           ___          _____  ");
        System.out.println("     /  /\\         /__/\\        /  /::\\   ");
        System.out.println("    /  /::\\        \\  \\:\\      /  /:/\\:\\                   ____    ╬═╬");
        System.out.println("   /  /:/\\:\\        \\  \\:\\    /  /:/  \\:\\                 / . .\\   ╬═╬");
        System.out.println("  /  /:/~/::\\   _____\\__\\:\\  /__/:/ \\__\\:|                \\  ---<  ╬═╬");
        System.out.println(" /__/:/ /:/\\:\\ /__/::::::::\\ \\  \\:\\ /  /:/                 \\  /    ╬═╬");
        System.out.println(" \\  \\:\\/:/__\\/ \\  \\:\\~~\\~~\\/  \\  \\:\\  /:/        __________/ /     ╬═╬");
        System.out.println("  \\  \\::/       \\  \\:\\  ~~~    \\  \\:\\/:/      -=:___________/      ╬═╬");
        System.out.println("   \\  \\:\\        \\  \\:\\         \\  \\::/   ");
        System.out.println("    \\  \\:\\        \\  \\:\\         \\__\\/    ");
        System.out.println("     \\__\\/         \\__\\/                 ");

        System.out.println("                    ___          _____         _____          ___           ___     ");
        System.out.println("                   /  /\\        /  /::\\       /  /::\\        /  /\\         /  /\\    ");
        System.out.println("                  /  /::\\      /  /:/\\:\\     /  /:/\\:\\      /  /:/_       /  /::\\   ");
        System.out.println("  ___     ___    /  /:/\\:\\    /  /:/  \\:\\   /  /:/  \\:\\    /  /:/ /\\     /  /:/\\:\\  ");
        System.out.println(" /__/\\   /  /\\  /  /:/~/::\\  /__/:/ \\__\\:| /__/:/ \\__\\:|  /  /:/ /:/_   /  /:/~/:/  ");
        System.out.println(" \\  \\:\\ /  /:/ /__/:/ /:/\\:\\ \\  \\:\\ /  /:/ \\  \\:\\ /  /:/ /__/:/ /:/ /\\ /__/:/ /:/___");
        System.out.println("  \\  \\:\\  /:/  \\  \\:\\/:/__\\/  \\  \\:\\  /:/   \\  \\:\\  /:/  \\  \\:\\/:/ /:/ \\  \\:\\/:::::/");
        System.out.println("   \\  \\:\\/:/    \\  \\::/        \\  \\:\\/:/     \\  \\:\\/:/    \\  \\::/ /:/   \\  \\::/~~~~ ");
        System.out.println("    \\  \\::/      \\  \\:\\         \\  \\::/       \\  \\::/      \\  \\:\\/:/     \\  \\:\\     ");
        System.out.println("     \\__\\/        \\  \\:\\         \\__\\/         \\__\\/        \\  \\::/       \\  \\:\\    ");
        System.out.println("                   \\__\\/                                     \\__\\/         \\__\\/    \n");

    }
    
    private static void playWinnerBGM(String filepath){
    
        
        try
        {
            
        File musicPath = new File(filepath);
         
        if(musicPath.exists()){
            
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
            
            //JOptionPane.showMessageDialog(null,"Press OK to Exit Game");
            
        } else
        {
         System.out.println("Can't find file");
        }
        
        }
        catch(Exception ex){
        
            
        
        }
      
    }
    
     private static void playBGM(String filepath){
    
        
        try
        {
            
        File musicPath = new File(filepath);
         
        if(musicPath.exists()){
            
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            
     
            
            //clip.stop();
            
        } else
        {
         System.out.println("Can't find file");
        }
        
        }
        catch(Exception ex){
        
            
        
        }
      
    }
    

}
