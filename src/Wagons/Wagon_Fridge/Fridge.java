package Wagons.Wagon_Fridge;

import java.util.Arrays;

public class Fridge {
    /**This code defines a class called Fridge which simulates a fridge that can store different types of products such as meat,
     * fruits, vegetables, and milk. The class contains an array of Product objects and a variable to keep track of the total mass of the fridge with products.

     The Product class is a superclass that has attributes like name and mass.
     Each of the subclasses of Product represents a type of product that can be stored in the fridge, and each has a default name and mass.

     The Fridge class has several methods. The toString() method returns a string representation of the Fridge object.
     The fillFridge() method fills the products array with random objects of type Meat, Fruit, Vegetable,
     or Milk and updates the total mass of the fridge. The unloadFridge() method sets all elements of the products array to null.
     The getMassFridge_with_products_KG() method returns the total mass of the fridge with products.
     The setMassFridge_with_products_KG() method sets the total mass of the fridge with products.

     Overall, this code provides a basic simulation of a fridge that can store different types of
     products and perform basic operations like filling and unloading the fridge.*/
    private double massFridge_with_products_KG;
    private final Product[] products = new Product[100];

    public Fridge() {
        massFridge_with_products_KG = 0;
    }

    @Override
    public String toString() {
        return "\nFridge{" +
                "massFridge_with_products_KG=" + (int)massFridge_with_products_KG +
                ", products=" + Arrays.toString(products) +
                '}';
    }

    public void fillFridge() {
        for (int x = 0; x < products.length; x++) {
            int random = (int) (Math.random() * 3);
            switch (random) {
                case 0:
                    products[x] = new Meat();
                    massFridge_with_products_KG += products[x].getMass_gram() / 1000.0;
                    break;
                case 1:
                    products[x] = new Fruit();
                    massFridge_with_products_KG += products[x].getMass_gram() / 1000.0;
                    break;
                case 2:
                    products[x] = new Vegeteble();
                    massFridge_with_products_KG += products[x].getMass_gram() / 1000.0;
                    break;
                case 3:
                    products[x] = new Milk();
                    massFridge_with_products_KG += products[x].getMass_gram() / 1000.0;
                    break;
            }
        }

    }

    public void unloadFridge() {
        Arrays.fill(products, null);
    }

    public double getMassFridge_with_products_KG() {
        return massFridge_with_products_KG;
    }

    public void setMassFridge_with_products_KG(double massFridge_with_products_KG) {
        this.massFridge_with_products_KG = massFridge_with_products_KG;
    }
}

class Product {
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", mass_gram=" + mass_gram +
                '}';
    }

    protected double getMass_gram() {
        return mass_gram;
    }

    private final String name;
    private final double mass_gram;

    Product(String name, double mass_gram) {
        this.name = name;
        this.mass_gram = mass_gram;
    }
}

class Meat extends Product {
    Meat() {
        super("Ribeye", 800);
    }
}

class Milk extends Product {
    Milk() {
        super("Milk 3%", 560);
    }
}

class Vegeteble extends Product {
    Vegeteble() {
        super("Carrot", 40);
    }
}

class Fruit extends Product {
    Fruit() {
        super("Orange", 120);
    }
}

