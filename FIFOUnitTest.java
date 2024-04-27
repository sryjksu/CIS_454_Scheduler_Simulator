import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class FIFOUnitTest {

    @Test
    public void testFIFOAlgorithm() {
        // Create a list of processes for testing
        List
        <Process> processes = new ArrayList<>();
        processes.add(new Process("P1", 0, 3)); // Process with name "P1", input time 0, running time 3
        processes.add(new Process("P2", 1, 2)); // Process with name "P2", input time 1, running time 2
        processes.add(new Process("P3", 2, 4)); // Process with name "P3", input time 2, running time 4

        // Create a FIFOAlgorithm instance with the test processes
        FIFOAlgorithm fifoAlgorithm = new FIFOAlgorithm(processes);

        // Run the scheduler
        Schedule outputSchedule = fifoAlgorithm.runScheduler();

        // Validate the output schedule
        assertNotNull(outputSchedule);

        // Validate the schedule for each process
        assertEquals(Schedule.State.RUNNING, outputSchedule.getState("P1", 0)); // Process P1 should start at time 0
        assertEquals(Schedule.State.FINISHED, outputSchedule.getState("P1", 3)); // Process P1 should finish at time 3

        assertEquals(Schedule.State.RUNNING, outputSchedule.getState("P2", 3)); // Process P2 should start at time 3
        assertEquals(Schedule.State.FINISHED, outputSchedule.getState("P2", 5)); // Process P2 should finish at time 5

        assertEquals(Schedule.State.RUNNING, outputSchedule.getState("P3", 5)); // Process P3 should start at time 5
        assertEquals(Schedule.State.FINISHED, outputSchedule.getState("P3", 9)); // Process P3 should finish at time 9
    }
}

