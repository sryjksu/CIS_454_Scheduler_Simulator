import java.util.ArrayList;

public class Scheduler {
    private ArrayList<Process> processList;

    public Scheduler(ArrayList<Process> processList) {
        this.processList = processList;
    }

    public void execute() {
        if (this.processList != null && !this.processList.isEmpty()) {
            Schedule schedule = FIFOAlgorithm.runFIFOAlgorithm(this.processList);
            System.out.println("Schedule execution completed. Details:");
        } else {
            System.out.println("Process list is empty or not set");
        }
    }
}
