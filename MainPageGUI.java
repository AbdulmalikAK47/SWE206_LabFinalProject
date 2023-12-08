import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPageGUI extends JFrame {
    private JButton manageProjectsButton;
    private JButton manageTeamsButton;
    private JButton manageUsersButton;
    private JButton manageMachinesButton;
    private JButton viewScheduleButton;
    private JButton signOutButton;

    public MainPageGUI() {
        initializeUI();
        setTitle("KFUPM Research Center Management System");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
    }

    private void initializeUI() {
        manageProjectsButton = new JButton("Manage Projects");
        manageTeamsButton = new JButton("Manage Teams");
        manageUsersButton = new JButton("Manage Users");
        manageMachinesButton = new JButton("Manage Machines");
        viewScheduleButton = new JButton("View Schedule");
        signOutButton = new JButton("Sign Out");

        manageProjectsButton.addActionListener(e -> openManageProjects());
        manageTeamsButton.addActionListener(e -> openManageTeams());
        manageUsersButton.addActionListener(e -> openManageUsers());
        manageMachinesButton.addActionListener(e -> openManageMachines());
        viewScheduleButton.addActionListener(e -> openViewScheduleGUI());
        signOutButton.addActionListener(e -> signOut());

        viewScheduleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openViewScheduleGUI();
            }
        });


        setLayout(new GridLayout(3, 2, 10, 10)); // Simple grid layout
        add(manageProjectsButton);
        add(manageTeamsButton);
        add(manageUsersButton);
        add(manageMachinesButton);
        add(viewScheduleButton);
        add(signOutButton);
    }

    private void openManageProjects() {
        ManageProjectsGUI manageProjectsGUI = new ManageProjectsGUI();
        manageProjectsGUI.setVisible(true);    }

    private void openManageTeams() {
        ManageTeamsGUI manageTeamsGUI = new ManageTeamsGUI();
        manageTeamsGUI.setVisible(true);  
     
    }

    private void openManageUsers() {
        ManageUsersGUI manageUsersGUI = new ManageUsersGUI();
        manageUsersGUI.setVisible(true);
    }

    private void openManageMachines() {
        ManageMachinesGUI manageMachinesGUI = new ManageMachinesGUI();
        manageMachinesGUI.setVisible(true);
    }

    private void openViewScheduleGUI() {
        
 /*  ViewScheduleGUI ViewScheduleGUI = new ViewScheduleGUI( );
        ViewScheduleGUI.setVisible(true); */
       
    }

    private void signOut() {
        // Handle Sign Out logic
        dispose(); // Close the window
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainPageGUI().setVisible(true));
    }

   
}
 

 
    

