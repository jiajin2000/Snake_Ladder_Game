package snake_ladder_game;

import adt.linkedListInterface;
import adt.linkedList;
import entity.Board;
import java.util.*;
import static snake_ladder_game.Add_Snake_Ladder.SorLSquareList;
import static snake_ladder_game.Add_Snake_Ladder.endTree;
import static snake_ladder_game.Add_Snake_Ladder.startTree;

public class Board_Layout {

    public static linkedListInterface<Board> boardList;
    static Scanner scan = new Scanner(System.in);

    public static void Board_Layout() {
        System.out.println();
        System.out.println("========Snakes & Ladders========");
        System.out.print("Enter anything to START the game: ");
        scan.next().charAt(0);
        board100();
    }

    //Board100
    public static void board100() {
        boardList = new linkedList<>();
        addBoard100();
        updateBoard100();
        displayBoard100();
    }

    public static void addBoard100() {
        for (int i = 1; i < 101; i++) {
            boardList.add(new Board(Integer.toString(i)));
        }

    }

    public static void updateBoard100() {
        for (int i = 0; i < SorLSquareList.size(); i++) {
            boardList.replace(SorLSquareList.get(i).getStartSquare(), new Board(SorLSquareList.get(i).getType()));
        }

        for (int i = 0; i < Snake_ladder_game.playerList.size(); i++) {
            String boardNo;

            int position = Snake_ladder_game.playerList.get(i).getCurrentPosition();
            String positionInString = Integer.toString(Snake_ladder_game.playerList.get(i).getCurrentPosition());
            boardNo = boardList.get(Snake_ladder_game.playerList.get(i).getCurrentPosition() - 1).getBoardSquare();
            if (boardNo.equals(positionInString) == true || boardNo == "Snake" || boardNo == "Ladder") {
                boardList.replace(position, new Board("*" + Snake_ladder_game.playerList.get(i).getPlayerName() + "*"));
            } else {
                boardList.replace(position, new Board(boardList.get(position - 1).getBoardSquare() + Snake_ladder_game.playerList.get(i).getPlayerName() + "*"));
            }
        }
    }

    public static void displayBoard100() {
        System.out.println();
        for (int i = 0; i < 85; i++) {
            System.out.print("=");
        }
        System.out.print("Snakes & Ladders Board");
        for (int i = 0; i < 85; i++) {
            System.out.print("=");
        }
        System.out.println();

        for (int i = 99; i >= 0; i--) {
            if (i == 99) {
                System.out.print("  ");
            }
            System.out.printf("%-19s", boardList.get(i).getBoardSquare());

            System.out.print(" ");

            if (i % 10 == 0) {
                int f = i - 10;
                for (int k = f; k < i; k++) {
                    if (k == f) {
                        System.out.println();
                        System.out.print("  ");
                    }
                    if (k < 9) {
                        System.out.printf("%-19s", boardList.get(k).getBoardSquare());
                    } else {
                        System.out.printf("%-19s", boardList.get(k).getBoardSquare());
                    }
                    System.out.print(" ");
                }
                i = f;
                System.out.println();
                System.out.print("  ");
            }
        }
        System.out.print("\b\b");
        for (int i = 0; i < 192; i++) {
            System.out.print("=");
        }
        System.out.println();
        System.out.println();

    }

}
