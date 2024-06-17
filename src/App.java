public class App {
    public static void main(String[] args) throws Exception {
        var employee = new employees(1, "John Doe", 30, 123456789, "johndoe@example.com", "O+");
        Allergies allergy1 = new Allergies("peanuts");
        Allergies allergy2 = new Allergies("shellfish");
        employee.addAllergy(allergy1);
        employee.addAllergy(allergy2);
        System.out.println(employee);
    }
}