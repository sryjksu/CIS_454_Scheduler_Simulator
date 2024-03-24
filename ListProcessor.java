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
            int inputTime, runningTime;
            String algorithmType;
                
            while(input.hasNext()){
                line = input.nextLine();
                info = new Scanner(line);
                inputTime = Integer.parseInt(info.next());
                runningTime = Integer.parseInt(info.next());
                algorithmType = info.next();
                
                process = new Process(inputTime, runningTime, algorithmType);
                list.add(process);
                input.close();
            }
        }

        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}