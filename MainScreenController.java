package CIS_454_Scheduler_Simulator;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.util.Duration;

import javafx.event.EventHandler;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable
{

    @FXML
    private Label addMessage;
    
    @FXML
    private ChoiceBox<String> algorithm;

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
    
    private ArrayList<String> processNameList = new ArrayList();
    private ArrayList<Integer> processRunTimeList = new ArrayList();
    private ArrayList<Integer> processStartTimeList = new ArrayList();
    
    // try to store user input in list, and display success or not
    @FXML
    void addProcess(ActionEvent event)
    {
        try
        {
            String processName1 = processName.getText();
            int processRunTime1 = Integer.parseInt(processRunTime.getText());
            int processStartTime1 = Integer.parseInt(processStartTime.getText());
            processNameList.add(processName1);
            processRunTimeList.add(processRunTime1);
            processStartTimeList.add(processStartTime1);
            addMessage.setText("Process Added!");
        }
        catch (NumberFormatException e)
        {
            addMessage.setText("Please enter a number for Process Run Time and Process Start Time.");
        }
        FadeTransition fade = new FadeTransition();
        fade.setNode(addMessage);
        fade.setDuration(Duration.millis(2000));
        fade.setInterpolator(Interpolator.EASE_IN);
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.play();
    }
    
    @FXML
    void runSimulation(ActionEvent event) throws Exception 
    {
        String algorithmChosen = algorithm.getValue();
        createProcessList();
        // call scheduler here
        
        // load animation scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Animation.fxml"));
        Parent root = loader.load();
        AnimationController animationController = loader.getController();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        
        // go to next ms when space is pressed
        scene.setOnKeyPressed(new EventHandler<KeyEvent>()
        {
            @Override
            public void handle(KeyEvent event)
            {
                switch(event.getCode())
                {
                    case SPACE:
                        animationController.nextMS();
                        break;
                }
            }
        });
        
        stage.setScene(scene);
        stage.show();
    }
    
    private String[] algorithms = {"FIFO", "SJF", "RR"};
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1)
    {
        algorithm.getItems().addAll(algorithms);
    }
    
    private void createProcessList()
    {
        return;
    }
}
