package Controller;

import Model.DTO.SupplierDetailsDTO;
import Model.Entity.SupplierDetails;
import Service.SupplierService;
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

public class SupplierController {
    //AddSupplier
    public TextField fieldId;
    public TextField fieldLegalName;
    public TextField fieldTradeName;
    public TextField fieldPrimaryContact;
    public TextField fieldEmergencyContact;
    public TextField fieldPhysicalAddress;
    public Button btnCancel;
    public Button btnAdd;
    public Button btnAddMain;
    public Button btnUpdateMain;
    public Button btnDeleteMain;
    public Button btnSearchMain;
    public Button btnView;
    public Button btnHelp;
    public Button btnSettings;
    public Button btnHomePage;
    //DeleteSupplier
    public Button btnDelete;
    public Button btnViewMain;
    public Button btnSearch;
    //Suppliers
    public Button btnProducts;
    public Button btnOverview;
    public Button btnOrders;
    public Button btnPayments;
    public Button btnCustomers;
    public Button btnLogOut;
    public Button btnUserDetails;
    public TextField txtSearch;
    public Button btnManageSuppliers;
    public TextArea txtSearchDetails;
    public TableView tblSuppliers;
    //UpdateSupplier
    public Button btnUpdate;
    private Stage stage;
    private SupplierService supplierService;
    public SupplierController(){
        stage=new Stage();
        supplierService=new SupplierService();
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

    public void ClickManageSuppliers(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/AddSupplier.fxml"))));
        stage.show();
        
    }

    public void ClickSupplierOrders(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/SupplierOrders.fxml"))));
        stage.show();
    }

    public void ClickHelp(ActionEvent actionEvent) {
    }

    public void ClickSettings(ActionEvent actionEvent) {
    }

    public void ClickLogout(ActionEvent actionEvent) {
    }

    public void ClickCancel(ActionEvent actionEvent) {
        fieldLegalName.setText("");
        fieldTradeName.setText("");
        fieldPrimaryContact.setText("");
        fieldEmergencyContact.setText("");
        fieldPhysicalAddress.setText("");
        
    }

    public void ClickAdd(ActionEvent actionEvent) throws SQLException {
        supplierService.addSupplier(new SupplierDetailsDTO(fieldLegalName.getText(),fieldTradeName.getText(),fieldPrimaryContact.getText(),fieldEmergencyContact.getText(),fieldPhysicalAddress.getText()));
    }

    public void ClickUpdateMain(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/UpdateSupplier.fxml"))));
        stage.show();
    }

    public void ClickDeleteMain(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/DeleteSupplier.fxml"))));
        stage.show();
    }

    public void ClickSearchMain(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/SearchSupplier.fxml"))));
        stage.show();
    }

    public void ClickViewMain(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Suppliers.fxml"))));
        stage.show();
    }

    public void ClickHomePage(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Dashboard.fxml"))));
        stage.show();
    }

    public void ClickDelete(ActionEvent actionEvent) throws SQLException {
        supplierService.deleteSupplier(fieldId.getText());
    }

    public void ClickAddMain(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/AddSupplier.fxml"))));
        stage.show();
    }

    public void ClickSearch(ActionEvent actionEvent) throws SQLException {
        SupplierDetails supplierDetails=supplierService.searchSupplier(fieldId.getText());
        fieldLegalName.setText(supplierDetails.getLegalName());
        fieldTradeName.setText(supplierDetails.getTradeName());
        fieldPrimaryContact.setText(supplierDetails.getPrimaryContact());
        fieldEmergencyContact.setText(supplierDetails.getEmergencyContact());
        fieldPhysicalAddress.setText(supplierDetails.getPhysicalAddress());
    }

    public void ClickUpdate(ActionEvent actionEvent) throws SQLException {
        supplierService.updateSupplier(new SupplierDetails(fieldId.getText(),fieldLegalName.getText(),fieldTradeName.getText(),fieldPrimaryContact.getText(),fieldEmergencyContact.getText(),fieldPhysicalAddress.getText()));
    }
}
