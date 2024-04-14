
import java.util.ArrayList;

public class SchedulerApp {
    private Scheduler scheduler;
    private ArrayList<Process> processList;

    public SchedulerApp() {
        ListProcessor listProcessor = new ListProcessor();
        listProcessor.createList("processes.txt");  
        this.processList = listProcessor.GetList();
        this.scheduler = new Scheduler(processList); 
    }

    public void runScheduler() {
        if (!processList.isEmpty()) {
            scheduler.execute();
        } else {
            System.out.println("No processes to schedule.");
        }
    }
}

