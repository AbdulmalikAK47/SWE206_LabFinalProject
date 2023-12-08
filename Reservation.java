public class Reservation {
    private String reservationId;
    private Machine machine;
    private User user;
    private TimeSlot timeSlot;

    public Reservation(String reservationId, Machine machine, User user, TimeSlot timeSlot) {
        this.reservationId = reservationId;
        this.machine = machine;
        this.user = user;
        this.timeSlot = timeSlot;
    }

    // Getters and Setters
    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    @Override
    public String toString() {
        return "Reservation{" +
               "reservationId='" + reservationId + '\'' +
               ", machine=" + machine +
               ", user=" + user +
               ", timeSlot=" + timeSlot +
               '}';
    }

    // Additional methods as needed for reservation management
}
