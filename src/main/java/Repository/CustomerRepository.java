package Repository;

import Controller.CustomerOrderController;
import Controller.PaymentController;
import DBConnection.Singleton;
import Model.Entity.CustomerDetails;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/* private String id;
    private String FirstName;
    private String LastName;
    private String EmailAddress;
    private String PhoneNo;*/
public class CustomerRepository {
    private Connection connection;
    public boolean addCustomer(CustomerDetails customerDetails) throws SQLException {
        connection= Singleton.getSingleton().getConnection();
        PreparedStatement stm=connection.prepareStatement("INSERT INTO CustomerDetails VALUES (?,?,?,?,?)");
        stm.setObject(1,customerDetails.getId());
        stm.setObject(2,customerDetails.getFirstName());
        stm.setObject(3,customerDetails.getLastName());
        stm.setObject(4,customerDetails.getEmailAddress());
        stm.setObject(5,customerDetails.getPhoneNo());
        if(stm.executeUpdate()>0){
            return true;
        }else {
            return false;
        }
    }
    public boolean updateCustomer(CustomerDetails customerDetails) throws SQLException {
        connection = Singleton.getSingleton().getConnection();
        PreparedStatement stm = connection.prepareStatement("UPDATE CustomerDetails SET FirstName=? Lastname=? EmailAddress=? PhoneNo=? WHERE id=?");
        stm.setObject(5, customerDetails.getId());
        stm.setObject(1, customerDetails.getFirstName());
        stm.setObject(2, customerDetails.getLastName());
        stm.setObject(3, customerDetails.getEmailAddress());
        stm.setObject(4, customerDetails.getPhoneNo());
        if (stm.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean deleteCustomer(String id) throws SQLException {
        connection = Singleton.getSingleton().getConnection();
        PreparedStatement stm = connection.prepareStatement("DELETE FROM CustomerDetails WHERE id=?");
        stm.setObject(1,id);
        if (stm.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }
    public CustomerDetails searchCustomer(String id) throws SQLException {
        connection=Singleton.getSingleton().getConnection();
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM CustomerDetails WHERE id=?");
        stm.setObject(1,id);
        ResultSet rst=stm.executeQuery();
        while (rst.next()){
            return new CustomerDetails(rst.getString("id"), rst.getString("FirstName"),rst.getString("Lastname"),rst.getString("EmailAddress"), rst.getString("PhoneNo")) ;
        }
        return null;
    }
    public ObservableList<CustomerDetails> getAllCustomers() throws SQLException {
        ObservableList<CustomerDetails>arrayOfAll= FXCollections.observableArrayList();
        connection=Singleton.getSingleton().getConnection();
        PreparedStatement stm=connection.prepareStatement("SELECT * FROM CustomerDetails");
        ResultSet rst=stm.executeQuery();
        while(rst.next()){
            arrayOfAll.add(new CustomerDetails(rst.getString("id"),rst.getString("FirstName"),rst.getString("LastName"),rst.getString("EmailAddress"),rst.getString("PhoneNo")));
        }
        return arrayOfAll;
    }
}

