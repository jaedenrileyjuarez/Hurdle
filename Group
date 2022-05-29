import java.util.ArrayList;

public class Group {
    private String name;
    private boolean status;
    private ArrayList<Runner> runners;

    public Group() {
        this(null, null);
    }

    public Group(String name, ArrayList<Runner> runners) {
        this.name = name;
        status = false;
        this.runners = runners;
    }

    public String getName() {
        return name;
    }

    public void updateName(String newName) {
        name = newName;
    }

    public ArrayList<Runner> getRunners() {
        return runners;
    }
    
    public void updateRunners(ArrayList<Runner> newRunners) {
        runners = newRunners;
    }

    public boolean getStatus() {
        return status;
    }

    public void changeStatus() {
        status = true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Showing data for group: " + name + "\n");
        int longestLength = 0;
        for (Runner name: runners) {
            if (name.getName().length() > longestLength) {
                longestLength = name.getName().length();
            }
        }
        longestLength++;
        
        for (Runner name: runners){
            int spaceSize = longestLength - name.getName().length();
            sb.append("Name: " + name.getName());
            for (int i = 0; i < spaceSize; i++) {
                sb.append(" ");
            }
            sb.append("Rank: " + name.getRank() + " Status: " + name.getStatus() + "\n");            
        }
        sb.append("Group members: " + runners.toString() + "\n");
        return sb.toString();
    }
}
