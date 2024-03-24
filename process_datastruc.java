/**
 * Represents a process in the Scheduler Simulator System.
 * Each process contains input time, running time, and preferred algorithm.
 */
public class Process {
    private int inputTime; // Input time of the process
    private int runningTime; // Running time of the process
    private String algorithmType; // Type of algorithm the process would like to use

    /**
     * Constructs a new Process with specified input time, running time, and algorithm type.
     * @param inputTime The input time of the process.
     * @param runningTime The running time of the process.
     * @param algorithmType The preferred algorithm type of the process.
     */
    public Process(int inputTime, int runningTime, String algorithmType) {
        this.inputTime = inputTime;
        this.runningTime = runningTime;
        this.algorithmType = algorithmType;
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
     * Gets the algorithm type preferred by the process.
     * @return The algorithm type preferred by the process.
     */
    public String getAlgorithmType() {
        return algorithmType;
    }

    /**
     * Sets the algorithm type preferred by the process.
     * @param algorithmType The algorithm type preferred by the process to set.
     */
    public void setAlgorithmType(String algorithmType) {
        this.algorithmType = algorithmType;
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
                ", algorithmType='" + algorithmType + '\'' +
                '}';
    }
}
