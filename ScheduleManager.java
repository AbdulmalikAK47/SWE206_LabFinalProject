import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ScheduleManager {
    User user1 = new User("U123", "John Doe", "johndoe@example.com");
    Machine m1 = new Machine("01","av");
    User user2 = new User("U123", "John Doe", "johndoe@example.com");
    Machine m2 = new Machine("01","av");
    Reservation reservationForMachine1 = new Reservation(
        "R001", m1,
        user1,
        new TimeSlot("09:00", "11:00")
    );

    Reservation reservationForMachine2 = new Reservation(
        "R001", m2,
        user2,
        new TimeSlot("09:00", "11:00")
    );


    // Create machines with reservations
    List<Machine> machines = Arrays.asList( m1,m2 );

    public ScheduleManager(List<Machine> machines) {
        this.machines = machines;
    }


    public List<Machine> getMachines() {
         return new ArrayList<>();
    }

    // Fetches available machines for a given time slot
    public List<Machine> getAvailableMachines(TimeSlot timeSlot) {
        return machines.stream()
                       .filter(machine -> isMachineAvailable(machine, timeSlot))
                       .collect(Collectors.toList());
    }

    public boolean isMachineAvailable(Machine machine, TimeSlot timeSlot) {
        // Logic to check if the machine is available in the given time slot
        // This would iterate through machine's reservations and check for conflicts
        return true; // Simplified for this example
    }

    // Add more methods as needed for scheduling functionalities
}
