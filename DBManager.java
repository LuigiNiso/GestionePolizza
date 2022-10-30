import java.sql.*;

public class DBManager {
    private Connection connection;
    private Statement query;
    private ResultSet rs;

    public DBManager() {
        System.out.println("Installing drivers...");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Installed!");
        } catch (Exception e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
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

    public String login(String email, String password) {

        try {
            rs = query.executeQuery("SELECT users.Email FROM users WHERE Email = '" + email + "';");
            if (rs.next()) {
                ResultSet users = query.executeQuery(
                        "SELECT * FROM users WHERE Email = '" + email + "' AND Password = '" + password + "'");
                if (users.next()) {
                    if (users.getInt("admin") == 1) {
                        return "2"; // LOG AS ADMIN
                    } else {
                        return "1"; // LOG AS USER
                    }
                } else {
                    return "Password errata!"; // WRONG PASSWORD
                }
            } else {
                return "Email non regisrata"; // EMAIL NOT REGISTERED
            }
        } catch (Exception e) {
            System.out.println("Error!");
            e.printStackTrace();
            return "Errore nel programma"; // PROGRAM ERROR
        }
    }

    public boolean addVehicle(String targa, String modello, int cilindrata, int scadenza) {
        String sql = "INSERT INTO `veicoli`(`Targa`, `Modello`, `Cilindrata`, `Scadenza`) VALUES ('" + targa + "','"
                + modello + "','" + cilindrata + "','" + scadenza + "')";
        try {
            query.execute(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getScadenza(String targa) {
        String sql = "SELECT users.Scadenza FROM users WHERE Targa = " + targa + ";";
        try {
            rs = query.executeQuery(sql);
            return rs.getString("Scadenza");
        } catch (Exception e) {
            return null;
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
