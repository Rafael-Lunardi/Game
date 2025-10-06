import java.util.Scanner;

public class Game {
    private Level levelOne;
    private Level levelTwo;
    private Level levelThree;
    private boolean bonus;

    public Level getLevel(int i) {
        if (i == 1) return levelOne;
        if (i == 2) return levelTwo;
        if (i == 3) return levelThree;
        return null;
    }

    public Game() {
        levelOne = new Level();
        levelTwo = new Level();
        levelThree = new Level();
    }

    /**
     * Returns true if this game is a bonus game and returns false otherwise
     */
    public boolean isBonus() {
        return bonus;
    }

    public void addbonus() {
        bonus = true;
    }

    /**
     * Simulates the play of this Game (consisting of three levels) and updates all relevant * game data
     */
    public void play() {
        System.out.println("First Level Score:");
        Scanner s = new Scanner(System.in);
        levelOne.setPoints(s.nextInt());
        levelOne.reachGoal();
        System.out.println("Second Level Score:");
        levelTwo.setPoints(s.nextInt());
        levelTwo.reachGoal();
        System.out.println("Third Level Score:");
        levelThree.setPoints(s.nextInt());
        levelThree.reachGoal();
        System.out.println("Did you complete bonus? (y/n)");
        if (s.nextLine() == "y"){
            addbonus();
        }

    }

    /**
     * Returns the score earned in the most recently played game, as described in part (a)
     */
    public int getScore() { /* to be implemented in part (a) */
        int points = 0;
        if (levelOne.goalReached()){
            points += levelOne.getPoints();
            if (levelTwo.goalReached()) {
                points += levelTwo.getPoints();
                if (levelThree.goalReached()) {
                    points += levelThree.getPoints();
                }
            }
        }
        if (isBonus()){
            points *= 3;
        }
        return points;
    }

    /**
     * Simulates the play of num games and returns the highest score earned, as
     * described in part (b)
     * Precondition: num > 0
     */
    public int playManyTimes(int num) { /* to be implemented in part (b) */
        int maxScore = 0;
        for (int i = 0; i < num; i++) {
            play();
            if (getScore() > maxScore){
                maxScore = getScore();
            }
        }
        return maxScore;
    }
// There may be instance variables, constructors, and methods that are not shown.
}

