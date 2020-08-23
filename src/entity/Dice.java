package entity;

import adt.LinkedStack;
import adt.LinkedStackInterface;

public class Dice {

    private int diceNum;

    public Dice(int diceNum) {
        this.diceNum = diceNum;
    }

    public void setDice(int diceNum) {
        this.diceNum = diceNum;
    }
    
    public int getDice() {
        return diceNum;
    }

    public Dice() {
        roll();
    }

    public void roll() {
        diceNum = (int) (Math.random() * 6) + 1;
    }


    @Override
    public String toString() {
        return String.format("Dice  : %d\n", diceNum);
    }
}
