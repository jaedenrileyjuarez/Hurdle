import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Challenge {
    private int size;
    private String currentChallenge;
    ArrayList<String> allChallenges;
    ArrayList<String> resetChallenges;

    public Challenge() {
        updateAllChallenges();
    }
    
    private void updateAllChallenges() {
        File challenges = new File("ChallengesSmallFile.txt");
        Scanner key;
        try {
            key = new Scanner(challenges);
            allChallenges = new ArrayList<String>();
            resetChallenges = new ArrayList<String>();
            while (key.hasNext()) {
                String next = key.nextLine();
                allChallenges.add(next);
                resetChallenges.add(next);
            }
            key.close();
            size = allChallenges.size();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getChallenge() {
        Random rand = new Random();
        int challengeIndex = rand.nextInt(size);
        currentChallenge = allChallenges.get(challengeIndex);
        allChallenges.remove(currentChallenge);
        size--;
        return currentChallenge;
    }

    public void reset() {
        if (allChallenges.size() == 0) {
            for (String challenge : resetChallenges) {
                allChallenges.add(challenge);
            }
        }
    }
}
