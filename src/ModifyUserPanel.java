import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class ModifyUserPanel extends JPanel {
    private JPanel parentPanel;
    private DatabaseHelper db;
    private Connection conn;
    private JPanel mainPanel;

    public ModifyUserPanel(JPanel parentPanel, DatabaseHelper db, Connection conn, JPanel mainPanel) {
        this.parentPanel = parentPanel;
        this.db = db;
        this.conn = conn;
        this.mainPanel = mainPanel;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel modifyLabel = new JLabel("Modify User");
        modifyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        modifyLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JTextField nameField = new JTextField();
        nameField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        nameField.setAlignmentX(Component.CENTER_ALIGNMENT);

        String[] attributes = { "Age", "Phone", "Email", "Blood Type", "Allergies" };
        JComboBox<String> attributeComboBox = new JComboBox<>(attributes);
        attributeComboBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        attributeComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField newValueField = new JTextField();
        newValueField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        newValueField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton submitButton = new JButton("Submit");
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.setBackground(new Color(70, 130, 180));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = nameField.getText();
                    String attribute = (String) attributeComboBox.getSelectedItem();
                    String newValue = newValueField.getText();
                    db.modifyUserAttribute(conn, name, attribute, newValue);
                    JOptionPane.showMessageDialog(ModifyUserPanel.this, "User modified successfully");
                    CardLayout cl = (CardLayout) (mainPanel.getLayout());
                    cl.show(mainPanel, "admin");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(ModifyUserPanel.this, "Error modifying user: " + ex.getMessage());
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

        add(modifyLabel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(new JLabel("Name:"));
        add(nameField);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(new JLabel("Attribute to modify:"));
        add(attributeComboBox);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(new JLabel("New value:"));
        add(newValueField);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(submitButton);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(backButton);
    }
}
