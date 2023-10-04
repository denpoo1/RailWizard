package Wagons.Wafon_for_loquids;
import Wagon.Wagon_for_goods;
import Wagons.*;
import java.util.Arrays;

public class Wagon_for_liquids extends Wagon_for_goods {
    /**This code is a Java class called Wagon_for_liquids which extends the Wagon_for_goods class.
    It represents a type of wagon designed to transport liquids, and contains an array of Barrel objects, which can be filled with liquid.

The Wagon_for_liquids class has instance variables to keep track of the total mass of the barrels and whether or not the wagon has been loaded.
It also overrides the lading() and debarkation() methods of the parent class.

The lading() method fills all the barrels with random amounts of liquid using the fill_all_Barrels() method and sets the gross weight of the wagon.
The debarkation() method unloads all the barrels using the unload_all_Barrels() method.

The toString() method returns a string representation of the wagon object, including the details of all the barrels and whether or not the wagon has been loaded.

Overall, this code defines a Java class for a wagon designed to transport liquids, which can be loaded and unloaded using barrels.*/
    private Barrel[] barrels = {new Barrel(), new Barrel(), new Barrel(), new Barrel(), new Barrel(), new Barrel(), new Barrel(), new Barrel(), new Barrel(), new Barrel(),};
    private double mass_Barrels_ton = 0;
    private boolean isLading = false;

    public Wagon_for_liquids() {
        super(Names_of_shipper.randomShipperGas());
    }

    @Override
    public void debarkation() {
        if (isLading) {
            unload_all_Barrels();
            isLading = false;
        } else {
            System.out.println("The " + getClass() + "has already been unloaded");
        }
    }

    @Override
    public String toString() {
        return "\nWagon_for_liquids{" +
                "barrels=" + Arrays.toString(barrels) +
                ", mass_Barrels_ton=" + mass_Barrels_ton +
                ", isLading=" + isLading +
                '}';
    }

    @Override
    public void lading() {
        if (!isLading) {
            fill_all_Barrels();
            setGross_weight(mass_Barrels_ton);
            isLading = true;
        } else {
            System.out.println("The " + getClass() + " is already loaded");
        }
    }

    private void fill_all_Barrels() {
        for (Barrel barrel : barrels) {
            barrel.fillBarrel();
            mass_Barrels_ton += barrel.getMassBarrel_with_liquid_LT() / 1000;
        }
    }

    private void unload_all_Barrels() {
        for (Barrel barrel : barrels) {
            barrel.unloadBarrel();
        }
        mass_Barrels_ton = 0;
    }
}
