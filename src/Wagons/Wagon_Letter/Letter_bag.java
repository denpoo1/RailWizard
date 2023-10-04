package Wagons.Wagon_Letter;

import java.util.Arrays;

class Letter_bag {
    /**This is a Java code for a class called "Letter_bag".
     * It has two private fields: an array of "Letter" objects and a double "massLetterBag" representing the total mass of letters in the bag.

     The class has three methods:

     "getMassLetterBag()" returns the total mass of the letters in the bag.
     "fillLetterBag()" fills the bag with 300 new "Letter" objects and sets the total mass of the bag to 20.
     "unloadLetterBag()" removes all "Letter" objects from the bag and sets the total mass of the bag to 0.
     The class also has an overridden "toString()" method that returns a string representation of the object's current state,
     including the array of letters and the total mass of the bag.*/
    private Letter[] letters = new Letter[300];
    private double massLetterBag = 0;


    double getMassLetterBag() {
        return massLetterBag;
    }

    void fillLetterBag() {
        for(int x = 0; x < letters.length; x++) {
            letters[x] = new Letter();
        }
        massLetterBag = 20;
    }
    void unloadLetterBag() {
        Arrays.fill(letters, null);
        massLetterBag = 0;
    }
    @Override
    public String toString() {
        return "Letter_bag{" +
                "letters=" + Arrays.toString(letters) +
                ", massLetterBag=" + massLetterBag +
                '}';
    }
}
