import java.util.ArrayList;
import java.util.List;

/**
 * Represents a schedule for process management using a list of individual moves.
 */
public class Schedule {
    private List<OneMove> scheduleList;

    /**
     * Constructs a Schedule with an empty list of moves.
     */
    public Schedule() {
        this.scheduleList = new ArrayList<>();
    }
    public enum status {READY, RUNNING, BLOCKED, FINISHED};

    /**
     * Adds a move to the schedule.
     * @param processName The name of the process.
     * @param runningTime The time of the move.
     * @param moveToStatus The status to which the process is moved.
     */
    public void addMove(String processName, int runningTime, status moveToStatus) {
        scheduleList.add(new OneMove(processName, runningTime, moveToStatus));
    }

    /**
     * Represents a single move containing process name, time, and status.
     */
    public static class OneMove {
        public String processName;
        public int runningTime;
        public status moveToStatus;
        
        public OneMove(String processName, int runningTime, status moveToStatus) {
            this.processName = processName;
            this.runningTime = runningTime;
            this.moveToStatus = moveToStatus;
        }
    }
    public List<OneMove> getStatusChangesUpToTime(int runningTime) {
        List<OneMove> statusChanges = new ArrayList<>();
        for (OneMove move : scheduleList) {
            if (move.runningTime <= runningTime) {
                statusChanges.add(move);
            } else {
                break; 
            }
        }
        return statusChanges;
    }

}

