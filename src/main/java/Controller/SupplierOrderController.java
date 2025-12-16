package Controller;

import Model.DTO.SupplierDetailsDTO;
import Model.DTO.SupplierOrderDetailsDTO;
import Model.Entity.SupplierDetails;
import Model.Entity.SupplierOrderDetails;
import Service.SupplierOrderService;
import Service.SupplierService;
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

public class SupplierOrderController implements Initializable {
    //AddSupplierOrder
    public TextField fieldId;
    public TextField fieldSupplierId;
    public TextField fieldDate;
    public TextField fieldExpectedDate;
    public TextField fieldTotalCost;
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
    //DeleteSupplierOrder
    public Button btnDelete;
    public Button btnSearch;
    //SupplierOrders
    public Button btnProducts;
    public Button btnOverview;
    public Button btnOrders;
    public Button btnPayments;
    public Button btnCustomers;
    public Button btnLogOut;
    public Button btnUserDetails;
    public TextField txtSearch;
    public Button btnManageOrders;
    public TextArea txtSearchDetails;
    public TableView tblSupplierOrders;
    //UpdateSupplierOrder
    public Button btnUpdate;
    public TableColumn ColOrderId;
    public TableColumn ColSupplierId;
    public TableColumn ColOrderDate;
    public TableColumn ColExpectedDate;
    public TableColumn ColTotalCost;
    private Stage stage;
    private SupplierOrderService supplierOrderService;
    public SupplierOrderController(){
        supplierOrderService=new SupplierOrderService();
        stage=new Stage();

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

    public void ClickManageOrders(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/AddSupplier.fxml"))));
        stage.show();
    }

    public void ClickSupplier(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Suppliers.fxml"))));
        stage.show();
    }

    public void ClickCancel(ActionEvent actionEvent) {
        fieldSupplierId.setText("");
        fieldDate.setText("");
        fieldExpectedDate.setText("");
        fieldTotalCost.setText("");
    }

    public void ClickAdd(ActionEvent actionEvent) throws SQLException {
        supplierOrderService.addSupplierOrder(new SupplierOrderDetailsDTO(fieldSupplierId.getText(),fieldDate.getText(),fieldExpectedDate.getText(),Double.parseDouble(fieldTotalCost.getText())));
    }

    public void ClickUpdateMain(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/UpdateSupplierOrder.fxml"))));
        stage.show();
    }

    public void ClickDeleteMain(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/DeleteSupplierOrder.fxml.fxml"))));
        stage.show();
    }

    public void ClickSearchMain(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/SearchSupplierOrder.fxml"))));
        stage.show();
    }

    public void ClickViewMain(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/SupplierOrders.fxml"))));
        stage.show();
    }

    public void ClickHomePage(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Dashboard.fxml"))));
        stage.show();
    }

    public void ClickAddMain(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/AddSupplierOrder.fxml"))));
        stage.show();

    }

    public void ClickSearch(ActionEvent actionEvent) throws SQLException {
        SupplierOrderDetails supplierOrderDetails=supplierOrderService.searchSupplierOrder(fieldId.getText());
        fieldSupplierId.setText(supplierOrderDetails.getSupplierId());
        fieldDate.setText(supplierOrderDetails.getOrderDate());
        fieldExpectedDate.setText(supplierOrderDetails.getExpectedDate());
        fieldTotalCost.setText(String.valueOf(supplierOrderDetails.getTotalCost()));
    }

    public void ClickUpdate(ActionEvent actionEvent) throws SQLException {
        supplierOrderService.updateSupplierOrder(new SupplierOrderDetails(fieldId.getText(),fieldSupplierId.getText(),fieldDate.getText(),fieldExpectedDate.getText(),Double.parseDouble(fieldTotalCost.getText())));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            ColOrderId.setCellValueFactory(new PropertyValueFactory<>("OrderId"));
            ColSupplierId.setCellValueFactory(new PropertyValueFactory<>("SupplierId"));
            ColOrderDate.setCellValueFactory(new PropertyValueFactory<>("OrderDate"));
            ColExpectedDate.setCellValueFactory(new PropertyValueFactory<>("ExpectedDate"));
            ColTotalCost.setCellValueFactory(new PropertyValueFactory<>("TotalCost"));
            setItems();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void setItems() throws SQLException {
        tblSupplierOrders.setItems(supplierOrderService.getAll());
    }
}
