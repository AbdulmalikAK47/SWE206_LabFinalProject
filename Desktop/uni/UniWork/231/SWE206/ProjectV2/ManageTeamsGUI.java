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

        deleteTeamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ss");
                deleteTeam();
            }
        });

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
       Team selectedTeam = teamList.getSelectedValue();
    if (selectedTeam == null) {
        JOptionPane.showMessageDialog(this, "Please select a team to edit", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Create fields for editing team details
    JTextField teamNameField = new JTextField(selectedTeam.getName(), 20);
    JTextField teamDescArea = new JTextField(selectedTeam.getName(), 20);

    // Add more fields if needed (e.g., for team members)

    // Set up a panel with labels and fields
    JPanel panel = new JPanel(new GridLayout(0, 2));
    panel.add(new JLabel("Team Name:"));
    panel.add(teamNameField);
    panel.add(new JLabel("Team Description:"));
    panel.add(teamDescArea);
    // Add more components to the panel if needed

    // Show a dialog with the panel
    int result = JOptionPane.showConfirmDialog(this, panel, 
        "Edit Team Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

    if (result == JOptionPane.OK_OPTION) {
        String teamName = teamNameField.getText().trim();
        
        String teamdescArea= teamDescArea.getText().trim(); 

        // Retrieve other details from fields if necessary

        // Simple validation
        if (!teamName.isEmpty()) {
            selectedTeam.setName(teamName);
            selectedTeam.setName(teamdescArea);

            // Update other attributes of the team as necessary

            // Logic to update the team in the data source
            // For example: teamService.updateTeam(selectedTeam);

            // Refresh the team list display
            teamListModel.setElementAt(selectedTeam, teamList.getSelectedIndex());
        } else {
            JOptionPane.showMessageDialog(this, "Team name cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    }

    private void deleteTeam() {
       
            Team selectedTeam = teamList.getSelectedValue();
            System.out.println("ss");
            if (selectedTeam == null) {
                JOptionPane.showMessageDialog(this, "Please select a team to delete", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
    
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this team?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                teams.remove(selectedTeam);
                teamListModel.removeElement(selectedTeam);
            }
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

