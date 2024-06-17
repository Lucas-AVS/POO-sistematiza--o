import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    private static JFrame frame;
    private static JPanel panel;

    public static void main(String[] args) {
        // Create employee for testing
        var employee = new Employee(1, "John Doe", 30, 123456789, "johndoe@example.com", "O+");
        Allergies allergy1 = new Allergies("peanuts");
        Allergies allergy2 = new Allergies("shellfish");
        employee.getAllergies().add(allergy1);
        employee.getAllergies().add(allergy2);

        // Create JFrame
        frame = new JFrame("Employee Info");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize panel
        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        // Create JLabel and JTextField for user input
        JLabel nameLabel = new JLabel("Enter employee name:");
        JTextField nameField = new JTextField();

        // Create JButton for submitting user input
        JButton submitButton = new JButton("Submit");

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
        panel.add(nameField);
        panel.add(submitButton);

        // Add panel to frame and set visible
        frame.add(panel);
        frame.setVisible(true);
    }

    private static void updateEmployeeInfo(Employee employee) {
        // Clear existing components
        panel.removeAll();
        panel.setLayout(new GridLayout(6, 1));

        // Create JLabels for displaying employee info
        JLabel nameLabel = new JLabel("Name: " + employee.getName());
        JLabel ageBloodTypeLabel = new JLabel("Age: " + employee.getAge() + " Blood Type: " + employee.getBloodType());
        JLabel phoneLabel = new JLabel("Phone: " + employee.getPhone());
        JLabel emailLabel = new JLabel("Email: " + employee.getEmail());
        JLabel allergiesLabel = new JLabel("Allergic to: " + employee.getAllergiesInfo());

        // Create JButton for new query
        JButton newQueryButton = new JButton("New Query");
        newQueryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetPanel();
            }
        });

        // Add components to panel
        panel.add(nameLabel);
        panel.add(ageBloodTypeLabel);
        panel.add(phoneLabel);
        panel.add(emailLabel);
        panel.add(allergiesLabel);
        panel.add(newQueryButton);

        // Refresh the panel
        panel.revalidate();
        panel.repaint();
    }

    private static void updateNotFoundMessage() {
        // Clear existing components
        panel.removeAll();
        panel.setLayout(new GridLayout(2, 1));

        // Create JLabel for displaying not found message
        JLabel notFoundLabel = new JLabel("User not found.");

        // Create JButton for new query
        JButton newQueryButton = new JButton("New Query");
        newQueryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetPanel();
            }
        });

        // Add components to panel
        panel.add(notFoundLabel);
        panel.add(newQueryButton);

        // Refresh the panel
        panel.revalidate();
        panel.repaint();
    }

    private static void resetPanel() {
        // Clear existing components
        panel.removeAll();
        panel.setLayout(new GridLayout(3, 1));

        // Create JLabel and JTextField for user input
        JLabel nameLabel = new JLabel("Enter employee name:");
        JTextField nameField = new JTextField();

        // Create JButton for submitting user input
        JButton submitButton = new JButton("Submit");

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
        panel.add(nameField);
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
