package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import javax.print.attribute.standard.Media;
import javax.print.attribute.standard.MediaName;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class AdminLoginFormController {
    private static int attempts=3;
    public PasswordField txtPassWord;
    private static final String ADMIN_PASSWORD="abc23";
    public AnchorPane pneAdminLoginForm;

    public void txtPassWordOnAction(ActionEvent actionEvent) throws IOException {
        if (!txtPassWord.getText().equals(ADMIN_PASSWORD)){

            if (attempts==0){

                Platform.exit();
                return;
            }
            new Alert(Alert.AlertType.ERROR,"Invalid Admin Password ! You have "+attempts+" left");
            attempts--;
//
//            URL resource = this.getClass().getResource("/audio/Fnaf Secuirty Breach Song Sound Effect.mp3");
//            Media media = new Media(resource.toString());
//            MediaPlayer mediaPlayer=new MediaPlayer(media);
            // mediaPlayer.play();




            Alert alert= new Alert(Alert.AlertType.ERROR,"Invalid Password. Access Denied !");
            InputStream resourceAsaStream=this.getClass().getResourceAsStream("/images/wrong-password.png");
            Image image = new Image(resourceAsaStream);
            ImageView imageView=new ImageView(image);
            imageView.setFitWidth(48);
            imageView.setFitHeight(48);
            alert.setGraphic(imageView);
            alert.setHeaderText("Invalid Login Credential");
            alert.setTitle("Access Denied");
            alert.showAndWait();
            txtPassWord.requestFocus();
            return;
        }
        URL resource = this.getClass().getResource("/view/ControlCenterForm.fxml");
        AnchorPane controlCenter= FXMLLoader.load(resource);
        Parent pneContainer=(AnchorPane) pneAdminLoginForm.getParent();
        pneContainer.getChildrenUnmodifiable().add(controlCenter);
        AnchorPane.setLeftAnchor(pneContainer, 0.0);
        AnchorPane.setRightAnchor(pneContainer,0.0);
        AnchorPane.setBottomAnchor(pneContainer,0.0);
        AnchorPane.setTopAnchor(pneContainer,0.0);
    }
}
