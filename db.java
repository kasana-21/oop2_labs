package singleton;//SINGLETON DESIGN PATTERN

import java.sql.Connection;
import java.sql.DriverManager;

public class db{
    // Database connection
    public static String db_url = "jdbc:mysql://localhost:3306/"; // Database URL
    public static String db_name = "db_name"; // Database name
    public static String password = "password"; // Database password
    public static String username = "username"; // Database username
    public static String driver = "com.mysql.jdbc.Driver"; // Database driver
    private Connection connection = null;

    public static Connection connect(){
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(db_url + db_name, username, password);
        }catch(Exception e){
            System.out.println(e);
        }
        return conn;
    }

    // A singleton pattern to allow the connection to be instantiated only once from the Singleton class
    private static Connection conn;
    public static Connection getConnection(){
        if(conn == null){
            conn = connect();
        }
        return conn;
    }

    public Connection getConn(){
        return connection;
    }

    // Close the connection
    public static void closeConnection(){
        try{
            conn.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }

}
