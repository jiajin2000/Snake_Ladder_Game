package entity;

public class Player {

    private static int nextNumber = 0;
    private String name;
    private int number;
    private int currentPosition = 1;
    private int stepNumber;

    public Player(int number) {
        this.number = number;
    }

    public Player(String name) {
        this.name = name;
        this.number = nextNumber++;
    }

    public String getPlayerName() {
        return name;
    }

    public void setPlayerName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public static int getNextNumber() {
        return nextNumber;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    @Override
    public String toString() {
        return String.format("Player No. %-5d Player Name : %-20s\n", number + 1, name);
    }

}
