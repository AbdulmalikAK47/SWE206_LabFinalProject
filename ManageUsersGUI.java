import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ManageUsersGUI extends JFrame {
    private JList<User> userList;
    private DefaultListModel<User> userModel;
    private JButton addUserButton;
    private JButton editUserButton;
    private JButton deleteUserButton;
    private List<User> users; // This would typically be fetched from a database

    public ManageUsersGUI() {
        this.users = new ArrayList<>(); // Placeholder for user data
        initializeUI();
        setTitle("Manage Users");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
    }

    private void initializeUI() {
        userModel = new DefaultListModel<>();
        userList = new JList<>(userModel);
        addUserButton = new JButton("Add User");
        editUserButton = new JButton("Edit User");
        deleteUserButton = new JButton("Delete User");

        addUserButton.addActionListener(e -> addUser());
        editUserButton.addActionListener(e -> editUser());
        deleteUserButton.addActionListener(e -> deleteUser());

        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addUser();
            }
        });

        editUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                editUser();

            }
        });

        this.setLayout(new BorderLayout());
        this.add(new JScrollPane(userList), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addUserButton);
        buttonPanel.add(editUserButton);
        buttonPanel.add(deleteUserButton);
        this.add(buttonPanel, BorderLayout.SOUTH);

        refreshUserList();
    }



    private void addUser() {
            // Create text fields for user details
            JTextField userNameField = new JTextField(20);
            JTextField userEmailField = new JTextField(20);
            JComboBox<String> userRoleComboBox = new JComboBox<>(new String[]{"Admin", "Member"});
        
            // Set up a panel with labels and text fields
            JPanel panel = new JPanel(new GridLayout(0, 1));
            panel.add(new JLabel("Name:"));
            panel.add(userNameField);
            panel.add(new JLabel("Email:"));
            panel.add(userEmailField);
            panel.add(new JLabel("Role:"));
            panel.add(userRoleComboBox);
        
            // Show a dialog with the panel
            int result = JOptionPane.showConfirmDialog(this, panel, 
                    "Enter User Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
            // Process the data if the OK button was pressed
            if (result == JOptionPane.OK_OPTION) {
                String name = userNameField.getText().trim();
                String email = userEmailField.getText().trim();
                String role = (String) userRoleComboBox.getSelectedItem();
        
                // Simple validation
                if (!name.isEmpty() && !email.isEmpty()) {
                    User newUser = new User("01", name, email, role);
                    users.add(newUser);
                    refreshUserList();
                } else {
                    JOptionPane.showMessageDialog(this, "Name and email cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        
    

    private void editUser() {
       
            System.out.println("Edit User button clicked"); // Debugging print statement
            // ... rest of the method ...
        
        
       
            // Get the selected user from the list
            User selectedUser = userList.getSelectedValue();
            if (selectedUser == null) {
                JOptionPane.showMessageDialog(this, "Please select a user to edit", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        
            // Create text fields for user details, pre-filled with selected user's data
            JTextField userNameField = new JTextField(selectedUser.getName(), 20);
            JTextField userEmailField = new JTextField(selectedUser.getEmail(), 20);
            JComboBox<String> userRoleComboBox = new JComboBox<>(new String[]{"Admin", "Member"});
            userRoleComboBox.setSelectedItem(selectedUser.getRole());
        
            // Set up a panel with labels and text fields
            JPanel panel = new JPanel(new GridLayout(0, 1));
            panel.add(new JLabel("Name:"));
            panel.add(userNameField);
            panel.add(new JLabel("Email:"));
            panel.add(userEmailField);
            panel.add(new JLabel("Role:"));
            panel.add(userRoleComboBox);
        
            // Show a dialog with the panel
            int result = JOptionPane.showConfirmDialog(this, panel, 
                    "Edit User Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
            // Process the data if the OK button was pressed
            if (result == JOptionPane.OK_OPTION) {
                String name = userNameField.getText().trim();
                String email = userEmailField.getText().trim();
                String role = (String) userRoleComboBox.getSelectedItem();
        
                // Simple validation
                if (!name.isEmpty() && !email.isEmpty()) {
                    selectedUser.setName(name);
                    selectedUser.setEmail(email);
                    selectedUser.setRole(role);
                    refreshUserList();
                } else {
                    JOptionPane.showMessageDialog(this, "Name and email cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        
    

    private void deleteUser() {
        // Delete the selected user
        // Update the user list after deleting
    }

    private void refreshUserList() {
        userModel.clear();
        for (User user : users) {
            userModel.addElement(user);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ManageUsersGUI().setVisible(true));
    }
}
