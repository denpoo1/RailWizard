package Wagons.Wafon_for_loquids;

public class Barrel {
    /**This code defines a class named "Barrel" within the package "Wagons.Wafon_for_loquids". The class contains the following methods:

"fillBarrel": a public method that randomly generates a mass value (between 40 and 90) for the barrel filled with liquid and sets it as the value of the private instance variable "massBarrel_with_liquid_LT".
"getMassBarrel_with_liquid_LT": a public method that returns the current value of the private instance variable "massBarrel_with_liquid_LT".
"toString": an overridden method from the Object class that returns a string representation of the Barrel object, including its mass.
"unloadBarrel": a public method that sets the value of the private instance variable "massBarrel_with_liquid_LT" to 0, effectively unloading the liquid from the barrel.*/
    private double massBarrel_with_liquid_LT = 0;

    public void fillBarrel() {
        massBarrel_with_liquid_LT = ((Math.random() * 50) + 40);
    }

    public double getMassBarrel_with_liquid_LT() {
        return massBarrel_with_liquid_LT;
    }

    @Override
    public String toString() {
        return "Barrel{" +
                "massBarrel_with_liquid_LT=" + massBarrel_with_liquid_LT +
                '}';
    }

    public void unloadBarrel() {
        massBarrel_with_liquid_LT = 0;
    }

}
