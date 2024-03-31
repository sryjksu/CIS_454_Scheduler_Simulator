package CIS_454_Scheduler_Simulator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class MainScreenController
{

    @FXML
    private Label addMessage;

    @FXML
    private Button buttonAddProcess;

    @FXML
    private Button buttonRunSimulation;

    @FXML
    private TextField processName;

    @FXML
    private TextField processRunTime;

    @FXML
    private TextField processStartTime;

    @FXML
    void addProcess(ActionEvent event)
    {
        addMessage.setText("Process Added!");
        try
        {
            String processName1 = processName.getText();
            int processRunTime1 = Integer.parseInt(processRunTime.getText());
            int processStartTime1 = Integer.parseInt(processStartTime.getText());
            addMessage.setText("Process Added!");
        }
        catch (NumberFormatException e)
        {
            addMessage.setText("Please enter a number for Process Run Time and Process Start Time.");
        }
    }

    @FXML
    void runSimulation(ActionEvent event) throws Exception 
    {
        Parent root = FXMLLoader.load(getClass().getResource("Animation.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
