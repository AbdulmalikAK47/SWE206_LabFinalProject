import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ManageProjectsGUI extends JFrame {
    private JList<Project> projectList;
    private DefaultListModel<Project> projectListModel;
    private JButton editProjectButton;
    private JButton deleteProjectButton;
    private JButton addProjectButton;
    private List<Project> projects; // This should be fetched from a database or data source

    public ManageProjectsGUI() {
        this.projects = new ArrayList<>(); // Example list, replace with actual data source
        initializeUI();
        setTitle("Manage Projects");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
    }

    private void initializeUI() {
        projectListModel = new DefaultListModel<>();
        projectList = new JList<>(projectListModel);
        addProjectButton = new JButton("Add New Project");
        editProjectButton = new JButton("Edit Existing Project");
        deleteProjectButton = new JButton("Delete any Project");

        addProjectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewProject();
            }
        });

        this.setLayout(new BorderLayout());
        this.add(new JScrollPane(projectList), BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(deleteProjectButton);
        buttonPanel.add(addProjectButton);
        buttonPanel.add(editProjectButton);
        buttonPanel.add(deleteProjectButton);
        this.add(buttonPanel, BorderLayout.SOUTH);

        refreshProjectList();
    }

    private void addNewProject() {
        // Open a dialog to enter new project details
        JTextField projectNameField = new JTextField(20);
        JTextArea projectDescArea = new JTextArea(5, 20);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Project Name:"));
        panel.add(projectNameField);
        panel.add(new JLabel("Description:"));
        panel.add(new JScrollPane(projectDescArea));

        int result = JOptionPane.showConfirmDialog(null, panel, 
                "Enter Project Details", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String name = projectNameField.getText();
            String description = projectDescArea.getText();
            Project newProject = new Project("01", name, description, new ArrayList<>());
            projects.add(newProject);
            refreshProjectList();
        }
    }

    private void refreshProjectList() {
        projectListModel.clear();
        for (Project project : projects) {
            projectListModel.addElement(project);
        }
    }
}
