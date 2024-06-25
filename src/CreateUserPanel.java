import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class CreateUserPanel extends JPanel {
    private JPanel parentPanel;
    private DatabaseHelper db;
    private Connection conn;
    private JPanel mainPanel;

    public CreateUserPanel(JPanel parentPanel, DatabaseHelper db, Connection conn, JPanel mainPanel) {
        this.parentPanel = parentPanel;
        this.db = db;
        this.conn = conn;
        this.mainPanel = mainPanel;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel createLabel = new JLabel("Create User");
        createLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        createLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JTextField nameField = new JTextField();
        nameField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        nameField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField ageField = new JTextField();
        ageField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        ageField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField phoneField = new JTextField();
        phoneField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        phoneField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField emailField = new JTextField();
        emailField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        emailField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField bloodTypeField = new JTextField();
        bloodTypeField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        bloodTypeField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField allergiesField = new JTextField();
        allergiesField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        allergiesField.setAlignmentX(Component.CENTER_ALIGNMENT);

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
                    int age = Integer.parseInt(ageField.getText());
                    int phone = Integer.parseInt(phoneField.getText());
                    String email = emailField.getText();
                    String bloodType = bloodTypeField.getText();
                    String allergies = allergiesField.getText();
                    Employee newEmployee = new Employee(0, name, age, phone, email, bloodType, allergies);
                    db.createUser(conn, newEmployee);
                    JOptionPane.showMessageDialog(CreateUserPanel.this, "User created successfully");
                    CardLayout cl = (CardLayout) (mainPanel.getLayout());
                    cl.show(mainPanel, "admin");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(CreateUserPanel.this, "Invalid input: Age and Phone must be numbers");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(CreateUserPanel.this, "Error creating user: " + ex.getMessage());
                }
            }
        });

        add(createLabel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(new JLabel("Name:"));
        add(nameField);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(new JLabel("Age:"));
        add(ageField);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(new JLabel("Phone:"));
        add(phoneField);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(new JLabel("Email:"));
        add(emailField);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(new JLabel("Blood Type:"));
        add(bloodTypeField);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(new JLabel("Allergies:"));
        add(allergiesField);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(submitButton);
    }
}
