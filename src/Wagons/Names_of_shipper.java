package Wagons;

import java.util.ArrayList;

public class Names_of_shipper {
    /**This is a Java code for a class called "Names_of_shipper" which includes several static methods to generate random names of shippers for different types of cargo.

     The class contains multiple private ArrayLists, each of which includes a list of strings representing the names of shippers for a specific type of cargo,
     such as gas, liquid toxic, fridge, explosive, items toxic, mail, etc.

     For each type of cargo, there is a static method that returns a randomly selected shipper name from the corresponding ArrayList.
     The randomization is done using the Math.random() method to generate a random index within the range of the ArrayList's size.

     The code uses the Java Collections framework to define and manipulate the ArrayLists.
     The double braces initialization syntax is used to create and initialize each ArrayList in a single statement.*/
    private static ArrayList<String> shippersGas = new ArrayList<>() {{
        add("USA");
        add("Iran");
        add("China");
        add("Qatar");
        add("Canada");
        add("Australia");
        add("Saudi Arabia");
        add("Norway");
        add("Algeria");
    }};

    public static String randomShipperGas() {
        return shippersGas.get((int) (Math.random() * shippersGas.size()));
    }

    private static ArrayList<String> shippersLiquidToxic = new ArrayList<>() {{
        add("Latvia");
        add("Germany");
        add("Greece");
        add("Spain");
        add("Bulgaria");
    }};

    public static String randomLiquidToxic() {
        return shippersLiquidToxic.get((int) (Math.random() * shippersLiquidToxic.size()));
    }

    private static ArrayList<String> shippersFridge = new ArrayList<>() {{
        add("Bosch");
        add("Mitsubishi Electric");
        add("Miele");
        add("Smeg");
        add("Gorenje");
        add("Asko");
        add("Hitachi");
    }};

    public static String randomFridge() {
        return shippersFridge.get((int) (Math.random() * shippersFridge.size()));
    }

    private static ArrayList<String> shippersExplosive = new ArrayList<>() {{
        add("Romania");
        add("Malaysia");
        add("Japan");
        add("Iran");
        add("Iraq");
        add("Saudi Arabia");
        add("Bangladesh");
    }};

    public static String randomExplosive() {
        return shippersExplosive.get((int) (Math.random() * shippersExplosive.size()));
    }

    private static ArrayList<String> shipperItemsToxic = new ArrayList<>() {{
        add("Kazakhstan");
        add("Australia");
        add("Namibia");
        add("Uzbekistan");
        add("Ukraine");
        add("India");
        add("Brazil");
        add("Romania");
        add("toxic items");
    }};

    public static String randomItemsToxic() {
        return shipperItemsToxic.get((int) (Math.random() * shipperItemsToxic.size()));
    }

    private static ArrayList<String> shipperMail = new ArrayList<>() {{
        add("InPost");
        add("DHL");
        add("NovaPoczta");
        add("AmazonDelivery");
        add("EbayDelivery");
        add("Allegro");
        add("OLX");
    }};

    public static String randomMail() {
        return shipperMail.get((int) (Math.random() * shipperMail.size()));
    }

    private static ArrayList<String> shipperName = new ArrayList<>() {{
        add("Denis");
        add("Adam");
        add("Oleg");
        add("Alina");
        add("Sasha");
        add("Harper");
        add("Emily");
        add("Abigail");
        add("Charlotte");
        add("Mia");
        add("Isabella");
        add("Sophia");
        add("Ava");
        add("Olivia");
        add("Emma");
        add("Ethan");
        add("Elijah");
        add("Michael");
        add("Jacob");
        add("Benjamin");
        add("James");
        add("Mason");
        add("William");
        add("Liam");
        add("Noah");
    }};

    public static String randomName() {
        return shipperName.get((int) (Math.random() * shipperName.size()));
    }

    private static ArrayList<String> shipperLastName = new ArrayList<>() {{
        add("Evans");
        add("Stone");
        add("Roberts");
        add("Mills");
        add("Lewis");
        add("Morgan");
        add("Florence");
        add("Campbell");
        add("Bronte");
        add("Bell");
        add("Adams");
        add("Williams");
        add("Peters");
        add("Gibson");
        add("Martin");
        add("Jordan");
        add("Jackson");
        add("Grant");
        add("Davis");
        add("Collins");
        add("Bradley");
        add("Barlow");
        add("Ivanov");
        add("Petrov");
    }};

    public static String randomLastName() {
        return shipperLastName.get((int) (Math.random() * shipperLastName.size()));
    }
}



