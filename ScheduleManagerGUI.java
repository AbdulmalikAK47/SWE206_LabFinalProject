import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ScheduleManagerGUI extends JFrame {
    private ScheduleManager scheduleManager;
    private JComboBox<String> machineComboBox;
    private JButton checkAvailabilityButton;
    private JTextArea availabilityTextArea;

    public ScheduleManagerGUI() {
       
        initializeUI();
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

    private void initializeUI() {
        machineComboBox = new JComboBox<>();
        checkAvailabilityButton = new JButton("Check Availability");
        availabilityTextArea = new JTextArea(10, 30);
        availabilityTextArea.setEditable(false);

        JPanel panel = new JPanel();
        panel.add(machineComboBox);
        panel.add(checkAvailabilityButton);
        panel.add(new JScrollPane(availabilityTextArea));

        this.add(panel);

        populateMachines();
        initializeActions();
    }

    private void populateMachines() {
        // Assuming machines have a suitable toString() method
        scheduleManager.getMachines().forEach(machine -> machineComboBox.addItem(machine.getMachineId()));
    }

    private void initializeActions() {
        checkAvailabilityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedMachineName = (String) machineComboBox.getSelectedItem();
                // Simplified - in practice, you would have a date picker or similar
                TimeSlot timeSlot = new TimeSlot("09:00", "17:00"); 
                Machine selectedMachine = scheduleManager.getMachines().stream()
                        .filter(machine -> machine.getMachineId().equals(selectedMachineName))
                        .findFirst()
                        .orElse(null);

                if (selectedMachine != null) {
                    boolean isAvailable = scheduleManager.isMachineAvailable(selectedMachine, timeSlot);
                    availabilityTextArea.setText(selectedMachineName + " is " + (isAvailable ? "available" : "not available") + " at the selected time.");
                }
            }
        });
    }}

   /*  public static void main(String[] args) {
        // Example usage
        List<Machine> machines = List.of(new Machine("1",  "Available"),
                                         new Machine("2",  "In Use"));
        ScheduleManager scheduleManager = new ScheduleManager();
        ScheduleManagerGUI gui = new ScheduleManagerGUI();
        gui.setVisible(true);
    }
}
 */