import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class EmployeeInfoPanel extends JPanel {
    public EmployeeInfoPanel(Employee employee, JPanel mainPanel) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel infoLabel = new JLabel("Employee Information");
        infoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoLabel.setFont(new Font("Arial", Font.BOLD, 16));

        add(infoLabel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(new JLabel("Name: " + employee.getName()));
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(new JLabel("Age: " + employee.getAge()));
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(new JLabel("Phone: " + employee.getPhone()));
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(new JLabel("Email: " + employee.getEmail()));
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(new JLabel("Blood Type: " + employee.getBloodType()));
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(new JLabel("Allergies: " + employee.getAllergiesInfo()));

        JButton backButton = new JButton("Back");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setBackground(new Color(70, 130, 180));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) (mainPanel.getLayout());
            cl.show(mainPanel, "login");
        });

        add(Box.createRigidArea(new Dimension(0, 20)));
        add(backButton);
    }
}
