package Wagons.Wagon_for_Bagadge;

import java.util.HashMap;

import Wagons.Wagons_for_passedgers.Bagaze;
import Wagons.Wagons_for_passedgers.Person;
import Wagon.Wagon;

public class Wagon_for_Bagaze extends Wagon {
    /**This code defines a class Wagon_for_Bagaze which extends Wagon and is used to carry luggage for passengers on a train.
     * It has instance variables mass_all_bagadges_ton, which tracks the total mass of all luggage on the wagon, and bagazeHashMap, which is a HashMap that maps a passenger's ID to their luggage.

     The class has a constructor that calls the superclass constructor with null for the Names_of_shipper, "Fittings" for the Name_of_cargo, 3 for the Amount_of_places and 0 for the Gross_weight.
     The superclass constructor is defined in the Wagon class.

     The class has a toString() method that returns a string representation of the wagon's mass and luggage information.

     The add_luggage(Person person) method takes a Person object and adds their luggage to the wagon by putting each item of luggage into the bagazeHashMap with a key that combines the passenger's ID and a unique number.
     The method also adds the mass of each item of luggage to the mass_all_bagadges_ton variable.

     The setMass_all_bagadges_ton(double mass_all_bagadges_ton) method is used to set the value of the mass_all_bagadges_ton variable.

     The pick_up_luggage(Person person) method takes a Person object and removes their luggage from the wagon by retrieving each item of luggage from the bagazeHashMap using the passenger's ID and a unique number.
     The method also subtracts the mass of each item of luggage from the mass_all_bagadges_ton variable.

     The class also overrides the debarkation() and lading() methods from the superclass and sets them to null since they are not used in this context.*/
    private double mass_all_bagadges_ton = 0;
    private HashMap<Double, Bagaze> bagazeHashMap = new HashMap<>();

    public Wagon_for_Bagaze() {
        super(null, "Fittings", 3, 0);
    }

    @Override
    public String toString() {
        return "\nWagon_for_Bagaze{" +
                "mass_all_bagadges_ton=" + mass_all_bagadges_ton +
                ", bagazeHashMap=" + bagazeHashMap +
                '}';
    }

    public void add_luggage(Person person) {
        double y = 1;
        for (int x = 0; x < person.getBagaze().length; x++) {
            bagazeHashMap.put(person.getID() + y++, person.getBagaze()[x]);
            mass_all_bagadges_ton += (person.getBagaze()[x].getMass_KG() / 1000.0);
            person.getBagaze()[x] = null;
        }
    }

    public void setMass_all_bagadges_ton(double mass_all_bagadges_ton) {
        this.mass_all_bagadges_ton = mass_all_bagadges_ton;
    }

    public void pick_up_luggage(Person person) {
        double y = 1;
        Bagaze[] bagazes = new Bagaze[3];
        for (int x = 0; x < person.getBagaze().length; x++) {
            bagazes[x] = bagazeHashMap.get(person.getID() + y);
            mass_all_bagadges_ton -= (bagazes[x].getMass_KG() / 1000.0);
            bagazeHashMap.remove(person.getID() + y++);
        }
        person.setBagaze(bagazes);
    }

    @Override
    public void debarkation() {
        //null
    }

    @Override
    public void lading() {
       //null
    }
}
