package Controller;

import Model.DTO.PaymentetailsDTO;
import Model.Entity.CustomerDetails;
import Model.Entity.PaymentDetails;
import Service.PaymentService;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class PaymentController {
    //AddPayment
    public TextField fieldId;
    public TextField fieldOrderDetailId;
    public TextField fieldPaymentMethod;
    public TextField fieldAmountPayed;
    public TextField fieldCardType;
    public Button btnCancel;
    public Button btnAdd;
    public Button btnAddMain;
    public Button btnUpdateMain;
    public Button btnDeleteMain;
    public Button btnSearchMain;
    public Button btnViewMain;
    public Button btnHelp;
    public Button btnSettings;
    public Button btnHomePage;
    public Button btnSearch;
    //DeletePayment
    public TextField fieldCustomerId;
    public Button btnDelete;
    //Payments
    public Button btnProducts;
    public Button btnOverview;
    public Button btnOrders;
    public Button btnPayments;
    public Button btnCustomers;
    public Button btnLogOut;
    public Button btnUserDetails;
    public TextField txtSearch;
    public Button btnManagePayments;
    public TextArea txtSearchDetails;
    public TableView tblPayments;
    //UpdatePayment
    public Button btnUpdate;
    private Stage stage;
    private PaymentService paymentService;
    public PaymentController(){
        stage=new Stage();
        paymentService=new PaymentService();
    }
    public void ClickSupplier(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Suppliers.fxml"))));
        stage.show();
    }

    public void ClickSupplierOrders(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/SupplierOrders.fxml"))));
        stage.show();
    }

    public void ClickProducts(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Products.fxml"))));
        stage.show();
    }

    public void ClickOverview(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Dashboard.fxml"))));
        stage.show();
    }

    public void ClickCustomer(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Customer.fxml"))));
        stage.show();
    }

    public void ClickCustomerOrders(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/CustomerOrders.fxml"))));
        stage.show();
    }

    public void ClickHelp(ActionEvent actionEvent) {
    }

    public void ClickSettings(ActionEvent actionEvent) {
    }

    public void ClickLogout(ActionEvent actionEvent) {
    }

    public void ClickManagePayments(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/AddPayment.fxml"))));
        stage.show();
    }

    public void ClickCancel(ActionEvent actionEvent) {
        fieldOrderDetailId.setText("");
        fieldPaymentMethod.setText("");
        fieldAmountPayed.setText("");
        fieldCardType.setText("");
    }

    public void ClickAdd(ActionEvent actionEvent) throws SQLException {
        paymentService.addPayment(new PaymentetailsDTO(fieldOrderDetailId.getText(),fieldPaymentMethod.getText(),Integer.parseInt(fieldAmountPayed.getText()),fieldCardType.getText()));
    }

    public void ClickAddMain(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/AddPayment.fxml"))));
        stage.show();
    }

    public void ClickUpdateMain(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/UpdatePayment.fxml"))));
        stage.show();
    }

    public void ClickDeleteMain(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/DeletePayment.fxml"))));
        stage.show();
    }

    public void ClickSearchMain(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/SearchPayments.fxml"))));
        stage.show();
    }

    public void ClickViewMain(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Payments.fxml.fxml"))));
        stage.show();
    }

    public void ClickHomePage(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Dashboard.fxml"))));
        stage.show();
    }

    public void ClickDelete(ActionEvent actionEvent) throws SQLException {
        paymentService.deletePayment(fieldId.getText());
    }

    public void ClickSearch(ActionEvent actionEvent) throws SQLException {
        PaymentDetails paymentDetails=paymentService.searchPayment(fieldId.getText());
        fieldOrderDetailId.setText(paymentDetails.getOrderDetailId());
        fieldPaymentMethod.setText(paymentDetails.getPaymentMethod());
        fieldAmountPayed.setText(String.valueOf(paymentDetails.getAmountPayed()));
        fieldCardType.setText(paymentDetails.getCardType());
    }

    public void ClickUpdate(ActionEvent actionEvent) throws SQLException {
        paymentService.updatePayment(new PaymentDetails(fieldId.getText(),fieldOrderDetailId.getText(),fieldPaymentMethod.getText(),Integer.parseInt(fieldAmountPayed.getText()),fieldCardType.getText()));
    }
}
