import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewScheduleGUI extends JFrame {
    private JComboBox<Machine> machineComboBox;
    private JTextArea scheduleTextArea;
    private JButton viewButton;
    private List<Machine> machines; // This should be fetched from a database or other data source

    public ViewScheduleGUI(List<Machine> dummyMachines) {
        this.machines = machines;
        initializeUI();
        setTitle("View Machine Schedule");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
    }

    private void initializeUI() {
        machineComboBox = new JComboBox<>();
        scheduleTextArea = new JTextArea(10, 30);
        scheduleTextArea.setEditable(false);
        viewButton = new JButton("View Schedule");

        for (Machine machine : machines) {
            machineComboBox.addItem(machine);
        }

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displaySchedule();
            }
        });

        this.setLayout(new BorderLayout());
        this.add(machineComboBox, BorderLayout.NORTH);
        this.add(new JScrollPane(scheduleTextArea), BorderLayout.CENTER);
        this.add(viewButton, BorderLayout.SOUTH);
    }

    private void displaySchedule() {
        Machine selectedMachine = (Machine) machineComboBox.getSelectedItem();
        if (selectedMachine != null) {
            // Logic to retrieve and display the schedule of the selected machine
            // For example:
            scheduleTextArea.setText(selectedMachine.getScheduleAsString());
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        // Example usage with dummy data
        List<Machine> dummyMachines = List.of(
            new Machine("Machine 1", "Available"),
            new Machine("Machine 2", "In Use")
            // ... other machines ...
        );
        SwingUtilities.invokeLater(() -> new ViewScheduleGUI(dummyMachines).setVisible(true));
    }
}
