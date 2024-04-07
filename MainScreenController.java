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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.util.Duration;

import javafx.event.EventHandler;

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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Animation.fxml"));
        Parent root = loader.load();
        AnimationController animationController = loader.getController();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        
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

}
