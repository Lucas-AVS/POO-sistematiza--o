public class Person {
    protected int ID;
    protected String name;
    protected int age;
    protected int phone;
    protected String email;
    protected String bloodType;

    public Person(int ID, String name, int age, int phone, String email, String bloodType) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.bloodType = bloodType;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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
}
