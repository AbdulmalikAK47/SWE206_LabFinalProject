import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ManageTeamsGUI extends JFrame {
    private JList<Team> teamList;
    private DefaultListModel<Team> teamListModel;
    private JButton addTeamButton;
    private JButton editTeamButton;
    private JButton deleteTeamButton;
    private List<Team> teams; // This would typically be fetched from a database

    public ManageTeamsGUI() {
        this.teams = new ArrayList<>(); // Placeholder for team data
        initializeUI();
        setTitle("Manage Teams");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
    }

    private void initializeUI() {
        teamListModel = new DefaultListModel<>();
        teamList = new JList<>(teamListModel);
        addTeamButton = new JButton("Add Team");
        editTeamButton = new JButton("Edit Team");
        deleteTeamButton = new JButton("Delete Team");

        addTeamButton.addActionListener(e -> addTeam());
        editTeamButton.addActionListener(e -> editTeam());
        deleteTeamButton.addActionListener(e -> deleteTeam());

       

        this.setLayout(new BorderLayout());
        this.add(new JScrollPane(teamList), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addTeamButton);
        buttonPanel.add(editTeamButton);
        buttonPanel.add(deleteTeamButton);
        this.add(buttonPanel, BorderLayout.SOUTH);

        refreshTeamList();
    }

    private void addTeam() {
        JTextField teamNameField = new JTextField(20);
        JTextArea teamDescArea = new JTextArea(5, 20);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Team Name:"));
        panel.add(teamNameField);
        panel.add(new JLabel("Description:"));
        panel.add(new JScrollPane(teamDescArea));

        int result = JOptionPane.showConfirmDialog(null, panel, 
                "Enter Project Details", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String name = teamNameField.getText();
            String id = teamDescArea.getText();
            Team newProject = new Team(id, name);
            teams.add(newProject);
            refreshTeamList();
        }
    }

    private void editTeam() {
        // Open a dialog to edit the selected team's details
        // Update the team list after editing
    }

    private void deleteTeam() {
        // Delete the selected team
        // Update the team list after deleting
    }

    private void refreshTeamList() {
        teamListModel.clear();
        for (Team team : teams) {
            teamListModel.addElement(team);
        }
    }


    // Main method for testing
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ManageTeamsGUI().setVisible(true));
    }
}

