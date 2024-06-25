import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class EmployeeInfoPanel extends JPanel {
    private JPanel parentPanel;
    private DatabaseHelper db;
    private Connection conn;
    private String employeeName;

    public EmployeeInfoPanel(JPanel parentPanel, DatabaseHelper db, Connection conn, String employeeName) {
        this.parentPanel = parentPanel;
        this.db = db;
        this.conn = conn;
        this.employeeName = employeeName;

        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Employee Information for: " + employeeName);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label, BorderLayout.NORTH);

        JPanel infoPanel = new JPanel(new GridLayout(6, 2, 10, 10));

        // Fetch employee details from the database and populate the fields
        Employee employee = db.getEmployeeByName(conn, employeeName);

        if (employee != null) {
            infoPanel.add(new JLabel("Name:"));
            infoPanel.add(new JLabel(employee.getName()));
            infoPanel.add(new JLabel("Age:"));
            infoPanel.add(new JLabel(String.valueOf(employee.getAge())));
            infoPanel.add(new JLabel("Phone:"));
            infoPanel.add(new JLabel(String.valueOf(employee.getPhone())));
            infoPanel.add(new JLabel("Email:"));
            infoPanel.add(new JLabel(employee.getEmail()));
            infoPanel.add(new JLabel("Blood Type:"));
            infoPanel.add(new JLabel(employee.getBloodType()));
            infoPanel.add(new JLabel("Allergies:"));
            infoPanel.add(new JLabel(employee.getAllergiesInfo()));
        } else {
            infoPanel.add(new JLabel("No information available for this employee."));
        }

        add(infoPanel, BorderLayout.CENTER);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) parentPanel.getLayout();
            cl.show(parentPanel, "employeeLogin");
        });

        add(backButton, BorderLayout.SOUTH);
    }
}
