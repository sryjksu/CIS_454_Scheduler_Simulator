import java.util.ArrayList;

public class Scheduler {
    private ArrayList<Process> processList;
    private SchedulerAlgorithm algorithm;

    public Scheduler(ArrayList<Process> processList, String algorithmType) {
        this.processList = processList;
        setAlgorithm(algorithmType); 
    }

    private void setAlgorithm(String algorithmType) {
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
                throw new IllegalArgumentException("Unknown scheduling algorithm type: " + algorithmType);
        }
    }

    public Schedule execute() {
        if (this.algorithm != null) {
            return this.algorithm.execute(this.processList);
        } else {
            System.err.println("No scheduling algorithm set.");
            throw new IllegalStateException("Attempt to execute scheduling without setting an algorithm.");
        }
    }
}
