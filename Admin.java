public class Admin extends User {
    
    public Admin(String userId, String name, String email) {
        super(userId, name, email, "Admin");
    }

    // Admin-specific methods
    public void manageProjects() {
        // Implementation
    }

    public void manageUsers() {
        // Implementation
    }
    
    // Other admin-specific functionalities
}
