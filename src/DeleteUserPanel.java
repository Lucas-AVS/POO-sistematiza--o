import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DeleteUserPanel extends JPanel {
    public DeleteUserPanel(JPanel mainPanel) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel deleteLabel = new JLabel("Delete User");
        deleteLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        deleteLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JTextField nameField = new JTextField();
        nameField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        nameField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton submitButton = new JButton("Submit");
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.setBackground(new Color(70, 130, 180));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);
        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            String password = new String(passwordField.getPassword());
            if (password.equals("admin")) {
                // Implement logic to delete user from the database
                // DatabaseHelper.deleteUserByName(name);

                CardLayout cl = (CardLayout) (mainPanel.getLayout());
                cl.show(mainPanel, "admin");
            } else {
                mainPanel.add(new AdminLoginFailedPanel(mainPanel), "adminLoginFailed");
                CardLayout cl = (CardLayout) (mainPanel.getLayout());
                cl.show(mainPanel, "adminLoginFailed");
            }
        });

        add(deleteLabel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(new JLabel("Name:"));
        add(nameField);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(new JLabel("Admin Password:"));
        add(passwordField);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(submitButton);
    }
}
