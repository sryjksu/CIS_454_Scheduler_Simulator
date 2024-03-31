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

    /**
     * Adds a move to the schedule.
     * @param processName The name of the process.
     * @param time The time of the move.
     * @param moveToStatus The status to which the process is moved.
     */
    public void addMove(String processName, int time, String moveToStatus) {
        scheduleList.add(new OneMove(processName, time, moveToStatus));
    }

    /**
     * Represents a single move containing process name, time, and status.
     */
    private static class OneMove {
        private String processName;
        private int runningTime;
        private String moveToStatus;

        public OneMove(String processName, int runningTime, String moveToStatus) {
            this.processName = processName;
            this.time = runningTime;
            this.moveToStatus = moveToStatus;
        }

        public String getProcessName() {
            return processName;
        }

        public int getTime() {
            return runningTime;
        }

        public String getMoveToStatus() {
            return moveToStatus;
        }
    }
}
