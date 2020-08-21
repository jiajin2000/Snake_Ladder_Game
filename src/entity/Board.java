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

    private String boardNo;

    public Board(String boardNo) {
        this.boardNo = boardNo;
    }

    public String getBoardNo() {
        return boardNo;
    }

    public void setBoardNo(String boardNo) {
        this.boardNo = boardNo;
    }
    
    public int boardNoInt(){
        return Integer.parseInt(boardNo);
    }

    
    @Override
    public String toString() {
        return String.format("Board NO : %s", boardNo);
    }

}
