/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import adt.DoublyLinkedList;
import adt.DoublyLinkedListInterface;
import java.util.Iterator;
import java.util.Objects;

/**
 *
 * @author Tan Chia Ter
 */
public class Leaderboard implements Comparable <Leaderboard> {
    private DoublyLinkedListInterface<Leaderboard> leaderboardList = new DoublyLinkedList<>();
    private String id;
    private int score;
    private static int rank = 1;
    private boolean isWinner;

    public Leaderboard(String id) {
        this.id = id;
        this.score = 0;
    }
    
    public Leaderboard(String id, int score) {
        this.id = id;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public boolean isIsWinner() {
        return score == 100;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Leaderboard other = (Leaderboard) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Leaderboard o) {
        if(score == o.score){
            return 0;
        }
        
        else if(score < o.score){
            return -1;
        }
        
        else{
            return 1;
        }
    }
    
    @Override
    public String toString(){
        return String.format(" Player : %-20s Score : %-10d\n" , id, score);
    }
    
    
}
