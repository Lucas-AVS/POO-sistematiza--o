public class Employee {
    private int empid;
    private String name;
    private int age;
    private int phone;
    private String email;
    private String bloodType;
    private String allergiesInfo;

    public Employee(int id, String name, int age, int phone, String email, String bloodType, String allergiesInfo) {
        this.empid = empid;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.bloodType = bloodType;
        this.allergiesInfo = allergiesInfo;
    }

    public int getId() {
        return empid;
    }

    public void setId(int id) {
        this.empid = empid;
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

    public String getAllergiesInfo() {
        return allergiesInfo;
    }

    public void setAllergiesInfo(String allergiesInfo) {
        this.allergiesInfo = allergiesInfo;
    }

}
