import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel {
    public LoginPanel(JPanel mainPanel) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel loginLabel = new JLabel("Employee Login");
        loginLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JTextField nameField = new JTextField();
        nameField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        nameField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton submitButton = new JButton("Submit");
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.setBackground(new Color(70, 130, 180));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                Employee employee = DatabaseHelper.getEmployeeByName(name);
                CardLayout cl = (CardLayout) (mainPanel.getLayout());
                if (employee != null) {
                    mainPanel.add(new EmployeeInfoPanel(employee, mainPanel), "employeeInfo");
                    cl.show(mainPanel, "employeeInfo");
                } else {
                    mainPanel.add(new NotFoundPanel(mainPanel), "notFound");
                    cl.show(mainPanel, "notFound");
                }
            }
        });

        JButton adminButton = new JButton("Admin");
        adminButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        adminButton.setBackground(new Color(70, 130, 180));
        adminButton.setForeground(Color.WHITE);
        adminButton.setFocusPainted(false);

        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) (mainPanel.getLayout());
                cl.show(mainPanel, "adminLogin");
            }
        });

        add(loginLabel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(new JLabel("Name:"));
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(nameField);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(submitButton);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(adminButton);
    }
}
