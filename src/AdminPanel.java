import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class AdminPanel extends JPanel {
    private JPanel parentPanel;
    private DatabaseHelper db;
    private Connection conn;

    public AdminPanel(JPanel parentPanel, DatabaseHelper db, Connection conn) {
        this.parentPanel = parentPanel;
        this.db = db;
        this.conn = conn;

        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Admin Panel");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(3, 1, 10, 10));

        JButton createUserButton = new JButton("Create User");
        JButton deleteUserButton = new JButton("Delete User");
        JButton modifyUserButton = new JButton("Modify User");

        centerPanel.add(createUserButton);
        centerPanel.add(deleteUserButton);
        centerPanel.add(modifyUserButton);

        add(centerPanel, BorderLayout.CENTER);

        createUserButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) parentPanel.getLayout();
            cl.show(parentPanel, "createUser");
        });

        deleteUserButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) parentPanel.getLayout();
            cl.show(parentPanel, "deleteUser");
        });

        modifyUserButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) parentPanel.getLayout();
            cl.show(parentPanel, "modifyUser");
        });
    }
}
