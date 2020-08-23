package entity;

public class Board {

    private String boardSquare;

    public Board(String boardNo) {
        this.boardSquare = boardNo;
    }

    public String getBoardSquare() {
        return boardSquare;
    }

    public void setBoardSquare(String boardSquare) {
        this.boardSquare = boardSquare;
    }

    public int boardSquareInt() {
        return Integer.parseInt(boardSquare);
    }

    @Override
    public String toString() {
        return String.format("Board Square : %s", boardSquare);
    }

}
