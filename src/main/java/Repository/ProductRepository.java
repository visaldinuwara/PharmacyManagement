package Repository;

import DBConnection.Singleton;
import Model.Entity.CustomerOrderDetails;
import Model.Entity.PaymentDetails;
import Model.Entity.ProductDetails;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/*    private String id;
    private String Name;
    private String Brand;
    private String Expiry;
    private String Date;
    private int Quantity;
    private double Price;*/
public class ProductRepository {
    private Connection connection;
    public boolean addProduct(ProductDetails productDetails) throws SQLException {
        connection= Singleton.getSingleton().getConnection();
        PreparedStatement stm=connection.prepareStatement("INSERT INTO ProductDetails VALUES (?,?,?,?,?,?)");
        stm.setObject(1,productDetails.getId());
        stm.setObject(2,productDetails.getName());
        stm.setObject(3,productDetails.getBrand());
        stm.setObject(4,productDetails.getExpiry());
        stm.setObject(5,productDetails.getQuantity());
        stm.setObject(6,productDetails.getPrice());
        if(stm.executeUpdate()>0){
            return true;
        }else {
            return false;
        }
    }
    public boolean updateProduct(ProductDetails productDetails) throws SQLException {
        connection= Singleton.getSingleton().getConnection();
        PreparedStatement stm=connection.prepareStatement("UPDATE ProductDetails SET Name=? Brand=? Expiry=? Quantity=? Price=? WHERE id=?");
        stm.setObject(6,productDetails.getId());
        stm.setObject(1,productDetails.getName());
        stm.setObject(2,productDetails.getBrand());
        stm.setObject(3,productDetails.getExpiry());
        stm.setObject(4,productDetails.getQuantity());
        stm.setObject(5,productDetails.getPrice());
        if(stm.executeUpdate()>0){
            return true;
        }else {
            return false;
        }
    }
    public boolean deleteProduct(String id) throws SQLException {
        connection= Singleton.getSingleton().getConnection();
        PreparedStatement stm=connection.prepareStatement("DELETE FROM ProductDetails WHERE id=?");
        stm.setObject(1,id);
        if(stm.executeUpdate()>0){
            return true;
        }else {
            return false;
        }
    }
    public ProductDetails searchProduct(String id) throws SQLException {
        connection= Singleton.getSingleton().getConnection();
        PreparedStatement stm=connection.prepareStatement("SELECT * FROM ProductDetails WHERE id=?");
        stm.setObject(1,id);
        ResultSet rst=stm.executeQuery();
        while(rst.next()){
            return new ProductDetails(rst.getString("id"),rst.getString("Name"),rst.getString("Brand"),rst.getString("Expiry"),rst.getInt("Quantity"),rst.getDouble("Price"));
        }
        return null;
    }
    public ObservableList<ProductDetails> getAllProducts() throws SQLException {
        ObservableList<ProductDetails> arrayOfAll= FXCollections.observableArrayList();
        connection= Singleton.getSingleton().getConnection();
        PreparedStatement stm=connection.prepareStatement("SELECT * FROM ProductDetails");
        ResultSet rst=stm.executeQuery();
        while(rst.next()){
            arrayOfAll.add(new ProductDetails(rst.getString("id"),rst.getString("Name"),rst.getString("Brand"),rst.getString("Expiry"),rst.getInt("Quantity"),rst.getDouble("Price")));
        }
        return arrayOfAll;
    }
}
