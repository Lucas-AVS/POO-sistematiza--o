import java.sql.*;

import javax.swing.JComboBox;

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

    public void createUser(Connection conn, Employee employee) throws SQLException {
        String sql = "INSERT INTO employees(name, age, phone, email, bloodType, allergiesinfo) VALUES(?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, employee.getName());
            pstmt.setInt(2, employee.getAge());
            pstmt.setInt(3, employee.getPhone());
            pstmt.setString(4, employee.getEmail());
            pstmt.setString(5, employee.getBloodType());
            pstmt.setString(6, employee.getAllergiesInfo());
            pstmt.executeUpdate();
        }
    }

    // public void createTable(Connection conn, String table_name) {
    // Statement statement;
    // try {
    // String query = "CREATE TABLE " + table_name + " ("
    // + "empid SERIAL PRIMARY KEY, "
    // + "name VARCHAR(200) NOT NULL, "
    // + "age INT NOT NULL, "
    // + "phone VARCHAR(15), "
    // + "email VARCHAR(200), "
    // + "bloodType VARCHAR(3) NOT NULL, "
    // + "allergiesInfo VARCHAR(255) DEFAULT 'no allergies'"
    // + ");";
    // statement = conn.createStatement();
    // statement.executeUpdate(query);
    // System.out.println("Table Created");
    // } catch (Exception e) {
    // System.out.println(e);
    // }
    // }

    public void modifyUser(Connection conn, Employee employee) throws SQLException {
        String sql = "UPDATE employees SET name = ?, age = ?, phone = ?, email = ?, bloodType = ?, allergiesinfo = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, employee.getName());
            pstmt.setInt(2, employee.getAge());
            pstmt.setInt(3, employee.getPhone());
            pstmt.setString(4, employee.getEmail());
            pstmt.setString(5, employee.getBloodType());
            pstmt.setString(6, employee.getAllergiesInfo());
            pstmt.setInt(7, employee.getId());
            pstmt.executeUpdate();
        }
    }

    public void deleteEmployeeByName(Connection conn, String name) throws SQLException {
        String sql = "DELETE FROM employees WHERE name = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }

    public void readEmployees(Connection conn, JComboBox<String> comboBox) throws SQLException {
        // Implementação do método aqui

        String sql = "SELECT name FROM employees";
        try (Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                comboBox.addItem(rs.getString("name"));
            }
        }
    }

    public boolean employeeExists(Connection conn, String name) {
        String sql = "SELECT COUNT(*) FROM employees WHERE name = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Employee getEmployeeByName(Connection conn, String name) {
        String query = "SELECT empid, name, age, phone, email, bloodtype, allergiesinfo FROM employees WHERE name = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int empid = rs.getInt("empid");
                String employeeName = rs.getString("name");
                int age = rs.getInt("age");
                int phone = rs.getInt("phone");
                String email = rs.getString("email");
                String bloodType = rs.getString("bloodtype");
                String allergiesInfo = rs.getString("allergiesinfo");

                return new Employee(empid, employeeName, age, phone, email, bloodType, allergiesInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
