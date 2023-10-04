package Wagons.Wagon_for_explosive;

import Wagon.Wagon_for_heavy_goods;
import java.util.Arrays;
import Wagons.Names_of_shipper;

public class Wagon_for_explosive_goods extends Wagon_for_heavy_goods {
    /**This code defines a class Wagon_for_explosive_goods which extends the Wagon_for_heavy_goods class.
     * The Wagon_for_explosive_goods class has a private field of type Wooden_box[] named wooden_boxes, which is an array of wooden boxes that can be filled with explosive goods.
     * It also has a private field mass_all_Boxes_Ton, which holds the total mass of all wooden boxes in the wagon.
     * Additionally, there is a private boolean field isLading that indicates whether the wagon is currently loaded or not.

     The constructor of the Wagon_for_explosive_goods class takes no arguments but calls the constructor
     of the parent class Wagon_for_heavy_goods with a randomly generated name of the shipper of the explosive goods.

     The Wagon_for_explosive_goods class overrides two methods of the parent class Wagon_for_heavy_goods:
     lading() and debarkation(). The lading() method first checks whether the wagon is already loaded or not,
     and if it is not, it fills all the wooden boxes with explosive goods and sets the gross weight of the wagon to the total mass of all the wooden boxes.
     If the wagon is already loaded, it prints a message indicating that the wagon is already loaded.

     In the debarkation() method, if the wagon is loaded, all the wooden boxes are unloaded and the isLading field is set to false.
     If the wagon is already unloaded, it prints a message indicating that the wagon has already been unloaded.

     The Wagon_for_explosive_goods class also has two private methods fill_all_Boxes() and unload_all_Boxes().
     The fill_all_Boxes() method fills all wooden boxes in the wagon with explosive goods and updates the mass_all_Boxes_Ton field with the total mass of all wooden boxes in tons.
     The unload_all_Boxes() method unloads all wooden boxes in the wagon and sets the mass_all_Boxes_Ton field to zero.

     Finally, the toString() method of the Wagon_for_explosive_goods class returns a string representation of the object,
     which includes the wooden_boxes array, the mass_all_Boxes_Ton field, and the isLading field.*/
    private Wooden_box[] wooden_boxes = {new Wooden_box(), new Wooden_box(), new Wooden_box(), new Wooden_box(), new Wooden_box(), new Wooden_box(), new Wooden_box(), new Wooden_box(), new Wooden_box(), new Wooden_box(), new Wooden_box(), new Wooden_box(), new Wooden_box(), new Wooden_box(), new Wooden_box(), new Wooden_box(), new Wooden_box()};
    private double mass_all_Boxes_Ton = 0;
    private boolean isLading = false;

    public Wagon_for_explosive_goods() {
        super(Names_of_shipper.randomExplosive());
    }

    @Override
    public void debarkation() {
        if (isLading) {
            unload_all_Boxes();
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
                    throw new Boom();
                } catch (Boom e) {
                    e.printStackTrace();
                    System.exit(0);
                }
            }
            fill_all_Boxes();
            setGross_weight(mass_all_Boxes_Ton);
            isLading = true;
        } else {
            System.out.println("The " + getClass() + " is already loaded");
        }
    }

    private void unload_all_Boxes() {
        for (Wooden_box wooden_box : wooden_boxes) {
            wooden_box.unloadWoodenBox();
            mass_all_Boxes_Ton = 0;
        }
    }

    @Override
    public String toString() {
        return "\nWagon_for_explosive_goods{" +
                "wooden_boxes=" + Arrays.toString(wooden_boxes) +
                ", mass_all_Boxes_Ton=" + mass_all_Boxes_Ton +
                ", isLading=" + isLading +
                '}';
    }

    private void fill_all_Boxes() {
        for (Wooden_box wooden_box : wooden_boxes) {
            wooden_box.fillWoodenBox();
            mass_all_Boxes_Ton += wooden_box.getMass_all_Explosive_KG() / 1000.0;
        }
    }
}
