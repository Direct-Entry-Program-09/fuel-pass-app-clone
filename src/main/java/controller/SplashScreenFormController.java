package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;

public class SplashScreenFormController {


    public Label lblLoading;

    public void initialize(){
        Timeline t1=new Timeline();
        var frame1=new KeyFrame(Duration.millis(2500), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lblLoading.setText("Connecting with the Database ....");
            }
        });
        var frame2=new KeyFrame(Duration.millis(4550), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lblLoading.setText("Loading data ....");
            }
        });
        var frame3=new KeyFrame(Duration.millis(2050), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lblLoading.setText("Setting up the UI ....");
            }
        });
        var frame4=new KeyFrame(Duration.millis(2750), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                URL resource = this.getClass().getResource("/view/HomeForm.fxml");
                Parent container= null;
                try {
                    container = FXMLLoader.load(resource);
                    Scene scene=new Scene(container);
                    Stage stage=new Stage();
                    stage.setScene(scene);
                    stage.setTitle("National Fuel Pass App");
                    stage.show();
                    stage.centerOnScreen();
                    lblLoading.getScene().getWindow().hide();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        t1.getKeyFrames().addAll(frame1,frame2,frame3,frame4);
        t1.playFromStart();



    }
}
