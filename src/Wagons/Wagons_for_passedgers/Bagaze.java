package Wagons.Wagons_for_passedgers;

public class Bagaze {
    Bagaze(String type,double ID, double mass_KG) {
        this.type = type;
        this.ID = ID;
        this.mass_KG = mass_KG;
    }

    private String type;
    private double ID;
    private double mass_KG;

    @Override
    public String toString() {
        return "Bagaze{" +
                "type='" + type + '\'' +
                ", ID=" + ID +
                ", mass_KG=" + mass_KG +
                '}';
    }

    public double getMass_KG() {
        return mass_KG;
    }

}
