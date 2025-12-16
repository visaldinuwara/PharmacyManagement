package Repository;

import DBConnection.Singleton;
import Model.Entity.CustomerDetails;
import Model.Entity.CustomerOrderDetails;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/*    private String OrderId;
    private String CustomerId;
    private String OrderDate;
    private double TotalAmount;
    private String ShippingAdress;*/
public class CustomerOrderRepository {
    private Connection connection;
    public boolean addCustomerOrder(CustomerOrderDetails customerOrderDetails) throws SQLException {
        connection= Singleton.getSingleton().getConnection();
        PreparedStatement stm=connection.prepareStatement("INSERT INTO CustomerOrderDetails VALUES (?,?,?,?,?)");
        stm.setObject(1,customerOrderDetails.getOrderId());
        stm.setObject(2,customerOrderDetails.getCustomerId());
        stm.setObject(3,customerOrderDetails.getOrderDate());
        stm.setObject(4,customerOrderDetails.getTotalAmount());
        stm.setObject(5,customerOrderDetails.getShippingAddress());
        if(stm.executeUpdate()>0){
            return true;
        }else {
            return false;
        }    }
    public boolean updateCustomerOrder(CustomerOrderDetails customerOrderDetails) throws SQLException {
        connection = Singleton.getSingleton().getConnection();
        PreparedStatement stm = connection.prepareStatement("UPDATE CustomerOrderDetails SET CustomerId=? OrderDate=? TotalAmount=? ShippingAddress=? WHERE OrderId=?");
        stm.setObject(5, customerOrderDetails.getOrderId());
        stm.setObject(1, customerOrderDetails.getCustomerId());
        stm.setObject(2, customerOrderDetails.getOrderDate());
        stm.setObject(3, customerOrderDetails.getTotalAmount());
        stm.setObject(4, customerOrderDetails.getShippingAddress());
        if (stm.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean deleteCustomerOrder(String id) throws SQLException {
        connection = Singleton.getSingleton().getConnection();
        PreparedStatement stm = connection.prepareStatement("DELETE FROM CustomerOrderDetails WHERE OrderId=?");
        stm.setObject(1,id);
        if (stm.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }
    public CustomerOrderDetails searchCustomerOrder(String id) throws SQLException {
        connection=Singleton.getSingleton().getConnection();
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM CustomerOrderDetails WHERE OrderId=?");
        stm.setObject(1,id);
        ResultSet rst=stm.executeQuery();
        while (rst.next()){
            return new CustomerOrderDetails(rst.getString("OrderId"), rst.getString("CustomerId"),rst.getString("OrderDate"),rst.getDouble("TotalAmount"), rst.getString("ShippingAddress")) ;
        }
        return null;
    }
    public ObservableList<CustomerOrderDetails> getAllCustomerOrders() throws SQLException {
        ObservableList<CustomerOrderDetails>arrayOfAll= FXCollections.observableArrayList();
        connection=Singleton.getSingleton().getConnection();
        PreparedStatement stm=connection.prepareStatement("SELECT * FROM CustomerOrderDetails");
        ResultSet rst=stm.executeQuery();
        while(rst.next()){
            arrayOfAll.add(new CustomerOrderDetails(rst.getString("OrderId"),rst.getString("CustomerId"),rst.getString("OrderDate"),rst.getDouble("TotalAmount"),rst.getString("ShippingAddress")));
        }
        return arrayOfAll;
    }
}
