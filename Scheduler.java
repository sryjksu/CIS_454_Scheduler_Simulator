import java.util.ArrayList;

public class Scheduler {
    private ArrayList<Process> processList;
    private FIFOAlgorithm algorithm;  

    public Scheduler(ArrayList<Process> processList) {
        this.processList = processList;
        this.algorithm = new FIFOAlgorithm(); 
    }

    public void execute() {
        if (this.processList != null && !this.processList.isEmpty()) {
            this.algorithm.execute(this.processList);
        } else {
            System.out.println("Process list is empty or not set");
        }
    }
}
