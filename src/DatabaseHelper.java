import java.sql.*;
import java.security.spec.ECField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseHelper {
    public Connection connect_to_db(String dbname, String user, String pass) {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, pass);
            if (conn != null) {
                System.out.println("Connection Established");
            } else {
                System.out.println("Connection Failed");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }

    public void createTable(Connection conn, String table_name) {
        Statement statement;
        try {
            String query = "CREATE TABLE " + table_name + " ("
                    + "empid SERIAL PRIMARY KEY, "
                    + "name VARCHAR(200) NOT NULL, "
                    + "age INT NOT NULL, "
                    + "phone VARCHAR(15), "
                    + "email VARCHAR(200), "
                    + "bloodType VARCHAR(3) NOT NULL, "
                    + "allergiesInfo VARCHAR(255) DEFAULT 'no allergies'"
                    + ");";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Created");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static final String URL = "jdbc:postgresql://localhost:5432/your_database";
    private static final String USER = "your_user";
    private static final String PASSWORD = "your_password";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static Employee getEmployeeByName(String name) {
        String sql = "SELECT * FROM employees WHERE name = ?";
        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                int phone = rs.getInt("phone");
                String email = rs.getString("email");
                String bloodType = rs.getString("blood_type");
                String allergies = rs.getString("allergies");
                return new Employee(id, name, age, phone, email, bloodType, allergies);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    // Additional methods for create, delete, and modify users
}
