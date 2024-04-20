import java.util.ArrayList;
import java.util.List;

/**
 * Represents a schedule for process management using a list of individual moves.
 */
public class Schedule {
    private List<OneMove> scheduleList;
    private int currentIndex;

    /**
     * Constructs a Schedule with an empty list of moves.
     */
    public Schedule() {
        this.scheduleList = new ArrayList<OneMove>();
        this.currentIndex = 0;
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

    public String getCurrentName() {
        if (currentIndex < scheduleList.size()) {
            return scheduleList.get(currentIndex).processName;
        } else {
            return null; // Handle index out of bounds
        }
    }

    public int getCurrentTime() {
        if (currentIndex < scheduleList.size()) {
            return scheduleList.get(currentIndex).runningTime;
        } else {
            return -1; // Handle index out of bounds
        }
    }

    public status getCurrentStatus() {
        if (currentIndex < scheduleList.size()) {
            return scheduleList.get(currentIndex).moveToStatus;
        } else {
            return null; // Handle index out of bounds
        }
    }

    public void moveToNext() {
        currentIndex++;
    }

    public int getNextTime() {
        if (currentIndex + 1 < scheduleList.size()) {
            return scheduleList.get(currentIndex + 1).runningTime;
        } else {
            return -1; // Handle index out of bounds
        }
    }

    /**
     * Represents a single move containing process name, time, and status.
     */
    private class OneMove {
        private String processName;
        private int runningTime;
        private status moveToStatus;
        
        private OneMove(String processName, int runningTime, status moveToStatus) {
            this.processName = processName;
            this.runningTime = runningTime;
            this.moveToStatus = moveToStatus;
        }
    }
}

