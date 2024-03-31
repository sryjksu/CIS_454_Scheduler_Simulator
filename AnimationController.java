package CIS_454_Scheduler_Simulator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import java.io.IOException;


import java.net.URL;
import java.util.ResourceBundle;

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
        TranslateTransition translateC1 = new TranslateTransition();
        translateC1.setNode(circle1);
        translateC1.setDuration(Duration.millis(500));
//         translateC1.setCycleCount(TranslateTransition.INDEFINITE);
        translateC1.setFromX(circle1.getCenterX());
        translateC1.setFromY(circle1.getCenterY());
        System.out.println(circle1.getCenterX());
        translateC1.setToX(100);
        translateC1.setToY(100);
        translateC1.play();
    }

}
