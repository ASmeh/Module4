package DB;

import props.PropertyReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {
    public static void main(String[] args) {
        initDB();
    }
    public static void initDB() {
        String path = "src/main/resources/sql/init_db.sql";
        try (FileReader reader = new FileReader(path);
             //FileReader reader = new FileReader(PropertyReader.getPopulateSql());
             // Wrap the FileReader in a BufferedReader for
             // efficient reading.
             BufferedReader bufferedReader = new BufferedReader(reader);
             // Establish a connection to the database.
             Connection connection = H2DataBase.getConnection();
             // Create a statement object to execute SQL
             // commands.
             Statement statement = connection.createStatement();) {

//            printMetaData(connection);
//            System.out.println("Executing commands at : "
//                    + path);

            StringBuilder builder = new StringBuilder();

            String line;
            int lineNumber = 0;
            int count = 0;

            // Read lines from the SQL file until the end of the
            // file is reached.
            while ((line = bufferedReader.readLine()) != null) {
                lineNumber += 1;
                line = line.trim();

                // Skip empty lines and single-line comments.
                if (line.isEmpty() || line.startsWith("--")) continue;

                builder.append(line);
                // If the line ends with a semicolon, it
                // indicates the end of an SQL command.
                if (line.endsWith(";")) try {
                    // Execute the SQL command
                    statement.execute(builder.toString());
                    // Print a success message along with
                    // the first 15 characters of the
                    // executed command.
                    System.out.println(++count + " Command successfully executed : " + builder.substring(0, Math.min(builder.length(), 15)) + "...");
                    builder.setLength(0);
                } catch (SQLException e) {
                    // If an SQLException occurs during
                    // execution, print an error message and
                    // stop further execution.
                    System.err.println("At line " + lineNumber + " : " + e.getMessage() + "\n");
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
