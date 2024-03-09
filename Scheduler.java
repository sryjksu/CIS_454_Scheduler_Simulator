import java.util.List;

public class Scheduler {
    private List<Process> processList;
    private String algorithm;

    public Scheduler(List<Process> list, String algorithm) {
        this.processList = list;
        this.algorithm = algorithm;
    }

}

