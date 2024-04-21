package CIS_454_Scheduler_Simulator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import java.io.IOException;

import java.net.URL;
import java.util.*;

import java.util.Random;

public class AnimationController implements Initializable
{

    @FXML
    private Button buttonBack;

    @FXML
    private Circle circle1;

    @FXML
    private Circle circle2;

    @FXML
    private Circle circle3;

    @FXML
    private Circle circle4;

    @FXML
    private Circle circle5;
    
    @FXML
    private Label endMessage;
    
    @FXML
    private Label timeLabel;

    @FXML
    void back(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1)
    {
        circles[0] = circle1;
        circles[1] = circle2;
        circles[2] = circle3;
        circles[3] = circle4;
        circles[4] = circle5;
    }
    
    Random random = new Random();
    
    // generate animation for "circle" to go to "state"
    public void anAnimation(Circle circle, Schedule.State state)
    {
        double x = 0, y = 0;
        switch (state)
        {
            case READY:
                x = 220 + random.nextInt(130) - 65;
                y = 373 + random.nextInt(130) - 65;
                break;
            case RUNNING:
                x = 480 + random.nextInt(130) - 65;
                y = 144 + random.nextInt(130) - 65;
                break;
            case BLOCKED:
                x = 740 + random.nextInt(130) - 65;
                y = 373 + random.nextInt(130) - 65;
                break;
            case FINISHED:
                finishCircle(circle);
                return;
        }
        
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(circle);
        translate.setDuration(Duration.millis(400));
        translate.setToX(x);
        translate.setToY(y);
        translate.play();
        translate.play();
    }
    
    int currentTime = -1;
    String processName;
    int timeOfMove;
    Schedule.State moveToState;
    boolean finish = false;
    
    // handle all actions within one ms
    Schedule schedule = MainScreenController.schedule;
    
    protected void nextMS()
    {
        if (finish)
        {
            return;
        }
        currentTime++;
        timeLabel.setText("Time: " + currentTime + "ms");
        while (true)
        {
            timeOfMove = schedule.getCurrentTime();
            if (timeOfMove == currentTime)
            {
                Circle circle;
                processName = schedule.getCurrentName();
                moveToState = schedule.getCurrentStatus();
                circle = nameToCircle(processName);
                anAnimation(circle, moveToState);
                if (schedule.getNextTime() == currentTime)
                {
                    schedule.moveToNext();
                    continue;
                }
                if (schedule.getNextTime() == -1)
                {
                    finishAnimation();
                    finish = true;
                    break;
                }
                else if (schedule.getNextTime() != currentTime)
                {
                    schedule.moveToNext();
                    break;
                }
            }
            else
            {
                break;
            }
        }
    }
    
    // show circle
    private void initializeCircle(Circle circle)
    {
        circle.setVisible(true);
    }
    
    // clear circle after process is finished
    private void finishCircle(Circle circle)
    {
        circle.setVisible(false);
        circle.setTranslateX(0);
        circle.setTranslateY(0);
    }
    
    // animation for end of all animation
    private void finishAnimation()
    {
        endMessage.setVisible(true);
    }
    
    // translate process name into circle
    Dictionary<String, Circle> circleName= new Hashtable<>();
    Circle[] circles = new Circle[5];
    int circleUsed = 0;
    
    private Circle nameToCircle(String name)
    {
        Circle circle;
        if ((circle = circleName.get(name)) == null)
        {
            circleName.put(name, circles[circleUsed]);
            circle = circleName.get(name);
            initializeCircle(circle);
            circleUsed++;
        }
        return circle;
    }
}
