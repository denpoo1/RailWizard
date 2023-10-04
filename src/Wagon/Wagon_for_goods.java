package Wagon;

import Wagons.Names_of_shipper;
import Wagons.Wafon_for_loquids.Barrel;
import Wagons.Wagon_Fridge.Fridge;

import java.util.Arrays;

public class Wagon_for_goods extends Wagon {
    /**This code is a Java program written in the "Wagon" package.
    It imports some classes from other packages, including the "Names_of_shipper" class from the "Wagons" package and the "Barrel" and "Fridge" classes from sub-packages of the "Wagons" package.
    The class "Wagon_for_goods" extends the abstract class "Wagon" and implements the interfaces "Lading" and "Debarkation".

The "Wagon_for_goods" class has several private instance variables, including "mass_ton", "countWagon", "goods", and "isLading".
It also has a constructor that takes a "shipper" argument and calls the superclass constructor with predefined values.
The "goods" variable is an array of "Object" type and is initialized with a length of 20.

The class has several methods, including "addFridge" and "addBarrel" that add a specified number of fridges or barrels to the "goods" array.
The "fill_all_Wagon" method fills the wagon with goods, calculates the total mass in tons, and updates the "mass_ton" instance variable.
The "unload_all_Wagon" method empties the wagon and updates the "mass_ton" instance variable to zero. The "lading" and "debarkation" methods implement the "Lading" and "Debarkation" interfaces, respectively.

The "toString" method returns a string representation of the "Wagon_for_goods" object, including its "mass_ton", "countWagon", "goods", and "isLading" instance variables.*/
    private double mass_ton;
    private int countWagon;
    private Object[] goods;
    private boolean isLading = false;

    public Wagon_for_goods(String shipper) {
        super(Names_of_shipper.randomShipperGas(), "Fittings", 2, 0);
        mass_ton = 0;
        countWagon = 0;
        goods = new Object[20];
    }

    @Override
    public void debarkation() {
        if (isLading) {
            unload_all_Wagon();
            mass_ton = 0;
            isLading = false;
        } else {
            System.out.println("The " + getClass() + "has already been unloaded");
        }
    }

    @Override
    public void lading() {
        if (!isLading) {
            fill_all_Wagon();
            setGross_weight(mass_ton);
            isLading = true;
        } else {
            System.out.println("The " + getClass() + " is already loaded");
        }
    }

    public void addFridge(int count) {
        for (int x = 0; x < count; x++) {
            goods[countWagon++] = new Fridge();
        }
    }

    public void addBarrel(int count) {
        for (int x = 0; x < count; x++) {
            goods[countWagon++] = new Barrel();
        }
    }

    private void fill_all_Wagon() {
        for (int x = 0; x < goods.length; x++) {
            if (goods[x] == null) {
                break;
            } else if (goods[x] instanceof Fridge) {
                Fridge fridge = (Fridge) goods[x];
                fridge.fillFridge();
                mass_ton += fridge.getMassFridge_with_products_KG() / 1000.0;
            } else {
                Barrel barrel = (Barrel) goods[x];
                barrel.fillBarrel();
                mass_ton += barrel.getMassBarrel_with_liquid_LT() / 1000.0;
            }
        }
    }

    private void unload_all_Wagon() {
        for (int x = 0; x < goods.length; x++) {
            if (goods[x] == null) {
                break;
            } else if (goods[x] instanceof Fridge) {
                Fridge fridge = (Fridge) goods[x];
                fridge.unloadFridge();
                fridge.setMassFridge_with_products_KG(0);
            } else {
                Barrel barrel = (Barrel) goods[x];
                barrel.unloadBarrel();
            }
        }
    }

    @Override
    public String toString() {
        return "Wagon_for_goods{" +
                "mass_ton=" + mass_ton +
                ", countWagon=" + countWagon +
                ", goods=" + Arrays.toString(goods) +
                ", isLading=" + isLading +
                '}';
    }
}
