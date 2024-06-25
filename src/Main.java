import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Employee Management System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);

            JPanel mainPanel = new JPanel(new CardLayout());

            DatabaseHelper db = new DatabaseHelper();
            Connection conn = db.connect_to_db("employeeCard", "postgres", "s3nh4");
            // db.createTable(conn, "employees");

            if (conn == null) {
                System.out.println("Failed to connect to the database. Exiting...");
                return;
            }

            JPanel adminPanel = new AdminPanel(mainPanel, db, conn);
            JPanel createUserPanel = new CreateUserPanel(mainPanel, db, conn, mainPanel);
            JPanel modifyUserPanel = new ModifyUserPanel(mainPanel, db, conn, mainPanel);
            JPanel deleteUserPanel = new DeleteUserPanel(mainPanel, db, conn, mainPanel);
            JPanel employeeLoginPanel = new EmployeeLoginPanel(mainPanel, db, conn, mainPanel);

            mainPanel.add(deleteUserPanel, "deleteUser");
            mainPanel.add(adminPanel, "admin");
            mainPanel.add(employeeLoginPanel, "employeeLogin");
            mainPanel.add(modifyUserPanel, "modifyUser");
            mainPanel.add(createUserPanel, "createUser");

            frame.add(mainPanel);
            frame.setVisible(true);

        });
    }
}
