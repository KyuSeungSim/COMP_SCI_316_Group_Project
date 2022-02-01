/*
 * Project: Class Assignment Week 13
 * Group: 11
 * Name: Nicholas Daniels, KyuSeung Sim
 * Class: COMP SCI 316-0800
 * Date: DEC 01 2020
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ThrityOneGUI extends Application {
   @Override
   public void start(Stage stage) throws Exception {
      Parent root = 
         FXMLLoader.load(getClass().getResource("ThrityOne.fxml"));
      
      Scene scene = new Scene(root);
      stage.setTitle("ThrityOne");
      stage.setScene(scene);
      stage.show();
   }

   public static void main(String[] args) {
      launch(args);
   }
}
