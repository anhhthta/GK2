package test.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DTBC {
    public static Connection getConnection() {
        Connection c = null;

        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            String url = "jdbc:mySQL://localhost:3306/ts1";
            String userName = "root";
            String pass = "123456789";
            
            c = DriverManager.getConnection(url, userName, pass);

        } catch (SQLException ex) {
            Logger.getLogger(DTBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
    
    public static void closeConnection(Connection c){
        try {
            if(c != null){
                c.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
