package Controller;

import Model.DTO.CustomerOrderDetailsDTO;
import Model.Entity.CustomerDetails;
import Model.Entity.CustomerOrderDetails;
import Service.CustomerOrderService;
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

public class CustomerOrderController implements Initializable {
    //AddCustomerOrder
    public TextField fieldCusId;
    public TextField fieldDate;
    public TextField fieldAmount;
    public TextField fieldAddress;
    //CustomerOrders
    public Button btnProducts;
    public Button btnOverview;
    public Button btnOrders;
    public Button btnPayments;
    public Button btnCustomers;
    public Button btnHelp;
    public Button btnSettings;
    public Button btnLogOut;
    public Button btnUserDetails;
    public TextField txtSearch;
    public Button btnManageOrders;
    public TextArea txtSearchList;
    public TableView tblCustomerOrders;
    //DeleteCustomerOrder
    public TextField fieldId;
    public Button btnCancel;
    public Button btnDelete;
    public Button btnAddMain;
    public Button btnUpdateMain;
    public Button btnDeleteMain;
    public Button btnSearchMain;
    public Button btnViewMain;
    public Button btnHomePage;
    public Button btnSearch;
    //UpdateCustomerOrder
    public Button btnUpdate;
    public TableColumn ColProductId;
    public TableColumn ColProductName;
    public TableColumn ColProductBrand;
    public TableColumn ColProductExpire;
    public TableColumn ColProductQuantity;
    public TableColumn ColProductPrice;
    private Stage stage;
    private CustomerOrderService customerOrderService;
    public CustomerOrderController(){
        stage=new Stage();
        customerOrderService=new CustomerOrderService();
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

    public void ClickCustomer(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Customer.fxml"))));
        stage.show();
    }

    public void ClickHelp(ActionEvent actionEvent) {
        //stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/"))));
    }

    public void ClickSettings(ActionEvent actionEvent) {
    }

    public void ClickLogout(ActionEvent actionEvent) {
    }

    public void ClickManageOrders(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/OrderDash.fxml"))));
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
        fieldCusId.setText("");
        fieldDate.setText("");
        fieldAmount.setText("");
        fieldAddress.setText("");
    }

    public void ClickAdd(ActionEvent actionEvent) throws SQLException {
        customerOrderService.addCustomerOrder(new CustomerOrderDetailsDTO(fieldCusId.getText(),fieldDate.getText(),Integer.valueOf(fieldAmount.getText()),fieldAddress.getText()));
    }

    public void ClickUpdateMain(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/UpdateCustomerOrder.fxml"))));
        stage.show();
    }

    public void ClickDeleteMain(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/DeleteCustomerOrder.fxml"))));
        stage.show();
    }

    public void ClickSearchMain(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/SearchCustomerOrder.fxml"))));
        stage.show();
    }

    public void ClickViewMain(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/CustomerOrders.fxml.fxml"))));
        stage.show();
    }

    public void ClickHomePage(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Dashboard.fxml"))));
        stage.show();
    }

    public void ClickDelete(ActionEvent actionEvent) throws SQLException {
        customerOrderService.deleteCustomer(fieldId.getText());
    }

    public void ClickAddMain(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/AddCustomerOrder.fxml"))));
        stage.show();
    }

    public void ClickSearch(ActionEvent actionEvent) throws SQLException {
        CustomerOrderDetails customerOrderDetails=customerOrderService.searchCustomerOrder(fieldId.getText());
        fieldCusId.setText(customerOrderDetails.getCustomerId());
        fieldDate.setText(customerOrderDetails.getOrderDate());
        fieldAmount.setText(String.valueOf(customerOrderDetails.getTotalAmount()));
        fieldAddress.setText(String.valueOf(customerOrderDetails.getTotalAmount()));
    }

    public void ClickUpdate(ActionEvent actionEvent) throws SQLException {
        customerOrderService.deleteCustomerOrder(new CustomerOrderDetails(fieldId.getText(),fieldCusId.getText(),fieldDate.getText(),Double.parseDouble(fieldAmount.getText()),fieldAddress.getText()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            ColProductId.setCellValueFactory(new PropertyValueFactory<>("OrderId"));
            ColProductName.setCellValueFactory(new PropertyValueFactory<>("CustomerId"));
            ColProductBrand.setCellValueFactory(new PropertyValueFactory<>("OrderDate"));
            ColProductExpire.setCellValueFactory(new PropertyValueFactory<>("TotalAmount"));
            ColProductPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
            setItems();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void setItems() throws SQLException {
        tblCustomerOrders.setItems(customerOrderService.getAll());
    }
}
