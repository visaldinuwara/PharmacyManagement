package Controller;

import Service.LoginPageService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class LoginPageController {

    private LoginPageService loginPageService;
    @FXML
    private Button loginButton;

    @FXML
    private Label messageLabel;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    void handleLoginButtonAction(ActionEvent event) throws SQLException, IOException {
        //if(loginPageService.loginCheck(usernameField.getText()).equals(passwordField.getText())){
            Parent root= FXMLLoader.load(getClass().getResource("/View/Dashboard.fxml"));
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        //}
    }

}
