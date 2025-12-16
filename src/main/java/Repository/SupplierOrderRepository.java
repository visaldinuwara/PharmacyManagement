package Repository;

import DBConnection.Singleton;
import Model.Entity.ProductDetails;
import Model.Entity.SupplierOrderDetails;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/*private String OrderId;
private String SupplierId;
private String OrderDate;
private String ExpectedDate;
private double TotalCost;*/
public class SupplierOrderRepository {
    private Connection connection;
    public boolean addSupplierOrder(SupplierOrderDetails supplierOrderDetails) throws SQLException {
        connection= Singleton.getSingleton().getConnection();
        PreparedStatement stm=connection.prepareStatement("INSERT INTO SupplierOrderDetails VALUES (?,?,?,?,?)");
        stm.setObject(1,supplierOrderDetails.getOrderId());
        stm.setObject(2,supplierOrderDetails.getSupplierId());
        stm.setObject(3,supplierOrderDetails.getOrderDate());
        stm.setObject(4,supplierOrderDetails.getExpectedDate());
        stm.setObject(5,supplierOrderDetails.getTotalCost());
        if(stm.executeUpdate()>0){
            return true;
        }else {
            return false;
        }
    }
    public boolean updateSupplierOrder(SupplierOrderDetails supplierOrderDetails) throws SQLException {
        connection= Singleton.getSingleton().getConnection();
        PreparedStatement stm=connection.prepareStatement("UPDATE SupplierOrderDetails SET SupplierId=? OrderDate=? ExpectedDate=? TotalCost=? WHERE OrderId=?");
        stm.setObject(5,supplierOrderDetails.getOrderId());
        stm.setObject(1,supplierOrderDetails.getSupplierId());
        stm.setObject(2,supplierOrderDetails.getOrderDate());
        stm.setObject(3,supplierOrderDetails.getExpectedDate());
        stm.setObject(4,supplierOrderDetails.getTotalCost());
        if(stm.executeUpdate()>0){
            return true;
        }else {
            return false;
        }
    }
    public boolean deleteSupplierOrder(String id) throws SQLException {
        connection= Singleton.getSingleton().getConnection();
        PreparedStatement stm=connection.prepareStatement("DELETE FROM SupplierOrderDetails WHERE OrderId=?");
        stm.setObject(1,id);
        if(stm.executeUpdate()>0){
            return true;
        }else {
            return false;
        }
    }
    public SupplierOrderDetails searchSupplierOrder(String id) throws SQLException {
        connection= Singleton.getSingleton().getConnection();
        PreparedStatement stm=connection.prepareStatement("SELECT * FROM SupplierOrderDetails WHERE OrderId=?");
        stm.setObject(1,id);
        ResultSet rst=stm.executeQuery();
        while(rst.next()){
            return new SupplierOrderDetails(rst.getString("OrderId"),rst.getString("SupplierId"),rst.getString("OrderDate"),rst.getString("ExpectedDate"),rst.getDouble("TotalCost"));
         }
            return null;
        }
    public ObservableList<SupplierOrderDetails> getAllSupplierOrders() throws SQLException {
        ObservableList<SupplierOrderDetails>arrayOfAll= FXCollections.observableArrayList();
        connection= Singleton.getSingleton().getConnection();
        PreparedStatement stm=connection.prepareStatement("SELECT * FROM SupplierOrderDetails");
        ResultSet rst=stm.executeQuery();
        while(rst.next()){
            arrayOfAll.add(new SupplierOrderDetails(rst.getString("OrderId"),rst.getString("SupplierId"),rst.getString("OrderDate"),rst.getString("ExpectedDate"),rst.getDouble("TotalCost")));
        }
        return null;
    }
}
