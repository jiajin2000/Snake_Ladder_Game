package snake_ladder_game;

import adt.ArrList;
import adt.ArrListInterface;
import adt.BinarySearchTree;
import adt.BinarySearchTreeInterface;
import entity.SorLSquare;
import java.util.Iterator;
import static snake_ladder_game.Snake_ladder_game.playerList;
import static snake_ladder_game.Snake_ladder_game.playerQueue;

public class Add_Snake_Ladder {

    public static ArrListInterface<SorLSquare> SorLSquareList;
    public static BinarySearchTree startTree = new BinarySearchTree();
    public static BinarySearchTree endTree = new BinarySearchTree();
    static String line = "================================";

    public static void SorLTree() {

        SorLSquareList = new ArrList<>(10);
        addSnakeorLadder();

        Object[] sol = {"Snake", 28, 30};

        for (int i = 0; i < SorLSquareList.size(); i++) {

            startTree.add(SorLSquareList.get(i).getStartSquare());

            endTree.add(SorLSquareList.get(i).getEndSquare());

        }

        System.out.println("========Snakes & Ladders========\n");
        System.out.print(SorLSquareList.toString());
        System.out.println(line);

    }

    public static void addSnakeorLadder() {

        SorLSquareList.add(new SorLSquare("Ladder", 20, 31));
        SorLSquareList.add(new SorLSquare("Ladder", 6, 25));
        SorLSquareList.add(new SorLSquare("Ladder", 41, 60));
        SorLSquareList.add(new SorLSquare("Ladder", 30, 80));

        SorLSquareList.add(new SorLSquare("Snake", 7, 50));
        SorLSquareList.add(new SorLSquare("Snake", 19, 62));
        SorLSquareList.add(new SorLSquare("Snake", 50, 78));
        SorLSquareList.add(new SorLSquare("Snake", 61, 90));
        SorLSquareList.add(new SorLSquare("Snake", 39, 93));
        SorLSquareList.add(new SorLSquare("Snake", 70, 97));

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

                if (position == startSquare && type == "Ladder") {
                    currentPosition = endSquare;
                    playerList.get(playerQueue.getFront().getNumber()).setCurrentPosition(currentPosition);
                    System.out.println("\n** Woo Hoo ! " + name + " taking the Shortcut with the Ladder from Position " + startSquare + " to " + endSquare + " **\n");

                }

            }

        }

        if (endTree.contains(currentPosition)) {

            for (int q = 0; q < SorLSquareList.size(); q++) {

                int position = currentPosition;
                int startSquare = SorLSquareList.get(q).getStartSquare();
                int endSquare = SorLSquareList.get(q).getEndSquare();
                String type = SorLSquareList.get(q).getType();

                if (position == endSquare && type == "Snake") {
                    currentPosition = startSquare;
                    playerList.get(playerQueue.getFront().getNumber()).setCurrentPosition(currentPosition);
                    System.out.println("\n** Oh No ! The Snake is too Slippery, " + name + " slide from Position " + endSquare + " to " + startSquare + " **\n");

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
}
