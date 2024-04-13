import java.util.*;
import java.io.*;

public class ListProcessor {
    ArrayList<Process> list = new ArrayList<Process>();


    public ListProcessor() {
    }

    public ArrayList<Process> GetList() {

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
                
            // runs while loop on all lines in the file
            while(input.hasNext()){
                // takes the first line
                line = input.nextLine();
                info = new Scanner(line);
                // parses the line with spaces as delimiters
                inputTime = Integer.parseInt(info.next());
                runningTime = Integer.parseInt(info.next());
                algorithmType = info.next();
                
                // creates a process with inputtime, runningtime, and algorithmtype as parameters
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
