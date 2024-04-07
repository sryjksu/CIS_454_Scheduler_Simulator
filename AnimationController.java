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
import java.util.ResourceBundle;

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
        initializecircle(circle1, 500, 150);
    }
    
    enum State {READY, RUNNING, BLOCKED};
    Random random = new Random();
    
    public void anAnimation(Circle circle, State state)
    {
        double x = 0, y = 0;
        switch(state)
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
        }
        
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(circle);
        translate.setDuration(Duration.millis(400));
        translate.setToX(x);
        translate.setToY(y);
        translate.play();
        translate.play();
    }
    
    int currentTime = 0;
    
    public void nextMS()
    {
        currentTime++;
        timeLabel.setText("Time: " + currentTime + "ms");
        // do animation according to schedule
        anAnimation(circle1, State.READY);
    }
    
    public void initializecircle(Circle circle, double x, double y)
    {
        circle.setVisible(true);
        anAnimation(circle, State.BLOCKED);
    }
}
