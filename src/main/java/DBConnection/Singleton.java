package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton {
    private Connection connection;
    private static Singleton singleton;
    public Singleton() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost/PharmacyManagement","root","12344321");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Connection getConnection(){
        return connection;
    }
    public static Singleton getSingleton(){
        if(singleton==null){
            singleton=new Singleton();
            return singleton;
        }
        return singleton;
    }
}
