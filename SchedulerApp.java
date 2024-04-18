
import java.util.ArrayList;

public class SchedulerApp {
    private Scheduler scheduler;
    private ArrayList<Process> processList;

    public SchedulerApp(String algorithmType, String fileName) {
        ListProcessor listProcessor = new ListProcessor();
        listProcessor.createList(fileName); 
        this.processList = listProcessor.GetList();
        this.scheduler = new Scheduler(processList, algorithmType);  
    }

    public void runScheduler() {
        if (!processList.isEmpty()) {
            Schedule schedule = scheduler.execute();  
            displaySchedule(schedule);  //test
        } else {
            System.out.println("No processes to schedule.");
        }
    }
        private void displaySchedule(Schedule schedule) {
        if (schedule != null) {
            System.out.println("Scheduled Tasks:");
            System.out.println(schedule);  // Assuming the Schedule class has a proper toString method
        } else {
            System.out.println("No schedule created.");
        }
    }
    // display is just to check does it work or not
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please specify a scheduling algorithm (e.g., FIFO, SJF, RR).");
            return;
        }
        SchedulerApp schedulerApp = new SchedulerApp(args[0]);
        schedulerApp.runScheduler();
    }

}
