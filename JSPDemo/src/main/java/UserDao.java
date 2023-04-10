import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserDao {
   static Connection conn;
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/jdbc_demo";
        String user="root";
        String pass="paudel123";
        conn = DriverManager.getConnection(url,user,pass);
        return conn;
    }
    void addUser(User usr){
        
    }
}
