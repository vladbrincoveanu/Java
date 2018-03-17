import java.time.LocalDateTime;

public class MonitoredData {

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String activityLabel;

    MonitoredData(LocalDateTime startTime, LocalDateTime endTime, String activityLabel) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.activityLabel = activityLabel;
    }

    LocalDateTime getStartTime() {
        return startTime;
    }

    LocalDateTime getEndTime() {
        return endTime;
    }

    String getActivityLabel() {
        return activityLabel;
    }

    public String toString() {
        return this.startTime + " " + this.endTime + " " + activityLabel + " \n";
    }
}
