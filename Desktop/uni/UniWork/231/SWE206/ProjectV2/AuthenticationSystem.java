import java.util.HashMap;
import java.util.Map;

public class AuthenticationSystem {
    private Map<String, String> userCredentials; // username and password

    public AuthenticationSystem() {
        userCredentials = new HashMap<>();
        // In a real system, you'd use a more secure way to store and check credentials
        userCredentials.put("admin", "admin123");
        userCredentials.put("user", "user123");
    }

    public boolean authenticate(String username, String password) {
        return userCredentials.containsKey(username) && userCredentials.get(username).equals(password);
    }
}
