import java.util.ArrayList;
import java.util.List;

public class Team {
    private String teamId;
    private String name;
    private List<User> members; // A list of users who are members of the team

    public Team(String teamId, String name) {
        this.teamId = teamId;
        this.name = name;
        this.members = new ArrayList<>();
    }

    // Getters and Setters
    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    // Method to add a member to the team
    public void addMember(User user) {
        if (!members.contains(user)) {
            members.add(user);
        }
    }

    // Method to remove a member from the team
    public void removeMember(User user) {
        members.remove(user);
    }

    @Override
    public String toString() {
        return "Team{" +
               "teamId='" + teamId + '\'' +
               ", name='" + name + '\'' +
               ", members=" + members +
               '}';
    }
}
