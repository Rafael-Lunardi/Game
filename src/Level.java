public class Level {
    private boolean reachedGoal = false;
    private int points = 0;

    /**
     * Returns true if the player reached the goal on this level and returns false otherwise
     */
    public boolean goalReached() {
        return reachedGoal;
    }

    public void reachGoal() {
        reachedGoal = true;
    }

    /**
     * Returns the number of points (a positive integer) recorded for this level
     */
    public int getPoints() {
        if (points > 0) {
            return points;
        } else return 0;
    }

    public void setPoints(int p) {
        points = p;
    }
}

