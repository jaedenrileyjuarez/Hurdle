import java.util.ArrayList;
import java.util.Scanner;

public class TrackManager {
    private String groupName;
    private ArrayList<Runner> allRunners;
    private Scanner input;
    private Group group;
    private ArrayList<String> rules;
    private static int nextAvailableRank = 1;

    // Empty constructor for trackmanager
    public TrackManager() {
        allRunners = new ArrayList<Runner>();
        rules = new ArrayList<String>();
        group = new Group();
        input = new Scanner(System.in);
    }

    // Controls one full lap around the track
    public void play() {
        printHeader();
        groupName = getGroupName();
        allRunners = getRunners();
        group.updateName(groupName);
        group.updateRunners(allRunners);
        displayChallenge();
        // runs until everyone in the group completes the challenge
        while (group.getStatus() == false) {
            showBoard();
            updateLap();
            verifySubmissions();
        }
        displayEndResults();
    }

    // Prints the header information for the game
    private void printHeader() {
        System.out.print(
                "Howdy guys, gals, and non-binary pals. Welcome to Hurdle! \nPress 'y' to get more "
                        + "info and any other key to continue to the track: ");
        String answer = input.nextLine().toLowerCase();
        if (answer.equals("y")) {
            System.out.println("\n***The Hurdle Handbook***");
            System.out.println(
                    "\nHere's the hoe-down. At a random point during the week, Hurdle will\n alert "
                            + "all runners across the globe about the start of a new race. \nThe goal of every"
                            + "runner is to finish the race as fast as possible. \nHowever, there is one thing"
                            + "standing in the way... a hurdle!");
            System.out
                    .println("\nTo hop the hurdle, runners must document their completion of the \n"
                            + "challenge with a photo and fellow competitors will verify. Each \ntime a runner"
                            + "hops a hurdle, the runner with contribute a rule to \nincrease the difficulty "
                            + "of completing the initial challenge. As \nrules are added, the hurdle's height"
                            + "increases for the remaining \ncompetitors.");
            System.out.println(
                    "\nOnce all runners finish the race, rest up, drink some water, and \nstretch "
                            + "before gearing up for next week's race.");
            System.out.print("\nPress any key to continue to the track: ");
            input.nextLine();
        }
    }

    private String getGroupName() {
        System.out.print("\nPlease enter a name for your group: ");
        return input.nextLine();
    }

    private ArrayList<Runner> getRunners() {
        boolean moreRunners = true;
        int currentNumPlayers = 0;
        System.out.println("\nYour team must have at least two runners.");
        while (moreRunners) {
            System.out.print("\nPlease enter a name for Runner " + (currentNumPlayers + 1) + ": ");
            currentNumPlayers++;
            String name = input.nextLine();
            Runner player = new Runner(name);
            allRunners.add(player);
            System.out.print("\nPress 'y' to add more runners, 'n' to stop: ");
            moreRunners = input.nextLine().toLowerCase().equals("y");
        }
        return allRunners;
    }

    private void displayChallenge() {
        Challenge currentHurdle = new Challenge();
        System.out.println("Welcome group " + groupName + "! Are you ready for your hurdle?");
        System.out.println("\n\nOn your mark...");
        System.out.println("\n\nGet set...");
        System.out.println("\n\nGO!!!\n\n");
        System.out.println("Your challenge for the week is: " + currentHurdle.getChallenge());
    }

    private void updateLap() {
        if (group.getStatus() == true) {
            System.out.println("\n***Final Board***");
        } else {
            System.out.println("\n***Current Board***");
        }
        System.out.println("Height of hurdle: " + nextAvailableRank);
        System.out.println("Runners finished: " + (nextAvailableRank - 1));
        System.out.println("Current rules: " + rules.toString());
    }

    private void verifySubmissions() {
        String space = " ";
        while (!space.equals("y")) {
            System.out.print("\nEnter 'y' when a member of group " + groupName + " is ready to "
                    + "submit their photo to verify they hopped the hurdle: ");
            space = input.nextLine().toLowerCase();
        }

        System.out.print("Hey runner! What's your name? ");
        String name = input.nextLine();
        ArrayList<String> runnerToString = new ArrayList<String>();
        for (Runner runner : allRunners) {
            runnerToString.add(runner.getName());
        }

        while (!runnerToString.contains(name)) {
            System.out.print("I'm sorry, it doesn't look like you're in group " + groupName
                    + ". Please try again with a different name: ");
            name = input.nextLine();

        }
        System.out.print(
                "Please submit your photo for peer verification. (for prototype purposes, enter 'y')");
        boolean isVerified = input.nextLine().toLowerCase().equals("y");
        if (isVerified) {

            int index = runnerToString.indexOf(name);
            Runner nextPlace = allRunners.get(index);
            nextPlace.changeStatus();
            nextPlace.changeRank(nextAvailableRank);
            nextAvailableRank++;
            System.out.println(
                    "\nCongratulations " + nextPlace.getName() + "! You hopped the hurdle!");
            if (rules.size() < allRunners.size() - 1) {
                System.out.print("Your final ranking is #" + nextPlace.getRank()
                        + ". Please add your rule: ");
                String newRule = input.nextLine();
                rules.add(newRule);
            } else {
                group.changeStatus();
            }

        }
    }

    private void displayEndResults() {
        updateLap();
        System.out.println("\nCongrats on finishing the race runners! We'll see you next week.");
    }
    
    private void showBoard() {
        System.out.println("=========={}=======");
        System.out.println("||               ||");
        System.out.println("||               ||");
        System.out.println("||               ||");
        System.out.println("||               ||");
        System.out.println("==================");
    }
}
