import java.util.ArrayList;

public class Scheduler {
    private ArrayList<Process> processList;
    
    private SchedulerAlgorithm algorithm;

    public Scheduler(ArrayList<Process> processList, String algorithmType) {
        this.processList = processList;
        switch (algorithmType) {
            case "FIFO":
                this.algorithm = new FIFOAlgorithm();
                break;
            case "SJF":
                this.algorithm = new SJFAlgorithm();
                break;
            case "RR":
                this.algorithm = new RRAlgorithm();
                break;
            default:
                throw new IllegalArgumentException("Unknown");
        }
    }

    public Schedule execute() {
        if (this.algorithm != null) {
            return this.algorithm.execute(this.processList);
        } else {
            System.out.println("No scheduling algorithm set.");
            return null;
        }
    }
}

