import java.util.*;
import java.io.*;

public class ListProcessor {
    private ArrayList<Process> list;
    private String fileName;
    
    public ListProcessor() {
        list = new ArrayList<Process>();
    }

    public ArrayList<Process> GetList() {

        return list;
    }

    public void createList(String file) {
        try {
            fileName = file;
            FileInputStream fstream = new FileInputStream(file);
            Scanner input = new Scanner(fstream);
            String line;
            Scanner info;
            Process process;
            int inputTime, runningTime;
            String processName;
                
            // runs while loop on all lines in the file
            while(input.hasNext()){
                // takes the first line
                line = input.nextLine();
                info = new Scanner(line);
                // parses the line with spaces as delimiters
                processName = info.next();
                inputTime = Integer.parseInt(info.next());
                runningTime = Integer.parseInt(info.next());
                
                // creates a process with name, inputTime, runningTime as parameters
                process = new Process(processName, inputTime, runningTime);
                list.add(process);
            }
            input.close();
        }

        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }

    public static void main(String[] args) {
        ListProcessor listProcessor = new ListProcessor();
        listProcessor.createList("Process List.txt");
        ArrayList<Process> list = listProcessor.GetList();
        System.out.println("List of processes:");
        for (Process process : list) {
            System.out.println(process.getName() + " " + process.getInputTime() + " " + process.getRunningTime());
        }
    }
}
