// stores data for each user
// create different instance variables that change for each runner

public class Runner {
    public String name;
    private static int prevAccountNum = 1000;
    private int accountNumber;
    public boolean status; // to be reset every week
    public int rank; // to be reset every week

    // Constructor for each runner
    public Runner(String name) {
        this.name = name;
        status = false;
        rank = 0;
        accountNumber = prevAccountNum + 1;
        prevAccountNum++;
    }

    // Access this user's name
    public String getName() {
        return name;
    }

    // Access this user's dare status
    public boolean getStatus() {
        return status;
    }

    // Access this user's rank
    public int getRank() {
        return rank;
    }

    public void changeStatus() {
        status = true;
    }

    public void changeRank(int factor) {
        if (status) {
            rank += factor;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        return sb.toString();
    }
}
