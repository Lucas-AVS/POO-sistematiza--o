import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLoginPanel extends JPanel {
    public AdminLoginPanel(JPanel mainPanel) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel adminLabel = new JLabel("Admin Login");
        adminLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        adminLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JTextField passwordField = new JPasswordField();
        passwordField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton submitButton = new JButton("Submit");
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.setBackground(new Color(70, 130, 180));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = passwordField.getText();
                if (password.equals("admin")) {
                    CardLayout cl = (CardLayout) (mainPanel.getLayout());
                    cl.show(mainPanel, "admin");
                } else {
                    mainPanel.add(new AdminLoginFailedPanel(mainPanel), "adminLoginFailed");
                    CardLayout cl = (CardLayout) (mainPanel.getLayout());
                    cl.show(mainPanel, "adminLoginFailed");
                }
            }
        });

        add(adminLabel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(new JLabel("Password:"));
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(passwordField);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(submitButton);
    }
}
