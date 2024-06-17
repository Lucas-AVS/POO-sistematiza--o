public class Allergies {
    private String allergy;

    public Allergies(String allergy) {
        this.allergy = allergy;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    @Override
    public String toString() {
        return allergy;
    }
}