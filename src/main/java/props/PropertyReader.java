package props;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    public static String getConnectionUrlH2() {
        try (InputStream inputStream = PropertyReader.class.getClassLoader().
                getResourceAsStream("application.properties")) {
            Properties props = new Properties();
            if(inputStream == null) {
                System.out.println("Sorry unable to find application.properties.");
                return null;
            }
            props.load(inputStream);
            return new String("jdbc:h2:./test");
           /* return new StringBuilder("jdbc:")
                    .append(props.getProperty("h2.db.host"))
                    .append(":./")
                    .append(props.getProperty("h2.db.database"))
                    .toString();*/

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public static String getPopulateSql() {
        try (InputStream inputStream = PropertyReader.class.getClassLoader().
                getResourceAsStream("application.properties")) {
            Properties props = new Properties();
            if(inputStream == null) {
                System.out.println("Sorry unable to find application.properties.");
                return null;
            }
            props.load(inputStream);
            return new StringBuilder("")
                    .append(props.getProperty("sql.populate.db"))
                    .toString();

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
