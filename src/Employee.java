public class Employee extends Person {
    private String allergiesInfo;

    public Employee(int ID, String name, int age, int phone, String email, String bloodType, String allergiesInfo) {
        super(ID, name, age, phone, email, bloodType);
        this.allergiesInfo = allergiesInfo;
    }

    public String getAllergiesInfo() {
        return allergiesInfo;
    }

    public void setAllergiesInfo(String allergiesInfo) {
        this.allergiesInfo = allergiesInfo;
    }

    @Override
    public int getID() {
        return super.getID();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public int getPhone() {
        return super.getPhone();
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public String getBloodType() {
        return super.getBloodType();
    }
}
