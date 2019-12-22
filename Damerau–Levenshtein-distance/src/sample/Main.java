package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //set title of stage
        primaryStage.setTitle("Calculate Damerau–Levenshtein distance");

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new URL("file:///C:/Users/martin/IdeaProjects/Damerau–Levenshtein-distance/src/sample/sample.fxml"));
        GridPane gridPane = loader.<GridPane>load();

        // create a scene
        Scene scene=new Scene(gridPane, 500, 500);
        //add a mouse cursor to the scene
        scene.setCursor(Cursor.HAND);

        //scene is added to stage
        primaryStage.setScene(scene);
        //stage (and content) is shown
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
