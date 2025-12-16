package Controller;

import Model.DTO.CustomerDetailDTO;
import Model.Entity.CustomerDetails;
import Service.CustomerService;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {
    //AddCustomer
    public TextField fieldId;
    public TextField fieldFirstName;
    public TextField fieldLastName;
    public TextField fieldEmailAddress;
    public TextField fieldPhoneNo;
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
    //Customer
    public Button btnProducts;
    public Button btnOverview;
    public Button btnOrders;
    public Button btnPayments;
    public Button btnCustomers;
    public Button btnLogOut;
    public Button btnUserDetails;
    public TextField txtSearch;
    public Button btnManage;
    public TextArea txtSearchList;
    public TableView tblCustomer;
    //DeleteCustomer
    public Button btnDelete;
    //SearchCustomer
    public TextField fieldEmailAdress;
    //UpdateCustomer
    public Button btnUpdate;
    public Button btnSupplier;
    public TableColumn ColCusId;
    public TableColumn ColFirstName;
    public TableColumn ColLastName;
    public TableColumn ColEmailAddress;
    public TableColumn ColPhoneNumber;
    private Stage stage;
    private CustomerService customerService;
    public CustomerController(){
        stage=new Stage();
        customerService=new CustomerService();
    }
    public void ClickProducts(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Products.fxml"))));
        stage.show();
    }

    public void ClickOverview(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Dashboard.fxml"))));
        stage.show();
    }

    public void ClickPayments(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Payments.fxml"))));
        stage.show();
    }

    public void ClickCustomerOrders(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/CustomerOrders.fxml"))));
        stage.show();
    }

    public void ClickHelp(ActionEvent actionEvent) {
       // stage.setScene(new Scene(FXMLLoader.load(getClass().getResource())));
    }

    public void ClickSettings(ActionEvent actionEvent) {
    }

    public void ClickLogout(ActionEvent actionEvent) {
    }

    public void ClickManageCustomers(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/AddCustomer.fxml"))));
        stage.show();
    }

    public void ClickSupplier(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Suppliers.fxml"))));
        stage.show();
    }

    public void ClickSupplierOrders(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/SupplierOrders.fxml"))));
        stage.show();
    }

    public void ClickCancel(ActionEvent actionEvent) {
        fieldFirstName.setText("");
        fieldLastName.setText("");
        fieldEmailAddress.setText("");
        fieldPhoneNo.setText("");
    }

    public void ClickAdd(ActionEvent actionEvent) throws SQLException {
        customerService.addCustomer(new CustomerDetailDTO(fieldFirstName.getText(),fieldLastName.getText(),fieldEmailAddress.getText(),fieldPhoneNo.getText()));
    }

    public void ClickUpdateMain(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/UpdateCustomer.fxml"))));
        stage.show();
    }

    public void ClickDeleteMain(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/DeleteCustomer.fxml"))));
        stage.show();
    }

    public void ClickSearchMain(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/SearchCustomer.fxml"))));
        stage.show();
    }

    public void ClickViewMain(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Dashboard.fxml"))));
        stage.show();
    }

    public void ClickHomePage(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Dashboard.fxml"))));
        stage.show();
    }

    public void ClickAddMain(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/AddCustomer.fxml"))));
        stage.show();
    }

    public void ClickDelete(ActionEvent actionEvent) throws SQLException {
        customerService.deleteCustomer(fieldId.getText());
    }

    public void ClickSearch(ActionEvent actionEvent) throws SQLException {
        CustomerDetails customerDetails=customerService.searchCustomer(fieldId.getText());
        fieldFirstName.setText(customerDetails.getFirstName());
        fieldLastName.setText(customerDetails.getLastName());
        fieldEmailAddress.setText(customerDetails.getEmailAddress());
        fieldPhoneNo.setText(customerDetails.getPhoneNo());

    }

    public void ClickUpdate(ActionEvent actionEvent) throws SQLException {
        customerService.updateCustomer(new CustomerDetails(fieldId.getText(),fieldFirstName.getText(),fieldLastName.getText(),fieldEmailAddress.getText(),fieldPhoneNo.getText()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            ColCusId.setCellValueFactory(new PropertyValueFactory<>("id"));
            ColFirstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
            ColLastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
            ColEmailAddress.setCellValueFactory(new PropertyValueFactory<>("EmailAddress"));
            ColPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("PhoneNo"));
            setItems();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void setItems() throws SQLException {
        tblCustomer.setItems(customerService.getAllCustomer());
    }
}
