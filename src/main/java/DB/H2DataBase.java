package DB;

import props.PropertyReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2DataBase {
    private static H2DataBase INSTANCE = new H2DataBase();
    private static Connection connection;
    private H2DataBase() {
        String connectionURL = PropertyReader.getConnectionUrlH2();
        try{
            connection = DriverManager.getConnection(connectionURL);
        } catch (SQLException ex) {
            System.out.println(String.format("Sql expection.Cannot create connection, reason %s",ex.getSQLState()));
            throw new RuntimeException("Cannot create connection.")
        }
    }
    public static H2DataBase getInstance() {
        return INSTANCE;
    }

    public static Connection getConnection() {
        return  connection;
    }
}
