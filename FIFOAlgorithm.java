
import java.util.ArrayList;
import java.util.List;

public class FIFOAlgorithm {
    private List<Process> inputProcesses;
    private List<Process> readyList;
    private List<Process> runningList;
    private List<Process> finishedList;
    private Schedule outputSchedule;
    private int currentTime;

    public FIFOAlgorithm(List<Process> inputProcesses) {
        this.inputProcesses = inputProcesses;
        this.readyList = new ArrayList<>();
        this.runningList = new ArrayList<>();
        this.finishedList = new ArrayList<>();
        this.outputSchedule = new Schedule();
        this.currentTime = 0;
    }

    public Schedule runScheduler() {
        Process currentProcess = null; // Pointer to the currently running process
        
        while (!finishedList.containsAll(inputProcesses)) {
            // Check for processes with input time less than or equal to current time
            for (Process process : inputProcesses) {
                if (process.getInputTime() <= currentTime && !readyList.contains(process)) {
                    readyList.add(process);
                    outputSchedule.addMove(process.getName(), currentTime, Schedule.State.READY);
                    System.out.println("123");
                }
            }
    
            // If no process is running and there are processes ready, start the next process
            if (currentProcess == null && !readyList.isEmpty()) {
                currentProcess = readyList.remove(0);
                outputSchedule.addMove(currentProcess.getName(), currentTime, Schedule.State.RUNNING);
                System.out.println("234");
            }
    
            // Decrement running time of the currently running process
            // If a process is currently running
            if (currentProcess != null) {
                // If the running time is zero, move the process to the finished list
                if (currentProcess.getRunningTime() == 0) {
                    finishedList.add(currentProcess);
                    outputSchedule.addMove(currentProcess.getName(), currentTime, Schedule.State.FINISHED);
                    currentProcess = null; // Reset the pointer to indicate no process is running
                    System.out.println("456");
                } else {
                // If the running time is not zero, decrement it by one
                    currentProcess.setRunningTime(currentProcess.getRunningTime() - 1);
                    outputSchedule.addMove(currentProcess.getName(), currentTime, Schedule.State.RUNNING);
                    System.out.println("345");
                }
            }

    
            // Increment current time
            currentTime++;
        }
    
        return outputSchedule;
    }
    
}
