package firstyear.project.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcFix {
    private final String url = "jdbc:mysql://charlie.cgkrzn2ampmn.eu-central-1.rds.amazonaws.com:3306/charlie?useSSL=false";
    private final String username = "myfinger";
    private final String password = "qisig2018";
    protected Connection connection = null;

    public JdbcFix(){
    }

    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e){e.printStackTrace();}
        return connection;
    }
    public void closeConnection(Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
