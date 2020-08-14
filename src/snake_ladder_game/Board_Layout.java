package snake_ladder_game;

import adt.linkedListInterface;
import adt.linkedList;
import entity.Board;
import java.util.*;
import static snake_ladder_game.Add_Snake_Ladder.SorLSquareList;
import static snake_ladder_game.Add_Snake_Ladder.endTree;
import static snake_ladder_game.Add_Snake_Ladder.startTree;

/**
 *
 * @author kengboongoh
 */
public class Board_Layout {

    /**
     * @param args the command line arguments
     */
    public static linkedListInterface<Board> boardList;
    static Scanner scan = new Scanner(System.in);

    public static void Board_Layout() {

        boardList = new linkedList<>();
        int option;
        System.out.println("Snakes & Ladders");
        System.out.println("1. 100 Squares");
        System.out.println("2. 50 Squares");
        System.out.print("Please select the Snakes & Ladders version you want to play (1/2):");
        option = scan.nextInt();

        while (option < 1 || option > 2) {

            System.out.println("\nInvalid Entry!Please select again");
            System.out.println("Snakes & Ladders");
            System.out.println("1. 100 Squares");
            System.out.println("2. 50 Squares");
            System.out.print("Please select the Snakes & Ladders version you want to play (1/2):");
            option = scan.nextInt();
            System.out.println();
        }

        if (option == 1) {
            addBoard100();
            
             for (int i = 0; i < SorLSquareList.size(); i++) 
              {

                   //boardList.replace(Snake_ladder_game.playerList.get(i).getCurrentPosition(), new Board(Snake_ladder_game.playerList.get(i).getPlayerName()));
                   boardList.replace(SorLSquareList.get(i).getStartSquare(), new Board(SorLSquareList.get(i).getType()));  
                   //boardList.replace(1, new Board(boardList.get(1-1).getBoardNo()+"/P2/P3/P4"));
     
              }
             
               for (int i = 0; i < Snake_ladder_game.playerList.size(); i++) 
              {
                   String boardNo;
                   int position= Snake_ladder_game.playerList.get(i).getCurrentPosition();
                   String positionInString = Integer.toString(Snake_ladder_game.playerList.get(i).getCurrentPosition());
                   boardNo = boardList.get(Snake_ladder_game.playerList.get(i).getCurrentPosition()-1).getBoardNo();
                   
                   System.out.println(boardNo+positionInString);
                   if(boardNo.equals(positionInString) == true || boardNo== "Snake" || boardNo== "Ladder"){
                   boardList.replace(1,new Board(Snake_ladder_game.playerList.get(i).getPlayerName()+"*"));    
                   }
                   else{
                        boardList.replace(position,
                           new Board("*"+boardList.get(position-1).getBoardNo()+Snake_ladder_game.playerList.get(i).getPlayerName()+"*"));
                   }
                  //boardList.replace(SorLSquareList.get(i).getStartSquare(), new Board(SorLSquareList.get(i).getType()));  
                   //boardList.replace(1, new Board(boardList.get(1-1).getBoardNo()+"/P2/P3/P4"));
     
              }
            
            //boardList.replace(1, new Board("P1"));
            //boardList.replace(1, new Board(boardList.get(1-1).getBoardNo()+"/P2/P3/P4"));
            displayBoard100();
        } else {
            addBoard50();
//            boardList.replace(23, new Board("P1"));
//            boardList.replace(25, new Board("SNAKE"));
            displayBoard50();
        }

    }

    public static void addBoard100() {
        for (int i = 1; i < 101; i++) {
            boardList.add(new Board(Integer.toString(i)));
        }

    }
    
    public static void displayBoard100(){
        System.out.println();
        
        for (int i = 99; i >= 0; i--) {
            if (i == 99) {
                System.out.print("    ");
            }
            System.out.printf("%-19s",boardList.get(i).getBoardNo());

            System.out.print(" ");

            if (i % 10 == 0) {
                int f = i - 10;
                for (int k = f; k < i; k++) {
                    if (k == f) {
                        System.out.println();
                        System.out.print("    ");
                    }
                    if (k < 9) {
                        System.out.printf("%-19s",boardList.get(k).getBoardNo());
                    } else {
                        System.out.printf("%-19s",boardList.get(k).getBoardNo());
                    }
                    System.out.print(" ");
                }
                i = f;
                System.out.println();
                System.out.print("    ");
            }
        }
        System.out.println();
    }

    public static void addBoard50() {

        for (int i = 1; i < 51; i++) {
            boardList.add(new Board(Integer.toString(i)));
        }
    }
    
    public static void displayBoard50(){
        for (int i = 50; i >= 0; i--) {

            if (i % 10 == 0) {
                if (i != 50) {
                    System.out.printf("%-19s",boardList.get(i).getBoardNo());
                }
                int f = i - 10;
                for (int k = f; k < i; k++) {
                    if (k == f) {
                        System.out.println();
                        System.out.print("    ");
                    }
                    if (k < 9) {
                        System.out.printf("%-19s",boardList.get(k).getBoardNo());
                    } else {
                        System.out.printf("%-19s",boardList.get(k).getBoardNo());
                    }
                    System.out.print(" ");
                }
                i = f;
                System.out.println();
                System.out.print("    ");
            } else {
                System.out.printf("%-19s",boardList.get(i).getBoardNo());
                System.out.print(" ");
            }

        }
        System.out.println();
    }

}