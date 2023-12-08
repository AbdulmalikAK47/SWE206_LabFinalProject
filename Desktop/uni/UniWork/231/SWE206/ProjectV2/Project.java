import java.util.List;

public class Project {
    private String projectId;
    private String name;
    private String description;
    private List<User> assignedTeam; // A list of users assigned to the project

    public Project(String projectId, String name, String description, List<User> assignedTeam) {
        this.projectId = projectId;
        this.name = name;
        this.description = description;
        this.assignedTeam = assignedTeam;
    }

    // Getters and setters
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getAssignedTeam() {
        return assignedTeam;
    }

    public void setAssignedTeam(List<User> assignedTeam) {
        this.assignedTeam = assignedTeam;
    }

    // Method to add a team member to the project
    public void addTeamMember(User user) {
        this.assignedTeam.add(user);
    }

    // Method to remove a team member from the project
    public void removeTeamMember(User user) {
        this.assignedTeam.remove(user);
    }

    @Override
    public String toString() {
        return "Project{" +
               "projectId='" + projectId + '\'' +
               ", name='" + name + '\'' +
               ", description='" + description + '\'' +
               ", assignedTeam=" + assignedTeam +
               '}';
    }
}
