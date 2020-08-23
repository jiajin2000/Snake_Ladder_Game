/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Ang Jen Tat
 */
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
    
    public int boardSquareInt(){
        return Integer.parseInt(boardSquare);
    }

    
    @Override
    public String toString() {
        return String.format("Board Square : %s", boardSquare);
    }

}
