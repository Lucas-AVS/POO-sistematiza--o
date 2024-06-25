import javax.swing.*;
import java.awt.*;

public class AdminLoginFailedPanel extends JPanel {
    public AdminLoginFailedPanel(JPanel parentPanel) {
        setLayout(new BorderLayout());
        JLabel message = new JLabel("Admin Login Failed. Please try again.");
        message.setHorizontalAlignment(SwingConstants.CENTER);
        add(message, BorderLayout.CENTER);
    }
}
