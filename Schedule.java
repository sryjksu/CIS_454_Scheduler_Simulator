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

    /**
     * Represents a single move containing process name, time, and status.
     */
    private static class OneMove {
        private String processName;
        private int runningTime;
        private status moveToStatus;
        
        private OneMove(String processName, int runningTime, status moveToStatus) {
            this.processName = processName;
            this.runningTime = runningTime;
            this.moveToStatus = moveToStatus;
        }
    }

    public OneMove getCurrentMove() {
        if (currentIndex >= 0 && currentIndex < scheduleList.size()) {
            return scheduleList.get(currentIndex);
        }
        return null;
    }

    public OneMove getNextMove() {
        currentIndex++;
        if (currentIndex >= 0 && currentIndex < scheduleList.size()) {
            return scheduleList.get(currentIndex);
        }
        return null;
    }

    public String getProcessName() {
        OneMove currentMove = getCurrentMove();
        if (currentMove != null) {
            return currentMove.processName;
        }
        return null;
    }

    public int getRunningTime() {
        OneMove currentMove = getCurrentMove();
        if (currentMove != null) {
            return currentMove.runningTime;
        }
        return -1;
    }

    public status getMoveToStatus() {
        OneMove currentMove = getCurrentMove();
        if (currentMove != null) {
            return currentMove.moveToStatus;
        }
        return null;
    }
}

