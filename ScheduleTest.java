package CIS_454_Scheduler_Simulator;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ScheduleTest {
    private Schedule schedule;

    @Before
    public void setUp() {
        schedule = new Schedule();
        schedule.addMove("Process1", 10, Schedule.State.READY);
        schedule.addMove("Process2", 5, Schedule.State.RUNNING);
        schedule.addMove("Process3", 15, Schedule.State.BLOCKED);
    }

    @Test
    public void testGetCurrentName_Initial() {
        assertEquals("Process1", schedule.getCurrentName());
    }

    @Test
    public void testGetCurrentTime_Initial() {
        assertEquals(10, schedule.getCurrentTime());
    }

    @Test
    public void testGetCurrentStatus_Initial() {
        assertEquals(Schedule.State.READY, schedule.getCurrentStatus());
    }

    @Test
    public void testMoveToNext() {
        schedule.moveToNext();
        assertEquals("Process2", schedule.getCurrentName());
        assertEquals(5, schedule.getCurrentTime());
        assertEquals(Schedule.State.RUNNING, schedule.getCurrentStatus());
    }

    @Test
    public void testGetNextTime_WithNextAvailable() {
        assertEquals(5, schedule.getNextTime());
    }

    @Test
    public void testGetNextTime_AtEndOfList() {
        schedule.moveToNext(); // Move to Process2
        schedule.moveToNext(); // Move to Process3
        assertEquals(-1, schedule.getNextTime()); // No next process
    }

    @Test
    public void testGetCurrentName_OutOfBounds() {
        schedule.moveToNext(); // Move to Process2
        schedule.moveToNext(); // Move to Process3
        schedule.moveToNext(); // Beyond Process3
        assertNull(schedule.getCurrentName());
    }

    @Test
    public void testGetCurrentTime_OutOfBounds() {
        schedule.moveToNext(); // Move to Process2
        schedule.moveToNext(); // Move to Process3
        schedule.moveToNext(); // Beyond Process3
        assertEquals(-1, schedule.getCurrentTime());
    }

    @Test
    public void testGetCurrentStatus_OutOfBounds() {
        schedule.moveToNext(); // Move to Process2
        schedule.moveToNext(); // Move to Process3
        schedule.moveToNext(); // Beyond Process3
        assertNull(schedule.getCurrentStatus());
    }
}
