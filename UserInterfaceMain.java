import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.scene.text.Font;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;

import java.lang.Thread;

public class UserInterfaceMain extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        Pane root = new Pane();
        
        //each block adds a element in the ui window
        Label labelWelcome = new Label("Welcome to Scheduler Simulator!");
        labelWelcome.setFont(new Font("Times New Roman", 20));
        labelWelcome.relocate(400, 10);
        root.getChildren().add(labelWelcome);
        
        Label labelReadMe = new Label("Please read readme for instructions.");
        labelReadMe.setFont(new Font("Times New Roman", 20));
        labelReadMe.relocate(400, 40);
        root.getChildren().add(labelReadMe);
        
        Button buttonRun = new Button("Run Simulation");
        buttonRun.setFont(new Font("Times New Roman", 12));
        buttonRun.relocate(450, 550);
        root.getChildren().add(buttonRun);
        
        TextField processName = new TextField();
        processName.relocate(50, 200);
        processName.setText("Process Name");
        root.getChildren().add(processName);
        
        TextField processStartTime = new TextField();
        processStartTime.relocate(250, 200);
        processStartTime.setText("Process Start Time");
        root.getChildren().add(processStartTime);
        
        TextField processRunTime = new TextField();
        processRunTime.relocate(450, 200);
        processRunTime.setText("Process Run Time");
        root.getChildren().add(processRunTime);
        
        Button buttonAdd = new Button("Add");
        buttonAdd.setFont(new Font("Times New Roman", 12));
        buttonAdd.relocate(650, 200);
        root.getChildren().add(buttonAdd);
        
        Scene scene = new Scene(root, 1000, 600);
        stage.setScene(scene);
        stage.setTitle("Scheduler Simulator");
        stage.show();
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
}