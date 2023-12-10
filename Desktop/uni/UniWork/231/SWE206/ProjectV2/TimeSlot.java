

public class TimeSlot {
    private String startTime;
    private String endTime;
    private String day;
    private String date;
    private Team team;
    private String teamId;

    public TimeSlot(String startTime, String endTime, String day, Team team, String date) {
        this.team = team;
        this.startTime = startTime;
        this.endTime = endTime;
        this.day = day;
        this.date = date;
    }

    // Getters and Setters
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return day + "\t" + date + "\t" + startTime + " - " + endTime + "\t[" + team.getName() + " - " + team.getTeamId() + "]";
    }

    // Additional methods as needed
}
