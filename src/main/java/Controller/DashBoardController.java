package Controller;

import Service.DashBoardService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DashBoardController implements Initializable {
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
    public Rectangle month01g;
    public Rectangle month02g;
    public Rectangle month03g;
    public Rectangle month04g;
    public Rectangle month05g;
    public Rectangle month06g;
    public Rectangle month07g;
    public Rectangle month08g;
    public Rectangle month09g;
    public Rectangle month10g;
    public Rectangle month11g;
    public Rectangle month12g;
    private Stage stage;
    private DashBoardService dashBoardService;

    public DashBoardController() {
        stage = new Stage();
        dashBoardService = new DashBoardService();
    }

    public void navigateProducts(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Products.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void navigateOrders(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/OrderDash.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void navigatePayments(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Payments.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void navigateCustomers(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Customer.fxml"));
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            getAmount();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void getAmount() throws SQLException {
        double[] valueArray = dashBoardService.getOrders();
        Rectangle[] recArray = {month01g, month02g, month03g, month04g, month05g, month06g, month07g, month08g, month09g, month10g, month11g, month12g};
        int count = 0;
        if (valueArray != null) {
            for (Rectangle value : recArray) {
                recArray[count].setHeight(valueArray[count]);
                count++;
            }
        } else {
            for (Rectangle value : recArray) {
                recArray[count].setHeight(0);
                count++;
            }
        }
    }
}