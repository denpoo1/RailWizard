package Wagons.Wagon_for_explosive;

class Explosive {
    private String name;
    private double mass_gramm;
    Explosive(String name, double mass_gramm) {
        this.mass_gramm = mass_gramm;
        this.name = name;
    }
    public double getMass_gramm() {
        return mass_gramm;
    }

    @Override
    public String toString() {
        return "Explosive{" +
                "name='" + name + '\'' +
                ", mass_gramm=" + mass_gramm +
                '}';
    }
}
