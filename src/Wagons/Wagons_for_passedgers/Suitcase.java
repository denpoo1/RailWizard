package Wagons.Wagons_for_passedgers;

class Suitcase extends Bagaze {
    @Override
    public String toString() {
        return "Suitcase{}";
    }

    Suitcase(double ID) {
        super("Suitcase", ID, 2);
    }
}
