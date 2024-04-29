import java.util.ArrayList;
import java.util.List;


public class SJFAlgorithm extends SchedulerAlgorithm{
    private List<Process> inputProcesses;
    private List<Process> readyList;
    private List<Process> finishedList;
    private Schedule outputSchedule;
    private int currentTime;
    private List<Process> readyProcesses;

    public SJFAlgorithm(List<Process> inputProcesses) {
        this.inputProcesses = inputProcesses;
        this.readyList = new ArrayList<>();

        this.finishedList = new ArrayList<>();
        this.outputSchedule = new Schedule();
        this.readyProcesses = new ArrayList<>();
        this.currentTime = 0;
    }
    public Schedule runScheduler() {
        return null;
    }
}
