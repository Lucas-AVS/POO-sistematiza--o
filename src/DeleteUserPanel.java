import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class DeleteUserPanel extends JPanel {
    private JPanel parentPanel;
    private DatabaseHelper db;
    private Connection conn;
    private JPanel mainPanel;

    public DeleteUserPanel(JPanel parentPanel, DatabaseHelper db, Connection conn, JPanel mainPanel) {
        this.parentPanel = parentPanel;
        this.db = db;
        this.conn = conn;
        this.mainPanel = mainPanel;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel deleteLabel = new JLabel("Delete User");
        deleteLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        deleteLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JComboBox<String> userComboBox = new JComboBox<>();
        userComboBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        userComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        try {
            db.readEmployees(conn, userComboBox);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error reading users: " + e.getMessage());
        }

        JButton deleteButton = new JButton("Delete");
        deleteButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        deleteButton.setBackground(new Color(70, 130, 180));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFocusPainted(false);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String selectedUser = (String) userComboBox.getSelectedItem();
                    db.deleteEmployeeByName(conn, selectedUser);
                    JOptionPane.showMessageDialog(DeleteUserPanel.this, "User deleted successfully");
                    CardLayout cl = (CardLayout) (mainPanel.getLayout());
                    cl.show(mainPanel, "admin");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(DeleteUserPanel.this, "Error deleting user: " + ex.getMessage());
                }
            }
        });

        JButton backButton = new JButton("Back");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) (mainPanel.getLayout());
                cl.show(mainPanel, "admin");
            }
        });

        add(deleteLabel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(userComboBox);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(deleteButton);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(backButton);
    }
}
