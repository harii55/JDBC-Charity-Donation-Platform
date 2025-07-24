package main.java.com.charityapp.db;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class dbUtil {

        private static String URL;
        private static String USERNAME;
        private static String PASSWORD;

        static {
            try (InputStream input = dbUtil.class.getClassLoader().getResourceAsStream("db.properties")) {
                Properties props = new Properties();
                if (input == null) {
                    throw new RuntimeException("db.properties file not found");
                }
                props.load(input);

                URL = props.getProperty("db.url");
                USERNAME = props.getProperty("db.username");
                PASSWORD = props.getProperty("db.password");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }

        public static void closeConnection(Connection conn) {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

}
