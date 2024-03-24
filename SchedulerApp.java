import java.util.ArrayList;
import java.util.List;

public class SchedulerApp {
    private Scheduler scheduler;
    private List<Process> processList;

    public SchedulerApp() {
        this.processList = new ArrayList<>();
    }

    public void addProcess(Process process) {
        processList.add(process);
    }

    public void runScheduler(String algorithm) {
        this.scheduler = new Scheduler(processList, algorithm);
        this.scheduler.executeAlgorithm();
    }

}
