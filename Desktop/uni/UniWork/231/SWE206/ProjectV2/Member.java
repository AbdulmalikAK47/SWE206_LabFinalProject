import java.util.List;

public class Member extends User {
    private List<String> researchInterests;

    public Member(String userId, String name, String email, List<String> researchInterests) {
        super(userId, name, email, "Member");
        this.researchInterests = researchInterests;
    }

    // Getters and setters
    public List<String> getResearchInterests() {
        return researchInterests;
    }

    public void setResearchInterests(List<String> researchInterests) {
        this.researchInterests = researchInterests;
    }

    // Member-specific methods
    public void viewProjectInformation() {
        // Implementation
    }
    
    // Other member-specific functionalities
}
