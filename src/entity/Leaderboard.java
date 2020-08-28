package entity;

import java.util.Objects;
import static snake_ladder_game.Snake_ladder_game.TOTAL_BOARD_SQUARE;

public class Leaderboard implements Comparable<Leaderboard> {

    private String id;
    private int score;
    private boolean isWinner = false;

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

    public boolean checkWinner() {
        if (score == TOTAL_BOARD_SQUARE) {
            isWinner = true;
        }
        return isWinner;
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
        if (score == o.score) {
            return 0;
        } else if (score < o.score) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return String.format(" %-20s %-5d\n", id, score);
    }

}
