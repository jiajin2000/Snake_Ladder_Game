/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import adt.LinkedStack;
import adt.LinkedStackInterface;
/**
 *
 * @author jiajin
 */
public class Dice {
    private int diceNum;
    
    public Dice(int diceNum) {
        this.diceNum = diceNum;
    }

    public int getDiceNum(){
        return diceNum;
    }

    public void setDiceNum(int diceNum) {
        this.diceNum = diceNum;
    }
    public Dice() {
        roll();
    }
    
    public void roll(){
        diceNum = (int)(Math.random()*6) + 1;
    }
  
    public int getDice(){
        return diceNum;
    }
    
    @Override
  public String toString() {
    return String.format("Dice  : %d\n", diceNum);
}
}
