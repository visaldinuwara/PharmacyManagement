package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBoardController {
    //Dashboard
    public Button btnProducts;
    public Button btnOverview;
    public Button btnOrders;
    public Button btnPayments;
    public Button btnCustomers;
    public Button btnHelp;
    public Button btnSettings;
    public Button btnLogOut;
    public Button btnAlarm;
    public Button btnUserDetails;
    private Stage stage;
    public DashBoardController(){
        stage=new Stage();
    }
    public void navigateProducts(ActionEvent actionEvent) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("/View/Products.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void navigateOrders(ActionEvent actionEvent) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("/View/OrderDash.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void navigatePayments(ActionEvent actionEvent) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("/View/Payments.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void navigateCustomers(ActionEvent actionEvent) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("/View/Customer.fxml"));
        stage.setScene(new Scene(root));
        stage.show();

    }

    public void navigateHelp(ActionEvent actionEvent) {
        //Parent root=FXMLLoader.load(getClass().getResource())
    }

    public void navigateSettings(ActionEvent actionEvent) {
    }

    public void navigateLogout(ActionEvent actionEvent) {
    }
}
