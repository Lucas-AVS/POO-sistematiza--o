import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        DatabaseHelper db = new DatabaseHelper();
        Connection conn = db.connect_to_db("employeeCard", "postgres", "s3nh4");
        db.createTable(conn, "employees");

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Employee Management System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);

            JPanel mainPanel = new JPanel(new CardLayout());
            mainPanel.add(new LoginPanel(mainPanel), "login");
            mainPanel.add(new AdminLoginPanel(mainPanel), "adminLogin");
            mainPanel.add(new AdminPanel(mainPanel), "admin");
            mainPanel.add(new CreateUserPanel(mainPanel), "createUser");
            mainPanel.add(new DeleteUserPanel(mainPanel), "deleteUser");
            mainPanel.add(new ModifyUserPanel(mainPanel), "modifyUser");

            frame.add(mainPanel);
            frame.setVisible(true);
        });
    }
}
