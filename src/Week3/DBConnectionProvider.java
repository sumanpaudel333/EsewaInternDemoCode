package Week3;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionProvider {
    static Connection conn;

    public static Connection createConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/jdbc_demo";
            String uname = "root";
            String pass = "paudel123";
            conn = DriverManager.getConnection(url, uname, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
