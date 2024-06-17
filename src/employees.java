import java.util.ArrayList;

public class employees {
    private int ID;
    private String name;
    private int age;
    private int phone;
    private String email;
    private String bloodType;
    private ArrayList<Allergies> allergies;

    public employees(int ID, String name, int age, int phone, String email, String bloodType) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.bloodType = bloodType;
        this.allergies = new ArrayList<Allergies>();
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public ArrayList<Allergies> getAllergies() {
        return allergies;
    }

    public void addAllergy(Allergies allergy) {
        this.allergies.add(allergy);
    }

    @Override
    public String toString() {
        return "employees [name=" + name + ", age=" + age + ", bloodType=" + bloodType + ", allergies=" + allergies
                + "]";
    }
}
