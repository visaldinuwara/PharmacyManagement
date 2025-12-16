package Controller;

import Model.DTO.ProductDetailsDTO;
import Model.Entity.ProductDetails;
import Service.ProductService;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ProductController implements Initializable {
    //AddProduct
    public TextField fieldId;
    public TextField fieldName;
    public TextField fieldBrand;
    public TextField fieldExpire;
    public TextField fieldQuantity;
    public TextField fieldPrice;
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
    //DeleteProduct
    public Button btnDelete;
    public Button btnViewMain;
    public Button btnSearch;
    //Products
    public Button btnProducts;
    public Button btnOverview;
    public Button btnOrders;
    public Button btnPayments;
    public Button btnCustomers;
    public Button btnLogOut;
    public Button btnUserDetails;
    public Button btnManageProducts;
    public TextArea txtSearchDetails;
    public TableView tblProducts;
    public Button btnCustomerOrders;
    public Button btnCustomer;
    //UpdateProduct
    public Button btnUpdate;
    public TableColumn ColProductId;
    public TableColumn ColProductName;
    public TableColumn ColProductBrand;
    public TableColumn ColProductExpire;
    public TableColumn ColProductQuantity;
    public TableColumn ColProductPrice;
    private Stage stage;
    private ProductService productService;
    public ProductController(){
        stage = new Stage();
        productService=new ProductService();
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
        //stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/"))));
    }

    public void ClickSettings(ActionEvent actionEvent) {
    }

    public void ClickLogout(ActionEvent actionEvent) {
    }

    public void btnManageProducts(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/AddProduct.fxml"))));
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
        fieldName.setText("");
        fieldBrand.setText("");
        fieldExpire.setText("");
        fieldQuantity.setText("");
        fieldPrice.setText("");
    }

    public void ClickAdd(ActionEvent actionEvent) throws SQLException {
        productService.addProduct(new ProductDetailsDTO(fieldName.getText(),fieldBrand.getText(),fieldExpire.getText(),Integer.parseInt(fieldQuantity.getText()),Double.parseDouble(fieldPrice.getText())));
    }

    public void ClickUpdateMain(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/UpdateProduct.fxml"))));
        stage.show();
    }

    public void ClickDeleteMain(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/DeleteProduct.fxml"))));
        stage.show();
    }

    public void ClickSearchMain(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/SearchPayments.fxml"))));
        stage.show();
    }

    public void ClickViewMain(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Products.fxml"))));
        stage.show();
    }

    public void ClickHomePage(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Dashboard.fxml"))));
        stage.show();
    }

    public void ClickDelete(ActionEvent actionEvent) throws SQLException {
        productService.deleteProduct(fieldId.getText());
    }

    public void ClickAddMain(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/AddProduct.fxml"))));
        stage.show();
    }

    public void ClickSearch(ActionEvent actionEvent) throws SQLException {
        ProductDetails productDetails=productService.searchProduct(fieldId.getText());
        fieldName.setText(productDetails.getName());
        fieldBrand.setText(productDetails.getBrand());
        fieldExpire.setText(productDetails.getExpiry());
        fieldQuantity.setText(String.valueOf(productDetails.getQuantity()));
        fieldPrice.setText(String.valueOf(productDetails.getPrice()));
    }

    public void ClickUpdate(ActionEvent actionEvent) throws SQLException {
        productService.updateProduct(new ProductDetails(fieldId.getText(),fieldName.getText(),fieldBrand.getText(),fieldExpire.getText(),Integer.parseInt(fieldQuantity.getText()),Double.parseDouble(fieldPrice.getText())));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            ColProductId.setCellValueFactory(new PropertyValueFactory<>("id"));
            ColProductName.setCellValueFactory(new PropertyValueFactory<>("Name"));
            ColProductBrand.setCellValueFactory(new PropertyValueFactory<>("Brand"));
            ColProductExpire.setCellValueFactory(new PropertyValueFactory<>("Expiry"));
            ColProductQuantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
            ColProductPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
            setItems();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void setItems() throws SQLException {
        tblProducts.setItems(productService.getAll());
    }
}
