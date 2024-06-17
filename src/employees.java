import java.util.ArrayList;

public class employees extends Person {
    private ArrayList<Allergies> allergies;

    public employees(int ID, String name, int age, int phone, String email, String bloodType) {
        super(ID, name, age, phone, email, bloodType);
        this.allergies = new ArrayList<Allergies>();
    }

    public String getAllergiesInfo() {
        if (allergies.isEmpty()) {
            return name + " has no allergies.";
        } else {
            StringBuilder sb = new StringBuilder(name + " is allergic to ");
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