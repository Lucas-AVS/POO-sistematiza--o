import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class NotFoundPanel extends JPanel {
    public NotFoundPanel(JPanel mainPanel) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel notFoundLabel = new JLabel("User Not Found");
        notFoundLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        notFoundLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JButton backButton = new JButton("Back");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setBackground(new Color(70, 130, 180));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) (mainPanel.getLayout());
            cl.show(mainPanel, "login");
        });

        add(notFoundLabel);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(backButton);
    }
}
