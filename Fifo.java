import java.util.ArrayList;
import java.util.List;

public class FIFOAlgorithm {

    private List<Integer> queue;
    private int capacity;

    public FIFOAlgorithm(int capacity) {
        this.capacity = capacity;
        this.queue = new ArrayList<>(capacity);
    }

    public void referencePage(int pageNumber) {
        if (!queue.contains(pageNumber)) {
            if (queue.size() == capacity) {
                queue.remove(0); 
            }
            queue.add(pageNumber); 
        }
    }

    public void displayPages() {
        System.out.println("Pages in memory: " + queue);
    }
}