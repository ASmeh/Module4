package DB;
import java.sql.*;

public class Database {
    private Connection connection;
    public Database(String dbUrl) {

    }
    Connection getConnection() {
        return  connection;
    }
}
