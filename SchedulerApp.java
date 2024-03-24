import java.util.ArrayList;

public class SchedulerApp {
    private Scheduler scheduler;
    private ArrayList<Process> processList;

    public SchedulerApp() {
        ListProcessor listProcessor = new ListProcessor(); 
        this.processList = listProcessor.GetList(); 
    }

    public void runScheduler(String algorithm) {
        this.scheduler = new Scheduler(this.processList, algorithm);
        scheduler.execute();
    }

}
