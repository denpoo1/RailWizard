package Wagon;

import Wagons.Names_of_shipper;
import Wagons.Wafon_for_loquids.Barrel;
import Wagons.Wagon_Fridge.Fridge;
import Wagons.Wagon_for_explosive.Wooden_box;
import Wagons.Wagons_for_toxic_goods.Nuclear_bomb;

import java.util.Arrays;

public class Wagon_for_heavy_goods extends Wagon {
    /**This is a Java code for a class called "Wagon_for_heavy_goods" which extends another class called "Wagon".

The class has several instance variables such as "mass_ton" which is a double,
"countWagon" which is an integer, "goods" which is an array of objects, and "isLading" which is a boolean.

The constructor of the class takes in a String parameter called "shipper" and calls the constructor of the parent class "Wagon" with some arguments,
initializes "mass_ton" to 0, "countWagon" to 0, and initializes the "goods" array to a new object array of length 20.

The class also overrides some methods from the parent class such as "debarkation()" and "lading()".

The "toString()" method is also overridden to return a string representation of the instance variables.

There are two additional methods called "addBomb()" and "addWoodenBox()" that add objects of type "Nuclear_bomb" and "Wooden_box" respectively to the "goods" array.

The class also has two private helper methods called "fill_all_Wagon()" and "unload_all_Wagon()" which are called from the "lading()" and "debarkation()" methods respectively to fill and unload the "goods" array.

Overall, this class seems to represent a wagon that can carry heavy goods such as nuclear bombs and wooden boxes.*/
    private double mass_ton;
    private int countWagon;
    private Object[] goods;
    private boolean isLading = false;

    public Wagon_for_heavy_goods(String shipper) {
        super(Names_of_shipper.randomItemsToxic(), "Fittings", 2, 0);
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

    @Override
    public String toString() {
        return "Wagon_for_heavy_goods{" +
                "mass_ton=" + mass_ton +
                ", countWagon=" + countWagon +
                ", goods=" + Arrays.toString(goods) +
                ", isLading=" + isLading +
                '}';
    }

    public void addBomb(int count) {
        for (int x = 0; x < count; x++) {
            goods[countWagon++] = new Nuclear_bomb();
            mass_ton += Nuclear_bomb.getMassBomb_KG() / 1000.0;
        }
    }

    public void addWoodenBox(int count) {
        for (int x = 0; x < count; x++) {
            goods[countWagon++] = new Wooden_box();
        }
    }

    private void fill_all_Wagon() {
        for (int x = 0; x < goods.length; x++) {
            if (goods[x] == null) {
                break;
            } else if (goods[x] instanceof Nuclear_bomb) {
                mass_ton += Nuclear_bomb.getMassBomb_KG() / 1000.0;
            } else {
                Wooden_box wooden_box = (Wooden_box) goods[x];
                wooden_box.fillWoodenBox();
                mass_ton += wooden_box.getMass_all_Explosive_KG() / 1000.0;
            }
        }
    }

    private void unload_all_Wagon() {
        for (int x = 0; x < goods.length; x++) {
            if (goods[x] == null) {
                break;
            } else if (goods[x] instanceof Wooden_box) {
                Wooden_box wooden_box = (Wooden_box) goods[x];
                wooden_box.unloadWoodenBox();
            } else {
                goods[x] = null;
            }
        }
    }

}
