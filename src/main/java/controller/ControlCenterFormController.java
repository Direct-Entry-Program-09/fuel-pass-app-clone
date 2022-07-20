package controller;

import javafx.application.Platform;
import javafx.scene.layout.AnchorPane;

public class ControlCenterFormController {
    public AnchorPane pneController;

    public void initialize(){
        Platform.runLater(pneController::requestFocus);
    }

}
