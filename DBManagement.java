import java.sql.*;

public class DBManagement {
    private Connection connection;
    private Statement query;
    private ResultSet rs;

    public DBManagement() {
        System.out.println("Installing drivers...");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
        System.out.println("Installed!");
    }

    public void connectToDB() {
        String urlDB = "jdbc:mysql://localhost:3306/agenzia_polizze?serverTimezone=UTC";
        String userDB = "root";
        String pwdDB = "";

        try {

            System.out.println("Connecting to the db...");
            connection = DriverManager.getConnection(urlDB, userDB, pwdDB);
            System.out.println("Connected!");

            // Statement creation
            query = connection.createStatement();
        } catch (Exception e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
    }

    public boolean register(String email, String password, int admin) {
        String sql = "INSERT INTO `users` (`Email`, `Password`, `admin`) VALUES ('" + email + "', '" + password + "', '"
                + admin + "');";
        try {
            query.execute(sql);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void closeAll() {
        try {
            if (connection != null) {
                connection.close();
            }
            if (query != null) {
                query.close();
            }

            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
