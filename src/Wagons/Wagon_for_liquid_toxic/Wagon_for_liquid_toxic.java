package Wagons.Wagon_for_liquid_toxic;

import Wagon.Wagon_for_goods;
import Wagons.Names_of_shipper;

public class Wagon_for_liquid_toxic extends Wagon_for_goods {
    /**This code defines a Java class called "Wagon_for_liquid_toxic" that extends the "Wagon_for_goods" class.
     * The purpose of this class is to represent a train wagon designed for transporting liquid toxic cargo.

     The class has two instance variables: "max_mass_of_toxic" which represents the maximum mass of the toxic substance the wagon can carry,
     and "isLading" which indicates whether the wagon is currently loaded or not.

     The constructor method initializes the instance variable "isLading" to false and calls a static method "randomLiquidToxic()"
     from the "Names_of_shipper" class to randomly assign a shipper name for the wagon.

     The class also defines two methods: "lading()" and "debarkation()". "lading()" method is used to load the wagon with cargo,
     while "debarkation()" method is used to unload it.

     In the "lading()" method, if the wagon is already loaded, it prints a message saying so. Otherwise,
     it sets the "isLading" flag to true, generates a random gross weight for the cargo, and adds it to the net weight of the wagon.
     Additionally, there is a conditional statement that generates a small chance of throwing an exception called "Nuclear_fuel_leak" if
     a random number generator generates the value of 1 out of 10,000.

     In the "debarkation()" method, if the wagon is already unloaded, it prints a message saying so. Otherwise,
     it sets the "isLading" flag to false.

     Finally, the class defines an overridden "toString()" method that returns a string representation of the instance variables of the object.*/

    private final double max_mass_of_toxic = 40;
    private boolean isLading = false;

    public Wagon_for_liquid_toxic() {
        super(Names_of_shipper.randomLiquidToxic());
    }

    @Override
    public void debarkation() {
        if (isLading) {
            isLading = false;
        } else {
            System.out.println("The " + getClass() + "has already been unloaded");
        }
    }

    @Override
    public void lading() {
        if (!isLading) {
            if((int)(Math.random() * 10_000) == 1) {
                try {
                    throw new Nuclear_fuel_leak();
                } catch (Nuclear_fuel_leak e) {
                    e.printStackTrace();
                    System.exit(0);
                }
            }
            setGross_weight(((Math.random() * max_mass_of_toxic) + 15) + getNet_weight());
            isLading = true;
        } else {
            System.out.println("The " + getClass() + " is already loaded");
        }
    }

    @Override
    public String toString() {
        return "\nWagon_for_liquid_toxic{" +
                "max_mass_of_toxic=" + max_mass_of_toxic +
                ", isLading=" + isLading +
                '}';
    }
}
