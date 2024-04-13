import java.util.ArrayList;
import java.util.List;

public class FIFOAlgorithm {

    public static Schedule runFIFOAlgorithm(List<Process> processes) {
        Schedule schedule = new Schedule();
        List<Process> processList = new ArrayList<>();

        int currentTime = 0;

        for (Process process : processes) {
            // If the process arrives later, wait until its arrival time
            while (currentTime < process.getInputTime()) {
                currentTime++;
            }

            // Execute the process
            schedule.addMove(process.getAlgorithmType(), process.getRunningTime(), process.getInputTime(), "Running");

            // Update the current time
            currentTime += process.getRunningTime();

            // Add the process to the list for future execution (FIFO)
            processList.add(process);
        }

        for (Process finishedProcess : processList) {
            schedule.addMove(finishedProcess.getAlgorithmType(), 0, currentTime, "Finished");
        }

        return schedule;
    }
}
