package Wagons.Wagon_Letter;
import Wagons.Names_of_shipper;
import java.util.Arrays;
import Wagon.Wagon;

public class Wagon_Letter extends Wagon {
    /**This is a Java code for a class called Wagon_Letter, which extends another class called Wagon.

     The Wagon_Letter class has several private instance variables such as mass_all_LetterBag_Ton, isLading, and letter_bags.
     The mass_all_LetterBag_Ton variable keeps track of the total weight of all letter bags,
     isLading is a boolean flag to keep track of whether the wagon is being loaded or not, and letter_bags is an array that contains Letter_bag objects.

     The Wagon_Letter class has a constructor that sets the shipper name to a random name from the
     Names_of_shipper enum, and sets the wagon's type, capacity, and gross weight.

     The class also has a debarkation() method that unloads all letter bags if the wagon is loaded,
     and a lading() method that loads all letter bags into the wagon and sets the gross weight accordingly.

     The unload_all_LetterBags() method unloads all letter bags and sets the mass_all_LetterBag_Ton variable to zero.
     The fill_all_LetterBags() method fills all letter bags and updates the mass_all_LetterBag_Ton variable.

     Finally, the toString() method returns a string representation of the Wagon_Letter object.*/
    private double mass_all_LetterBag_Ton = 0;
    private boolean isLading = false;
    private Letter_bag[] letter_bags = {new Letter_bag(), new Letter_bag(), new Letter_bag(), new Letter_bag(), new Letter_bag(), new Letter_bag(), new Letter_bag(), new Letter_bag()};

    public Wagon_Letter() {
        super(Names_of_shipper.randomMail(), "Fittings", 2, 0);
    }

    @Override
    public void debarkation() {
        if (isLading) {
            unload_all_LetterBags();
            isLading = false;
        } else {
            System.out.println("The " + getClass() + "has already been unloaded");
        }
    }
    @Override
    public void lading() {
        if (!isLading) {
            fill_all_LetterBags();
            setGross_weight(mass_all_LetterBag_Ton);
            isLading = true;
        } else {
            System.out.println("The " + getClass() + " is already loaded");
        }
    }

    private void unload_all_LetterBags() {
        for (Letter_bag letter_bag : letter_bags) {
            letter_bag.unloadLetterBag();
            mass_all_LetterBag_Ton = 0;
        }
    }

    private void fill_all_LetterBags() {
        for (Letter_bag letter_bag : letter_bags) {
            letter_bag.fillLetterBag();
            mass_all_LetterBag_Ton += letter_bag.getMassLetterBag() / 1000.0;
        }
    }
    @Override
    public String toString() {
        return "Wagon_Letter{" +
                "mass_all_LetterBag_Ton=" + mass_all_LetterBag_Ton +
                ", isLading=" + isLading +
                ", letter_bags=" + Arrays.toString(letter_bags) +
                '}';
    }
}
