import java.util.ArrayList;

public class Employee extends Person {
    private ArrayList<Allergies> allergies;

    public Employee(int ID, String name, int age, int phone, String email, String bloodType) {
        super(ID, name, age, phone, email, bloodType);
        this.allergies = new ArrayList<>();
    }

    public String getAllergiesInfo() {
        if (allergies.isEmpty()) {
            return getName() + " has no allergies.";
        } else {
            StringBuilder sb = new StringBuilder(getName() + " is allergic to ");
            for (Allergies allergy : allergies) {
                sb.append(allergy.getSubstance()).append(", ");
            }
            // Remove the last comma and space
            sb.setLength(sb.length() - 2);
            return sb.toString();
        }
    }

    public ArrayList<Allergies> getAllergies() {
        return allergies;
    }

    public void setAllergies(ArrayList<Allergies> allergies) {
        this.allergies = allergies;
    }
}
