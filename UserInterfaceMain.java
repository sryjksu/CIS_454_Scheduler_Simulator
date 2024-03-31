package CIS_454_Scheduler_Simulator;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;

import javafx.scene.text.Font;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;

import java.lang.Thread;
import java.io.IOException;

public class UserInterfaceMain extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        Scene scene = new Scene(root, 960, 540);
        stage.setScene(scene);
        stage.setTitle("Scheduler Simulator");
        stage.show();
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
}