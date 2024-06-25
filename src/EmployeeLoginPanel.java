import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class EmployeeLoginPanel extends JPanel {
    private JPanel parentPanel;
    private DatabaseHelper db;
    private Connection conn;
    private JPanel mainPanel;

    public EmployeeLoginPanel(JPanel parentPanel, DatabaseHelper db, Connection conn, JPanel mainPanel) {
        this.parentPanel = parentPanel;
        this.db = db;
        this.conn = conn;
        this.mainPanel = mainPanel;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel loginLabel = new JLabel("Employee Login");
        loginLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JTextField nameField = new JTextField();
        nameField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        nameField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton loginButton = new JButton("Login");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setBackground(new Color(70, 130, 180));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                if (db.employeeExists(conn, name)) {
                    Employee employee = db.getEmployeeByName(conn, name);
                    if (employee != null) {
                        JPanel employeeInfoPanel = new EmployeeInfoPanel(mainPanel, db, conn, name);
                        mainPanel.add(employeeInfoPanel, "employeeInfo");
                        CardLayout cl = (CardLayout) (mainPanel.getLayout());
                        cl.show(mainPanel, "employeeInfo");
                    } else {
                        JOptionPane.showMessageDialog(EmployeeLoginPanel.this, "Employee not found");
                    }
                } else {
                    JOptionPane.showMessageDialog(EmployeeLoginPanel.this, "Employee not found");
                }
            }
        });

        JButton adminLoginButton = new JButton("Admin Login");
        adminLoginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        adminLoginButton.setBackground(new Color(70, 130, 180));
        adminLoginButton.setForeground(Color.WHITE);
        adminLoginButton.setFocusPainted(false);
        adminLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "admin");
            }
        });

        add(loginLabel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(new JLabel("Name:"));
        add(nameField);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(loginButton);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(adminLoginButton); // Adicionando o botão Admin Login
    }
}
