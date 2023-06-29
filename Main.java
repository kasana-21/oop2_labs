package singleton;

public class Main {
    public static void main(String[] args) {
        // Get the connection
        db.getConnection();
        // Close the connection
        db.closeConnection();
    }
}