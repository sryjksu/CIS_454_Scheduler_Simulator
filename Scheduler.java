import java.util.List;

public class Scheduler {
    private SchedulerAlgorithm schedulerAlgorithm;

    public Scheduler(List<Process> list, String algorithm) {
        this.schedulerAlgorithm = new SchedulerAlgorithm(list, algorithm);
    }

    public void executeAlgorithm() {
        schedulerAlgorithm.execute();
    }
}
