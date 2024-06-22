import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AdminPanel extends JPanel {
    public AdminPanel(JPanel mainPanel) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel adminLabel = new JLabel("Admin Panel");
        adminLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        adminLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JButton createUserButton = new JButton("Create New User");
        createUserButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        createUserButton.setBackground(new Color(70, 130, 180));
        createUserButton.setForeground(Color.WHITE);
        createUserButton.setFocusPainted(false);
        createUserButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) (mainPanel.getLayout());
            cl.show(mainPanel, "createUser");
        });

        JButton deleteUserButton = new JButton("Delete User");
        deleteUserButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        deleteUserButton.setBackground(new Color(70, 130, 180));
        deleteUserButton.setForeground(Color.WHITE);
        deleteUserButton.setFocusPainted(false);
        deleteUserButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) (mainPanel.getLayout());
            cl.show(mainPanel, "deleteUser");
        });

        JButton modifyUserButton = new JButton("Modify User");
        modifyUserButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        modifyUserButton.setBackground(new Color(70, 130, 180));
        modifyUserButton.setForeground(Color.WHITE);
        modifyUserButton.setFocusPainted(false);
        modifyUserButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) (mainPanel.getLayout());
            cl.show(mainPanel, "modifyUser");
        });

        add(adminLabel);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(createUserButton);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(deleteUserButton);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(modifyUserButton);
    }
}
