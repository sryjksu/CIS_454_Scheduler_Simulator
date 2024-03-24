import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;

/**
 * Represents a scheduler for process management.
 */
public class Schedule {
    private List<Process> processList;
    private Process currentProcess;
    private Scheduler scheduler;
    private int timeSlice;
    private Statistics RunningData;
 
    /**
     * Constructs a Schedule with the specified scheduler and time quantum.
     * @param scheduler The scheduler algorithm to be used.
     * @param timeSlice The time slice for round-robin scheduling.
     */
    public Schedule(Scheduler scheduler, int timeSlice) {
        this.processList = new LinkedList<>();
        this.scheduler = scheduler;
        this.timeSlice = timeSlice;
        this.RunningData = new RunningData();
    }

    // Methods to manipulate process queue, add/remove processes, etc.

    // Methods to handle scheduling events, such as process arrival, completion, etc.

    // Methods to simulate the scheduler, perform scheduling decisions, context switches, etc.

    // Methods to track and update Running data like input time, total running time, end time. This will be used to create animation.

}
