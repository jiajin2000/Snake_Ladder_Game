package snake_ladder_game;

import adt.ArrList;
import adt.ArrListInterface;
import adt.BinarySearchTree;
import adt.BinarySearchTreeInterface;
import entity.SorLSquare;
import java.io.File;
import java.util.Iterator;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import static snake_ladder_game.Snake_ladder_game.playerList;
import static snake_ladder_game.Snake_ladder_game.playerQueue;

public class Add_Snake_Ladder {

    public static ArrListInterface<SorLSquare> SorLSquareList;
    public static BinarySearchTree startTree = new BinarySearchTree();
    public static BinarySearchTree endTree = new BinarySearchTree();
    static String line = "================================";

    public static void SorLTree(int option) {
        
        
        SorLSquareList = new ArrList<>(15);
        
        addSnakeorLadder(option);

        Object[] sol = {"Snake", 28, 30};

        for (int i = 0; i < SorLSquareList.size(); i++) {

            startTree.add(SorLSquareList.get(i).getStartSquare());

            //endTree.add(SorLSquareList.get(i).getStartSquare());

        }

        System.out.println("========Snakes & Ladders========\n");
        System.out.print(SorLSquareList.toString());
        System.out.println(line);

    }

    public static void addSnakeorLadder(int option) {

       if(option == 1)
       {
            SorLSquareList.add(new SorLSquare("Ladder", 6, 25));
            SorLSquareList.add(new SorLSquare("Ladder", 13, 49));
            SorLSquareList.add(new SorLSquare("Ladder", 20, 31));
            SorLSquareList.add(new SorLSquare("Ladder", 30, 80));
            SorLSquareList.add(new SorLSquare("Ladder", 41, 60));
            SorLSquareList.add(new SorLSquare("Ladder", 52, 71));
            SorLSquareList.add(new SorLSquare("Ladder", 77, 87));
            SorLSquareList.add(new SorLSquare("Ladder", 80, 91));
            
            SorLSquareList.add(new SorLSquare("Snake", 62, 19));
            SorLSquareList.add(new SorLSquare("Snake", 78, 50));
            SorLSquareList.add(new SorLSquare("Snake", 90, 61));
            SorLSquareList.add(new SorLSquare("Snake", 97, 39));
            
       }else if( option == 2){
            
            SorLSquareList.add(new SorLSquare("Ladder", 6, 25));
            SorLSquareList.add(new SorLSquare("Ladder", 20, 31));
            SorLSquareList.add(new SorLSquare("Ladder", 30, 80));
            SorLSquareList.add(new SorLSquare("Ladder", 41, 60));
            SorLSquareList.add(new SorLSquare("Ladder", 77, 87));
            
            SorLSquareList.add(new SorLSquare("Snake", 50, 7));
            SorLSquareList.add(new SorLSquare("Snake", 62, 19));
            SorLSquareList.add(new SorLSquare("Snake", 78, 50));
            SorLSquareList.add(new SorLSquare("Snake", 90, 61));
            SorLSquareList.add(new SorLSquare("Snake", 97, 24));
        
       }else{
       
            SorLSquareList.add(new SorLSquare("Ladder", 20, 31));
            SorLSquareList.add(new SorLSquare("Ladder", 6, 25));
            SorLSquareList.add(new SorLSquare("Ladder", 41, 60));

            SorLSquareList.add(new SorLSquare("Snake", 50, 7));
            SorLSquareList.add(new SorLSquare("Snake", 62, 19));
            SorLSquareList.add(new SorLSquare("Snake", 88, 23));
            SorLSquareList.add(new SorLSquare("Snake", 93, 39));
            SorLSquareList.add(new SorLSquare("Snake", 82, 45));
            SorLSquareList.add(new SorLSquare("Snake", 78, 50));
            SorLSquareList.add(new SorLSquare("Snake", 90, 61));
            SorLSquareList.add(new SorLSquare("Snake", 97, 24));
       
           
       }

    }

    public static void checkSorL() {

        int currentPosition = playerList.get(playerQueue.getFront().getNumber()).getCurrentPosition();

        String name = playerList.get(playerQueue.getFront().getNumber()).getPlayerName();

        if (startTree.contains(currentPosition)) {

            for (int t = 0; t < SorLSquareList.size(); t++) {

                int position = currentPosition;
                int startSquare = SorLSquareList.get(t).getStartSquare();
                int endSquare = SorLSquareList.get(t).getEndSquare();
                String type = SorLSquareList.get(t).getType();
                String filepath = "src/music/woohoo.wav";

                if (position == startSquare && type == "Ladder") {
                    currentPosition = endSquare;
                    playerList.get(playerQueue.getFront().getNumber()).setCurrentPosition(currentPosition);
                    System.out.println("\n** Woo Hoo ! " + name + " taking the Shortcut with the Ladder from Position " + startSquare + " to " + endSquare + " **\n");
                    playAudio(filepath);

                }

            }

        }

        if (startTree.contains(currentPosition)) {

            for (int q = 0; q < SorLSquareList.size(); q++) {

                int position = currentPosition;
                int startSquare = SorLSquareList.get(q).getStartSquare();
                int endSquare = SorLSquareList.get(q).getEndSquare();
                String type = SorLSquareList.get(q).getType();
                String filepath = "src/music/oh_no.wav";

                
                if (position == startSquare && type == "Snake") {
                    currentPosition = endSquare;
                    playerList.get(playerQueue.getFront().getNumber()).setCurrentPosition(currentPosition);
                    System.out.println("\n** Oh No ! The Snake is too Slippery, " + name + " slide from Position " + startSquare + " to " + endSquare + " **\n");
                    playAudio(filepath);
                }

            }

        }
        
        

    }

    public static void display(BinarySearchTreeInterface tree) {

        Iterator it = tree.getInorderIterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println("\n");
    }
    
    private static void playAudio(String filepath){
    
        
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
}
