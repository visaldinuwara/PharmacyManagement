package Repository;

import DBConnection.Singleton;
import Model.Entity.CustomerOrderDetails;
import Model.Entity.PaymentDetails;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
/*    private String PaymentId;
    private String OrderDetailId;
    private String PaymentMethod;
    private double AmountPayed;
    private String CardType;*/
public class PaymentRepository {
    private Connection connection;
    public boolean addPayment(PaymentDetails paymentDetails) throws SQLException {
        connection= Singleton.getSingleton().getConnection();
        PreparedStatement stm=connection.prepareStatement("INSERT INTO PaymentDetails VALUES (?,?,?,?,?)");
        stm.setObject(1,paymentDetails.getPaymentId());
        stm.setObject(2,paymentDetails.getOrderDetailId());
        stm.setObject(3,paymentDetails.getPaymentMethod());
        stm.setObject(4,paymentDetails.getAmountPayed());
        stm.setObject(5,paymentDetails.getCardType());
        if(stm.executeUpdate()>0){
            return true;
        }else {
            return false;
        }
    }
    public boolean updatePayment(PaymentDetails paymentDetails) throws SQLException {
        connection=Singleton.getSingleton().getConnection();
        PreparedStatement stm = connection.prepareStatement("UPDATE PaymentDetails SET OrderDetailId=? PaymentMethod=? AmountPayed=? CardType=? WHERE PaymentId=?");
        stm.setObject(1,paymentDetails.getOrderDetailId());
        stm.setObject(2,paymentDetails.getPaymentMethod());
        stm.setObject(3,paymentDetails.getAmountPayed());
        stm.setObject(4,paymentDetails.getCardType());
        stm.setObject(5,paymentDetails.getPaymentId());
        if(stm.executeUpdate()>0){
            return true;
        }else{
            return false;
        }
    }
    public boolean deletePayment(String id) throws SQLException {
        connection=Singleton.getSingleton().getConnection();
        PreparedStatement stm = connection.prepareStatement("DELETE FROM PaymentDetails WHERE PaymentId=?");
        stm.setObject(1,id);
        if(stm.executeUpdate()>0){
            return true;
        }else{
            return false;
        }
    }
    public PaymentDetails searchPayment(String id) throws SQLException {
        connection=Singleton.getSingleton().getConnection();
        PreparedStatement stm=connection.prepareStatement("SELECT * FROM PaymentDetails WHERE PaymentId=?");
        stm.setObject(1,id);
        ResultSet rst=stm.executeQuery();
        while(rst.next()){
            return new PaymentDetails(rst.getString("PaymentId"),rst.getString("OrderDetailId"),rst.getString("PaymentMethod"),rst.getDouble("AmountPayed"),rst.getString("CardType"));
        }
        return null;
    }
    public ObservableList<PaymentDetails> getAllPayments() throws SQLException {
        ObservableList<PaymentDetails> arrayOfAll= FXCollections.observableArrayList();
        connection=Singleton.getSingleton().getConnection();
        PreparedStatement stm=connection.prepareStatement("SELECT * FROM PaymentDetails");
        ResultSet rst=stm.executeQuery();
        while(rst.next()){
            arrayOfAll.add(new PaymentDetails(rst.getString("PaymentId"),rst.getString("OrderDetailId"),rst.getString("PaymentMethod"),rst.getDouble("AmountPayed"),rst.getString("CardType")));
        }
        return arrayOfAll;
    }
}
