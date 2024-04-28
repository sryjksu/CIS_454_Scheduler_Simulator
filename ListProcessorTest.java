import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.io.File;

public class ListProcessorTest {

    @Test
    public void testEmptyList() {
        ListProcessor lp = new ListProcessor();
        ArrayList<Process> list = lp.GetList();
        assertNotNull(list);
        assertEquals(0, list.size());
    }

    @Test
    public void testCreateListFromFile() throws Exception {
        ListProcessor lp = new ListProcessor();
        lp.createList("Process List.txt"); // create a test file with some data
        ArrayList<Process> list = lp.GetList();
        assertNotNull(list);
        assertEquals(2, list.size()); // assuming 2 processes in the file

        Process p1 = list.get(0);
        assertEquals("Process1", p1.getName());
        assertEquals(10, p1.getInputTime());
        assertEquals(20, p1.getRunningTime());

        Process p2 = list.get(1);
        assertEquals("Process2", p2.getName());
        assertEquals(30, p2.getInputTime());
        assertEquals(40, p2.getRunningTime());
    }

}