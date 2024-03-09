import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;

import javafx.scene.text.Font;

import java.lang.Thread;

public class UserInterfaceMain extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        Pane root = new Pane();
        
        
        
        Scene scene = new Scene(root, 600, 600);
        stage.setScene(scene);
        stage.setTitle("Scheduler Simulator");
        stage.show();
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
}