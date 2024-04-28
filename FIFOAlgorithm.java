

import java.util.ArrayList;
import java.util.List;

public class FIFOAlgorithm {
    private List<Process> inputProcesses;
    private List<Process> readyList;
    private List<Process> finishedList;
    private Schedule outputSchedule;
    private int currentTime;
    private List<Process> readyProcesses;

    public FIFOAlgorithm(List<Process> inputProcesses) {
        this.inputProcesses = inputProcesses;
        this.readyList = new ArrayList<>();

        this.finishedList = new ArrayList<>();
        this.outputSchedule = new Schedule();
        this.readyProcesses = new ArrayList<>();
        this.currentTime = 0;
    }

    public Schedule makeSchedule() {
        Process runningProcess = null; // Pointer to the currently running process
        
        while (!inputProcesses.isEmpty() || !finishedList.containsAll(readyProcesses)) {
            // Check for processes with input time less than or equal to current time
            for (Process process : inputProcesses) {
                if (process.getInputTime() <= currentTime) {
                    readyProcesses.add(process);
                    outputSchedule.addMove(process.getName(), currentTime, Schedule.State.READY);
                }
            }
            
            // Move ready processes to the ready list and remove them from input list
            for (Process process : readyProcesses ) {
                if (!readyList.contains(process)){
                readyList.add(process);
                inputProcesses.remove(process);
                }
            }
            
           

    
            // Decrement running time of the currently running process
            // If a process is currently running
            if (runningProcess != null) {
                // If the running time is zero, move the process to the finished list
                if (runningProcess.getRunningTime() == 0) {
                    finishedList.add(runningProcess);
                    outputSchedule.addMove(runningProcess.getName(), currentTime , Schedule.State.FINISHED);
                    readyList.remove(runningProcess);
                    Process nextToRun = readyList.get(0);
                    runningProcess = nextToRun; // Reset the pointer to indicate no process is running
                    runningProcess.setRunningTime(runningProcess.getRunningTime() - 1);
                    if (!finishedList.contains(runningProcess)){
                        outputSchedule.addMove(runningProcess.getName(), currentTime , Schedule.State.RUNNING);
                    }
                } else {
                    // If the running time is not zero, decrement it by one
                    runningProcess.setRunningTime(runningProcess.getRunningTime() - 1);

                }
            }


            // If no process is running and there are processes ready, start the next process
            if (runningProcess == null && !readyList.isEmpty()) {
                Process nextProcess = readyList.get(0);
                runningProcess = nextProcess;
                if (!finishedList.contains(runningProcess)){
                    outputSchedule.addMove(runningProcess.getName(), currentTime, Schedule.State.RUNNING);
                }
            }

            // Increment current time
            currentTime++;
        }
        
        return outputSchedule;
    }
    
}

