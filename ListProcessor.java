import java.util.*;
import java.io.*;

public class ListProcessor {
    List<Process>  list = new ArrayList<>();

    public ListProcessor() {
    }

    public List<Process> GetList() {

        return list;
    }

    public void createList(String file) {
        try {
            FileInputStream fstream = new FileInputStream(file);
            Scanner input = new Scanner(fstream);
            String line;
            Scanner info;
            Process process;
            int pid, arrival;
                
            while(input.hasNext()){
                line = input.nextLine();
                info = new Scanner(line);
                pid = Integer.parseInt(info.next());
                arrival = Integer.parseInt(info.next());
                
                process = new Process(pid, arrival);
                list.add(process);
                input.close();
            }
        }

        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}