package snake_ladder_game;

import entity.Player;
import adt.ArrList;
import adt.CircularArrQueue;
import adt.ArrListInterface;
import adt.BinarySearchTree;
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
import adt.SortedDoublyLinkedList;
import adt.SortedDoublyLinkedListInterface;

public class Snake_ladder_game {

    static Scanner scan = new Scanner(System.in);
    public static ArrListInterface<Player> playerList;
    public static SortedDoublyLinkedListInterface<Leaderboard> leaderboardList;
    public static CircularArrQueueInterface<Player> playerQueue;
    public static BinarySearchTree startTree = new BinarySearchTree();
    public static BinarySearchTree endTree = new BinarySearchTree();
    public static final int TOTAL_BOARD_SQUARE = 100;

    public static void main(String[] args) {
        
        //Game's background music
        String filepath = "src/music/BGM.wav";
        playBGM(filepath);

        //Logo of the game
        logo();
        
        leaderboardList = new SortedDoublyLinkedList<>();
        playerList = new ArrList<>();
        playerQueue = new CircularArrQueue<>();
        
        //Add the registed players into the array list named array list
        Add_Player.addPlayer();
       
        //User should select the level of the game
        chooseGameLevel();
        
        //Display the layout of the board
        Board_Layout.Board_Layout();
        //Add the players into sorted linked list and create the leaderboard of the game
        Sort_Ranking.createLeaderBoard();
        //Add the players into the array queue in order to determine their order of throwing the dice
        Queue_Player.queuePlayer();
       
        
        while (!leaderboardList.getNth(0).checkWinner()) {
            //Display the name of the player of this round
            Queue_Player.round();
            //Display updated board
            Board_Layout.board100();
            //Display updated leaderboard
            Sort_Ranking.updateRanking();
            //Pop the user out of the queue then insert back into the back of the queue
            Queue_Player.turnRound();

        }
        
    
       
        String winner = leaderboardList.getNth(0).getId();
        //Display the winner of the game
        System.out.println("Congratulation !!!  " + winner + " WIN THE GAME !!!");
        
        filepath = "src/music/winning.wav";
        
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
     
     private static void chooseGameLevel(){
     
      String line = "================================";
      
      System.out.println(line);
      System.out.println("\tLevel of Difficulty");
      System.out.println(line);
      System.out.println("1. Normal");
      System.out.println("2. Hard");
      System.out.println("3. Nightmare");
      System.out.println(line);
      System.out.print("Please Choose The Level of Difficulty :");
      int option = scan.nextInt();
         
       while ((option > 3) || (option < 1) ) 
       {
                System.out.println("\nPlease Enter 1 to 3 only !");
                System.out.print("Please Choose The Level of Difficulty :");
                option = scan.nextInt();
                //System.out.println("");
       }  
      System.out.println(line);
      
      Add_Snake_Ladder.SorLTree(option);
      
     
     }
    

}
