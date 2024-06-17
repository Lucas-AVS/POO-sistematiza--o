import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    private static JFrame frame;
    private static JPanel panel;

    public static void main(String[] args) {
        // Create employee for testing
        var employee = getTestEmployee();

        // Create JFrame
        frame = new JFrame("Employee Info");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize panel
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Create JLabel and JTextField for user input
        JLabel nameLabel = new JLabel("Enter employee name:");
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        JTextField nameField = new JTextField();
        nameField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        nameField.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Create JButton for submitting user input
        JButton submitButton = new JButton("Submit");
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.setBackground(new Color(70, 130, 180));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);

        // Add action listener to submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                if (name.equals(employee.getName())) {
                    updateEmployeeInfo(employee);
                } else {
                    updateNotFoundMessage();
                }
            }
        });

        // Add components to panel
        panel.add(nameLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(nameField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(submitButton);

        // Add panel to frame and set visible
        frame.add(panel);
        frame.setVisible(true);
    }

    private static void updateEmployeeInfo(Employee employee) {
        // Clear existing components
        panel.removeAll();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Create JLabels for displaying employee info
        JLabel nameLabel = new JLabel("Name: " + employee.getName());
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        JLabel ageBloodTypeLabel = new JLabel(
                "Age: " + employee.getAge() + " | Blood Type: " + employee.getBloodType());
        ageBloodTypeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        ageBloodTypeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        JLabel phoneLabel = new JLabel("Phone: " + employee.getPhone());
        phoneLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        phoneLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        JLabel emailLabel = new JLabel("Email: " + employee.getEmail());
        emailLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        JLabel allergiesLabel = new JLabel("Allergic to: " + employee.getAllergiesInfo());
        allergiesLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        allergiesLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        // Create JButton for new query
        JButton newQueryButton = new JButton("New Query");
        newQueryButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        newQueryButton.setBackground(new Color(70, 130, 180));
        newQueryButton.setForeground(Color.WHITE);
        newQueryButton.setFocusPainted(false);
        newQueryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetPanel();
            }
        });

        // Add components to panel
        panel.add(nameLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(ageBloodTypeLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(phoneLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(emailLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(allergiesLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(newQueryButton);

        // Refresh the panel
        panel.revalidate();
        panel.repaint();
    }

    private static void updateNotFoundMessage() {
        // Clear existing components
        panel.removeAll();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Create JLabel for displaying not found message
        JLabel notFoundLabel = new JLabel("User not found.");
        notFoundLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        notFoundLabel.setFont(new Font("Arial", Font.BOLD, 14));
        notFoundLabel.setForeground(Color.RED);

        // Create JButton for new query
        JButton newQueryButton = new JButton("New Query");
        newQueryButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        newQueryButton.setBackground(new Color(70, 130, 180));
        newQueryButton.setForeground(Color.WHITE);
        newQueryButton.setFocusPainted(false);
        newQueryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetPanel();
            }
        });

        // Add components to panel
        panel.add(notFoundLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(newQueryButton);

        // Refresh the panel
        panel.revalidate();
        panel.repaint();
    }

    private static void resetPanel() {
        // Clear existing components
        panel.removeAll();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Create JLabel and JTextField for user input
        JLabel nameLabel = new JLabel("Enter employee name:");
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        JTextField nameField = new JTextField();
        nameField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        nameField.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Create JButton for submitting user input
        JButton submitButton = new JButton("Submit");
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.setBackground(new Color(70, 130, 180));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);

        // Add action listener to submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                var employee = getTestEmployee(); // Retrieve the test employee
                if (name.equals(employee.getName())) {
                    updateEmployeeInfo(employee);
                } else {
                    updateNotFoundMessage();
                }
            }
        });

        // Add components to panel
        panel.add(nameLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(nameField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(submitButton);

        // Refresh the panel
        panel.revalidate();
        panel.repaint();
    }

    private static Employee getTestEmployee() {
        var employee = new Employee(1, "John Doe", 30, 123456789, "johndoe@example.com", "O+");
        Allergies allergy1 = new Allergies("peanuts");
        Allergies allergy2 = new Allergies("shellfish");
        employee.getAllergies().add(allergy1);
        employee.getAllergies().add(allergy2);
        return employee;
    }
}
