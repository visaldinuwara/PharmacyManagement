package Repository;

import DBConnection.Singleton;
import Model.Entity.CustomerDetails;
import Model.Entity.CustomerOrderDetails;
import Model.Entity.LoginDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/*    private String UserName;
    private String Password;*/
public class LoginPageRepository {
    private Connection connection;
    public boolean addLogin(LoginDetails loginDetails) throws SQLException {
        connection= Singleton.getSingleton().getConnection();
        PreparedStatement stm=connection.prepareStatement("INSERT INTO LoginDetails VALUES (?,?)");
        stm.setObject(1,loginDetails.getUserName());
        stm.setObject(2,loginDetails.getPassword());
        if(stm.executeUpdate()>0){
            return true;
        }else {
            return false;
        }
    }
    public boolean updateLogin(LoginDetails loginDetails) throws SQLException {
        connection = Singleton.getSingleton().getConnection();
        PreparedStatement stm = connection.prepareStatement("UPDATE LoginDetails SET Password=? WHERE UserName=?");
        stm.setObject(2,loginDetails.getUserName());
        stm.setObject(1, loginDetails.getPassword());
        if (stm.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }       }
    public boolean deleteLogin(String id) throws SQLException {
        connection = Singleton.getSingleton().getConnection();
        PreparedStatement stm = connection.prepareStatement("DELETE FROM LoginDetails WHERE UserName=?");
        stm.setObject(1,id);
        if (stm.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }
    public LoginDetails searchLogin(String id) throws SQLException {
        connection=Singleton.getSingleton().getConnection();
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM LoginDetails WHERE UserName=?");
        stm.setObject(1,id);
        ResultSet rst=stm.executeQuery();
        while (rst.next()){
            return new LoginDetails(rst.getString("UserName"), rst.getString("Password"));
        }
        return null;
    }
    public ArrayList<LoginDetails> getAllLoginDetails() throws SQLException {
        ArrayList<LoginDetails>arrayOfAll=new ArrayList<>();
        connection=Singleton.getSingleton().getConnection();
        PreparedStatement stm=connection.prepareStatement("SELECT * FROM LoginDetails");
        ResultSet rst=stm.executeQuery();
        while(rst.next()){
            arrayOfAll.add(new LoginDetails(rst.getString("UserName"),rst.getString("Password")));
        }
        return arrayOfAll;
    }
}
