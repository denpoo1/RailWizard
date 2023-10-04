package Wagons.Wagon_for_Gas;

import Wagon.Wagon_for_goods;
import Wagons.Names_of_shipper;

public class Wagon_Gas extends Wagon_for_goods {
    /**This code is for a Java class called "Wagon_Gas" in a package called "Wagons.Wagon_for_Gas".
     * The class extends another class called "Wagon_for_goods" and imports another class called "Names_of_shipper".

     The "Wagon_Gas" class has a private variable called "max_mass_of_gas" that is a constant value of 30.
     It also has a private boolean variable called "isLading" that is initially set to false.

     The class has a constructor that calls the constructor of the parent class "Wagon_for_goods" with a randomly generated shipper name for gas.

     The class overrides the "toString" method to return a string containing the value of the "max_mass_of_gas" and "isLading" variables.

     The class also overrides two methods called "debarkation" and "lading".
     The "debarkation" method checks if the wagon is loaded and sets "isLading" to false if it is, otherwise,
     it prints a message saying that the wagon has already been unloaded.
     The "lading" method checks if the wagon is already loaded and sets the "isLading" variable to true if it is not.
     It sets the gross weight of the wagon to a random value between 20 and "max_mass_of_gas" plus the net weight of the wagon.*/
    private final double max_mass_of_gas = 30;
    private boolean isLading = false;


    public Wagon_Gas() {
        super(Names_of_shipper.randomShipperGas());
    }

    @Override
    public String toString() {
        return "\nWagon_Gas{" +
                "max_mass_of_gas=" + max_mass_of_gas +
                ", isLading=" + isLading +
                '}';
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
            setGross_weight(((Math.random() * max_mass_of_gas) + 20) + getNet_weight());
            isLading = true;
        } else {
            System.out.println("The " + getClass() + " is already loaded");
        }
    }
}
