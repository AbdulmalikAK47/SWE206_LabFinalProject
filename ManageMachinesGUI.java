import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ManageMachinesGUI extends JFrame {
    private JList<Machine> machineList;
    private DefaultListModel<Machine> machineListModel;
    private JButton addMachineButton;
    private JButton editMachineButton;
    private JButton deleteMachineButton;
    private List<Machine> machines; // This should be fetched from a database or other data source

    public ManageMachinesGUI() {
        this.machines = new ArrayList<>(); // Placeholder for machine data
        initializeUI();
        setTitle("Manage Machines");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
    }

    private void initializeUI() {
        machineListModel = new DefaultListModel<>();
        machineList = new JList<>(machineListModel);
        addMachineButton = new JButton("Add Machine");
        editMachineButton = new JButton("Edit Machine");
        deleteMachineButton = new JButton("Delete Machine");

        addMachineButton.addActionListener(e -> addMachine());
        editMachineButton.addActionListener(e -> editMachine());
        deleteMachineButton.addActionListener(e -> deleteMachine());

        this.setLayout(new BorderLayout());
        this.add(new JScrollPane(machineList), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addMachineButton);
        buttonPanel.add(editMachineButton);
        buttonPanel.add(deleteMachineButton);
        this.add(buttonPanel, BorderLayout.SOUTH);

        refreshMachineList();
    }

    private void addMachine() {
        // Open a dialog to enter new machine details
        // Update the machine list after adding
    }

    private void editMachine() {
        // Open a dialog to edit the selected machine's details
        // Update the machine list after editing
    }

    private void deleteMachine() {
        // Delete the selected machine
        // Update the machine list after deleting
    }

    private void refreshMachineList() {
        machineListModel.clear();
        for (Machine machine : machines) {
            machineListModel.addElement(machine);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ManageMachinesGUI().setVisible(true));
    }
}
