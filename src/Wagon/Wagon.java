package Wagon;

import Interfaces.Lading;
import Interfaces.Debarkation;
public abstract class Wagon implements Lading, Debarkation {
    /**This is a Java code for an abstract class called "Wagon".

The class has four private fields: "shipper", "means_of_protection",
"net_weight", and "gross_weight". The first two fields are Strings, and the last two are doubles.
The class also has a private field called "ID", which is an int generated randomly.

The class implements two interfaces called "Lading" and "Debarkation".
It also overrides the toString() method to print out the values of all the fields.

There are three methods defined in this class.
The first method "getNet_weight()" returns the value of the "net_weight" field.
The second method "getGross_weight()" returns the value of the "gross_weight" field.
The third method "setGross_weight(double gross_weight)" sets the value of the "gross_weight" field.

The constructor for this class takes four parameters: "shipper", "means_of_protection", "net_weight", and "gross_weight".
These values are used to initialize the corresponding fields.
Since this is an abstract class, it cannot be instantiated, but can only be used as a base class for other classes that extend it.*/
    private String shipper;
    private String means_of_protection;
    private double net_weight;
    private double gross_weight;
    private int ID = (int) (Math.random() * 10_000_000) + 1;

    @Override
    public String toString() {
        return "Wagon{" +
                "shipper='" + shipper + '\'' +
                ", means_of_protection='" + means_of_protection + '\'' +
                ", net_weight=" + net_weight +
                ", gross_weight=" + gross_weight +
                ", ID=" + ID +
                '}';
    }

    public double getNet_weight() {
        return net_weight;
    }

    public double getGross_weight() {
        return gross_weight;
    }

    public void setGross_weight(double gross_weight) {
        this.gross_weight = gross_weight;
    }

    public Wagon(String shipper, String means_of_protection, double net_weight, double gross_weight) {
        this.shipper = shipper;
        this.means_of_protection = means_of_protection;
        this.net_weight = net_weight;
        this.gross_weight = gross_weight;
    }
}
