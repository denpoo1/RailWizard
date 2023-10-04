package Wagons.Wagons_for_passedgers;

import java.util.Arrays;
import Wagons.Names_of_shipper;

public class Person {
    /**This code defines a class called "Person" within the package "Wagons.Wagons_for_passedgers".
     * Each instance of the class represents a person with a first name, last name, ID, and luggage.
     * The luggage is an array of "Bagaze" objects, and each person has a total mass in kilograms.

     The "Person" class has several methods:

     The "getID" method returns the person's ID.
     The "getBagaze" method returns an array of the person's luggage.
     The "setBagaze" method allows you to set the person's luggage.
     The "getMass_KG" method returns the person's total mass in kilograms.
     The constructor method initializes the person's first name, last name, ID, luggage, and mass.
     The first name and last name are generated randomly using the "Names_of_shipper" class.
     The ID is a randomly generated double between 0 and 1,000,000.
     The luggage is created using the "randomBagaze" method, which randomly generates an array of "Bagaze" objects with a length of 3.
     The "Person" class also has a "toString" method that returns a string representation of the person, including their first name, last name, ID, and luggage.
     The "randomBagaze" method is a private helper method that generates a random array of "Bagaze" objects for the person's luggage.*/
    private String firstName;

    public double getID() {
        return ID;
    }

    private double ID;

    public Bagaze[] getBagaze() {
        return bagaze;
    }

    public void setBagaze(Bagaze[] bagaze) {
        this.bagaze = bagaze;
    }

    public double getMass_KG() {
        return mass_KG;
    }

    private String lastName;
    private Bagaze[] bagaze;
    private double mass_KG;

    public Person() {
        firstName = Names_of_shipper.randomName();
        lastName = Names_of_shipper.randomLastName();
        ID = Math.random() * 1_000_000;
        bagaze = randomBagaze(ID);
        mass_KG = 60;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", ID=" + ID +
                ", lastName='" + lastName + '\'' +
                ", bagaze=" + Arrays.toString(bagaze) +
                '}';
    }

    private Bagaze[] randomBagaze(double ID) {
        Bagaze[] bagazes = new Bagaze[3];
        for (int x = 0; x < bagazes.length; x++) {
            int random = (int) ((Math.random() * 2) + 1);
            switch (random) {
                case 1:
                    bagazes[x] = new Suitcase(ID);
                    break;
                case 2:
                    bagazes[x] = new Backpack(ID);
            }
        }
        return bagazes;
    }
}
