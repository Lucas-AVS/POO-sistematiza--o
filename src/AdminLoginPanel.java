import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class AdminLoginPanel extends JPanel {
    private JPanel parentPanel;
    private DatabaseHelper db;
    private Connection conn;

    public AdminLoginPanel(JPanel parentPanel, DatabaseHelper db, Connection conn) {
        this.parentPanel = parentPanel;
        this.db = db;
        this.conn = conn;

        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Admin Login");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        JTextField usernameField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Login");

        centerPanel.add(new JLabel("Username:"));
        centerPanel.add(usernameField);
        centerPanel.add(new JLabel("Password:"));
        centerPanel.add(passwordField);
        centerPanel.add(loginButton);

        add(centerPanel, BorderLayout.CENTER);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (username.equals("admin") && password.equals("password")) {
                    CardLayout cardLayout = (CardLayout) parentPanel.getLayout();
                    cardLayout.show(parentPanel, "admin");
                } else {
                    JOptionPane.showMessageDialog(AdminLoginPanel.this, "Invalid username or password");
                }
            }
        });
    }
}
