import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Machine {
    private String machineId;
  
    private String status; // e.g., "Available", "In Use", "Under Maintenance"
    private ArrayList<TimeSlot> timeSlots; // A list to track reservations for this machine

    public Machine(String machineId,  String status, ArrayList<TimeSlot> timeSlots) {
        this.machineId = machineId;
        this.status = status;
        this.timeSlots = timeSlots;
    }

    // Getters and Setters
    public String getMachineId() {
        return machineId;
    }

    public void setMachineId(String machineId) {
        this.machineId = machineId;
    }

 


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getScheduleAsString() {
        if (timeSlots.isEmpty()) {
            return "No reservations scheduled.";
        }

        StringBuilder schedule = new StringBuilder();
        for (TimeSlot timeSlots : timeSlots) {
            schedule.append(timeSlots.toString()).append("\n"); // Format each reservation
        }

        return schedule.toString();
    }

    public ArrayList<TimeSlot> getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(ArrayList<TimeSlot> timeSlots) {
        this.timeSlots = timeSlots;
    }

    // Method to add a reservation to the machine
    public void addTimeSlot(TimeSlot timeSlot) {
        timeSlots.add(timeSlot);
    }

    // Method to remove a reservation from the machine
    public void removeTimeSlot(TimeSlot timeSlot) {
        timeSlots.remove(timeSlot);
    }
    
    
   
    

    // Create reservations with users
    


   
    
         
  
    
    @Override
    public String toString() {
        return "Machine{" +
               "machineId='" + machineId + '\'' +
                + '\'' +
               ", status='" + status + '\'' +
               ", reservations=" + timeSlots +
               '}';
    }

    // Additional functionalities like checking machine availability can be added here
}
