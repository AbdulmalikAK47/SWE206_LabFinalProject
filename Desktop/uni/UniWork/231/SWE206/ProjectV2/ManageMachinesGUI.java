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
    private JButton makeReservationButton; // New button for making reservations

    private ArrayList<Machine> machines; // This should be fetched from a database or other data source

    public ManageMachinesGUI() {
        this.machines = new ArrayList<>(); // Placeholder for machine data
        initializeUI();
        setTitle("Manage Machines");
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
    }

    private void initializeUI() {
        machineListModel = new DefaultListModel<>();
        machineList = new JList<>(machineListModel);
        addMachineButton = new JButton("Add Machine");
        editMachineButton = new JButton("Edit Machine");
        deleteMachineButton = new JButton("Delete Machine");
        makeReservationButton = new JButton("Make a Reservation"); // Initialize the reservation button


        addMachineButton.addActionListener(e -> addMachine());
        editMachineButton.addActionListener(e -> editMachine());
        deleteMachineButton.addActionListener(e -> deleteMachine());
        makeReservationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeReservation();
            }
        });


        this.setLayout(new BorderLayout());
        this.add(new JScrollPane(machineList), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addMachineButton);
        buttonPanel.add(editMachineButton);
        buttonPanel.add(deleteMachineButton);
        buttonPanel.add(makeReservationButton); // Add the reservation button to the panel

        this.add(buttonPanel, BorderLayout.SOUTH);

        refreshMachineList();
    }
    public ArrayList<Machine> getMachineList() {
        return machines;
    }
    private void makeReservation() {
        Machine selectedMachine = machineList.getSelectedValue();
        if (selectedMachine == null) {
            JOptionPane.showMessageDialog(this, "Please select a machine to reserve", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        JTextField startTimeField = new JTextField(5);
        JTextField endTimeField = new JTextField(5);
        JTextField dayField = new JTextField(10);
        JTextField dateField = new JTextField(10);
        JComboBox<Team> teamComboBox = new JComboBox<>();

        Team t4 = new Team("0123", "Socrative");
        Team t8 = new Team("012334", "Apricot");

        teamComboBox.addItem(t4);
        teamComboBox.addItem(t8);


         // Assuming you have a list of teams
    
        // Populate teamComboBox with teams (Assuming you have a method getTeams())
       
    
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Start Time (HH:mm):"));
        panel.add(startTimeField);
        panel.add(new JLabel("End Time (HH:mm):"));
        panel.add(endTimeField);
        panel.add(new JLabel("Day:"));
        panel.add(dayField);
        panel.add(new JLabel("Date (YYYY-MM-DD):"));
        panel.add(dateField);
        panel.add(new JLabel("Team:"));
        panel.add(teamComboBox);
    
        int result = JOptionPane.showConfirmDialog(null, panel, 
                "Enter Details for New Reservation", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            TimeSlot newTimeSlot = new TimeSlot(
                startTimeField.getText(), 
                endTimeField.getText(), 
                dayField.getText(), 
                (Team) teamComboBox.getSelectedItem(), 
                dateField.getText()
            );
    
            selectedMachine.getTimeSlots().add(newTimeSlot); // Add the new time slot to the machine
            // Optionally, refresh the list or UI
        }
    }
    

    private void addMachine() {
        JTextField machineIdField = new JTextField(10);
        JComboBox<String> statusComboBox = new JComboBox<>(new String[]{"Available", "In Use", "Under Maintenance"});

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Machine ID:"));
        panel.add(machineIdField);
        panel.add(new JLabel("Status:"));
        panel.add(statusComboBox);

        int result = JOptionPane.showConfirmDialog(this, panel, 
                "Enter New Machine Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            String machineId = machineIdField.getText();
            String status = (String) statusComboBox.getSelectedItem();

            Machine newMachine = new Machine(machineId, status, new ArrayList<>());
            machines.add(newMachine); // Assuming 'machines' is your list of Machine objects
            refreshMachineList(); // Update your machine list UI
    }}

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
