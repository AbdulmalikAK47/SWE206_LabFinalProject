import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInGUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton signInButton;
    private AuthenticationSystem authSystem;

    public SignInGUI() {
        authSystem = new AuthenticationSystem();
        initializeUI();
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
    }

    private void initializeUI() {
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        signInButton = new JButton("Sign In");

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performSignIn();
            }
        });

        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.add(usernameField);
        panel.add(passwordField);
        panel.add(signInButton);

        add(panel);
    }

    private void performSignIn() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (authSystem.authenticate(username, password)) {
            JOptionPane.showMessageDialog(this, "Login Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
            openMainPage();
            this.dispose(); // Close the login window
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Credentials", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openMainPage() {
        MainPageGUI mainPage = new MainPageGUI();
        mainPage.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SignInGUI().setVisible(true));
    }
}
