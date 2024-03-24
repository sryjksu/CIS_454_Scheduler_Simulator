/**
 * Represents a process in the Scheduler Simulator System.
 * Each process contains input time, running time, and preferred algorithm.
 */
public class Process {
    private int inputTime; // Input time of the process
    private int runningTime; // Running time of the process
    

    /**
     * Constructs a new Process with specified input time, running time, and algorithm type.
     * @param inputTime The input time of the process.
     * @param runningTime The running time of the process.
     */
    public Process(int inputTime, int runningTime, String algorithmType) {
        this.inputTime = inputTime;
        this.runningTime = runningTime;
    }

    // Getters and setters

    /**
     * Gets the input time of the process.
     * @return The input time of the process.
     */
    public int getInputTime() {
        return inputTime;
    }

    /**
     * Sets the input time of the process.
     * @param inputTime The input time of the process to set.
     */
    public void setInputTime(int inputTime) {
        this.inputTime = inputTime;
    }

    /**
     * Gets the running time of the process.
     * @return The running time of the process.
     */
    public int getRunningTime() {
        return runningTime;
    }

    /**
     * Sets the running time of the process.
     * @param runningTime The running time of the process to set.
     */
    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
    }


    /**
     * Returns the string representation of the process.
     * @return String representation of the process.
     */
    @Override
    public String toString() {
        return "Process{" +
                "inputTime=" + inputTime +
                ", runningTime=" + runningTime +
                '}';
    }
}
