import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Machine {
    private String machineId;
  
    private String status; // e.g., "Available", "In Use", "Under Maintenance"
    private List<Reservation> reservations; // A list to track reservations for this machine

    public Machine(String machineId,  String status) {
        this.machineId = machineId;
     
        this.status = status;
        this.reservations = new ArrayList<>();
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
        if (reservations.isEmpty()) {
            return "No reservations scheduled.";
        }

        StringBuilder schedule = new StringBuilder();
        for (Reservation reservation : reservations) {
            schedule.append(reservation.toString()).append("\n"); // Format each reservation
        }

        return schedule.toString();
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    // Method to add a reservation to the machine
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    // Method to remove a reservation from the machine
    public void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
    }
    
    
   
    

    // Create reservations with users
    


   
    
         
  
    
    @Override
    public String toString() {
        return "Machine{" +
               "machineId='" + machineId + '\'' +
                + '\'' +
               ", status='" + status + '\'' +
               ", reservations=" + reservations +
               '}';
    }

    // Additional functionalities like checking machine availability can be added here
}
