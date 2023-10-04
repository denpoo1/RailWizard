package Wagons.Wagons_for_passengers;

import Wagons.Wagon_for_Bagadge.Wagon_for_Bagaze;
import java.util.Arrays;
import Wagon.Wagon;
import Interfaces.Electricity;

public class Wagon_for_passengers extends Wagon implements Electricity{
    /**
     * This is a Java code for a class called "Wagon_for_passengers" in the "Wagons_for_passedgers" package.
     * It extends the "Wagon" class and implements the "Electricity" interface.
     * The class contains an array of "Person" objects, which represents the passengers of the wagon.
     * It also has a reference to an instance of "Wagon_for_Bagaze" class, which represents the luggage compartment of the wagon.
     *
     * The class has several methods:
     *
     * "Wagon_for_passengers" constructor: It initializes the wagon's type, material, number of wheels, and maximum weight.
     * It also takes an instance of "Wagon_for_Bagaze" class as a parameter and assigns it to the "wagon_for_bagaze" field.
     * "debarkation" method: It unloads all the passengers and luggage from the wagon if it is loaded.
     * Otherwise, it prints a message indicating that the wagon has already been unloaded.
     * "lading" method: It loads the wagon with passengers and luggage if it is not loaded.
     * It calls the "fill_all_PassedgerWagon" method to fill the wagon with passengers and their luggage,
     * and then sets the gross weight of the wagon to the total weight of the passengers and their luggage.
     * It also sets the "isLading" field to true.
     * If the wagon is already loaded, it prints a message indicating that the wagon is already loaded.
     * "fill_all_PassedgerWagon" method: It creates a new "Person" object for each element of the "people" array and adds their luggage to the "wagon_for_bagaze" object.
     * It also calculates the total weight of the passengers and their luggage and assigns it to the "mass_all_people_ton" field.
     * "unload_all_PassedgerWagon" method: It removes all the luggage of the passengers from the "wagon_for_bagaze" object and sets the "people" array elements to null.
     * It also resets the "mass_all_people_ton" and "wagon_for_bagaze.mass_all_bagadges_ton" fields to 0.
     * "toString" method: It returns a string representation of the "Wagon_for_passengers" object, including its passengers, their luggage, total weight, and loading status.*/
    private Person[] people = new Person[10];
    private double mass_all_people_ton = 0;
    private boolean isLading = false;
    private Wagon_for_Bagaze wagon_for_bagaze;


    public Wagon_for_passengers(Wagon_for_Bagaze wagon_for_bagaze) {
        super("Wagon_for_passendgers", "Fittings", 4, 0);
        this.wagon_for_bagaze = wagon_for_bagaze;
    }

    @Override
    public void debarkation() {
        if (isLading) {
            unload_all_PassedgerWagon();
            isLading = false;
        } else {
            System.out.println("The " + getClass() + "has already been unloaded");
        }
    }

    @Override
    public void lading() {
            if (!isLading) {
                fill_all_PassedgerWagon();
                setGross_weight(mass_all_people_ton);
                isLading = true;

            } else {
                System.out.println("The " + getClass() + " is already loaded");
            }
        }
    private void fill_all_PassedgerWagon() {
        for (int x = 0; x < people.length; x++) {
            people[x] = new Person();
            wagon_for_bagaze.add_luggage(people[x]);
            mass_all_people_ton += (people[x].getMass_KG() / 1000);
        }
    }
    private void unload_all_PassedgerWagon() {
        for (int x = 0; x < people.length; x++) {
            wagon_for_bagaze.pick_up_luggage(people[x]);
            people[x] = null;
        }
        mass_all_people_ton = 0;
        wagon_for_bagaze.setMass_all_bagadges_ton(0);
    }
    @Override
    public String toString() {
        return "Wagon_for_passengers{" +
                "people=" + Arrays.toString(people) +
                ", mass_all_people_ton=" + mass_all_people_ton +
                ", isLading=" + isLading +
                ", wagon_for_bagaze=" + wagon_for_bagaze +
                '}';
    }
}
