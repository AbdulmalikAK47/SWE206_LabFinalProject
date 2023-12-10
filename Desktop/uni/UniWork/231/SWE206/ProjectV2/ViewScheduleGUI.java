import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ViewScheduleGUI extends JFrame {
    private JComboBox<Machine> machineComboBox;
    private JTextArea scheduleTextArea;
    private JButton viewButton;
    private ArrayList<Machine> machines; // This should be fetched from a database or other data source
    

    public ViewScheduleGUI(ArrayList<Machine> machines) {
        this.machines = machines;
        initializeUI();
        setTitle("View Machine Schedule");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
    }

    public ArrayList<Machine> getMachines() {
        return machines;
    }

    private void initializeUI() {
        machineComboBox = new JComboBox<>();
        scheduleTextArea = new JTextArea(10, 30);
        scheduleTextArea.setEditable(false);
        viewButton = new JButton("View Schedule");
        JPanel headerPanel = new JPanel(new GridLayout(1, 4)); // 1 row, 4 columns
        headerPanel.setBackground(Color.LIGHT_GRAY);

        JLabel dayLabel = new JLabel("Day", SwingConstants.CENTER);
        JLabel dateLabel = new JLabel("Date", SwingConstants.CENTER);
        JLabel teamLabel1 = new JLabel("Team", SwingConstants.CENTER);
        JLabel teamLabel2 = new JLabel("Team", SwingConstants.CENTER); // Note: This might be a typo or intentional duplicate
        
        Font headerFont = new Font("Arial", Font.BOLD, 12);
        dayLabel.setFont(headerFont);
        dateLabel.setFont(headerFont);
        teamLabel1.setFont(headerFont);
        teamLabel2.setFont(headerFont);
    
        dayLabel.setForeground(Color.WHITE);
        dateLabel.setForeground(Color.WHITE);
        teamLabel1.setForeground(Color.WHITE);
        teamLabel2.setForeground(Color.WHITE);
    
        // Add labels to the panel
        headerPanel.add(dayLabel);
        headerPanel.add(dateLabel);
        headerPanel.add(teamLabel1);
        headerPanel.add(teamLabel2);
        this.add(headerPanel, BorderLayout.NORTH);

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

        ArrayList<TimeSlot> t = new ArrayList<>();

        Team te1 = new Team("9838347", "SWE");
        Team te2 = new Team("9838347", "SWE");
       TimeSlot t1 = new TimeSlot("15:00", "19:30", "Sun", te2, "30/5/2015");
       TimeSlot t2 = new TimeSlot("15:00", "19:30", "Sun", te1, "30/5/2015");

       t.add(t1);
       t.add(t2);

       Machine m1 = new Machine("123", "reserved", t);
       Machine m2 = new Machine("467", "reserved", t);


       ArrayList<Machine> m = new ArrayList<>();
       m.add(m1);
       m.add(m2);

        ViewScheduleGUI machines = new ViewScheduleGUI(m);
    
        // Example usage with dummy data 


        if (machines.getMachines().size() == 0){
            JOptionPane.showMessageDialog(null, "Schedule is empty", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            SwingUtilities.invokeLater(() -> new ViewScheduleGUI( machines.getMachines()).setVisible(true));
        }
    
    }
}