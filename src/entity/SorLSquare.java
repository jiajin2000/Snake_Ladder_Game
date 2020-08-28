package entity;

public class SorLSquare {

    private static int nextNumber = 1;
    private int number;
    private String type;
    private int startSquare;
    private int endSquare;

    public SorLSquare(String type, int startSquare, int endSquare) {
        this.startSquare = startSquare;
        this.endSquare = endSquare;
        this.type = type;
        this.number = nextNumber++;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public int getEndSquare() {
        return endSquare;
    }

    public void setEndSquare(int endSquare) {
        this.endSquare = endSquare;
    }

    public int getStartSquare() {
        return startSquare;
    }

    public void setStartSquare(int startSquare) {
        this.startSquare = startSquare;
    }

    @Override
    public String toString() {
        return String.format("Type : %-10s From %d to %d \n", type, startSquare, endSquare);
    }

}
