package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;

public class Controller {
    @FXML private TextField textfield1;
    @FXML private TextField textfield2;
    @FXML private TextArea actiontarget;

    @FXML
    private void handleButtonAction(javafx.event.ActionEvent actionEvent) {
        String first=textfield1.getText();
        String second=textfield2.getText();

        int[][] dist=DamerauLevenshtein_distance.calculate(first,second);
        String distance= Integer.toString(dist[first.length()][second.length()]);

        actiontarget.setText("The distance is "+ distance+
                "\n\n The distance matrix is \n"+DistanceMatrixToString( first, second));
    }

    private String DistanceMatrixToString(String first, String second){
        int [][] dist=DamerauLevenshtein_distance.calculate(first,second);
        String result="";
        for (int j=0; j<= second.length(); j++){
            for (int i=0; i<= first.length(); i++){
                result+=" "+Integer.toString(dist[i][j]);
                if (i==first.length()){
                    result+="\n";
                }
            }
        }
        return result;
    }
}
