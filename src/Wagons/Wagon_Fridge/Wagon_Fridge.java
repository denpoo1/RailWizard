package Wagons.Wagon_Fridge;

import Wagon.Wagon_for_goods;
import Wagons.Names_of_shipper;
import java.util.Arrays;
import Interfaces.Electricity;

public class Wagon_Fridge extends Wagon_for_goods implements Electricity {

    private Fridge[] fridges = {new Fridge(), new Fridge(), new Fridge(), new Fridge(), new Fridge(), new Fridge()};
    private boolean isLading = false;

    double getMass_all_Products() {
        return mass_all_Products_ton;
    }

    void setMass_all_Products(double mass_all_Products) {
        this.mass_all_Products_ton = mass_all_Products;
    }

    private double mass_all_Products_ton = 0;

    public Wagon_Fridge() {
        super(Names_of_shipper.randomFridge());
    }

    @Override
    public String toString() {
        return "Wagon_Fridge{" +
                "fridges=" + Arrays.toString(fridges) +
                "isLading=" + isLading +
                "mass_all_Products_ton=" + mass_all_Products_ton +
                '}';
    }

    @Override
    public void debarkation() {
        if (isLading) {
            unload_all_Fridges();
            isLading = false;
        } else {
            System.out.println("The " + getClass() + "has already been unloaded");
        }
    }

    @Override
    public void lading() {
        if (!isLading) {
            fill_all_Fridges();
            setGross_weight(mass_all_Products_ton);
            isLading = true;

        } else {
            System.out.println("The " + getClass() + " is already loaded");
        }
    }

    private void unload_all_Fridges() {
        for (Fridge fridge : fridges) {
            fridge.unloadFridge();
            fridge.setMassFridge_with_products_KG(0);
            setMass_all_Products(0);
        }
    }

    public void setMass_all_Products_ton(double mass_all_Products_ton) {
        this.mass_all_Products_ton = mass_all_Products_ton;
    }

    public double getMass_all_Products_ton() {
        return mass_all_Products_ton;
    }

    private void fill_all_Fridges() {
        for (Fridge fridge : fridges) {
            fridge.fillFridge();
            setMass_all_Products(getMass_all_Products() + (fridge.getMassFridge_with_products_KG() / 1000.0));
        }
    }
}


