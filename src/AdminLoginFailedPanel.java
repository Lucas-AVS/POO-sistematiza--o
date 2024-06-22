import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AdminLoginFailedPanel extends JPanel {
    public AdminLoginFailedPanel(JPanel mainPanel) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel failedLabel = new JLabel("Admin Login Failed");
        failedLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        failedLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JButton backButton = new JButton("Back");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setBackground(new Color(70, 130, 180));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) (mainPanel.getLayout());
            cl.show(mainPanel, "adminLogin");
        });

        add(failedLabel);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(backButton);
    }
}
