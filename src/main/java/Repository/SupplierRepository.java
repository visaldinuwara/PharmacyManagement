package Repository;

import DBConnection.Singleton;
import Model.Entity.ProductDetails;
import Model.Entity.SupplierDetails;
import Model.Entity.SupplierOrderDetails;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/*    private String id;
    private String LegalName;
    private String TradeName;
    private String PrimaryContact;
    private String EmergencyContact;
    private String PhysicalAddress;*/
public class SupplierRepository {
    private Connection connection;
    public boolean addSupplier(SupplierDetails supplierDetails) throws SQLException {
        connection= Singleton.getSingleton().getConnection();
        PreparedStatement stm=connection.prepareStatement("INSERT INTO Suppliers VALUES (?,?,?,?,?,?)");
        stm.setObject(1,supplierDetails.getId());
        stm.setObject(2,supplierDetails.getLegalName());
        stm.setObject(3,supplierDetails.getTradeName());
        stm.setObject(4,supplierDetails.getPrimaryContact());
        stm.setObject(5,supplierDetails.getEmergencyContact());
        stm.setObject(6,supplierDetails.getPhysicalAddress());
        if(stm.executeUpdate()>0){
            return true;
        }else {
            return false;
        }
    }
    public boolean updateSupplier(SupplierDetails supplierDetails) throws SQLException {
        connection= Singleton.getSingleton().getConnection();
        PreparedStatement stm=connection.prepareStatement("UPDATE Suppliers SET LegalName=? TradeName=? PrimaryContact=? EmergencyContact=? PhysicalAddress=? WHERE id=?");
        stm.setObject(6,supplierDetails.getId());
        stm.setObject(1,supplierDetails.getLegalName());
        stm.setObject(2,supplierDetails.getTradeName());
        stm.setObject(3,supplierDetails.getPrimaryContact());
        stm.setObject(4,supplierDetails.getEmergencyContact());
        stm.setObject(5,supplierDetails.getPhysicalAddress());
        if(stm.executeUpdate()>0){
            return true;
        }else {
            return false;
        }
    }
    public boolean deleteSupplier(String id) throws SQLException {
        connection= Singleton.getSingleton().getConnection();
        PreparedStatement stm=connection.prepareStatement("DELETE FROM Suppliers WHERE id=?");
        stm.setObject(1,"id");
        if(stm.executeUpdate()>0){
            return true;
        }else {
            return false;
        }
    }
    public SupplierDetails searchSupplier(String id) throws SQLException {
        connection= Singleton.getSingleton().getConnection();
        PreparedStatement stm=connection.prepareStatement("SELECT * FROM Suppliers WHERE id=?");
        stm.setObject(1,"id");
        ResultSet rst=stm.executeQuery();
        while(rst.next()){
            return new SupplierDetails(rst.getString("id"),rst.getString("LegalName"),rst.getString("TradeName"),rst.getString("PrimaryContact"),rst.getString("EmergencyContact"),rst.getString("PhysicalAddress"));
        }
        return null;
    }
    public ObservableList<SupplierDetails> getAllSuppliers() throws SQLException {
        ObservableList<SupplierDetails>arrayOfAll= FXCollections.observableArrayList();
        connection= Singleton.getSingleton().getConnection();
        PreparedStatement stm=connection.prepareStatement("SELECT * FROM Suppliers");
        ResultSet rst=stm.executeQuery();
        while(rst.next()){
            arrayOfAll.add(new SupplierDetails(rst.getString("id"),rst.getString("LegalName"),rst.getString("TradeName"),rst.getString("PrimaryContact"),rst.getString("EmergencyContact"),rst.getString("PhysicalAddress")));
        }
        return null;
    }
}
